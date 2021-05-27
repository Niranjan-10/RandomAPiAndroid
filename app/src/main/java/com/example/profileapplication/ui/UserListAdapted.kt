package com.example.profileapplication.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.profileapplication.R
import com.example.profileapplication.data.User
import com.example.profileapplication.ui.ListFragmentDirections.actionListFragmentToDetailFragment3
import com.example.profileapplication.util.loadImage
import kotlinx.android.synthetic.main.user_item.view.*

class UserListAdapted(private val userList: ArrayList<User.Result>) :
    RecyclerView.Adapter<UserListAdapted.UserViewHolder>(), OnClickListener {

    fun updateUsers(newUsers: List<User.Result>) {

        userList.clear()
        userList.addAll(newUsers)
        notifyDataSetChanged()
    }


    class UserViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        private val email = view.text_view_email
        private val gender = view.text_view_gender
        private val imageView = view.image_view


        fun bind(user: User.Result) {
            email.text = user.email
            gender.text = user.gender
            imageView.loadImage(user.pictures.medium)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.user_item, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
        holder.view.setOnClickListener {
            var result = userList[position] as User.Result
            var url = result.pictures.medium
            var gender = result.gender
            var email = result.email
            val action = actionListFragmentToDetailFragment3(gender, email, url)

            Navigation.findNavController(holder.view).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onItemClick(view: View) {
        Log.d("clicked", "clicked")


    }


}