package com.yagysumule.githubusers.ui.user

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yagysumule.githubusers.data.source.local.entity.UserEntity
import com.yagysumule.githubusers.databinding.ActivityUserBinding
import com.yagysumule.githubusers.viewmodel.ViewModelFactory

class UserActivity : AppCompatActivity(), UserActivityCallback {

    private lateinit var activityUserBinding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityUserBinding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(activityUserBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[UserViewModel::class.java]

        val userAdapter = UserAdapter(this)

        activityUserBinding.progressBar.visibility = View.VISIBLE
        viewModel.getUsers().observe(this, { users ->
            activityUserBinding.progressBar.visibility = View.GONE
            userAdapter.setUsers(users)
            userAdapter.notifyDataSetChanged()
        })

        with(activityUserBinding.rvUser) {
            layoutManager = LinearLayoutManager(this@UserActivity)
            setHasFixedSize(true)
            this.adapter = userAdapter
        }

    }

    override fun onShareClick(user: UserEntity) {
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle("Bagikan pengguna ini ke")
            .setText("Ikuti profil ${user.name}")
            .startChooser()
    }
}