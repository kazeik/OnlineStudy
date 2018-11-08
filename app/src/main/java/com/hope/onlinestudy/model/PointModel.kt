package com.hope.onlinestudy.model

/**
 * 我的积分
 * @property allIntegralRules List<AllIntegralRule>
 * @property pageInfo PageInfo
 * @property time TimeModel
 * @constructor
 */
data class PointModel(
        val allIntegralRules: List<AllIntegralRule>,
        val pageInfo: PageInfo,
        val time: TimeModel
)