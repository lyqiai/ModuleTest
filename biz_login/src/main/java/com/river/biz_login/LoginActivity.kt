package com.river.biz_login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.river.biz_login.databinding.ActivityLoginBinding

@Route(path = "/login/activity")
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginAction.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username = binding.username.text.toString()
        val password = binding.password.text.toString()

        AccountManager.setAccount(username)

        finish()
    }
}