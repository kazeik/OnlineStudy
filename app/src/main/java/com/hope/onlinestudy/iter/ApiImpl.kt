package com.hope.onlinestudy.iter

import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.HttpNetUtils
import com.lidroid.xutils.http.RequestParams
import com.lidroid.xutils.http.client.HttpRequest

/**
 * @author hope.chen, QQ:77132995, email:kazeik@163.com
 * 2018 10 16 11:06
 * 类说明:
 */
class ApiImpl(private val callback: INetStrListener) : ApiInter {
    override fun gethomepage() {
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.GET,ApiUtils.toAppHomePage,callback)
    }

    override fun getmessage(type: String, page: Int, tag: String) {
        val params = RequestParams()
        params.addBodyParameter("method", type)
        params.addBodyParameter("currentPage", "$page")
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.POST, ApiUtils.getmessage, tag, params, callback)
    }

    override fun getVerfiyCode(phone: String, tag: String) {
    }

    override fun login(username: String, userpwd: String, tag: String) {
        val params = RequestParams()
        params.addBodyParameter("username", username)
        params.addBodyParameter("userpwd", userpwd)
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.POST, ApiUtils.login, tag, params, callback)

    }
}