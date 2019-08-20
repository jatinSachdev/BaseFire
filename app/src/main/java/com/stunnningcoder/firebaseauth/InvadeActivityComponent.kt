package com.stunnningcoder.firebaseauth

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager

/**
 * Created by JS on 8/19/19.
 */
class InvadeActivityComponent(val applicationComponent: ApplicationComponent, val layoutInflater : LayoutInflater,val fragmentManager: FragmentManager) {

    fun getViewFactory() : ViewProviderFactory{
        return ViewProviderFactory(layoutInflater, fragmentManager)
    }

}