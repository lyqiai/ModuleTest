package com.river.biz_login

import android.content.Context
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/login/service")
class LoginServiceImpl : LoginService {
    override fun login(context: Context, observer: Observer<Boolean>) {
    }

    override fun isLogin(): Boolean {
        return AccountManager.isLogin()
    }

    override fun getAccount(): String? {
        return AccountManager.getAccount()
    }

    override fun init(context: Context?) {
    }
}