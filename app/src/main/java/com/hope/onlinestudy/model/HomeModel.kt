package com.hope.onlinestudy.model

/**
 *
 * @property comSlideList List<ComSlide> banner
 * @property excellent List<LessonItemModel> 精品课程
 * @property menuList List<MenuModel> 分类及子分类列表
 * @property recommended List<LessonItemModel> 推荐课程
 * @property schoolList List<SchoolModel> 学校列表
 * @property studySpecialtys List<StudySpecialty> 分类
 * @property supplierlList List<Supplierl> 公司列表
 * @constructor
 */
data class HomeModel(
        val comSlideList: List<ComSlide>,
        val excellent: List<LessonItemModel>,
        val menuList: List<MenuModel>,
        val recommended: List<LessonItemModel>,
        val schoolList: List<SchoolModel>,
        val studySpecialtys: List<StudySpecialty>,
        val supplierlList: List<Supplierl>
)