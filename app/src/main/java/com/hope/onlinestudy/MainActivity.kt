package com.hope.onlinestudy

import android.view.View
import com.hope.lib.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*


class MainActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> startOther(LoginActivity::class.java, true)
            R.id.btnRegister -> startOther(RegisterActivity::class.java)
            R.id.tvForget -> startOther(ForgetPassActivity::class.java)
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        btnLogin.setOnClickListener(this)
        btnRegister.setOnClickListener(this)
        tvForget.setOnClickListener(this)
    }
}
