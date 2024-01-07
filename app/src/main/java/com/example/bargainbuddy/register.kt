package com.example.bargainbuddy

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var btnRegister: Button = findViewById(R.id.btRegister);

        btnRegister.setOnClickListener() {
            insertRegister();
        }
    }

    fun insertRegister(){
        var helper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS", null)
        var cv = ContentValues()

        var editTextName: EditText = findViewById(R.id.name);
        var editTextPassword: EditText = findViewById(R.id.password);

        cv.put("NAME", editTextName.text.toString())
        cv.put("PWD", editTextPassword.text.toString())

        db.insert("USERS", null,cv)

        editTextName.setText("")
        editTextPassword.setText("")

        intent = Intent(this, login::class.java);
        startActivity(intent)


    }

}