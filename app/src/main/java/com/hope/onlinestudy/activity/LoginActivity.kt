package com.hope.onlinestudy.activity

import android.view.View
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.view_title.*

class LoginActivity : BaseActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnSubmit->startOther(StartActivity::class.java)
            R.id.iv_backup->finish()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        tv_title.setText("登录")
        btnSubmit.setOnClickListener(this)
        iv_backup.setOnClickListener(this)
    }

}
