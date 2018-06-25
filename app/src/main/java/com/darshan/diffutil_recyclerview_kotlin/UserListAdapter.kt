package com.darshan.diffutil_recyclerview_kotlin

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_user.view.tvUserName

class UserListAdapter :
  ListAdapter<User, UserListAdapter.UserListViewHolder>(UserItemCallback()) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    UserListViewHolder(parent.inflate(R.layout.row_user))

  override fun onBindViewHolder(holder: UserListViewHolder, position: Int) =
    holder.bind(getItem(position))

  class UserListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(user: User) = with(itemView) {
      tvUserName.text = user.name
    }
  }
}


