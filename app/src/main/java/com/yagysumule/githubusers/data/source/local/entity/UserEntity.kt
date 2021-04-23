package com.yagysumule.githubusers.data.source.local.entity

data class UserEntity(
    var userName: String,
    var name: String,
    var avatar: String,
    var company: String,
    var location: String,
    var repository: Int,
    var follower: Int,
    var following: Int,
    var favorites: Boolean = false
    )

