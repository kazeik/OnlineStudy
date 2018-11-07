package com.hope.onlinestudy.model

data class MessageModel(
        val courseId: Int,
        val courseName: String,
        val createtime: Createtime,
        val id: Int,
        val messageInfo: String,
        val messageReadState: Int,
        val messageState: Int,
        val orderId: Long,
        val userId: Int
)