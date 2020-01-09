package com.example.thejumbo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.thejumbo.databinding.FragmentFunBoxesBinding


class FunBoxesFragment : Fragment() {

    private lateinit var funBoxesBinding: FragmentFunBoxesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        funBoxesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_fun_boxes, container, false)
        return funBoxesBinding.root
    }
}
