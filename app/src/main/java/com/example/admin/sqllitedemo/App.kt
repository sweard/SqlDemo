package com.example.admin.sqllitedemo

import android.app.Application
import android.content.Context

/**
 * Created by admin on 2017/11/1.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = applicationContext

    }

    companion object {
        var instance: Context? = null
        fun context(): Context = instance!!

    }
}