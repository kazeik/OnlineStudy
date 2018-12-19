package com.hope.onlinestudy.activity

import android.view.View
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseActivity
import kotlinx.android.synthetic.main.view_title.*

class AboutActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_backup -> finish()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_about
    }

    override fun initData() {
        tv_title.text = "关于我们"
    }

}
