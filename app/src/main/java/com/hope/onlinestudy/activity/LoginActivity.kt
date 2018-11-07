package com.hope.onlinestudy.activity

import android.annotation.SuppressLint
import android.text.TextUtils
import android.view.View
import com.hope.onlinestudy.utils.PreferencesUtils
import com.hope.onlinestudy.BuildConfig
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseModel
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.Utils.parserJson
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.view_title.*
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity(), View.OnClickListener {
    private var username: String? = null
    private var userpwd: String? = null
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

        username = PreferencesUtils.getString(this, "username")
        userpwd = PreferencesUtils.getString(this, "userpwd")
        if (BuildConfig.LOG_DEBUG) {
            username = "zxstudent1"
            userpwd = "123456"
        }
        etAccount.setText(username)
        etPass.setText(userpwd)
    }

    private fun login() {
        username = etAccount.text.toString().trim()
        userpwd = etPass.text.toString().trim()

        if (TextUtils.isEmpty(username)) {
            toast("用户名不能为空")
            return
        }
        if (TextUtils.isEmpty(userpwd)) {
            toast("登录密码不能为空")
            return
        }

        PreferencesUtils.putString(this, "username", username!!)
        PreferencesUtils.putString(this, "userpwd", userpwd!!)

        showDialog(true)
        apiInter.login(username!!, userpwd!!, ApiUtils.login)
    }

    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
        if (tag == ApiUtils.login) {
            val jsonModel = parserJson<BaseModel>(body)
            when (jsonModel.code) {
                1 -> startOther(StartActivity::class.java, true)
                else -> toast(jsonModel.message!!)
            }
        }
    }
}
