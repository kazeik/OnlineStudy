package com.hope.onlinestudy.model

/**
 * 消息
 * @property courseId Int
 * @property courseName String
 * @property createtime TimeModel
 * @property id Int
 * @property messageInfo String
 * @property messageReadState Int
 * @property messageState Int
 * @property orderId Long
 * @property userId Int
 * @constructor
 */
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