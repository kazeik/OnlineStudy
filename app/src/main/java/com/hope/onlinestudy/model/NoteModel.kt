package com.hope.onlinestudy.model

data class NoteModel(
        /**
         * 用户笔记
         */
        val eduNoteList: List<EduNote>,
        val pageInfo: PageInfo
)