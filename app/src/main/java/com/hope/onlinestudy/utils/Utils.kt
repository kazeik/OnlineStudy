package com.hope.onlinestudy.utils

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo
import android.app.KeyguardManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.content.FileProvider
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.gson.Gson
import com.hope.onlinestudy.BuildConfig
import java.io.File
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

object Utils {



    // 当前日期
    // 获取小时
    // 获取分钟
    // 从0:00分开是到目前为止的分钟数
    //int minuteOfDay = 9 * 60 + minute;// 从0:00分开是到目前为止的分钟数
    // 起始时间 17:20的分钟数
    // 结束时间 19:00的分钟数
    //		SimpleDateFormat formatters = new SimpleDateFormat("HH:mm");
    //        Date curDates = new Date(System.currentTimeMillis());// 获取当前时间
    //        String strs = formatters.format(curDates);
    //        System.out.println(strs);
    //        //开始时间
    //        int sth = 21;//小时
    //        int stm = 00;//秒
    //        //结束时间
    //        int eth = 23;//小时
    //        int etm = 59;//秒
    //
    //        String[] dds = new String[] {};
    //
    //        boolean res = false;
    //        // 分取系统时间 小时分
    //        dds = strs.split(":");
    //        int dhs = Integer.parseInt(dds[0]);
    //        int dms = Integer.parseInt(dds[1]);
    //
    //        if (sth <= dhs && dhs <= eth) {
    //            if (sth == dhs && stm >= dms) {
    //            	res = true;
    //            } else if (dhs == eth && etm <= dms) {
    //            	res = true;
    //            } else {
    //            	res = false;
    //            }
    //        } else {
    //        	res = false;
    //        }
    //		return res;
    val asTime: Boolean
        get() {
            val cal = Calendar.getInstance()
            val hour = cal.get(Calendar.HOUR_OF_DAY)
            val minute = cal.get(Calendar.MINUTE)
            val minuteOfDay = hour * 60 + minute
            val start = 21 * 60 + 0
            val end = 24 * 60
            return minuteOfDay in start..end

        }

    // 当前日期
    // 获取小时
    // 获取分钟
    // 从0:00分开是到目前为止的分钟数
    //int minuteOfDay = 9 * 60 + minute;// 从0:00分开是到目前为止的分钟数
    // 起始时间 17:20的分钟数
    // 结束时间 19:00的分钟数
    //		SimpleDateFormat formatters = new SimpleDateFormat("HH:mm");
    //        Date curDates = new Date(System.currentTimeMillis());// 获取当前时间
    //        String strs = formatters.format(curDates);
    //        System.out.println(strs);
    //        //开始时间
    //        int sth = 00;//小时
    //        int stm = 00;//秒
    //        //结束时间
    //        int eth = 05;//小时
    //        int etm = 59;//秒
    //
    //        String[] dds = new String[] {};
    //
    //        boolean res = false;
    //        // 分取系统时间 小时分
    //        dds = strs.split(":");
    //        int dhs = Integer.parseInt(dds[0]);
    //        int dms = Integer.parseInt(dds[1]);
    //
    //        if (sth <= dhs && dhs <= eth) {
    //            if (sth == dhs && stm >= dms) {
    //            	res = true;
    //            } else if (dhs == eth && etm <= dms) {
    //            	res = true;
    //            } else {
    //            	res = false;
    //            }
    //        } else {
    //        	res = false;
    //        }
    //		return res;
    val asTime1: Boolean
        get() {
            val cal = Calendar.getInstance()
            val hour = cal.get(Calendar.HOUR_OF_DAY)
            val minute = cal.get(Calendar.MINUTE)
            val minuteOfDay = hour * 60 + minute
            val start = 0 * 60 + 0
            val end = 6 * 60
            return minuteOfDay in start..end
        }

