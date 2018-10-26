package com.hope.onlinestudy.activity

import android.view.View
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> startOther(LoginActivity::class.java)
            R.id.btnRegister -> startOther(RegisterActivity::class.java)
            R.id.tvForget -> startOther(ForgetPassActivity::class.java)
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        btnLogin.setOnClickListener(this)
        btnRegister.setOnClickListener(this)
        tvForget.setOnClickListener(this)
    }
}
