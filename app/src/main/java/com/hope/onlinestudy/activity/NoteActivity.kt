package com.hope.onlinestudy.activity

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.hope.lib.iter.OnItemEventListener
import com.hope.onlinestudy.R
import com.hope.onlinestudy.adapter.NoteAdapter
import com.hope.onlinestudy.base.BaseActivity
import com.hope.onlinestudy.model.DelNoteModel
import com.hope.onlinestudy.model.EduNote
import com.hope.onlinestudy.model.NoteListModel
import com.hope.onlinestudy.utils.ApiUtils
import com.hope.onlinestudy.utils.Utils.parserJson
import kotlinx.android.synthetic.main.activity_integral.*
import kotlinx.android.synthetic.main.view_title.*
import org.jetbrains.anko.toast

class NoteActivity : BaseActivity(), OnItemEventListener, View.OnClickListener {
    private var index = -1
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_backup -> finish()
        }
    }

    override fun onItemEvent(pos: Int) {
        index = pos
        val noteModel: EduNote = model?.data?.get(0)?.eduNoteList?.get(pos)!!
        showDialog()
        apiInter.delNote(noteModel.id)
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_home_work
    }

    private val adapter: NoteAdapter<EduNote> by lazy { NoteAdapter<EduNote>() }
    private var model: NoteListModel? = null
    override fun initData() {
        tv_title.setText("我的笔记")
        iv_backup.setOnClickListener(this)

        rcvList.layoutManager = LinearLayoutManager(this)
        rcvList.adapter = adapter
        adapter.itemEventListener = this

        showDialog()
        apiInter.sigleRequest(ApiUtils.toMyNote)
    }

    override fun getNetStr(tag: String, body: String) {
        super.getNetStr(tag, body)
        when (tag) {
            ApiUtils.toMyNote -> {
                model = parserJson(body)
                adapter.setDataEntityList(model?.data?.get(0)?.eduNoteList!!)
            }

            ApiUtils.delnote -> {
                val delModel = parserJson<DelNoteModel>(body)
                toast(delModel.info)
                if (delModel.result == "success") {
                    model?.data?.get(0)?.eduNoteList?.removeAt(index)
                    adapter.setDataEntityList(model?.data?.get(0)?.eduNoteList!!)
                }
            }
        }
    }
}
