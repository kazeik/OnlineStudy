package com.hope.onlinestudy.model

/**
 * 单个课程
 * @property addTime TimeModel
 * @property comUser ComUser
 * @property courseDesc String 课程详情
 * @property courseGoodsId String 课程ID
 * @property courseGoodsName String 课程名
 * @property courseImage String 课程图片
 * @property coursePreviewingVideo String
 * @property courseSaleCount String 已销售数量
 * @property courseStatus String
 * @property courseTimeLong String
 * @property courseType String
 * @property dod String
 * @property inviteCode String
 * @property isfree String
 * @property isopen String
 * @property lessionNum String 课时
 * @property pageViewcount String
 * @property promptInfo1 String 课程须知
 * @property promptInfo2 String 你能学到什么
 * @property recommendStatus String
 * @property salePoint String
 * @property specialtyId String
 * @property starLevel String
 * @property statusDesc String
 * @property studyCount String
 * @property studySpecialty StudySpecialty
 * @constructor
 */
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
        val isfree: Int,
        val isopen: String,
        val lessionNum: String,
        val pageViewcount: String,
        val promptInfo1: String,
        val promptInfo2: String,
        val recommendStatus: String,
        val salePoint: String,
        val specialtyId: String,
        val starLevel: Float,
        val statusDesc: String,
        val studyCount: String,
        val studySpecialty: StudySpecialty
)