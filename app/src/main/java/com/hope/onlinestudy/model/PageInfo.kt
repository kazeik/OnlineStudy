package com.hope.onlinestudy.model

/**
 * 分页
 * @property endRow Int
 * @property firstPage Int
 * @property hasNextPage Boolean
 * @property hasPreviousPage Boolean
 * @property isFirstPage Boolean
 * @property isLastPage Boolean
 * @property lastPage Int
 * @property navigatePages Int
 * @property navigatepageNums List<Int>
 * @property nextPage Int
 * @property pageNum Int
 * @property pageSize Int
 * @property pages Int
 * @property prePage Int
 * @property size Int
 * @property startRow Int
 * @property total Int
 * @constructor
 */
data class PageInfo(
        val endRow: Int,
        val firstPage: Int,
        val hasNextPage: Boolean,
        val hasPreviousPage: Boolean,
        val isFirstPage: Boolean,
        val isLastPage: Boolean,
        val lastPage: Int,
        val navigatePages: Int,
        val navigatepageNums: List<Int>,
        val nextPage: Int,
        val pageNum: Int,
        val pageSize: Int,
        val pages: Int,
        val prePage: Int,
        val size: Int,
        val startRow: Int,
        val total: Int
)