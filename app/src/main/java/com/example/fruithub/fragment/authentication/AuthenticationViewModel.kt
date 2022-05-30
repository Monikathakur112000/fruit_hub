package com.example.fruithub.fragment.authentication


import androidx.lifecycle.ViewModel
import com.example.fruithub.app.MyApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(randomName: String, val app: MyApplication) :
    ViewModel() {
    init {
        println("ViewModel:$randomName ${app.applicationContext}")
    }
}