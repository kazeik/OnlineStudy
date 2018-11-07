package com.hope.onlinestudy.fragment


import android.content.Intent
import android.support.v4.app.Fragment
import android.view.View
import com.bumptech.glide.Glide
import com.hope.onlinestudy.R
import com.hope.onlinestudy.activity.*
import com.hope.onlinestudy.base.BaseModel
import com.hope.onlinestudy.base.LazyFragment
import com.hope.onlinestudy.img.GlideCircleTransform
import com.hope.onlinestudy.model.ListUserModel
import com.hope.onlinestudy.model.UserInfoModel
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.ApiUtils.imgUrl
import com.hope.onlinestudy.utils.Utils.logs
import com.hope.onlinestudy.utils.Utils.parserJson
import kotlinx.android.synthetic.main.fragment_user.*
import org.jetbrains.anko.support.v4.act
import org.jetbrains.anko.support.v4.toast

/**
 * A simple [Fragment] subclass.
 *
 */
class UserFragment : LazyFragment(), View.OnClickListener {
    private var userModel: ListUserModel? = null
    override fun lazyLoad() {
        if (userModel == null) {
            activity?.showDialog()
            apiInter.sigleRequest(ApiUtils.toMyInfo)
        }
    }

    override fun onClick(v: View?) {
        val intt = Intent()
        when (v?.id) {
            R.id.rlChangePass -> startActivity(Intent(activity, ChangePassActivity::class.java))
            R.id.rlInfo -> {
                intt.putExtra("data", userModel?.data?.get(0))
                intt.setClass(activity, InfoActivity::class.java)
                startActivity(intt)
            }
            R.id.rlJf -> {
                intt.putExtra("data", userModel?.data?.get(0))
                intt.setClass(activity, IntegralActivity::class.java)
                startActivity(intt)
            }
            R.id.rlMessage -> startActivity(Intent(activity, MessageActivity::class.java))
            R.id.rlOrder -> startActivity(Intent(activity, OrderActivity::class.java))
            R.id.rlZy -> startActivity(Intent(activity, HomeWorkActivity::class.java))
            R.id.btnExit -> {
                activity?.myApplicaton?.exitApp()
                startActivity(Intent(activity, LoginActivity::class.java))
                activity?.finish()
            }
            R.id.rlAbout -> startActivity(Intent(activity, AboutActivity::class.java))
            R.id.rlLesson -> {
                intt.setClass(activity, WebViewActivity::class.java)
                intt.putExtra("url", "http://zxserver.f3322.net:8080/study/apphome/toMyCourse")
                startActivity(intt)
//                startActivity(Intent(activity, LessonActivity::class.java))
            }
        }
    }

    override fun initView(): Int {
        return R.layout.fragment_user
    }

    override fun bindData() {
        rlChangePass.setOnClickListener(this)
        rlInfo.setOnClickListener(this)
        rlJf.setOnClickListener(this)
        rlMessage.setOnClickListener(this)
        rlOrder.setOnClickListener(this)
        rlZy.setOnClickListener(this)
        btnExit.setOnClickListener(this)
        rlAbout.setOnClickListener(this)
        rlLesson.setOnClickListener(this)

        var imgpath = imgUrl
        if (null != userModel) {
            imgpath = "$imgUrl${userModel?.data?.get(0)!!.userImg}"
        }
        showIcon(imgpath)
    }

    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
        when (tag) {
            ApiUtils.toMyInfo -> {
                userModel = parserJson(body)
                if (userModel?.code == 1) {
                    tvName.text = userModel?.data?.get(0)!!.truename
                    showIcon("$imgUrl${userModel?.data?.get(0)!!.userImg}")
                } else {
                    toast(userModel?.message!!)
                }
            }
        }
    }

    private fun showIcon(path: String) {
        Glide.with(this).load(path)
                .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .transform(GlideCircleTransform(activity!!)).into(ivUserIcon)
    }
}
