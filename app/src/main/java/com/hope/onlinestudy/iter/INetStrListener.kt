package com.hope.onlinestudy.iter

/**
 * @author hope.chen , QQ:77132995,email:kazeik@163.com
 * 2018 09 14 网络请求后的数据 11:39
 * 类说明:
 */
interface INetStrListener {
    /**
     * 网络请求成功结果
     * @param tag 当前请求标识
     * @param body 服务端返回的数据
     */
    fun getNetStr(tag: String, body: String)

    /**
     * 网络请求错误
     * @param tag 当前请求标识
     * @param body 服务端返回的内容，有可能是异常信息
     */
    fun netError(tag: String, body: String?,e:Exception?)

    fun reLogin()
}
