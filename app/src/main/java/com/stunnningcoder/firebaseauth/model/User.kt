package com.stunnningcoder.firebaseauth.model

/**
 * Created by JS on 8/19/19.
 */
data class User(var email : String = "", var password : String = "")

sealed class InvadeState{
    class SignInSuccess() : InvadeState()
    class SignInFailure(var message : String): InvadeState()
    class LoginInFailure(): InvadeState()
    class LoginInSuccess(): InvadeState()
}