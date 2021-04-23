package com.yagysumule.githubusers.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UserResponse(
    var userName: String,
    var name: String,
    var avatar: String,
    var company: String,
    var location: String,
    var repository: Int,
    var follower: Int,
    var following: Int
) : Parcelable