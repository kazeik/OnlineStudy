package com.hope.onlinestudy.model

data class ListUserModel(
    val `data`: List<UserInfoModel>,
    val msg: String,
    val statusCode: Int
)