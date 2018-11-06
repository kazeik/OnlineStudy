package com.hope.onlinestudy.activity

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.text.TextUtils
import android.view.KeyEvent
import android.webkit.*
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.utils.Utils.logs
import kotlinx.android.synthetic.main.view_webview.*

class WebViewActivity : BaseActivity() {
    private var urlPath = "http://zxserver.f3322.net:8080/study/apphome/toAppHomePage"
    override fun getLayoutView(): Int {
        return R.layout.view_webview
    }

    @SuppressLint("JavascriptInterface", "SetJavaScriptEnabled", "AddJavascriptInterface")
    override fun initData() {
        val tempPath:String? = intent.getStringExtra("url")
        if (TextUtils.isEmpty(tempPath)) {
            urlPath = tempPath!!
        }
        wvView.loadUrl(urlPath)

        wvView.addJavascriptInterface(this, "android")
        wvView.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                logs("tag", "js来了")
                result?.confirm()
                return true
//                return super.onJsAlert(view, url, message, result)
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
            }

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
            }
        }
        wvView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                hideDialog()
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                showDialog()
            }
        }

        val webSettings = wvView.settings
        webSettings.javaScriptEnabled = true//允许使用js
        webSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK//不使用缓存，只从网络获取数据.

        //支持屏幕缩放
        webSettings.setSupportZoom(true)
        webSettings.setBuiltInZoomControls(true)
        webSettings.setDisplayZoomControls(false)
    }

    override public fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (wvView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK) {//点击返回按钮的时候判断有没有上一页
            wvView.goBack() // goBack()表示返回webView的上一页面
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    /**
     * JS调用android的方法
     * @param str
     * @return
     */
    @JavascriptInterface //仍然必不可少
    public fun getClient(str: String) {
    }

}
