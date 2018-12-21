package com.hope.onlinestudy.model

data class PointModel(
    val comIntegralCode: String,
    val comIntegralCountId: String,
    val comIntegralId: Int,
    val creationtime: Long,
    val expirationtime: String,
    val integralExpirationState: String,
    val integralIae: String,
    val integralIaeState: Int,
    val integralSpecify: String,
    val integralType: Int,
    val orderId: String,
    val teacherId: String,
    val userId: String
)