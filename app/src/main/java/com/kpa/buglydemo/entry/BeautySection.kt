package com.kpa.buglydemo.entry

import com.chad.library.adapter.base.entity.SectionEntity

/**
 *author: mr.kong
 *Date:2018/10/31
 *description:
 *project name:BuglyDemo
 **/
class BeautySection:SectionEntity<Result> {
    private var isMore = false

    constructor(isHeader: Boolean, header: String?, isMore: Boolean) : super(isHeader, header) {
        this.isMore = isMore
    }

    constructor(isHeader: Boolean,t: Result?) : super(t)
}