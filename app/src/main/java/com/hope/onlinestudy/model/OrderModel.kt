package com.hope.onlinestudy.model

/**
 * 订单
 * @property count Int
 * @property courseGoodsId Int
 * @property createtime TimeModel
 * @property eduOrderId Int
 * @property orderId String
 * @property orderMoney String
 * @property orderName String
 * @property orderState Int
 * @property orderUnitMoney String
 * @property updatetime TimeModel
 * @property userId Int
 * @constructor
 */
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