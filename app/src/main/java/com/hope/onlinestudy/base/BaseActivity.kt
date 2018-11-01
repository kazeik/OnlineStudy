package com.hope.onlinestudy.base

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.hope.lib.iter.INetStrListener
import com.hope.lib.view.LoadingView
import com.hope.onlinestudy.MainApplication
import com.hope.onlinestudy.iter.ApiImpl
import com.hope.onlinestudy.iter.ApiInter

/**
 * @author kazeik.chen, QQ:77132995, email:kazeik@163.com
 * 2018 09 14 14:13
 * 类说明:
 */
abstract class BaseActivity : FragmentActivity(), INetStrListener {
    var myApplicaton: MainApplication? = null
    private var loadingView: LoadingView? = null
    val apiInter :ApiInter by lazy { ApiImpl() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        myApplicaton = application as MainApplication
        myApplicaton?.addActivity(this)

        setContentView(getLayoutView())
        initData()
    }

    abstract fun getLayoutView(): Int

    abstract fun initData()

    override fun getNetStr(tag: String, body: String?) {
        hideDialog()
    }

    override fun netError(tag: String, body: String?, e: Exception?) {
        hideDialog()
    }

    override fun reLogin() {
    }

    fun startOther(cls: Class<*>) {
        startOther(Intent(this, cls))
    }

    fun startOther(intt: Intent) {
        startOther(intt, false)
    }

    fun startOther(intt: Intent, finish: Boolean) {
        startActivity(intt)
        if (finish) finish()
    }

    fun startOther(cls: Class<*>, finish: Boolean) {
        startOther(cls)
        if (finish) finish()
    }

    fun showDialog(msg: String? = "加载中", cancel: Boolean = false) {
        loadingView = LoadingView.getInstance(msg, cancel)
        loadingView?.show(fragmentManager, "dialog")
    }

    fun showDialog(cancel: Boolean = false) {
        showDialog("加载中", cancel)
    }

    fun hideDialog() {
        if (loadingView?.activity != null) {
            loadingView?.dismissAllowingStateLoss()
            loadingView = null
        }
    }
}