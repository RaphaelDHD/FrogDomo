package com.FrogDomo.View.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.FrogDomo.Model.LoginUser
import com.FrogDomo.Model.User
import com.FrogDomo.Repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    fun loginUser(user: LoginUser): LiveData<User> {
        var livedata = MutableLiveData<User>()
        viewModelScope.launch {
            val data = UserRepository.loginUser(user)
            data.collect {user->
                livedata.postValue(user)
            }

        }

        return livedata
    }
}