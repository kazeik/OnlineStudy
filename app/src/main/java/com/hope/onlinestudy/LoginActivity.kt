package com.hope.onlinestudy

import android.view.View
import com.hope.lib.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_title.*

class LoginActivity : BaseActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnSubmit->{}
            R.id.iv_backup->finish()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        btnSubmit.setOnClickListener(this)
        iv_backup.setOnClickListener(this)
    }

}
