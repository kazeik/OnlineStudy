package com.hope.onlinestudy.model

data class AddTime(
        val date: Int,
        val day: Int,
        val hours: Int,
        val minutes: Int,
        val month: Int,
        val seconds: Int,
        val time: Long,
        val timezoneOffset: Int,
        val year: Int
)