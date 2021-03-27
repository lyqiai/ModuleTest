package com.river.biz_vip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.river.biz_login.LoginService
import com.river.biz_vip.databinding.ActivityVipBinding
import com.river.common.RouterExtras

@Route(path = "/vip/activity", extras = RouterExtras.VIP)
class VipActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityVipBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val loginService =
            ARouter.getInstance().build("/login/service").navigation() as LoginService

        binding.vipName.text = loginService.getAccount() ?: "暂未登录"
    }
}