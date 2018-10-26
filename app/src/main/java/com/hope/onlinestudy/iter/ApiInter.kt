package com.hope.onlinestudy.iter

/**
 * @author hope.chen, QQ:77132995, email:kazeik@163.com
 * 2018 10 16 11:06
 * 类说明:
 */
interface ApiInter {

    fun login(email: String, password: String)

    fun getVerfiyCode(phone: String)
}