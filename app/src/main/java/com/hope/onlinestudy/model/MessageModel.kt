package com.hope.onlinestudy.model

data class MessageModel(
        val courseId: String,
        val courseName: String,
        val createtime: String,
        val id: Int,
        val messageInfo: String,
        val messageReadState: String,
        val messageState: String,
        val orderId: String,
        val userId: String
)