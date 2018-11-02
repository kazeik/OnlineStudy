package com.hope.onlinestudy.activity

import android.annotation.SuppressLint
import android.text.TextUtils
import android.view.View
import com.hope.lib.utils.PreferencesUtils
import com.hope.onlinestudy.BuildConfig
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseModel
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.Utils
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.view_title.*
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSubmit -> login()
            R.id.iv_backup -> finish()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_login
    }

    @SuppressLint("SetTextI18n")
    override fun initData() {
        tv_title.setText("登录")
        btnSubmit.setOnClickListener(this)
        iv_backup.setOnClickListener(this)

        if (BuildConfig.LOG_DEBUG) {
            etAccount.setText("zxstudent1")
            etPass.setText("123123")
        }
    }

    private fun login() {
        val username = etAccount.text.toString()
        val userpwd = etPass.text.toString()

        if (TextUtils.isEmpty(username)) {
            toast("用户名不能为空")
            return
        }
        if (TextUtils.isEmpty(userpwd)) {
            toast("登录密码不能为空")
            return
        }

        PreferencesUtils.putString(this, "username", username)
        PreferencesUtils.putString(this, "userpwd", userpwd)

        showDialog(true)
//        apiInter.login(username, userpwd, ApiUtils.login, this)
    }

    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
        if (tag == ApiUtils.login) {
            val jsonModel = Utils.parserJson<BaseModel<Any>>(body)
            when (jsonModel.code) {
                1 -> startOther(StartActivity::class.java, true)
                else -> toast(jsonModel.message)
            }
        }
    }
}
