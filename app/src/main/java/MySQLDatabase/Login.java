package MySQLDatabase;

import android.os.AsyncTask;
import android.os.Build;

import java.net.MalformedURLException;
import java.net.URL;

@android.support.annotation.RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class Login extends AsyncTask {

    public Login()
    {

    }

    protected void onPreExecute()
    {

    }




    @Override
    protected Object doInBackground(Object[] objects,String arg[]) {
       try
       {
           String username = (String) arg[0];
           String password = (String) arg[0];
           String link = "http://localhost:4723";

           URL url = new URL(link);
           HttpClient client = new DefaultHttpClient();

           HttpGet request = new HttpGet();

           request.



       } catch (MalformedURLException e) {
           e.printStackTrace();
       }

        return null;
    }
}
