package com.hope.onlinestudy.iter

/**
 * @author hope.chen, QQ:77132995, email:kazeik@163.com
 * 2018 10 16 11:06
 * 类说明:
 */
interface ApiInter {
    /**
     * @param username
     * @param userpwd
     */
    fun login(username: String, userpwd: String, tag: String)

    fun getVerfiyCode(phone: String, tag: String)
    /**
     * @author
     * @param type
     *      message :消息
     *      notice :通知
     * @param page :default =1
     */
    fun getmessage(type: String, page: Int, tag: String)


    fun changepass(oldPass: String, newpass: String)


    fun sigleRequest(tag: String)

    fun startRegister(phone: String, code: String)

    fun searchlesson(lessonName: String?)
}