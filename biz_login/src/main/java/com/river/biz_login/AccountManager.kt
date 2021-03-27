package com.river.biz_login

object AccountManager {
    private var username: String? = null

    fun setAccount(username: String) {
        this.username = username
    }

    fun isLogin(): Boolean {
        return username != null
    }

    fun getAccount(): String? {
        return username
    }
}