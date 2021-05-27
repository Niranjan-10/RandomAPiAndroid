package com.example.profileapplication.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.profileapplication.api.UserService
import com.example.profileapplication.data.User
//import com.example.profileapplication.data.UserList
import kotlinx.coroutines.*

class UserViewModel : ViewModel() {
    val userService = UserService().getUserService()
    var job: Job? = null

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        println("CoroutineExceptionHandler got $throwable")
    }

        var users = MutableLiveData<List<User.Result>>()
//    val users = MutableLiveData<List<UserList.User>>()
    val userLoadError = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchUsers()
    }

    private fun fetchUsers() {
        loading.value = true
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = userService.getUser(results = RESULTS)
            Log.d("Response", "${response.body()}")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    users.value = response.body()?.result
                    println(users.value)
                } else {
                    onError("Error : ${response.errorBody()}")
                }
            }

        }

        userLoadError.value = " "
        loading.value = false
    }

    private fun onError(message: String) {
        userLoadError.value = message
        loading.value = false
        Log.d("error","${message}")
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    companion object{
        private const val RESULTS = 50
    }

}