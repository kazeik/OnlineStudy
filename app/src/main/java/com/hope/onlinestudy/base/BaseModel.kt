package com.hope.onlinestudy.base

import java.io.Serializable

data class BaseModel<T>(
        val code: Int,
        val data: List<T>,
        val message: String
) : Serializable