package com.stunnningcoder.firebaseauth

import android.app.Application
import androidx.databinding.BindingAdapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.stunnningcoder.firebaseauth.model.InvadeState
import com.stunnningcoder.firebaseauth.model.User

/**
 * Created by JS on 8/19/19.
 */
class InvadeViewModel(val app: Application) : AndroidViewModel(app) {

    val userLiveData: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }
    val user: User by lazy {
        User()
    }

    val invadeStateLiveData : MutableLiveData<InvadeState> by lazy {
        MutableLiveData<InvadeState>()
    }

    fun doLogin() {
        if(user.email.isBlank() || !android.util.Patterns.EMAIL_ADDRESS.matcher(user.email).matches() || user.password.length < 6){
            invadeStateLiveData.value = InvadeState.SignInFailure("Please provide valid input")
            return
        }
        userLiveData.value = user
    }
}