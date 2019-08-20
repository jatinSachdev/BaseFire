package com.stunnningcoder.firebaseauth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.stunnningcoder.firebaseauth.fragment.InvadeFragment
import com.stunnningcoder.firebaseauth.fragment.ProfileFragment
import com.stunnningcoder.firebaseauth.fragment.TAG_INVADE_FRAGMENT
import com.stunnningcoder.firebaseauth.fragment.TAG_PROFILE_FRAGMENT

/**
 * Created by JS on 8/19/19.
 */
class InvadeActivityViewImplementation(
    val fragmentManager: FragmentManager,
    val inflater: LayoutInflater,
    layout: Int,
    container: ViewGroup?
) : ViewMvc {
    override var rootView: View = inflater.inflate(layout, container )


    fun inflateFragment() {
        fragmentManager.beginTransaction().add(R.id.clInvadeContainer, InvadeFragment.newInstance(), TAG_INVADE_FRAGMENT).commit()
    }

    fun inflateProfile(){
        fragmentManager.beginTransaction().replace(R.id.clInvadeContainer, ProfileFragment.newInstance(), TAG_PROFILE_FRAGMENT).commit()
    }




}