package com.hope.onlinestudy.model

data class UserBoy(
        val buyCount: Int,
        val buyTime: BuyTime,
        val comUser: Any,
        val courseDesc: String,
        val courseGoods: Any,
        val courseGoodsId: Int,
        val courseGoodsName: String,
        val courseImage: String,
        val courseTimeLong: Int,
        val courseUserId: Int,
        val courseUserType: Int,
        val dod: String,
        val freeCount: Int,
        val lessionNum: Int,
        val planUserCount: Int,
        val promptInfo1: String,
        val promptInfo2: String,
        val salePoint: Int,
        val specialtyId: Int,
        val studySpecialty: Any,
        val userId: Int
)