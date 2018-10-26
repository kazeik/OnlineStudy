package com.hope.onlinestudy

import android.view.View
import com.hope.lib.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.view_title.*

class RegisterActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSubmit -> {
            }
            R.id.iv_backup -> finish()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_register
    }

    override fun initData() {
        btnSubmit.setOnClickListener(this)
        iv_backup.setOnClickListener(this)
    }

}
