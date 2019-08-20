package com.stunnningcoder.firebaseauth.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.stunnningcoder.firebaseauth.BR
import com.stunnningcoder.firebaseauth.InvadeViewModel

import com.stunnningcoder.firebaseauth.R
import com.stunnningcoder.firebaseauth.databinding.FragmentProfileBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
const val TAG_PROFILE_FRAGMENT = "TAG_PROFILE_FRAGMENT"
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentProfileBinding>(inflater, R.layout.fragment_profile, container, false)
        activity?.let {activity->
            binding.setVariable(BR.invadeModel, ViewModelProviders.of(activity)[InvadeViewModel::class.java])
        }
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            ProfileFragment()
            }
}
