package com.hope.onlinestudy.model

data class LessonItemModel(
        val addTime: TimeModel,
        val comUser: ComUser,
        val courseDesc: String,
        val courseGoodsId: String,
        val courseGoodsName: String,
        val courseImage: String,
        val coursePreviewingVideo: String,
        val courseSaleCount: String,
        val courseStatus: String,
        val courseTimeLong: String,
        val courseType: String,
        val dod: String,
        val inviteCode: String,
        val isfree: String,
        val isopen: String,
        val lessionNum: String,
        val pageViewcount: String,
        val promptInfo1: String,
        val promptInfo2: String,
        val recommendStatus: String,
        val salePoint: String,
        val specialtyId: String,
        val starLevel: String,
        val statusDesc: String,
        val studyCount: String,
        val studySpecialty: StudySpecialty
)