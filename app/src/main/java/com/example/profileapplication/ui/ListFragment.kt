package com.example.profileapplication.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.profileapplication.R
import kotlinx.android.synthetic.main.user_fragment.*

class ListFragment : Fragment(R.layout.user_fragment) {
    lateinit var viewModel: UserViewModel
    private val userListAdapted = UserListAdapted(arrayListOf())


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.refresh()

        user_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userListAdapted
        }

        observeViewModel()
    }


    fun observeViewModel() {
        viewModel.users.observe(this, Observer { users ->
            users?.let {
                println(it)
                user_list.visibility = View.VISIBLE
                userListAdapted.updateUsers(it)
            }

        })

        viewModel.userLoadError.observe(this, {
            list_error.visibility = if (it == " ") View.GONE else View.VISIBLE
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->

            isLoading?.let {
                loadingView.visibility = if (it) View.VISIBLE else View.GONE

                if (it) {
                    list_error.visibility = View.GONE
                    user_list.visibility = View.GONE
                }
            }


        })
    }



}