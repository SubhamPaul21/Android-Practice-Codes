package com.example.thejumbo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.thejumbo.databinding.FragmentWelcomeBinding

/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment() {

    private lateinit var welcomeBinding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        welcomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container,false)
        return welcomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        welcomeBinding.orderCoffeeBtn.setOnClickListener {
            it.findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToOrderCoffeeFragment())
        }

        welcomeBinding.funBoxesBtn.setOnClickListener {
            it.findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToFunBoxesFragment())
        }

        welcomeBinding.quakeReportBtn.setOnClickListener {
            it.findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToQuakeReportFragment())
        }
    }
}
