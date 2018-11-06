package com.hope.onlinestudy.base

import java.io.Serializable

open class BaseModel : Serializable {
    var code: Int? = null
    var message: String? = null
}