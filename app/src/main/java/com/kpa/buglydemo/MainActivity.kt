package com.kpa.buglydemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tencent.bugly.beta.Beta
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

    }
}
