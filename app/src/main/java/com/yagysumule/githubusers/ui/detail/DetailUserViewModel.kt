package com.yagysumule.githubusers.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yagysumule.githubusers.data.UserRepository
import com.yagysumule.githubusers.data.source.local.entity.UserEntity

class DetailUserViewModel(private val userRepository: UserRepository) : ViewModel() {

    private lateinit var userName: String

    fun setSelectedUser(userName: String) {
        this.userName = userName
    }

    fun getUser(): LiveData<UserEntity> = userRepository.getUserWithDetail(userName)
}