    // 当前日期
    // 获取小时
    // 获取分钟
    // 从0:00分开是到目前为止的分钟数
    // 起始时间 17:20的分钟数
    // 结束时间 19:00的分钟数
    //		SimpleDateFormat formatters = new SimpleDateFormat("HH:mm");
    //        Date curDates = new Date(System.currentTimeMillis());// 获取当前时间
    //        String strs = formatters.format(curDates);
    //        System.out.println(strs);
    //        //开始时间
    //        int sth = 06;//小时
    //        int stm = 00;//秒
    //        //结束时间
    //        int eth = 8;//小时
    //        int etm = 59;//秒
    //
    //        String[] dds = new String[] {};
    //
    //        boolean res = false;
    //        // 分取系统时间 小时分
    //        dds = strs.split(":");
    //        int dhs = Integer.parseInt(dds[0]);
    //        int dms = Integer.parseInt(dds[1]);
    //
    //        if (sth <= dhs && dhs <= eth) {
    //            if (sth == dhs && stm >= dms) {
    //            	res = true;
    //            } else if (dhs == eth && etm <= dms) {
    //            	res = true;
    //            } else {
    //            	res = false;
    //            }
    //        } else {
    //        	res = false;
    //        }
    //		return res;
    val asTime2: Boolean
        get() {
            val cal = Calendar.getInstance()
            val hour = cal.get(Calendar.HOUR_OF_DAY)
            val minute = cal.get(Calendar.MINUTE)
            val minuteOfDay = hour * 60 + minute
            val start = 6 * 60
            val end = 9 * 60
            return minuteOfDay in start..end
        }

    fun logs(cls: Class<*>, msg: String) {
        logs(cls.simpleName, msg)
    }

    fun logs(tag: String = "", msg: String) {
        if (BuildConfig.LOG_DEBUG)
            Log.e(tag, msg)
    }

    inline fun <reified T : Any> parserJson(data: String): T {
        return Gson().fromJson(data, T::class.java)
    }

//    /**
//     * 获取手机设备MAC地址 ， 此处需要动态获取权限
//     */
//    @SuppressLint("MissingPermission", "HardwareIds")
//    fun getDeviceID(context: Context): String? {
//        var deviceid: String? = ""
//        val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//        deviceid = tm.deviceId
//        if (deviceid == null || deviceid.isEmpty()) {
//            val manager = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
//            deviceid = manager.connectionInfo.macAddress
//        }
//        return deviceid
//    }

    fun getMetaValue(context: Context?, metaKey: String?): String? {
        var metaData: Bundle? = null
        var apiKey: String? = null
        if (context == null || metaKey == null) {
            return null
        }
        val ai = context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
        if (null != ai) {
            metaData = ai.metaData
        }
        if (null != metaData) apiKey = metaData.getString(metaKey)
        return apiKey
    }

    fun getFloat(pri: String): String {
        val decimalFormat = DecimalFormat("0.00")// 构造方法的字符格式这里如果小数不足2位,会以0补足.
        val price = java.lang.Float.parseFloat(pri)
        return decimalFormat.format(price.toDouble())
    }

    fun getType(type: Int): String {
        when (type) {
            0 -> return "网点入金"
            1 -> return "买券"
            2 -> return "卖券"
            3 -> return "系统直入"
            4 -> return "买平仓"
            5 -> return "卖平仓"
            else -> return ""
        }
    }

