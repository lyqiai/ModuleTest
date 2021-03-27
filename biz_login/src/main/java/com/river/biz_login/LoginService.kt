package com.river.biz_login

import android.content.Context
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.template.IProvider

interface LoginService : IProvider {
    fun login(context: Context, observer: Observer<Boolean>)

    fun isLogin(): Boolean

    fun getAccount(): String?
}