package com.stunnningcoder.firebaseauth

import android.os.Bundle
import com.stunnningcoder.firebaseauth.fragment.TAG_PROFILE_FRAGMENT

const val TAG = "INVADE"
class InvadeActivity : BaseActivity() , ActivityFragmentInteractionInterface {
    override fun onFragmentAttached(action: String) {
        when(action){
            TAG_PROFILE_FRAGMENT ->{
                invadeActivityViewImplementation.inflateProfile()
            }
        }
    }

    private lateinit var invadeActivityViewImplementation: InvadeActivityViewImplementation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        invadeActivityViewImplementation =
            getViewProviderFactory().newInstance(InvadeActivityViewImplementation::class.java, null)
        setContentView(invadeActivityViewImplementation.rootView)
        invadeActivityViewImplementation.inflateFragment()
    }

}

interface ActivityFragmentInteractionInterface{
    fun onFragmentAttached(action : String)
}
