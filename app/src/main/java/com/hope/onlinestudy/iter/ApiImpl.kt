package com.hope.onlinestudy.iter

import com.hope.lib.base.BaseActivity

/**
 * @author hope.chen, QQ:77132995, email:kazeik@163.com
 * 2018 10 16 11:06
 * 类说明:
 */
class ApiImpl(private val mActivity: BaseActivity) : ApiInter {
    override fun getVerfiyCode(phone: String) {
        mActivity.showDialog()
    }

    override fun login(email: String, password: String) {
        mActivity.showDialog()
    }
}