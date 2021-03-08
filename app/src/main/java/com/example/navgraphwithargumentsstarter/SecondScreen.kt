package com.example.navgraphwithargumentsstarter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navgraphwithargumentsstarter.databinding.FragmentSecondScreenBinding

class SecondScreen : Fragment() {

    // binding
    // get your button from the binding
    // setup the click handler
    // write the code to nvaigate back

    lateinit var binding:FragmentSecondScreenBinding

    // 1. you need a args class reference (this is the thing that will receive your package)
    val args: SecondScreenArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondScreenBinding.inflate(this.layoutInflater, container, false)

        // 2. unpac/ access your varaibles tha tyou got from screen #1
        // these vars will be found in the args class
        binding.resultsLabel.text = args.name

        Log.d("SOMETHING", "The student gpa is: ${args.gpa}")

        binding.btnGoBack.setOnClickListener {
            goBackPressed()
        }
        return binding.root
    }

    private fun goBackPressed() {
        findNavController().navigate(R.id.action_goHome)
    }
}