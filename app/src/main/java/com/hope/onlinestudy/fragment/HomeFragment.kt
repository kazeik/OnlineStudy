package com.hope.onlinestudy.fragment


import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.hope.lib.iter.OnItemEventListener
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.HomeDataAdapter
import com.hope.onlinestudy.base.BaseFragment
import com.hope.onlinestudy.img.GlideImageLoader
import com.hope.onlinestudy.model.ComSlide
import com.hope.onlinestudy.model.HomeDataModel
import com.hope.onlinestudy.model.LessonItemModel
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.Utils.parserJson
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.layout_homepage.*
import kotlinx.android.synthetic.main.view_title.*


/**
 * A simple [Fragment] subclass.
 * 首页
 */
class HomeFragment : BaseFragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_right -> {
            }
        }
    }

    override fun initView(): Int {
        return R.layout.layout_homepage
    }

    private val commandAdapter: HomeDataAdapter<LessonItemModel> by lazy { HomeDataAdapter<LessonItemModel>(activity!!) }
    private val excelAdapter: HomeDataAdapter<LessonItemModel> by lazy { HomeDataAdapter<LessonItemModel>(activity!!) }

    override fun bindData() {
        tv_title.setText("首页")
        iv_backup.visibility = View.GONE
        iv_right.visibility = View.VISIBLE
        iv_right.setImageResource(R.drawable.sousuo)
        iv_right.setOnClickListener(this)

        //设置banner样式
        slider.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        //设置图片加载器
        slider.setImageLoader(GlideImageLoader())
        //设置banner动画效果
        slider.setBannerAnimation(Transformer.Default)
//        //设置标题集合（当banner样式有显示title时）
//        slider.setBannerTitles(titles)
        //设置自动轮播，默认为true
        slider.isAutoPlay(true)
        //设置轮播时间
        slider.setDelayTime(1500)
        //设置指示器位置（当banner模式中有指示器时）
        slider.setIndicatorGravity(BannerConfig.CENTER)

        rcvCommand.setNestedScrollingEnabled(false)
        rcvCommand.setHasFixedSize(true)
        rcvCommand.layoutManager = GridLayoutManager(activity, 2)
        rcvCommand.adapter = commandAdapter
        commandAdapter.itemEventListener = object : OnItemEventListener {
            override fun onItemEvent(pos: Int) {
            }
        }

        rcvExcel.setNestedScrollingEnabled(false)
        rcvExcel.setHasFixedSize(true)
        rcvExcel.layoutManager = GridLayoutManager(activity, 2)
        rcvExcel.adapter = excelAdapter
        excelAdapter.itemEventListener = object : OnItemEventListener {
            override fun onItemEvent(pos: Int) {
            }
        }

        activity?.showDialog()
        apiInter.sigleRequest(ApiUtils.toAppHomePage)
    }


    override fun onStart() {
        super.onStart()
        slider.startAutoPlay()
    }

    override fun onStop() {
        super.onStop()
        slider.stopAutoPlay()
    }

    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
        when (tag) {
            ApiUtils.toAppHomePage -> {
                val model: HomeDataModel = parserJson(body)
                initBanner(model.data?.get(0)?.comSlideList!!)
                commandAdapter.setDataEntityList(model.data?.get(0)?.recommended!!)
                excelAdapter.setDataEntityList(model.data?.get(0)?.excellent!!)
            }
        }
    }

    private fun initBanner(data: List<ComSlide>) {
        val list = ArrayList<String>()
        for (item in data) {
            list.add("${ApiUtils.imgUrl}${item.slideImg}")
        }
        slider.setImages(list)
        slider.start()
    }

}
