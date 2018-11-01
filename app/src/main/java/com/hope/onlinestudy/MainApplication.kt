package com.hope.onlinestudy

import android.app.Activity
import android.content.Context
import android.support.multidex.MultiDexApplication
import java.util.*

/**
 * @author kazeik.chen, QQ:77132995, email:kazeik@163.com
 * 2018 09 14 14:07
 * 类说明:
 */
class MainApplication : MultiDexApplication() {
    private var activityList: LinkedList<Activity>? = null

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        activityList = LinkedList()
    }

    fun addActivity(activity: Activity?) {
        if (null != activity && activityList != null)
            activityList?.add(activity)
    }

    fun exitApp() {
        if (activityList != null && !activityList!!.isEmpty()) {
            for (temp in activityList!!) {
                temp.finish()
            }
            activityList?.clear()
            activityList = null
        }
    }

    companion object {
        private var mInstance: MainApplication? = null

        val appContext: Context?
            get() = mInstance

        val instance: MainApplication
            get() {
                if (mInstance == null)
                    mInstance = MainApplication()

                return mInstance!!
            }
    }
}