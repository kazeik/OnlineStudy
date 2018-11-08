package com.hope.onlinestudy.model

data class OrderModel(
        val count: Int,
        val courseGoodsId: Int,
        val createtime: TimeModel,
        val eduOrderId: Int,
        val orderId: String,
        val orderMoney: String,
        val orderName: String,
        val orderState: Int,
        val orderUnitMoney: String,
        val updatetime: TimeModel,
        val userId: Int
)