package com.hope.onlinestudy.model

data class EduNote(
        val courseChapterId: Int,
        val courseChapterName: String,
        val courseId: Int,
        val courseName: String,
        val createtime: TimeModel,
        val id: String,
        val noteDate: String,
        val noteInfo: String,
        val noteTime: String,
        val userId: Int,
        val videoPlayId: Int
)