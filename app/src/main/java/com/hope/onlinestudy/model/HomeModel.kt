package com.hope.onlinestudy.model

data class HomeModel(
        val comSlideList: List<ComSlide>,
        val excellent: List<LessonItemModel>,
        val menuList: List<MenuModel>,
        val recommended: List<LessonItemModel>,
        val schoolList: List<SchoolModel>,
        val studySpecialtys: List<StudySpecialty>,
        val supplierlList: List<Supplierl>
)