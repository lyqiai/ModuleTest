package com.river.zujianhua

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.alibaba.android.arouter.launcher.ARouter
import com.river.biz_login.LoginService
import com.river.common.RouterExtras

@Interceptor(name = "vip拦截器", priority = 9)
class VipInterceptor : IInterceptor {
    private var context: Context? = null

    override fun init(context: Context?) {
        this.context = context
    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        val extra = postcard?.extra ?: -1

        if (extra and RouterExtras.VIP != 0) {
            val loginService =
                ARouter.getInstance().build("/login/service").navigation() as LoginService

            if (!loginService.isLogin()) {
                toast("请先登录")

                callback?.onInterrupt(RuntimeException("请先登录"))
                return
            }
        }

        callback?.onContinue(postcard)
    }

    private fun toast(message: String) {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}