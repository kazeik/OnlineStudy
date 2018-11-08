package com.hope.onlinestudy.model

data class ComSlide(
        val slideId: Int,
        val slideImg: String,
        val slideOrder: Int,
        val slideTitle: String,
        val slideType: Int,
        val slideUrl: String,
        val userId: Int
)