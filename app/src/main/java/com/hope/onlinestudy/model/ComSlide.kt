package com.hope.onlinestudy.model

/**
 * 幻灯片
 * @property slideId Int
 * @property slideImg String
 * @property slideOrder Int
 * @property slideTitle String
 * @property slideType Int
 * @property slideUrl String
 * @property userId Int
 * @constructor
 */
data class ComSlide(
        val slideId: Int,
        val slideImg: String,
        val slideOrder: Int,
        val slideTitle: String,
        val slideType: Int,
        val slideUrl: String,
        val userId: Int
)