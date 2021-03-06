package com.hope.onlinestudy.fragment


import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.view.View
import com.bumptech.glide.Glide
import com.hope.onlinestudy.R
import com.hope.onlinestudy.activity.*
import com.hope.onlinestudy.base.LazyFragment
import com.hope.onlinestudy.img.GlideCircleTransform
import com.hope.onlinestudy.model.MsgLengthModel
import com.hope.onlinestudy.model.ListUserModel
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.ApiUtils.imgUrl
import com.hope.onlinestudy.utils.Utils.parserJson
import kotlinx.android.synthetic.main.fragment_user.*
import org.jetbrains.anko.support.v4.toast
import com.hope.onlinestudy.view.BadgeView


/**
 * A simple [Fragment] subclass.
 *
 */
class UserFragment : LazyFragment(), View.OnClickListener {
    var model: ListUserModel? = null

    override fun lazyLoad() {
        if (model == null) {
            activity?.showDialog()
            apiInter.getUserInfo(ApiUtils.userId!!)
        }
    }

    override fun onClick(v: View?) {
        val intt = Intent()
        when (v?.id) {
            R.id.rlChangePass -> startActivity(Intent(activity, ChangePassActivity::class.java))
            R.id.rlInfo -> {
                intt.putExtra("data", model?.data?.get(0))
                intt.setClass(activity, InfoActivity::class.java)
                startActivity(intt)
            }
            R.id.rlJf -> {
                intt.putExtra("data", model?.data?.get(0))
                intt.setClass(activity, IntegralActivity::class.java)
                startActivity(intt)
            }
            R.id.rlMessage -> startActivity(Intent(activity, MessageActivity::class.java))
            R.id.rlOrder ->
//                startActivity(Intent(activity, OrderActivity::class.java))
            {
                intt.setClass(activity, WebViewActivity::class.java)
                intt.putExtra("url", ApiUtils.toMyOrder)
                startActivity(intt)
            }
            R.id.rlZy -> startActivity(Intent(activity, HomeWorkActivity::class.java))
            R.id.btnExit -> {
                activity?.myApplicaton?.exitApp()
                startActivity(Intent(activity, LoginActivity::class.java))
                activity?.finish()
            }
            R.id.rlAbout -> startActivity(Intent(activity, AboutActivity::class.java))
            R.id.rlLesson -> {
                intt.setClass(activity, WebViewActivity::class.java)
                intt.putExtra("url", ApiUtils.toMyCourse)
//                intt.setClass(activity, LessonActivity::class.java)
                startActivity(intt)
            }
            R.id.rlNote -> {
//                intt.setClass(activity, NoteActivity::class.java)
                intt.setClass(activity, WebViewActivity::class.java)
                intt.putExtra("url", ApiUtils.toMyNote)
                startActivity(intt)
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
        rlNote.setOnClickListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
        when (tag) {
            ApiUtils.toMyInfo -> {
                model = parserJson(body)
                if (model?.statusCode == 0) {
                    tvName.text = model?.data?.get(0)?.truename
                    showIcon("$imgUrl${model?.data?.get(0)?.userImg}")
                } else
                    toast(model?.msg!!)
            }

            ApiUtils.toMyCenter -> {
                val msgModel: MsgLengthModel = parserJson(body)
                if (msgModel.data?.get(0)?.messageSize != 0) {
                    tvMsgSize.visibility = View.VISIBLE
                    val badge = BadgeView(activity)
                    badge.setTargetView(tvMsgSize)
                    badge.setBadgeCount(msgModel.data?.get(0)?.messageSize!!)
                }
            }
        }
    }

    private fun showIcon(path: String) {
        Glide.with(this).load(path).asBitmap()
            .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
            .transform(GlideCircleTransform(activity!!)).into(ivUserIcon)
    }
}
