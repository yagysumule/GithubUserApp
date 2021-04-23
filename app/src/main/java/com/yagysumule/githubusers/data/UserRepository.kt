package com.yagysumule.githubusers.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yagysumule.githubusers.data.source.local.entity.UserEntity
import com.yagysumule.githubusers.data.source.remote.RemoteDataSource
import com.yagysumule.githubusers.data.source.remote.response.UserResponse

class UserRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    UserDataSource {

    companion object {
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(remoteData: RemoteDataSource): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllUsers(): LiveData<List<UserEntity>> {
        val userResults = MutableLiveData<List<UserEntity>>()
        remoteDataSource.getAllUsers(object : RemoteDataSource.LoadUsersCallback {
            override fun onAllUsersReceived(userResponses: List<UserResponse>) {
                val userList = ArrayList<UserEntity>()
                for (response in userResponses) {
                    val user = UserEntity(
                        response.userName,
                        response.name,
                        response.avatar,
                        response.company,
                        response.location,
                        response.repository,
                        response.follower,
                        response.following,
                        false
                    )
                    userList.add(user)
                }
                userResults.postValue(userList)
            }
        })
        return userResults
    }

    override fun getFavoritesUsers(): LiveData<List<UserEntity>> {
        val userResults = MutableLiveData<List<UserEntity>>()
        remoteDataSource.getAllUsers(object : RemoteDataSource.LoadUsersCallback {
            override fun onAllUsersReceived(userResponses: List<UserResponse>) {
                val userList = ArrayList<UserEntity>()
                for (response in userResponses) {
                    val user = UserEntity(
                        response.userName,
                        response.name,
                        response.avatar,
                        response.company,
                        response.location,
                        response.repository,
                        response.follower,
                        response.following,
                        false
                    )
                    userList.add(user)
                }
                userResults.postValue(userList)
            }
        })
        return userResults
    }

    override fun getUserWithDetail(userName: String): LiveData<UserEntity> {
        val userResult = MutableLiveData<UserEntity>()

        remoteDataSource.getAllUsers(object : RemoteDataSource.LoadUsersCallback {
            override fun onAllUsersReceived(userResponses: List<UserResponse>) {
                lateinit var user: UserEntity
                for (response in userResponses) {
                    if (response.userName == userName) {
                        user = UserEntity(
                            response.userName,
                            response.name,
                            response.avatar,
                            response.company,
                            response.location,
                            response.repository,
                            response.follower,
                            response.following,
                            false
                        )
                    }
                }
                userResult.postValue(user)
            }
        })
        return userResult
    }
}