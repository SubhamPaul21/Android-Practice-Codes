package com.example.scorecounter


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_welcome.*

const val TEAM_A = "team_A_name"
const val TEAM_B = "team_B_name"

class WelcomeFragment : Fragment() {

    private lateinit var teamAName: String
    private lateinit var teamBName: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startBtn.setOnClickListener {
            val nameBundle = Bundle()
            teamAName = teamATextView.text.toString()
            teamBName = teamBTextView.text.toString()
            nameBundle.putString(TEAM_A, teamAName)
            nameBundle.putString(TEAM_B, teamBName)
            if (teamAName.isNotEmpty() and teamBName.isNotEmpty()) {
                it.findNavController().navigate(R.id.action_welcomeToCounter, nameBundle)
            } else {
                Toast.makeText(
                    context,
                    "Please provide all the team names to proceed",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
