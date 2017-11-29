package com.example.admin.sqllitedemo

import android.content.ContentValues
import android.util.Log

/**
 * Created by admin on 2017/11/1.
 *
 */
class SqLiteUtil {

    private val sqLiteHelper: SqLiteHelper by lazy { SqLiteHelper(App.context()) }

    fun insert(another: String, price: Double, pages: Int, name: String): Long {
        val contentValues = ContentValues()
        contentValues.put("another", another)
        contentValues.put("price", price)
        contentValues.put("pages", pages)
        contentValues.put("name", name)
        return sqLiteHelper.readableDatabase.insert("book", null, contentValues)
    }

    fun query() {
        val projection = arrayOf(sqLiteHelper.name, sqLiteHelper.pages, sqLiteHelper.price)
        val selection = sqLiteHelper.name + " = ?"
        val selectionArg = arrayOf("jeff")
        val cursor = sqLiteHelper.readableDatabase.query(sqLiteHelper.tableName,
                projection,
                selection,
                selectionArg,
                null,
                null,
                null
        )

        Log.d("Size", cursor.count.toString())
        if (cursor.moveToFirst()) {
            do {
                Log.d("查询Pages:", cursor.getString(cursor.getColumnIndex("pages")))
            } while (cursor.moveToNext())
        }
        cursor.close()
    }

    fun delete() {
        val selection = sqLiteHelper.name + " like ?"
        val selectionArg = arrayOf("jeff")
        sqLiteHelper.readableDatabase.delete(sqLiteHelper.tableName, selection, selectionArg)
    }

    fun update(pages: Int) {
        val path = ContentValues()
        path.put(sqLiteHelper.pages, pages)
        val selection = sqLiteHelper.pages + " = ?"
        val selectionArg = arrayOf("27")
        sqLiteHelper.readableDatabase.update(sqLiteHelper.tableName, path, selection, selectionArg)
    }
}