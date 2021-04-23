package com.yagysumule.githubusers.data.source.remote

import android.os.Handler
import android.os.Looper
import com.yagysumule.githubusers.data.source.remote.response.UserResponse
import com.yagysumule.githubusers.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply {
                    instance = this
                }
            }
    }

    fun getAllUsers(callback: LoadUsersCallback) {
        handler.postDelayed(
            { callback.onAllUsersReceived(jsonHelper.loadUsers()) },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    interface LoadUsersCallback {
        fun onAllUsersReceived(userResponses: List<UserResponse>)
    }
}