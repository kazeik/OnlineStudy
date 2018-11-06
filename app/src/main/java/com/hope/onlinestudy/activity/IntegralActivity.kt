package com.hope.onlinestudy.activity

import android.view.View
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.utils.ApiUtils
import kotlinx.android.synthetic.main.view_title.*

class IntegralActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_backup -> finish()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_integral
    }

    override fun initData() {
        tv_title.setText("我的积分")
        iv_backup.setOnClickListener(this)

        showDialog()
        apiInter.sigleRequest(ApiUtils.toMyPoint)
    }

    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
        if (tag == ApiUtils.toMyPoint) {

        }
    }
}
