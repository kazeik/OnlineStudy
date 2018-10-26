package com.hope.onlinestudy

import android.view.View
import com.hope.lib.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> {
            }
            R.id.btnRegister -> {
            }
            R.id.tvForget -> {
            }
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
