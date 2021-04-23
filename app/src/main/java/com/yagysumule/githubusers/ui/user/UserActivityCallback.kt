package com.yagysumule.githubusers.ui.user

import com.yagysumule.githubusers.data.source.local.entity.UserEntity

interface UserActivityCallback {
    fun onShareClick(user : UserEntity)
}