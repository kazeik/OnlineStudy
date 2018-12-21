package com.hope.onlinestudy.model

import java.io.Serializable

data class UserInfoModel(
    val companyName: String,
    val mobilephone: String,
    val truename: String,
    val userId: Int,
    val userImg: String,
    val useremail: String,
    val username: String,
    val usersex: String
):Serializable