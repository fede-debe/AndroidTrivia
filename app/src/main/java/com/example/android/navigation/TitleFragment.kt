package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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
        binding.playButton.setOnClickListener {
            // we call this function on the view to get an instance of the navigation controller
            /** Navigation.findNavController(it).navigate(R.id.action_titleFragment_to_gameFragment)
            view.view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)*/
            it.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }


        // declaring that I am going to have a menu associated with the TitleFragment
        setHasOptionsMenu(true)
        // we need to return binding.root (which contains the root of the layout we’ve just inflated)
        return binding.root
    }

    // menu are created on this method, as the layout we also inflate menus
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        // we use the inflater provided from the method to inflate the menu using the one-liner
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    // when a menu item is selected, this fragments' method will be called
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /** if the navigationUI doesn't handle the selection, we'll call super on options items selected with the menu item,
            which allows the app to directly handle the menu item without navigating.*/
        return NavigationUI.onNavDestinationSelected(item,
                view!!.findNavController())
        || super.onOptionsItemSelected(item)
    }
}