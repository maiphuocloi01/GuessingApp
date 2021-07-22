package com.example.guessinggame.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayerViewModel: ViewModel() {
    private val _username = MutableLiveData("Enter your name!")
    val username: LiveData<String> = _username
    fun setPlayersName(name: String){
        _username.value = name
    }
}