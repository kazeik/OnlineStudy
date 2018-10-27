package com.hope.onlinestudy.activity

import android.view.View
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseActivity
import kotlinx.android.synthetic.main.view_title.*

class MessageActivity : BaseActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_backup->finish()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.layout_title_recyclerview
    }

    override fun initData() {
        tv_title.setText("我的消息")
        iv_backup.setOnClickListener(this)
    }

}
