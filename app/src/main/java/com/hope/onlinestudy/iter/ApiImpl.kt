package com.hope.onlinestudy.iter

import com.hope.lib.iter.INetStrListener
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.HttpNetUtils
import com.lidroid.xutils.http.RequestParams
import com.lidroid.xutils.http.client.HttpRequest

/**
 * @author hope.chen, QQ:77132995, email:kazeik@163.com
 * 2018 10 16 11:06
 * 类说明:
 */
class ApiImpl() : ApiInter {
    override fun getmessage(type: String, page: Int, tag: String,callback:INetStrListener) {
        val params = RequestParams()
        params.addBodyParameter("method",type)
        params.addBodyParameter("currentPage","$page")
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.POST,ApiUtils.getmessage,tag,params,callback)
    }

    override fun getVerfiyCode(phone: String, tag: String,callback:INetStrListener) {
    }

    override fun login(username: String, userpwd: String, tag: String,callback:INetStrListener) {
        val params = RequestParams()
        params.addBodyParameter("username", username)
        params.addBodyParameter("userpwd", userpwd)
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.POST, ApiUtils.login, tag, params, callback)

    }
}