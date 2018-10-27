package com.hope.onlinestudy.activity

import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.KeyEvent
import android.widget.RadioGroup
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.FtPagerAdapter
import com.hope.onlinestudy.fragment.ExamineFragment
import com.hope.onlinestudy.fragment.HomeFragment
import com.hope.onlinestudy.fragment.UserFragment
import kotlinx.android.synthetic.main.activity_start.*
import org.jetbrains.anko.toast

class StartActivity : BaseActivity(), ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    override fun onPageScrollStateChanged(p0: Int) {
    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
    }

    override fun onPageSelected(p0: Int) {
        when (p0) {
            0 -> rb_zixuan.isChecked = true
            1 -> rb_hanqing.isChecked = true
            2 -> rb_my.isChecked = true
        }
    }
    private val fmList: MutableList<Fragment> by lazy { ArrayList<Fragment>() }
    private var firstTime: Long = 0

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.rb_zixuan -> vfpMain.currentItem = 0
            R.id.rb_hanqing -> vfpMain.currentItem = 1
            R.id.rb_my -> vfpMain.currentItem = 2
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_start
    }

    override fun initData() {

        fmList.add(HomeFragment())
        fmList.add(ExamineFragment())
        fmList.add(UserFragment())

        val adapter = FtPagerAdapter(supportFragmentManager, fmList)
        vfpMain.adapter = adapter
        vfpMain.offscreenPageLimit = 3
        vfpMain.setOnPageChangeListener(this)
        gr_bottom.setOnCheckedChangeListener(this)
    }
    override fun onKeyDown(paramInt: Int, paramKeyEvent: KeyEvent): Boolean {
        if (paramInt == KeyEvent.KEYCODE_BACK && paramKeyEvent.action == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - firstTime > 2000) {
                toast(R.string.msg_app_exit)
                firstTime = System.currentTimeMillis()
            } else {
                finish()
                myApplicaton?.exitApp()
            }
            return true
        }
        return super.onKeyDown(paramInt, paramKeyEvent)
    }
}