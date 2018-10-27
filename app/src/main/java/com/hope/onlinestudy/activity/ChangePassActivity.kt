package com.hope.onlinestudy.activity

import android.view.View
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseActivity
import kotlinx.android.synthetic.main.view_title.*

class ChangePassActivity : BaseActivity(), View.OnClickListener{
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_backup->finish()
            R.id.btnChangePass->{}
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_change_pass
    }

    override fun initData() {
        tv_title.setText("修改密码")
        iv_backup.setOnClickListener(this)
    }
    private fun changePass(){

    }
}
