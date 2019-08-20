package com.stunnningcoder.firebaseauth

import android.app.Application
import androidx.multidex.MultiDexApplication

/**
 * Created by JS on 8/19/19.
 */
class CustomApplication : MultiDexApplication(){


    fun getApplicationComponent() : ApplicationComponent{
        return ApplicationComponent()
    }


}