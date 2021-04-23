package com.yagysumule.githubusers.di

import android.content.Context
import com.yagysumule.githubusers.data.UserRepository
import com.yagysumule.githubusers.data.source.remote.RemoteDataSource
import com.yagysumule.githubusers.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): UserRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return UserRepository.getInstance(remoteDataSource)
    }
}