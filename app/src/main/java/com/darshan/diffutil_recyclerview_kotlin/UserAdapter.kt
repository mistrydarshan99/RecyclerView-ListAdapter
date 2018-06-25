package com.darshan.diffutil_recyclerview_kotlin

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_user.view.tvUserName
import kotlin.properties.Delegates

class UserAdapter(private val clickListener: (Int) -> Unit) :
  RecyclerView.Adapter<UserAdapter.UserViewHolder>(),
  AutoUpdatableAdapter {

  var items: List<User> by Delegates.observable(emptyList()) { prop, old, new ->
    autoNotify(old, new) { o, n -> o.id == n.id }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    UserViewHolder(parent.inflate(R.layout.row_user))

  override fun getItemCount() = items.size

  override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
    holder.bind(items[position], clickListener)

  class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(
      user: User,
      clickListener: (Int) -> Unit
    ) = with(itemView) {
      tvUserName.text = user.name
      tvUserName.setOnClickListener {
        clickListener(adapterPosition)
      }
    }
  }
}
