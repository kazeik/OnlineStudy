package com.hope.onlinestudy.base

import java.io.Serializable

open class BaseModel : Serializable {
    var statusCode: Int? = null
    var msg: String? = null
}