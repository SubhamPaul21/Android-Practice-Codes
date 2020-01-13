package com.example.thejumbo


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_welcome.*

/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        orderCoffeeBtn.setOnClickListener {
            it.findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToOrderCoffeeFragment())
        }

        funBoxesBtn.setOnClickListener {
            it.findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToFunBoxesFragment())
        }

        quakeReportBtn.setOnClickListener {
            it.findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToQuakeReportFragment())
        }
    }
}
