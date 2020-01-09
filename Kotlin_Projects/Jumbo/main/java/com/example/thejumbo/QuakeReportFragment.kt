package com.example.thejumbo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.thejumbo.databinding.FragmentQuakeReportBinding


class QuakeReportFragment : Fragment() {

    private lateinit var quakeReportBinding: FragmentQuakeReportBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        quakeReportBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_quake_report, container, false)
        return quakeReportBinding.root
    }
}
