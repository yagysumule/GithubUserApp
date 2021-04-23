package com.yagysumule.githubusers.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.yagysumule.githubusers.R
import com.yagysumule.githubusers.data.source.local.entity.UserEntity
import com.yagysumule.githubusers.databinding.ActivityDetailUserBinding
import com.yagysumule.githubusers.databinding.ContentDetailUserBinding
import com.yagysumule.githubusers.viewmodel.ViewModelFactory

class DetailUserActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var detailContentBinding: ContentDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailUserBinding = ActivityDetailUserBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailUserBinding.detailContent

        setContentView(activityDetailUserBinding.root)

        setSupportActionBar(activityDetailUserBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailUserViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val userName = extras.getString(EXTRA_USER)
            if (userName != null) {

                activityDetailUserBinding.progressBar.visibility = View.VISIBLE
                activityDetailUserBinding.content.visibility = View.INVISIBLE

                viewModel.setSelectedUser(userName)
                viewModel.getUser().observe(this, { user ->
                    activityDetailUserBinding.progressBar.visibility = View.GONE
                    activityDetailUserBinding.content.visibility = View.VISIBLE

                    populateUser(user)
                })
            }
        }
    }

    private fun populateUser(userEntity: UserEntity) {
        detailContentBinding.textName.text = userEntity.name
        detailContentBinding.textCompany.text = userEntity.company
        detailContentBinding.textLocation.text = userEntity.location
        detailContentBinding.textRepository.text = userEntity.repository.toString()
        detailContentBinding.textFollowers.text = userEntity.follower.toString()
        detailContentBinding.textFollowing.text = userEntity.following.toString()

        detailContentBinding.imagePhoto.let {
            Glide.with(this)
                .load(this.resources.getIdentifier(userEntity.avatar, "drawable", this.packageName))
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
                )
                .into(it)
        }

        supportActionBar?.title = userEntity.userName
    }
}