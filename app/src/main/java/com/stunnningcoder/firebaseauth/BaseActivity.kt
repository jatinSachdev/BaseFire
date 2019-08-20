package com.stunnningcoder.firebaseauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater

open class BaseActivity : AppCompatActivity() {

    protected lateinit var invadeActivityComponent: InvadeActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        invadeActivityComponent = InvadeActivityComponent(getApplicationComponent(), layoutInflater, supportFragmentManager)
    }

    private fun getApplicationComponent() : ApplicationComponent{
        return  (application as CustomApplication).getApplicationComponent()
    }

    fun getViewProviderFactory() : ViewProviderFactory{
        return  invadeActivityComponent.getViewFactory()
    }
}
