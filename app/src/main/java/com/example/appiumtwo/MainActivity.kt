package com.example.appiumtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread.sleep(5000);

        //var btnLogin = findViewById(R.id.btnLogin) as Button;
        //var btnRegister = findViewById(R.id.btnRegister) as Button;

        /*btnLogin.setOnClickListener{
           val intent = Intent(this, LoginActivity::class.java).apply {
               //putExtra()
               startActivity(intent);
           }

            btnRegister.setOnClickListener{
                val intent = Intent(this, RegisterActivity::class.java).apply {
                    //putExtra()
                    startActivity(intent);
                }

        }*/


        //android.widget.Button

        //Button btnLogin = (Button) findViewById(R.id.btnLogin);

        //btnLogin.animation.du


    }

    fun register(view : View)
    {
        val registerButton = findViewById<Button>(R.id.btnRegister);
        val message = "dcdc"

        val intent = Intent(this,RegisterActivity::class.java).apply {
            putExtra("kkk",message)
        }

        startActivity(intent)
    }

    fun login(view : View)
    {
        val loginButton = findViewById<Button>(R.id.btnLogin);
        val message = "dcdc"

        val intent = Intent(this,LoginActivity::class.java).apply {
            putExtra("kkk",message)
        }

        startActivity(intent)
    }
}
