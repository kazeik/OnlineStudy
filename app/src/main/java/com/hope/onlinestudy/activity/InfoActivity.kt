package com.hope.onlinestudy.activity

import android.text.TextUtils
import android.view.View
import com.bumptech.glide.Glide
import com.hope.onlinestudy.R
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.img.GlideCircleTransform
import com.hope.onlinestudy.model.UserInfoModel
import com.hope.onlinestudy.utils.ApiUtils
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.view_title.*

class InfoActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_backup -> finish()
        }
    }

    private var usermodel: UserInfoModel? = null
    override fun getLayoutView(): Int {
        return R.layout.activity_info
    }

    override fun initData() {
        tv_title.setText("我的资料")
        iv_backup.setOnClickListener(this)

        val data = intent.getSerializableExtra("data")
        if (null != data) {
            usermodel = data as UserInfoModel
        }

        Glide.with(this).load("${ApiUtils.imgUrl}${usermodel?.userImg}").asBitmap()
            .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).override(100, 100)
            .transform(GlideCircleTransform(this)).into(ivUserIcon)
        tvUserAccount.text = if (TextUtils.isEmpty(usermodel?.username)) "" else usermodel?.username
        tvUserName.text = if (TextUtils.isEmpty(usermodel?.truename)) "" else usermodel?.truename
        tvSex.text = if (usermodel?.usersex == "1") {
            "女"
        } else if (usermodel?.usersex == "2") {
            "男"
        } else {
            ""
        }
        tvTel.text = if (TextUtils.isEmpty(usermodel?.mobilephone) || TextUtils.equals(
                "null",
                usermodel?.mobilephone
            )
        ) "" else usermodel?.mobilephone
        tvEmail.text = if (TextUtils.isEmpty(usermodel?.useremail)) "" else usermodel?.useremail
        tvSchool.text = if (TextUtils.isEmpty(usermodel?.companyName)) "" else usermodel?.companyName
    }
}
