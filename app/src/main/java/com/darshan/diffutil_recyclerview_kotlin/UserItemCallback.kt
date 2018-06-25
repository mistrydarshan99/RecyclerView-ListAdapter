package com.darshan.diffutil_recyclerview_kotlin

import android.support.v7.util.DiffUtil

class UserItemCallback : DiffUtil.ItemCallback<User>() {
  override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: User?, newItem: User?): Boolean {
    return oldItem == newItem
  }

}
