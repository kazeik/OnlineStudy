package com.hope.onlinestudy.utils

import android.text.TextUtils
import com.google.gson.JsonParseException
import com.google.gson.JsonParser
import com.hope.onlinestudy.iter.INetStrListener
import com.hope.onlinestudy.MainApplication
import com.hope.onlinestudy.utils.Utils.logs
import com.lidroid.xutils.HttpUtils
import com.lidroid.xutils.exception.HttpException
import com.lidroid.xutils.http.HttpHandler
import com.lidroid.xutils.http.RequestParams
import com.lidroid.xutils.http.ResponseInfo
import com.lidroid.xutils.http.callback.RequestCallBack
import com.lidroid.xutils.http.client.HttpRequest
import org.apache.http.entity.StringEntity
import java.io.File

@Suppress("DEPRECATION")
/**
 * @author kazeik.chen, QQ:77132995, email:kazeik@163.com
 * 2017 04 27 11:28
 * 类说明:
 */
class HttpNetUtils {
    private var handler: HttpHandler<String>? = null

    private lateinit var utils: HttpUtils

    init {
        getHttpUtils()
    }

    fun requestData(method: HttpRequest.HttpMethod? = HttpRequest.HttpMethod.GET, url: String, listener: INetStrListener? = null) {
        requestData(method, url, url, null, listener)
    }

    /**
     *
     * @param method HttpRequest.HttpMethod?
     * @param url String
     * @param tag String
     * @param listener INetStrListener?
     */
    fun requestData(method: HttpRequest.HttpMethod? = HttpRequest.HttpMethod.GET, url: String, tag: String = "", listener: INetStrListener? = null) {
        requestData(method, url, tag, null, listener)
    }
    fun requestData(method: HttpRequest.HttpMethod? = HttpRequest.HttpMethod.GET, url: String, _params: RequestParams? = null, listener: INetStrListener? = null) {
        var params = _params
        if (null == params)
            params = RequestParams()
        send(method, url, params, url, listener)
    }

    /**
     *
     * @param method HttpRequest.HttpMethod?
     * @param url String
     * @param tag String
     * @param _params RequestParams?
     * @param listener INetStrListener?
     */
    fun requestData(method: HttpRequest.HttpMethod? = HttpRequest.HttpMethod.GET, url: String, tag: String = "", _params: RequestParams? = null, listener: INetStrListener? = null) {
        var params = _params
        if (null == params)
            params = RequestParams()
        send(method, url, params, tag, listener)
    }

    /**
     *
     * @param url String
     * @param path String
     * @param callBack RequestCallBack<File>
     */
    fun getFile(url: String, path: String, callBack: RequestCallBack<File>) {
        utils.download(url, path, true, true, callBack)
    }

    /**
     *
     * @param url String
     * @param path String
     * @param callBack RequestCallBack<File>
     */
    fun getFileByCookie(url: String, path: String, callBack: RequestCallBack<File>) {
        val tempcookie = PreferencesUtils.getString(MainApplication.appContext!!, "cookie")
        val params = RequestParams()
        if (null != tempcookie) {
            params.addHeader("Cookie", tempcookie)
        }
        utils.download(url, path, params, true, true, callBack)
    }

    private fun getHttpUtils(): HttpUtils {
        utils = HttpUtils()
        with(utils) {
            configRequestRetryCount(1)
            configTimeout(10 * 1000)
            configSoTimeout(10 * 1000)
            configCurrentHttpCacheExpiry(5)
        }
        return utils
    }


    fun requestJsonBody(apiUrl: String, jsonBody: String, tag: String, listener: INetStrListener?) {
        val params = RequestParams("UTF-8")
        params.setBodyEntity(StringEntity(jsonBody, "utf-8"))
        params.setContentType("application/json")
        send(HttpRequest.HttpMethod.POST, apiUrl, params, tag, listener)
    }

    private fun send(method: HttpRequest.HttpMethod?, apiUrl: String, params: RequestParams, tag: String, listener: INetStrListener?) {
        if (tag != ApiUtils.login) {
            val tempcookie = PreferencesUtils.getString(MainApplication.appContext!!, "cookie")
            if (null != tempcookie)
                params.addQueryStringParameter("userId", tempcookie)
            params.addQueryStringParameter("logintype", "1")
        }
        val url = "${ApiUtils.baseUrl}$apiUrl"
        logs("tag", "url = $url")
        handler = utils.send(method, url, params, object : RequestCallBack<String>(tag) {
            override fun onSuccess(responseInfo: ResponseInfo<String>) {
                val heads = responseInfo.allHeaders
                if (heads != null && !heads.isEmpty())
                    for (item in heads) {
                        if (item.name == "Set-Cookie") {
                            if (!TextUtils.isEmpty(item.value) && item.value.startsWith("study_app_login_cookie")) {
                                val temp = item.value.substring(0, item.value.indexOf(";"))
                                val tempCookie = temp.substring(temp.indexOf("=") + 1, temp.length)
                                PreferencesUtils.putString(MainApplication.appContext!!, "cookie", tempCookie)
                            }
                        }
                    }
                val body = responseInfo.result
                logs("tag", body)
                listener?.getNetStr(getUserTag().toString(), body)
            }

            override fun onFailure(e: HttpException, s: String) {
                logs("http", "请求失败：$tag | $s")
                listener?.netError(getUserTag().toString(), s, e)
            }

        })
    }

    private fun isGoodJson(json: String): Boolean {
        if (TextUtils.isEmpty(json)) {
            return false
        }
        return try {
            JsonParser().parse(json)
            true
        } catch (e: JsonParseException) {
            false
        }
    }

    fun cancelAll() {
        handler?.cancel()
        handler = null
    }

    companion object {
        fun getInstance(): HttpNetUtils {
            synchronized(HttpNetUtils::class.java) {
                return HttpNetUtils()
            }
        }
    }
}
