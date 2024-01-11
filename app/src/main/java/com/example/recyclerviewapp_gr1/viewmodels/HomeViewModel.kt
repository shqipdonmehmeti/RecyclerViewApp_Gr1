package com.example.recyclerviewapp_gr1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewapp_gr1.helpers.Helpers
import com.example.recyclerviewapp_gr1.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _userList : MutableLiveData<List<User>> = MutableLiveData(mutableListOf())
    val userList : LiveData<List<User>>
        get() = _userList

    private val _loading : MutableLiveData<Boolean> = MutableLiveData(false)
    val loading : LiveData<Boolean>
        get() = _loading

//    fun getUserList() : LiveData<List<User>> {
//        return _userList
//    }

    fun getUsers() {
        _loading.value = true
        Helpers.provideRetrofitInstance().getUsers().enqueue(object : Callback<List<User>?> {
            override fun onResponse(call: Call<List<User>?>, response: Response<List<User>?>) {
                _loading.value = false
                if (response.isSuccessful && response.body() != null) {
                    _userList.value = response.body()!!
                }
            }

            override fun onFailure(call: Call<List<User>?>, t: Throwable) {
                _loading.value = false
//                Toast.makeText(requireContext(),"Call not being made", Toast.LENGTH_LONG).show()
            }
        })
    }
}