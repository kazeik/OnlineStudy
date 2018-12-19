package com.hope.onlinestudy.activity

import android.text.TextUtils
import android.view.View
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.R
import com.hope.onlinestudy.utils.Utils
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.view_title.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseActivity(), View.OnClickListener {
    private var phone: String? = null
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegisterSubmit -> startRegister()
            R.id.iv_backup -> finish()
            R.id.btnCode -> getCode()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_register
    }

    override fun initData() {
        tv_title.text = "注册"
        btnRegisterSubmit.setOnClickListener(this)
        iv_backup.setOnClickListener(this)
        btnCode.setOnClickListener(this)
    }

    private fun startRegister() {
        val code = etPhone.text.toString()

        if (TextUtils.isEmpty(code)) {
            toast("手机验证码不能为空")
            return
        }
    }

    private fun getCode() {
        phone = etPhone.text.toString()
        if (TextUtils.isEmpty(phone)) {
            toast("手机号不能为空")
            return
        }

        if (!Utils.isMobileNO(phone!!)) {
            toast("手机号不正确")
            return
        }
    }
}
