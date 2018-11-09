package com.hope.onlinestudy.activity

import android.support.v7.widget.GridLayoutManager
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.SearchAdapter
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.model.LessonItemModel
import com.hope.onlinestudy.utils.ApiUtils
import kotlinx.android.synthetic.main.activity_integral.*
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : BaseActivity(), View.OnClickListener, TextView.OnEditorActionListener {
    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            val msg = etSearchView.text.toString()
            apiInter.searchlesson(msg)
            return true
        }
        return false
    }

    private val adapter: SearchAdapter<LessonItemModel> by lazy { SearchAdapter<LessonItemModel>(this) }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_backup -> finish()
        }
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_search
    }

    override fun initData() {
        iv_backup.setOnClickListener(this)
        etSearchView.setOnEditorActionListener(this)

        rcvList.layoutManager = GridLayoutManager(this, 2)
        rcvList.adapter = adapter
    }

    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
        when (tag) {
            ApiUtils.searchLesson -> {
                val type = object : TypeToken<List<LessonItemModel>>() {}.type
                val listdata = Gson().fromJson<List<LessonItemModel>>(body, type)
                adapter.setDataEntityList(listdata)
            }
        }
    }
}
