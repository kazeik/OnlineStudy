package com.hope.onlinestudy.model

data class PointListModel(
    val list: List<PointModel>,
    val msg: String,
    val shoopPoint: Int,
    val statusCode: Int,
    val studyPoint: Int,
    val totalPage: Int
)