package com.example.admin.sqllitedemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val sqlUtil: SqLiteUtil by lazy { SqLiteUtil() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        info.text = JniUtil.getFromC()
        create.setOnClickListener({
            Log.d(javaClass.name, "createClick")
        })

        Add.setOnClickListener({
            val random = Random()
            val pages = random.nextInt(100)

            info.text = sqlUtil.insert("P.S", 12.5, pages, "jeff").toString()
        })

        search.setOnClickListener({
            sqlUtil.query()
        })


        delete.setOnClickListener({
            sqlUtil.delete()
        })

        update.setOnClickListener({
            sqlUtil.update(666)
        })
    }
}
