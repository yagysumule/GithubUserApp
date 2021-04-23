package com.yagysumule.githubusers.ui.user

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yagysumule.githubusers.R
import com.yagysumule.githubusers.data.source.local.entity.UserEntity
import com.yagysumule.githubusers.databinding.ItemsUserBinding
import com.yagysumule.githubusers.ui.detail.DetailUserActivity
import java.util.*

class UserAdapter(private val callback: UserActivityCallback) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var listUsers = ArrayList<UserEntity>()

    fun setUsers(users: List<UserEntity>?) {
        if (users == null) return
        this.listUsers.clear()
        this.listUsers.addAll(users)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemsUserBinding =
            ItemsUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(itemsUserBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUsers[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = listUsers.size

    inner class UserViewHolder(private val binding: ItemsUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserEntity) {
            with(binding) {
                tvItemUsername.text = user.userName
                tvItemName.text = user.name
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailUserActivity::class.java)
                    intent.putExtra(DetailUserActivity.EXTRA_USER, user.userName)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(
                        itemView.context.resources.getIdentifier(
                            user.avatar,
                            "drawable",
                            itemView.context.packageName
                        )
                    )
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(this.imgPhoto)

                imgShare.setOnClickListener { callback.onShareClick(user) }
            }
        }
    }
}