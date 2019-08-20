package com.stunnningcoder.firebaseauth

import androidx.fragment.app.FragmentManager
import com.google.firebase.auth.FirebaseAuth

/**
 * Created by JS on 8/19/19.
 */
class ApplicationComponent{

    fun getAuthFirebase() : FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

}