package com.hope.onlinestudy.utils


/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 11 01 11:38
 * 类说明:
 */

object ApiUtils {
    val baseUrl = "http://zxserver.f3322.net:8080/study/"
    val imgUrl = "http://zxserver.f3322.net:8080/comm/"
    var userToken: String? = null
    var userId: String? = null
    //    获取消息
    val toMyMsg = "api/toMyMsg"
    //    登录
    val login = "api/appLogin"
    //退出登录
    val exitlogin = "apphome/exitLogin"
    //    我的课程
    val toMyCourse = "apphome/toMyCourse"
    val toAppHomePage = "apphome/toAppHomePage"

    val toTypeList = "apphome/toTypeList"
    //我的考试
    val toAppExam = "apphome/toAppExam"
    //我的笔记
    val toMyNote = "apphome/toMyNote"
    //    个人信息
    val toMyInfo = "api/toMyInfo"
    //    更改密码
    val changePass = "api/updateNewPassword"
    //    我的积分
    val toMyPoint = "api/myPoint"
    val toMyOrder = "apphome/toMyOrder"
    val toMyCenter = "apphome/toMyCenter"
    //课程搜索
    val searchLesson = "apphome/applikecoursegoodspaging"

    val delnote = "usernote/deleteNote"
}