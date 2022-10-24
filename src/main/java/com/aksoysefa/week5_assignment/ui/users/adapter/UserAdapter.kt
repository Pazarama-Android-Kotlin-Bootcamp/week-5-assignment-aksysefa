package com.aksoysefa.week5_assignment.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aksoysefa.week5_assignment.databinding.ItemUserLayoutBinding
import com.aksoysefa.week5_assignment.ui.model.Users


class UsersAdapter : ListAdapter<Users, UsersAdapter.UserViewHolder>(UsersDiffutil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class UserViewHolder(private val binding: ItemUserLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(users: Users){
            binding.dataHolder = users
            binding.executePendingBindings()
        }
    }

    class UsersDiffutil : DiffUtil.ItemCallback<Users>(){
        override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
            return oldItem==newItem
        }

    }
}