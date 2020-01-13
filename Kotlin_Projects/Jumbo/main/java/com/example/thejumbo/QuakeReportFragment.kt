package com.example.thejumbo


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_quake_report.*


class QuakeReportFragment : Fragment() {

    private val earthQuakeReport = listOf(
        Earthquake(
            0.2,
            "94km SSE of",
            "Taron, Papua New Guinea",
            1453777820750,
            "http://earthquake.usgs.gov/earthquakes/eventpage/us20004uks"
        ),
        Earthquake(
            5.7,
            "50km NNE of",
            "Al Hoceima, Morocco",
            1453695722730,
            "http://earthquake.usgs.gov/earthquakes/eventpage/us10004gy9"
        ),
        Earthquake(
            1.1,
            "86km E of",
            "Old Iliamna, Alaska",
            1453631430230,
            "http://earthquake.usgs.gov/earthquakes/eventpage/us10004gqp"
        ),
        Earthquake(
            3.1,
            "215km SW of",
            "Tomatlan, Mexico",
            1453399617650,
            "http://earthquake.usgs.gov/earthquakes/eventpage/us10004g4l"
        ),
        Earthquake(
            2.3,
            "52km SE of",
            "Shizunai, Japan",
            1452741933640,
            "http://earthquake.usgs.gov/earthquakes/eventpage/us10004ebx"
        ),
        Earthquake(
            4.6,
            "12km WNW of",
            "Charagua, Bolivia",
            1452741928270,
            "http://earthquake.usgs.gov/earthquakes/eventpage/us10004ebw"
        ),
        Earthquake(
            6.1,
            "74km NW of",
            "Rumoi, Japan",
            1452532083920,
            "http://earthquake.usgs.gov/earthquakes/eventpage/us10004djn"
        ),
        Earthquake(
            7.2,
            "227km SE of",
            "Sarangani, Philippines",
            1452530285900,
            "http://earthquake.usgs.gov/earthquakes/eventpage/us10004dj5"
        ),
        Earthquake(
            8.5,
            "Near the",
            "Pacific-Antarctic Ridge",
            1451986454620,
            "http://earthquake.usgs.gov/earthquakes/eventpage/us10004bgk"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quake_report, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        earthquake_list_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListAdapter(earthQuakeReport)
        }
    }
}
