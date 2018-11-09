package com.hope.onlinestudy.utils


/**
 * @author hope.chen
 *         QQ:77132995 email:kazeik@163.com
 *         2018 11 01 11:38
 * 类说明:
 */

object ApiUtils {
    val baseUrl = "http://zxserver.f3322.net:8080/appstudy/"
    val imgUrl = "http://zxserver.f3322.net:8080/comm/"

    //    获取消息
    val toMyMsg = "apphome/toMyMsg"
    //    登录
    val login = "apphome/appLogin"
    //退出登录
    val exitlogin = "apphome/exitLogin"
    //    我的课程
    val toMyCourse = "apphome/toMyCourse"
    val toAppHomePage = "apphome/toAppHomePage"
    //我的考试
    val toAppExam = "apphome/toAppExam"
    //我的笔记
    val toMyNote = "apphome/toMyNote"
    //    个人信息
    val toMyInfo = "apphome/toMyInfo"
    //    更改密码
    val changePass = "apphome/updateNewPassword"
    //    我的积分
    val toMyPoint = "apphome/toMyPoint"
    val toMyOrder = "apphome/toMyOrder"
    val toMyCenter = "apphome/toMyCenter"

    val searchLesson = "apphome/applikecoursegoodspaging"
}