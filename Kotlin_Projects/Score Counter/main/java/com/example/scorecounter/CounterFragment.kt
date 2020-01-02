package com.example.scorecounter


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_counter.*

class CounterFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamAText.text = arguments?.getString("team_A_name")
        teamBText.text = arguments?.getString("team_B_name")

        val buttonList: List<Button> = listOf(plusThreeBtnA, plusThreeBtnB, plusTwoBtnA, plusTwoBtnB, plusOneBtnA, plusOneBtnB, resetBtn)

        for (button in buttonList) {
            button.setOnClickListener {
                when(button) {
                    plusThreeBtnA -> threePointIncrement(teamAScoreText)
                    plusThreeBtnB -> threePointIncrement(teamBScoreText)
                    plusTwoBtnA -> twoPointIncrement(teamAScoreText)
                    plusTwoBtnB -> twoPointIncrement(teamBScoreText)
                    plusOneBtnA -> onePointIncrement(teamAScoreText)
                    plusOneBtnB -> onePointIncrement(teamBScoreText)
                    resetBtn -> resetPoints()
                }
            }
        }
    }

    // Increment the team score by +3
    private fun threePointIncrement(textView: TextView) {
        var score: Int = textView.text.toString().toInt()
        score += 3
        textView.text = score.toString()
    }

    // Increment the team score by +2
    private fun twoPointIncrement(textView: TextView) {
        var score: Int = textView.text.toString().toInt()
        score += 2
        textView.text = score.toString()
    }

    // Increment the team score by +1
    private fun onePointIncrement(textView: TextView) {
        var score: Int = textView.text.toString().toInt()
        score += 1
        textView.text = score.toString()
    }

    // Reset all values
    private fun resetPoints() {
        // Reset
        teamAScoreText.text = "0"
        teamBScoreText.text = "0"
    }
}
