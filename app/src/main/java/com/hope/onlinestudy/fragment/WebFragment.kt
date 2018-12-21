package com.hope.onlinestudy.fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.TextUtils
import android.view.KeyEvent
import android.webkit.*
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseFragment
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.Utils.logs
import kotlinx.android.synthetic.main.view_webview.*


/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 11 06 09:19
 * 类说明:
 */
class WebFragment : BaseFragment() {
    override fun initView(): Int {
        return R.layout.view_webview
    }

    companion object {
        fun instance(urlPath: String): WebFragment {
            val fragment = WebFragment()
            val bund = Bundle()
            bund.putString("url", urlPath)
            fragment.arguments = bund
            return fragment
        }
    }

    @SuppressLint("JavascriptInterface", "SetJavaScriptEnabled", "AddJavascriptInterface")
    override fun bindData() {
        val urlPath = arguments?.getString("url")
        wvView.loadUrl("${ApiUtils.baseUrl}$urlPath")//加载url

        wvView.addJavascriptInterface(this, "android")//添加js监听 这样html就能调用客户端
        wvView.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                return super.onJsAlert(view, url, message, result)
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
            }

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
            }
        }
        wvView.webViewClient = object : WebViewClient() {
        }

        val webSettings = wvView.settings
        webSettings.javaScriptEnabled = true//允许使用js
        webSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK//不使用缓存，只从网络获取数据.

        //支持屏幕缩放
        webSettings.setSupportZoom(true)
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false
    }

    fun injectIsParams(url: String): String {
        if(!TextUtils.isEmpty(url) && !url.contains("xxxx=1")){
            return if(url.contains("?")){
                "${url}&xxx=1"
            }else {
                "${url}?xxx=1"
            }
        }
        return url
    }


//    override public fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
//        if (wvView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK) {//点击返回按钮的时候判断有没有上一页
//            wvView.goBack() // goBack()表示返回webView的上一页面
//            return true
//        }
//        return super.onKeyDown(keyCode, event)
//    }


        /**
         * JS调用android的方法
         * @param str
         * @return
         */
        @JavascriptInterface //仍然必不可少
        public fun getClient(str: String) {
        }
    }