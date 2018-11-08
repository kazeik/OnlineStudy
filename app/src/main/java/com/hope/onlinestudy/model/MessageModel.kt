package com.hope.onlinestudy.model

data class MessageModel(
        val courseId: Int,
        val courseName: String,
        val createtime: TimeModel,
        val id: Int,
        val messageInfo: String,
        val messageReadState: Int,
        val messageState: Int,
        val orderId: Long,
        val userId: Int
)