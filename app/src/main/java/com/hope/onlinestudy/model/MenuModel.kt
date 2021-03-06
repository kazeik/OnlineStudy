package com.hope.onlinestudy.model

data class MenuModel(
        val secondStudySpecialty: List<SecondStudyModel>,
        val specialtyDesc: String,
        val specialtyFullcode: String,
        val specialtyFullname: String,
        val specialtyId: Int,
        val specialtyImg: String,
        val specialtyLevel: Int,
        val specialtyName: String,
        val specialtyOrder: Int,
        val specialtyParentid: Int,
        val threeStudySpecialty: List<Any>
)