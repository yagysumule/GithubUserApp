package com.yagysumule.githubusers.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yagysumule.githubusers.data.UserRepository
import com.yagysumule.githubusers.data.source.local.entity.UserEntity

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun getUsers() : LiveData<List<UserEntity>> = userRepository.getAllUsers()
}