    /**
     * Get package version.
     *
     * @return package version
     */
    fun getPackageVer(context: Context): String {
        var sPackage = "1.0.0"
        try {
            val pi = context.packageManager.getPackageInfo(context.packageName, 0)
            sPackage = pi.versionName
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return sPackage
    }

    fun install(context: Context, file: File) {
        val installintent = Intent()
        installintent.action = Intent.ACTION_VIEW
        installintent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        installintent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive")
        context.startActivity(installintent)
    }

    fun installNormal(context: Context, apkFile: File) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val apkUri = FileProvider.getUriForFile(context, "${BuildConfig.APPLICATION_ID}.fileProvider", apkFile)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive")
        } else {
            intent.setDataAndType(Uri.fromFile(apkFile),
                    "application/vnd.android.package-archive")
        }
        context.startActivity(intent)
    }

    fun getPackageCode(context: Context): Int {
        var sPackage = 0
        try {
            val pi = context.packageManager.getPackageInfo(context.packageName, 0)
            sPackage = pi.versionCode
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return sPackage
    }

    fun isMobileNO(mobiles: String): Boolean {
        val telRegex = "[1][3456789]\\d{9}"
        return if (TextUtils.isEmpty(mobiles))
            false
        else
            mobiles.matches(telRegex.toRegex())
    }

    @SuppressLint("SimpleDateFormat")
    fun formatMidTime(time: String?, eTime: String): String {
        var display = ""
        val tMin = 60 * 1000
        val tHour = 60 * tMin
        val tDay = 24 * tHour

        if (time != null) {
            try {
                val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                // Date tDate = new SimpleDateFormat(pattern).parse(time);
                val tDate = sdf.parse(time)// 传进的时间
                val today = sdf.parse(eTime)
                val thisYearDf = SimpleDateFormat("yyyy")
                val todayDf = SimpleDateFormat("yyyy-MM-dd")
                val thisYear = Date(thisYearDf.parse(thisYearDf.format(today)).time)
                val yesterday = Date(todayDf.parse(todayDf.format(today)).time)
                val beforeYes = Date(yesterday.time - tDay)

                if (tDate != null) {
                    val halfDf = SimpleDateFormat("yyyy-MM-dd")
                    val dTime = today.time - tDate.time
                    if (tDate.before(thisYear)) {
                        display = SimpleDateFormat("yyyy-MM-dd").format(tDate)
                    } else {
                        if (dTime < tMin) {
                            display = Math.ceil((dTime / 1000).toDouble()).toInt().toString() + "秒"
                        } else if (dTime < tHour) {
                            display = Math.ceil((dTime / tMin).toDouble()).toInt().toString() + "分"
                            display = display + Math.ceil(((dTime - Math.ceil((dTime / tMin).toDouble()).toInt() * tMin) / 1000).toDouble()).toInt() + "秒"
                        } else if (dTime < tDay && tDate.after(yesterday)) {
                            display = Math.ceil((dTime / tHour).toDouble()).toInt().toString() + "小时"
                            //display= display +(int)Math.ceil((dTime -(int) Math.ceil(dTime / tHour) *tHour)/);
                        } else if (tDate.after(beforeYes) && tDate.before(yesterday)) {
                            // display = "昨天" + new
                            // SimpleDateFormat("HH:mm").format(tDate);
                            display = "大于1天"
                        } else {
                            val betweenDays = (today.time - tDate.time) / (1000 * 3600 * 24)
                            display = "大于" + betweenDays + "天"
                        }
                    }
                }
            } catch (e: Exception) {
                display = ""
                e.printStackTrace()
            }

        }
        return display
    }

    fun formatMidTime(time: String?): String {
        var display = ""
        val tMin = 60 * 1000
        val tHour = 60 * tMin
        val tDay = 24 * tHour

        if (time != null) {
            try {
                val sdf = SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss")
                // Date tDate = new SimpleDateFormat(pattern).parse(time);
                val tDate = sdf.parse(time)// 传进的时间
                val today = Date()
                val thisYearDf = SimpleDateFormat("yyyy")
                val todayDf = SimpleDateFormat("yyyy-MM-dd")
                val thisYear = Date(thisYearDf.parse(
                        thisYearDf.format(today)).time)
                val yesterday = Date(todayDf.parse(todayDf.format(today))
                        .time)
                val beforeYes = Date(yesterday.time - tDay)

                if (tDate != null) {
                    val halfDf = SimpleDateFormat("yyyy-MM-dd")
                    val dTime = today.time - tDate.time
                    if (tDate.before(thisYear)) {
                        display = SimpleDateFormat("yyyy-MM-dd")
                                .format(tDate)
                    } else {
                        if (dTime < tMin) {
                            var mm = Math.ceil((dTime / 1000).toDouble()).toInt()
                            if (mm < 0)
                                mm = 1
                            display = mm.toString() + "秒"
                        } else if (dTime < tHour) {
                            display = Math.ceil((dTime / tMin).toDouble()).toInt().toString() + "分"
                            display = display + Math.ceil(((dTime - Math.ceil((dTime / tMin).toDouble()).toInt() * tMin) / 1000).toDouble()).toInt() + "秒"
                        } else if (dTime < tDay && tDate.after(yesterday)) {
                            display = Math.ceil((dTime / tHour).toDouble()).toInt().toString() + "小时"
                            //display= display +(int)Math.ceil((dTime -(int) Math.ceil(dTime / tHour) *tHour)/);
                        } else if (tDate.after(beforeYes) && tDate.before(yesterday)) {
                            // display = "昨天" + new
                            // SimpleDateFormat("HH:mm").format(tDate);
                            display = "大于1天"
                        } else {
                            val betweenDays = (today.time - tDate.time) / (1000 * 3600 * 24)
                            display = "大于" + betweenDays + "天"
                        }
                    }
                }
            } catch (e: Exception) {
                display = ""
                e.printStackTrace()
            }
        }
        return display
    }

    /**
     * 格式化时间（输出类似于 刚刚, 4分钟前, 一小时前, 昨天这样的时间）
     *
     * @param time         需要格式化的时间 如"2014-07-14 19:01:45"
     * @param :"yyyy-MM-dd HH:mm:ss"
     *
     *
     *
     *
     * 如果为空则默认使用"yyyy-MM-dd HH:mm:ss"格式
     * @return time为null，或者时间格式不匹配，输出空字符""
     */

    fun formatDisplayTime(time: String?): String {
        var display = ""
        val tMin = 60 * 1000
        val tHour = 60 * tMin
        val tDay = 24 * tHour

        if (time != null) {
            try {
                val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                // Date tDate = new SimpleDateFormat(pattern).parse(time);
                val tDate = sdf.parse(time)// 传进的时间
                val today = Date()
                val thisYearDf = SimpleDateFormat("yyyy")
                val todayDf = SimpleDateFormat("yyyy-MM-dd")
                val thisYear = Date(thisYearDf.parse(thisYearDf.format(today)).time)
                val yesterday = Date(todayDf.parse(todayDf.format(today)).time)
                val beforeYes = Date(yesterday.time - tDay)
                if (tDate != null) {
                    val halfDf = SimpleDateFormat("yyyy-MM-dd")
                    val dTime = today.time - tDate.time
                    if (tDate.before(thisYear)) {
                        display = SimpleDateFormat("yyyy-MM-dd").format(tDate)
                    } else {
                        if (dTime < tMin) {
                            display = "今天"
                        } else if (dTime < tHour) {
                            display = "今天"// = (int) Math.ceil(dTime / tMin) +
                            // "分钟前";
                        } else if (dTime < tDay && tDate.after(yesterday)) {
                            // display = (int) Math.ceil(dTime / tHour) + "小时前";
                            display = "今天"
                        } else if (tDate.after(beforeYes) && tDate.before(yesterday)) {
                            // display = "昨天" + new
                            // SimpleDateFormat("HH:mm").format(tDate);
                            display = "昨天"
                        } else {
                            display = halfDf.format(tDate)
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        return display
    }

    fun isAMapClientAvailable(context: Context): Boolean {
        val packageManager = context.packageManager
        val pinfo = packageManager.getInstalledPackages(0)
        if (pinfo != null) {
            for (i in pinfo.indices) {
                val pn = pinfo[i].packageName
                if (pn == "com.autonavi.minimap") {
                    return true
                }
            }
        }
        return false
    }

    fun isQQClientAvailable(context: Context): Boolean {
        val packageManager = context.packageManager
        val pinfo = packageManager.getInstalledPackages(0)
        if (pinfo != null) {
            for (i in pinfo.indices) {
                val pn = pinfo[i].packageName
                if (pn == "com.tencent.mobileqq") {
                    return true
                }
            }
        }
        return false
    }

    fun formatDisplayTime(time: String?, pattern: String): String {
        var display = ""
        val tMin = 60 * 1000
        val tHour = 60 * tMin
        val tDay = 24 * tHour
        if (time != null) {
            try {
                val tDate = SimpleDateFormat(pattern).parse(time)
                val today = Date()
                val thisYearDf = SimpleDateFormat("yyyy")
                val todayDf = SimpleDateFormat("yyyy-MM-dd")
                val thisYear = Date(thisYearDf.parse(thisYearDf.format(today)).time)
                val yesterday = Date(todayDf.parse(todayDf.format(today)).time)
                val beforeYes = Date(yesterday.time - tDay)
                if (tDate != null) {
                    val halfDf = SimpleDateFormat("MM-dd HH:mm")
                    val dTime = today.time - tDate.time
                    if (tDate.before(thisYear)) {
                        display = SimpleDateFormat("yyyy-MM-dd").format(tDate)
                    } else {
                        if (dTime < tMin) {
                            display = "刚刚"
                        } else if (dTime < tHour) {
                            display = Math.ceil((dTime / tMin).toDouble()).toInt().toString() + "分钟前"
                        } else if (dTime < tDay && tDate.after(yesterday)) {
                            display = Math.ceil((dTime / tHour).toDouble()).toInt().toString() + "小时前"
                        } else if (tDate.after(beforeYes) && tDate.before(yesterday)) {
                            display = "昨天"// + new
                            // SimpleDateFormat("HH:mm").format(tDate);
                        } else {
                            display = halfDf.format(tDate)
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        return display
    }

    fun getScreenViewBottomHeight(view: View): Int {
        return view.bottom
    }

    fun isBackground(context: Context): Boolean {
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val appProcesses = activityManager.runningAppProcesses
        for (appProcess in appProcesses) {
            if (appProcess.processName == context.packageName) {
                /*
                 * BACKGROUND=400 EMPTY=500 FOREGROUND=100 GONE=1000
				 * PERCEPTIBLE=130 SERVICE=300 ISIBLE=200
				 */
                Log.i(context.packageName, "此appimportace ="
                        + appProcess.importance
                        + ",context.getClass().getName()="
                        + context.javaClass.name)
                if (appProcess.importance != RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    Log.i(context.packageName, "处于后台" + appProcess.processName)
                    return true
                } else {
                    Log.i(context.packageName, "处于前台" + appProcess.processName)
                    return false
                }
            }
        }
        return false
    }

    /**
     * 判断当前应用程序处于前台还是后台
     *
     * @param context
     * @return 程序没有运行或者在后台运行 true，程序在前台运行返回false
     */
    fun isApplicationBroughtToBackground(context: Context): Boolean {
        val am = context
                .getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val tasks = am.getRunningTasks(1)
        if (!tasks.isEmpty()) {
            val topActivity = tasks[0].topActivity
            if (topActivity.packageName != context.packageName) {
                return true
            }
        }
        return false

    }

    fun RunApp(context: Context, packageName: String, intent: Intent?) {
        var intent = intent
        if (null == intent)
            intent = context.packageManager.getLaunchIntentForPackage(
                    packageName)
        val manager = context
                .getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val task_info = manager.getRunningTasks(20)
        var className = ""
        for (i in task_info.indices) {
            if (packageName == task_info[i].topActivity
                            .packageName) {
                className = task_info[i].topActivity.className
                // 这里是指从后台返回到前台 前两个的是关键
                intent!!.action = Intent.ACTION_MAIN
                intent.addCategory(Intent.CATEGORY_LAUNCHER)
                try {
                    intent.component = ComponentName(context, Class
                            .forName(className))
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace()
                }
                //
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                        or Intent.FLAG_ACTIVITY_NEW_TASK
                        or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
                context.startActivity(intent)
                return
            }
        }
        //        Intent intent2 = context.getPackageManager().getLaunchIntentForPackage(
        //                packageName);
        //        context.startActivity(intent2);
        context.startActivity(intent)
    }

    private fun RunApp(context: Context, packageName: String) {
        val intent = context.packageManager.getLaunchIntentForPackage(
                packageName)
        RunApp(context, packageName, intent)
    }

    fun isTopActivity(context: Context, tag: String): Boolean {
        var isTop = false
        val am = context
                .getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val cn = am.getRunningTasks(1)[0].topActivity

        if (cn.className.contains(tag)) {
            isTop = true
        }

        return isTop
    }

    /**
     * 判断是否黑屏
     *
     * @param c
     * @return
     */
    fun isScreenLocked(c: Context): Boolean {
        val mKeyguardManager = c
                .getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        return !mKeyguardManager.inKeyguardRestrictedInputMode()
    }


    fun getTime(sTime: String, eTime: String): Boolean {

        var res = false
        try {
            // 开始时间
            val sT = sTime.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val sth = Integer.parseInt(sT[0])// 小时
            val stm = Integer.parseInt(sT[1])// 秒
            // 结束时间
            val eT = eTime.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val eth = Integer.parseInt(eT[0])
            val etm = Integer.parseInt(eT[1])


            val cal = Calendar.getInstance()// 当前日期
            val hour = cal.get(Calendar.HOUR_OF_DAY)// 获取小时
            val minute = cal.get(Calendar.MINUTE)// 获取分钟
            val minuteOfDay = hour * 60 + minute// 从0:00分开是到目前为止的分钟数

            val start = sth * 60 + stm// 起始时间 17:20的分钟数
            val end = eth * 60 + etm// 结束时间 19:00的分钟数
            res = minuteOfDay >= start && minuteOfDay <= end
        }// 小时
        // 秒
        catch (ex: Exception) {
            res = false
            ex.printStackTrace()
        } finally {
            return res
        }

    }

    /*
     * 将时间戳转换为时间
     */
    fun stampToDate(s: String): String {
        val res: String
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val lt = s.toLong()
        val date = Date(lt)
        res = simpleDateFormat.format(date)
        return res
    }

    fun GetPlayTime(time: String): Int {
        var time = time
        var len = 0
        try {
            time = time.replace(" ", "")

            val temp = time.substring(0, 2)
            val sec = time.substring(3, 5)
            len = Integer.parseInt(temp) * 60 + Integer.parseInt(sec)
        } catch (ex: Exception) {
            len = 0
        }

        return len * 1000
    }

    /**
     * 检测邮箱地址是否合法
     *
     * @param email
     * @return true合法 false不合法
     */
    fun isEmail(email: String?): Boolean {
        if (null == email || "" == email) return false
        //        Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        val p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")//复杂匹配
        val m = p.matcher(email)
        return m.matches()
    }

    fun checkEmail(email: String): Boolean {
        var flag = false
        try {
            val check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"
            val regex = Pattern.compile(check)
            val matcher = regex.matcher(email)
            flag = matcher.matches()
        } catch (e: Exception) {
            flag = false
        }

        return flag
    }

    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun px2dip(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    /**
     * 获取屏幕高度(px)
     */
    fun getScreenHeight(context: Context): Int {
        return context.resources.displayMetrics.heightPixels
    }

    /**
     * 获取屏幕宽度(px)
     */
    fun getScreenWidth(context: Context): Int {
        return context.resources.displayMetrics.widthPixels
    }

//    fun isDealTime(): Boolean {
//        val currTime = System.currentTimeMillis()
//        val ymd = TimeUtil.getDayYYYYTime(currTime)
//        val startTime = TimeUtil.StringTimeToLong("$ymd 09:15:00", TimeUtil.DATE_YMD_HMS)
//        val endTime = TimeUtil.StringTimeToLong("$ymd 11:30:00", TimeUtil.DATE_YMD_HMS)
//        val startTime1 = TimeUtil.StringTimeToLong("$ymd 13:00:00", TimeUtil.DATE_YMD_HMS)
//        val endTime1 = TimeUtil.StringTimeToLong("$ymd 15:00:00", TimeUtil.DATE_YMD_HMS)
//
//        return TimeUtil.checkTimeInTime(currTime, startTime, endTime) || TimeUtil.checkTimeInTime(currTime, startTime1, endTime1)
//    }

    /**
     * 数值加
     */
    fun numAdd(num: Int, value: Int): String {
        return Arith.add(num.toString(), value.toString()).toString()
    }

    fun numAdd(num: String, value: String): Double {
        return Arith.add(num, value)
    }

    fun numAdd(num: Double, value: Double): String {
        return Arith.add(num, value).toString()
    }

    fun formatValue(value: Any): String {
        return String.format("%.4f", value)
    }

    /**
     * 数据减
     */
    fun numJian(num: Int, value: Int): String {
        var newNum = 0
        if (num > 0) {
            newNum = Arith.sub(num.toString(), value.toString()).toInt()
        } else {
            newNum = 0
        }
        return "$newNum"
    }

    fun numJian(num: Double, value: Double): String {
        var newNum = 0.0
        if (num > 0) {
            newNum = Arith.sub(num, value)
        } else {
            newNum = 0.0
        }
        return "$newNum"
    }

    fun numJian(num: String, value: String): Double {
        var newNum = 0.0
        if (num.toDouble() > 0) {
            newNum = Arith.sub(num, value)
        } else {
            newNum = 0.0
        }
        return newNum
    }

    fun hideKeyBroad(context: Context) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * @param dv
     * @param dv1
     */
    fun checkZF(dv: String, dv1: String): String {
        return "${getZF(dv, dv1)}%"
    }

    /**
     * @param dv
     * @param dv1
     */
    fun getZF(dv: String, dv1: String): Double {
        val cha = Arith.sub(dv, dv1).toString()
        val bf = Arith.mul("100.00", cha).toString()
        return Arith.div(dv1, bf, 2)

//        logs("tag", "最新价 = $dv  昨日价 = $dv1  差价 = $cha  乘100 = $bf  幅度 = $temp")
//        return temp
    }
}
