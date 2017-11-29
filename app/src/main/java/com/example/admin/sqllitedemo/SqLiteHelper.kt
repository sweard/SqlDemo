package com.example.admin.sqllitedemo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by admin on 2017/10/30.
 */
class SqLiteHelper(context: Context) : SQLiteOpenHelper(context, "sqlTest", null, 1) {

    val tableName = "book"
    val another = "another"
    val price = "price"
    val pages = "pages"
    val name = "name"

    private val createBook = "create table " + tableName + "(id integer primary key autoincrement, " +
            another + " text," +
            price + " real," +
            pages + " integer," +
            name + " text)"


    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(createBook)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}