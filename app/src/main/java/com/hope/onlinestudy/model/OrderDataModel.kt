package com.hope.onlinestudy.model

data class OrderDataModel(
        val mentOrderList: List<OrderModel>,
        val offOrderList: List<OrderModel>,
        val orderList: List<OrderModel>,
        val pageInfo: PageInfo,
        val pageInfoOff: PageInfo,
        val pageInfoment: PageInfo
)