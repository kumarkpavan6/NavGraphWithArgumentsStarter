package com.example.navgraphwithargumentsstarter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navgraphwithargumentsstarter.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    // 1. variable to store your binding
    lateinit var binding:FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 2. setup your binding
        binding = FragmentFirstBinding.inflate(this.layoutInflater, container, false)

        // you need to get a reference to the button
        binding.btnPushMe.setOnClickListener {
            // whatever your button click handler code is
            // when the person presses the button, it goes to screen 2
            //findNavController().navigate(R.id.action_goToSecondScreen)

            // 1. get the name from the UI
            val nameFromUI = binding.etName.text.toString()

            // 2. put the name in a  "Directions" class
            // 2b. also send a floating point number
            val action = FirstFragmentDirections.actionGoToSecondScreen(nameFromUI, 3.75f)

            // 3. send the "Directions class" to Screen #2
            findNavController().navigate(action)

        }
        // 3. return the binding so the screen has something to show
        return binding.root
    }
}