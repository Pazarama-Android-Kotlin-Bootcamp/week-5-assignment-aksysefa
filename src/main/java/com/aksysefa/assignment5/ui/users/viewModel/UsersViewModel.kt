package com.aksysefa.assignment5.ui.users.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aksysefa.assignment5.data.model.Users
import com.aksysefa.assignment5.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val usersRepository:UserRepository ,
) : ViewModel() {
     var userLiveData=MutableLiveData<List<Users>>()

    init {
    getUsers()
    }

    private fun getUsers(){
        usersRepository.getUsers().enqueue(object : Callback<List<Users>>{
            override fun onResponse(
                call: retrofit2.Call<List<Users>>,
                response: Response<List<Users>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                    userLiveData.postValue(it)
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<List<Users>>, t: Throwable) {
                Log.d(t.localizedMessage,"hata")
            }

        })
    }
}