package com.river.biz_home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.river.biz_home.databinding.ActivityHomeBinding

@Route(path = "/home/activity")
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.login.setOnClickListener {
            ARouter.getInstance().build("/login/activity").navigation()
        }

        binding.vip.setOnClickListener {
            ARouter.getInstance().build("/vip/activity").navigation()
        }
    }
}