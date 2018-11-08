package com.kpa.buglydemo.main.adapter

import android.media.Image
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kpa.buglydemo.R
import com.kpa.buglydemo.entry.BeautySection
import com.kpa.buglydemo.entry.Result

/**
 *author: mr.kong
 *Date:2018/10/31
 *description:
 *project name:BuglyDemo
 **/
class MainAdapter(layoutResId: Int, sectionHeadResId: Int, data: MutableList<BeautySection>) : BaseSectionQuickAdapter
<BeautySection, BaseViewHolder>(layoutResId, sectionHeadResId, data) {
    override fun convertHead(helper: BaseViewHolder, item: BeautySection) {
        helper.setText(R.id.mainItemHeadTv, item.header)
    }

    override fun convert(helper: BaseViewHolder, item: BeautySection) {
        val imageView = helper.getView<ImageView>(R.id.mainItemIv)
        if (!item.isHeader) {
            val t = item.t

            println("data = $t")
            Glide.with(mContext).load(t.url).into(imageView)
        }

    }

}