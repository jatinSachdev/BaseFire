package com.stunnningcoder.firebaseauth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import java.lang.IllegalArgumentException

/**
 * Created by JS on 8/19/19.
 *
 */
class ViewProviderFactory (val layoutInflater: LayoutInflater, val fragmentManager: FragmentManager){


    fun <T : ViewMvc> newInstance(type : Class<T>, container : ViewGroup?) : T{
        val viewMvc : ViewMvc
        if(type == InvadeActivityViewImplementation::class.java){
            viewMvc =  InvadeActivityViewImplementation(fragmentManager,layoutInflater, R.layout.activity_invade, container)
        }else{
            throw IllegalArgumentException("unsupported view")
        }
        @Suppress("UNCHECKED_CAST")
        return viewMvc as T
    }

}