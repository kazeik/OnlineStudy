package com.hope.onlinestudy.activity

import android.view.View
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.view_title.*

class RegisterActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegisterSubmit -> {
            }
            R.id.iv_backup -> finish()
            R.id.btnCode -> {
            }
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_register
    }

    override fun initData() {
        tv_title.setText("注册")
        btnRegisterSubmit.setOnClickListener(this)
        iv_backup.setOnClickListener(this)
        btnCode.setOnClickListener(this)
    }

}
