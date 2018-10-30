package com.kpa.buglydemo

import android.app.Application
import com.blankj.utilcode.util.Utils
import com.tencent.bugly.Bugly
import com.tencent.bugly.crashreport.CrashReport

/**
 *author: mr.kong
 *Date:2018/10/29
 *description:
 *project name:BuglyDemo
 **/
class BuglyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CrashReport.initCrashReport(applicationContext, "df3b688ea5", false)
        Bugly.init(applicationContext,"df3b688ea5",false)
        Utils.init(applicationContext)
    }
}