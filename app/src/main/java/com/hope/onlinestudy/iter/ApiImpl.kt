package com.hope.onlinestudy.iter

import android.text.TextUtils
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.HttpNetUtils
import com.lidroid.xutils.http.RequestParams
import com.lidroid.xutils.http.client.HttpRequest
import org.json.JSONObject

/**
 * @author hope.chen, QQ:77132995, email:kazeik@163.com
 * 2018 10 16 11:06
 * 类说明:
 */
class ApiImpl(private val callback: INetStrListener) : ApiInter {
    override fun getUserPoint(page: Int) {
        val jsonObject = JSONObject()
        jsonObject.put("currentPage",page)
        jsonObject.put("userId",ApiUtils.userId)
        val params = RequestParams()
        params.addQueryStringParameter("message", jsonObject.toString())
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.GET, ApiUtils.toMyPoint, params, callback)
    }

    override fun getUserInfo(userId: String) {
        val params = RequestParams()
        params.addBodyParameter("message",  JSONObject().put("userId",userId).toString())
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.POST, ApiUtils.toMyInfo, params, callback)
    }

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
        val jsonojbect = JSONObject()
        jsonojbect.put("newpassword",newpass)
        jsonojbect.put("oldpassword",oldPass)
        jsonojbect.put("userId",ApiUtils.userId)
        val params = RequestParams()
        params.addBodyParameter("message", jsonojbect.toString())
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.POST, ApiUtils.changePass, params, callback)
    }


    override fun getmessage(type: String, page: Int) {
        val jsonObject = JSONObject()
        jsonObject.put("currentPage",page)
        jsonObject.put("userId",ApiUtils.userId)
        jsonObject.put("msgType",type)
        val params = RequestParams()
        params.addQueryStringParameter("message", jsonObject.toString())
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.GET, ApiUtils.toMyMsg, params, callback)
    }

    override fun getVerfiyCode(phone: String, tag: String) {
    }

    override fun login(username: String, userpwd: String, tag: String) {
        val map = HashMap<String,String>()
        map["username"] = username
        map["userpwd"] = userpwd
        val params = RequestParams()
        params.addBodyParameter("message", JSONObject(map).toString())
        HttpNetUtils.getInstance().requestData(HttpRequest.HttpMethod.POST, ApiUtils.login, tag, params, callback)

    }
}