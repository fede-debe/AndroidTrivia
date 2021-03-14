package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false)

        // create onClickListener to trigger the action(navigate between the destination) - (in Kotlin we can pass an anonymous function into setOnClickListener)
        binding.playButton.setOnClickListener (
            // we call this function on the view to get an instance of the navigation controller
            /** Navigation.findNavController(it).navigate(R.id.action_titleFragment_to_gameFragment)
                view.view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)*/
            Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        )
        // we need to return binding.root (which contains the root of the layout we’ve just inflated)
        return binding.root
    }
}