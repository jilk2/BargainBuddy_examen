package com.example.bargainbuddy

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btnRegister: Button = findViewById(R.id.btRegister);
        btnRegister.setOnClickListener() {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        var btnLogin: Button = findViewById(R.id.btLogin);
        btnLogin.setOnClickListener() {
            var helper = MyDBHelper(applicationContext)
            var cr: Cursor;

            var editTextName: EditText = findViewById(R.id.etName);
            var editTextPassword: EditText = findViewById(R.id.etPassword)

            cr = helper.loginCheck(editTextName.text.toString(), editTextPassword.text.toString());

            if (cr.getCount() > 0){
                val intent = Intent(this, homepage::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Logingegevens zijn niet correct", Toast.LENGTH_LONG).show()
            }
        }
    }



}