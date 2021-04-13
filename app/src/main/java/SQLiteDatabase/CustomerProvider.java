package SQLiteDatabase;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;

public class CustomerProvider extends ContentProvider
{
    static final String PROVIDER_NAME = "com.example.appiumtwo.CustomerProvider";
    static final String URL = "content://"+PROVIDER_NAME+"/customers";
    static final Uri CONTENT_URI = Uri.parse(URL);

    private static HashMap<String,String> CUSTOMERS_PROJECTION_MAP;

    static final String _ID = "id";
    static final String NAME = "name";
    static final String GRADE = "grade";

    static final int CUSTOMERS =1;
    static final int CUSTOMER_ID = 2;

    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(PROVIDER_NAME,"customers",CUSTOMERS);
        uriMatcher.addURI(PROVIDER_NAME,"students/#",CUSTOMER_ID);
    }



    private SQLiteDatabase customerDB;

    static final String DATABASE_NAME="Customerdb";
    static final String CUSTOMER_TABLE_NAME = "Customers";
    static final int DATABASE_VERSION = 1;

    static final String CREATE_DB_TABLE =
            "CREATE TABLE "+CUSTOMER_TABLE_NAME+
                    "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Name TEXT NOT NULL, "+
                    "Surname TEXT NOT NULL,"+
                    "Email TEXT NOT NULL);";

    public static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
             db.execSQL("DROP TABLE IF EXISTS "+CUSTOMER_TABLE_NAME);

             onCreate(db);
        }
    }
    @Override
    public boolean onCreate() {
        Context context = getContext();

        DatabaseHelper dbHelper = new DatabaseHelper(context);

        customerDB = dbHelper.getWritableDatabase();

        return (customerDB == null) ? false:true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder)
    {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        switch (uriMatcher.match(uri))
        {
            case CUSTOMERS:
                qb.setProjectionMap(CUSTOMERS_PROJECTION_MAP);
                break;

            case CUSTOMER_ID:
                qb.appendWhere(_ID + "=" + uri.getPathSegments().get(1));
                break;
        }

        if(sortOrder == null || sortOrder == "")
        {
            sortOrder = NAME;
        }

        Cursor c = qb.query(customerDB,projection,selection,selectionArgs,null,
                null,sortOrder);

        c.setNotificationUri(getContext().getContentResolver(),uri);

        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri)
    {
        switch (uriMatcher.match(uri))
        {
            case CUSTOMERS:
                return "vnd.android.cursor.dir/vnd.example.customers";

            case CUSTOMER_ID:
                return "vnd.android.cursor.item/vnd.example.customers";

                default:
                    throw new IllegalArgumentException("Unsupported URI: "+uri);



        }
       // return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long rowID = customerDB.insert(CUSTOMER_TABLE_NAME,"",values);

        if(rowID > 0)
        {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI,rowID);

            getContext().getContentResolver().notifyChange(_uri,null);

            return _uri;
        }

        throw new SQLException("Failed to add a record into "+uri);

        //return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection,
                      @Nullable String[] selectionArgs)
    {
        int count = 0;

        switch (uriMatcher.match(uri))
        {
            case CUSTOMERS:
                count = customerDB.delete(CUSTOMER_TABLE_NAME,selection,selectionArgs);
                break;

            case CUSTOMER_ID:
                String id = uri.getPathSegments().get(1);

                count = customerDB.delete(CUSTOMER_TABLE_NAME,_ID+" = "+id+
                        (!TextUtils.isEmpty(selection) ? "" +
                                "AND ("+selection+')' : ""),selectionArgs);
                break;
                default:
                    throw new IllegalArgumentException("Unknown URI "+uri);

        }

        getContext().getContentResolver().notifyChange(uri,null);
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values,
                      @Nullable String selection, @Nullable String[] selectionArgs)
    {
        int count = 0;

        switch (uriMatcher.match(uri))
        {
            case CUSTOMERS:
                count = customerDB.update(CUSTOMER_TABLE_NAME,values,selection,selectionArgs);
                break;

            case CUSTOMER_ID:
                count = customerDB.update(CUSTOMER_TABLE_NAME,values,
                        _ID+" = " + uri.getPathSegments().get(1) +
                                (!TextUtils.isEmpty(selection) ? "" +
                                        "AND (" + selection +')' : ""), selectionArgs);
                break;

                default:
                    throw new IllegalArgumentException("Unknown URI "+uri);
        }

        getContext().getContentResolver().notifyChange(uri,null);
        return count;
    }
}
