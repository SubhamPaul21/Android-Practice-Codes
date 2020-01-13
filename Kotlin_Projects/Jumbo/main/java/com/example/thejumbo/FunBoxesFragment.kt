package com.example.thejumbo


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_fun_boxes.*
import java.util.*

class FunBoxesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fun_boxes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewList: List<View> =
            listOf(box_one,box_two,box_three,box_four,box_five,box_six,box_seven,box_eight,box_nine,box_ten,box_eleven,box_twelve,box_thirteen,box_fourteen,box_fifteen,box_sixteen)

        for (item in textViewList) {
            item.setOnClickListener {
                it.setBackgroundColor(ContextCompat.getColor(context!!, getRandomColor()))
            }
//            item.setBackgroundColor(ContextCompat.getColor(this, getRandomColor()))
        }
    }

    private fun getRandomColor(): Int = when (Random().nextInt(20)) {
        0 -> R.color.my_white
        1 -> R.color.my_red
        2 -> R.color.my_blue
        3 -> R.color.my_yellow
        4 -> R.color.blue_izis
        5 -> R.color.cerulean_blue
        6 -> R.color.chili_pepper
        7 -> R.color.emerald
        8 -> R.color.greenery
        9 -> R.color.honeysucle
        10 -> R.color.living_coral
        11 -> R.color.marsala
        12 -> R.color.mimosa
        13 -> R.color.radiand_orchid
        14 -> R.color.rose_quartz
        15 -> R.color.serenity
        16 -> R.color.tangerine
        17 -> R.color.treu_red
        18 -> R.color.ultra_violet
        19 -> R.color.colorAccent
        else -> R.color.colorPrimaryDark
    }
}
