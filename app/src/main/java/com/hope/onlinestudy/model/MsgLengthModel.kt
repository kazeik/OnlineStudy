package com.hope.onlinestudy.model

data class MsgLengthModel(
        val code: Int,
        val data: List<MessageSize>,
        val message: String
)