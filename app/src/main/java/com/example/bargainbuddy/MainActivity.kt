package com.example.bargainbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnRegister: Button = findViewById(R.id.gotologin);

        btnRegister.setOnClickListener() {
            goToLogin();
        }

    }

    fun goToLogin(){
        val intent = Intent(this, login::class.java)
        startActivity(intent)
    }
}