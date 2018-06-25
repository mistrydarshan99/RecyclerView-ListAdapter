package com.darshan.diffutil_recyclerview_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.fab
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.content_main.rvUser

class UserListAdapterActivity : AppCompatActivity() {

  val userAdapter = UserListAdapter()
  var i = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(toolbar)

    fab.setOnClickListener {
      i++
      if (i == 1) {
        userAdapter.submitList(
          listOf(
            User(1, "Krutarth 1"), User(1, "Ankitbhai 1"),
            User(1, "Irfan 1")
          )
        )
      } else if (i === 2) {
        userAdapter.submitList(
          listOf(
            User(1, "Krutarth 1")
          )
        )
      } else if (i == 3) {
        userAdapter.submitList(
          listOf(
            User(1, "Darshan 1"), User(1, "Krutarth 1")
          )
        )
      }
    }

    rvUser.adapter = userAdapter
    userAdapter.submitList(listOf(User(1, "Darshan 1"), User(1, "Hardik 1"), User(1, "Dipen 1")))
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    return when (item.itemId) {
      R.id.action_settings -> true
      else -> super.onOptionsItemSelected(item)
    }
  }
}
