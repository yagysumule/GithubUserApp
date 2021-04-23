package com.yagysumule.githubusers.data

import androidx.lifecycle.LiveData
import com.yagysumule.githubusers.data.source.local.entity.UserEntity

interface UserDataSource {

    fun getAllUsers(): LiveData<List<UserEntity>>

    fun getFavoritesUsers(): LiveData<List<UserEntity>>

    fun getUserWithDetail(userName: String): LiveData<UserEntity>
}