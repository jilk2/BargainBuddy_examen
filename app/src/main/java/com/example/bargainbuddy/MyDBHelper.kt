package com.example.bargainbuddy

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyDBHelper (context: Context) : SQLiteOpenHelper (context, "USERDB", null, 1){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS (USERID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PWD TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun loginCheck(name:String, password:String): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM USERS WHERE NAME = '" + name +"' AND PWD ='"+ password +"'", null)
    }


}