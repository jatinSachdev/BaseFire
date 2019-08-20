package com.stunnningcoder.firebaseauth.fragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.auth.FirebaseUser
import com.stunnningcoder.firebaseauth.*

import com.stunnningcoder.firebaseauth.databinding.FragmentInvadeBinding
import com.stunnningcoder.firebaseauth.model.InvadeState
import com.stunnningcoder.firebaseauth.model.User

const val TAG_INVADE_FRAGMENT = "TAG_INVADE_FRAGMENT"

class InvadeFragment : Fragment() {

    private lateinit var mBinding: FragmentInvadeBinding
    private lateinit var invadeViewModel: InvadeViewModel
    private lateinit var activityFragmentInteractionInterface : ActivityFragmentInteractionInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_invade, container, false)
        activity?.run { ViewModelProviders.of(this).get(InvadeViewModel::class.java) }?.also {
            invadeViewModel = it
            mBinding.setVariable(com.stunnningcoder.firebaseauth.BR.invadeViewModel, invadeViewModel)
        }
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        invadeViewModel.userLiveData.observe(viewLifecycleOwner, Observer { user ->
            activity?.let { activity ->
                mBinding.progress.visibility = View.VISIBLE
                doLogin(user, activity)
            }

        })
        invadeViewModel.invadeStateLiveData.observe(viewLifecycleOwner, Observer { invalidState ->
            when (invalidState) {
                is InvadeState.SignInFailure -> {
                    Toast.makeText(activity, invalidState.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun doLogin(
        user: User,
        activity: FragmentActivity
    ) {

        val auth = (invadeViewModel.app as CustomApplication).getApplicationComponent().getAuthFirebase()
        auth.createUserWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    updateUI(auth.currentUser)
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        activity, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            InvadeFragment()
    }

    private fun updateUI(user: FirebaseUser?) {
        mBinding.progress.visibility = View.GONE
        if (user != null) {
          activityFragmentInteractionInterface.onFragmentAttached(TAG_PROFILE_FRAGMENT)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let { it ->
            activityFragmentInteractionInterface = it as ActivityFragmentInteractionInterface
        }

    }
}
