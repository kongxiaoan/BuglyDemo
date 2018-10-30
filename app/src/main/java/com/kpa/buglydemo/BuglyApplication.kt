package com.kpa.buglydemo

import android.app.Application
import android.content.Context
import android.os.Environment
import android.view.View
import com.blankj.utilcode.util.Utils
import com.tencent.bugly.Bugly
import com.tencent.bugly.beta.Beta
import com.tencent.bugly.beta.UpgradeInfo
import com.tencent.bugly.beta.ui.UILifecycleListener
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
        // 如果您之前使用过Bugly SDK，请将以下这句注释掉。
        // CrashReport.initCrashReport(applicationContext, "df3b688ea5", false)
        //统一初始化方法：
        Beta.autoInit = true //自动初始化 （可以自动控制是否启动初始化）
        Beta.autoCheckUpgrade = true //是否自动更新
        Beta.upgradeCheckPeriod = 60 * 1000 //设置升级检车周期为60s 60s 内不重复发送请求策略
        Beta.initDelay = 1 * 1000 //延迟初始化
        Beta.largeIconId = R.drawable.ic_launcher_background //设置通知栏大图标
        Beta.smallIconId = R.drawable.ic_launcher_background //设置状态栏小图标
        Beta.defaultBannerId = R.drawable.ic_launcher_background //设置更新弹窗默认展示的banner
        Beta.storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) //设置sd卡的Download为更新资源存储目录
        Beta.showInterruptedStrategy = true //置开启显示打断策略 设置点击过确认的弹窗在App下次启动自动检查更新时会再次显示。
        Beta.canShowUpgradeActs.add(MainActivity::class.java) //添加可显示弹窗的Activity(只有在添加的)Activity显示弹窗
        Beta.upgradeDialogLayoutId = R.layout.select_dialog_item_material //设置自己的布局样式
        Beta.tipsDialogLayoutId = R.layout.main_activity //设置自定义tip弹窗UI布局
        //设置弹窗生命周期回调接口
        Beta.upgradeDialogLifecycleListener = object :UILifecycleListener<UpgradeInfo>{
            override fun onCreate(p0: Context?, p1: View?, p2: UpgradeInfo?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResume(p0: Context?, p1: View?, p2: UpgradeInfo?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPause(p0: Context?, p1: View?, p2: UpgradeInfo?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStart(p0: Context?, p1: View?, p2: UpgradeInfo?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStop(p0: Context?, p1: View?, p2: UpgradeInfo?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDestroy(p0: Context?, p1: View?, p2: UpgradeInfo?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }

        Beta.enableNotification = true // 设置是否显示消息通知
        Beta.autoDownloadOnWifi = true //Wi-Fi自动下载
        Beta.canShowApkInfo = true //设置弹窗中显示apk信息
        Beta.enableHotfix = true //关闭热更新能力




        Bugly.init(applicationContext, "df3b688ea5", false)
        Utils.init(applicationContext)
    }
}