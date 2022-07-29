package com.yxf.saoifwiki

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.yxf.saoifwiki.repo.SAOIFRepo

/**
 *   author:yxf
 *   time:2022/7/29
 */
class MyApp : Application() {
    val saoifRepo by lazy { SAOIFRepo() }

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}