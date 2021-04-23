package com.yagysumule.githubusers.utils

import android.content.Context
import com.yagysumule.githubusers.data.source.remote.response.UserResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadUsers(): List<UserResponse> {
        val list = ArrayList<UserResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("githubuser.json").toString())
            val listArray = responseObject.getJSONArray("users")
            for (i in 0 until listArray.length()) {
                val user = listArray.getJSONObject(i)

                val userName = user.getString("username")
                val name = user.getString("name")
                val avatar = user.getString("avatar")
                val company = user.getString("company")
                val location = user.getString("location")
                val repository = user.getInt("repository")
                val follower = user.getInt("follower")
                val following = user.getInt("following")

                val userResponse = UserResponse(
                    userName, name, avatar, company, location, repository, follower, following
                )
                list.add(userResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}