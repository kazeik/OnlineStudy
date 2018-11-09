package com.hope.onlinestudy.iter

import android.text.TextUtils
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
    override fun delNote(noteId: String) {
        val params = RequestParams()
        params.addBodyParameter("eduNoteId",noteId)
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.POST,ApiUtils.delnote,params,callback)
    }

    override fun searchlesson(lessonName: String?) {
        val params = RequestParams()
        if (!TextUtils.isEmpty(lessonName)) {
            params.addBodyParameter("name", lessonName)
        }
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.POST, ApiUtils.searchLesson, params, callback)
    }


    override fun sigleRequest(tag: String) {
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.GET, tag, callback)
    }

    override fun startRegister(phone: String, code: String) {
    }


    override fun changepass(oldPass: String, newpass: String) {
        val params = RequestParams()
        params.addBodyParameter("oldpassword", oldPass)
        params.addBodyParameter("newpassword", newpass)
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.GET, ApiUtils.changePass, params, callback)
    }


    override fun getmessage(type: String, page: Int, tag: String) {
        val params = RequestParams()
        params.addBodyParameter("method", type)
        params.addBodyParameter("currentPage", "$page")
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.POST, ApiUtils.toMyMsg, tag, params, callback)
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