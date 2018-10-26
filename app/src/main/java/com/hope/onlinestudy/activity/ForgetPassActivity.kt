package com.hope.onlinestudy.activity

import android.view.View
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.R
import kotlinx.android.synthetic.main.view_title.*

class ForgetPassActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_backup -> finish()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_forget_pass
    }

    override fun initData() {
        tv_title.setText("忘记密码")
    }

}
