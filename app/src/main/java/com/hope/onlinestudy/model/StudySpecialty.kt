package com.hope.onlinestudy.model

data class StudySpecialty(
        val comTeacherSpecialties: List<Any>,
        val recommendStatus: Int,
        val specialtyDesc: String,
        val specialtyFullcode: String,
        val specialtyFullname: String,
        val specialtyId: Int,
        val specialtyImg: String,
        val specialtyLevel: Int,
        val specialtyName: String,
        val specialtyOrder: Int,
        val specialtyParentid: Int
)