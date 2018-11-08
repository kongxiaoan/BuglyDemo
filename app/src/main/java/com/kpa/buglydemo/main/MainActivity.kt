package com.kpa.buglydemo.main

import android.os.Bundle
import android.os.HandlerThread
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.ScreenUtils
import com.kpa.buglydemo.R
import com.kpa.buglydemo.entry.BeautySection
import com.kpa.buglydemo.entry.Result
import com.kpa.buglydemo.main.adapter.MainAdapter
import com.kpa.buglydemo.net.BeautyLoader
import kotlinx.android.synthetic.main.main_activity.*
import rx.functions.Action1

class MainActivity : AppCompatActivity() {
    private var data = arrayListOf<BeautySection>()
    private var mAdapter: MainAdapter = MainAdapter(R.layout.main_item, R.layout.main_item_head, data)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScreenUtils.setFullScreen(this)
        BarUtils.setNavBarVisibility(this, false)
        BarUtils.setNotificationBarVisibility(false)
        BarUtils.setStatusBarVisibility(this, false)
        setContentView(R.layout.main_activity)
        initView()
    }

    override fun onStart() {
        super.onStart()
        BeautyLoader.getBeautyData("福利", 50, 1)?.subscribe(object : Action1<MutableList<Result>> {
            override fun call(t: MutableList<Result>?) {
                data.add(BeautySection(true, "美女图片", true))
                t?.forEach {
                    if (data.size == 5) {
                        data.add(BeautySection(true, "更多美女", true))
                    }
                    data.add(BeautySection(false, it))
                }
                if (data.size > 0) {
                    println("data = ${data}")
                    mAdapter.notifyDataSetChanged()
                }
            }

        }, object : Action1<Throwable> {
            override fun call(t: Throwable?) {

            }

        })
    }

    private fun initView() {
        mainListRv.layoutManager = GridLayoutManager(this, 4) as RecyclerView.LayoutManager?
        mainListRv.adapter = mAdapter
    }

}