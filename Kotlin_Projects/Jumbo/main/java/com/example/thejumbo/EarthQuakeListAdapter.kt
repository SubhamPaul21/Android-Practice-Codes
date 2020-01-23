package com.example.thejumbo

import android.content.Context
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.earthquake_list_item.view.*
import java.text.SimpleDateFormat
import java.util.*


class EarthQuakeListAdapter(private val earthquakeList: List<Earthquake>) :
    RecyclerView.Adapter<EarthquakeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthquakeViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.earthquake_list_item, parent, false)
        return EarthquakeViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return earthquakeList.size
    }

    override fun onBindViewHolder(holder: EarthquakeViewHolder, position: Int) {
        val holderItem = holder.itemView
        val magnitudeCircle: GradientDrawable =
            holderItem.magnitudeTextView.background as GradientDrawable
        holderItem.magnitudeTextView.text = earthquakeList[position].magnitude.toString()
        magnitudeCircle.setColor(
            ContextCompat.getColor(
                holderItem.context,
                getMagnitudeColor(earthquakeList[position].magnitude)
            )
        )
        holderItem.offsetTextView.text = earthquakeList[position].offset
        holderItem.locationTextView.text = earthquakeList[position].location
        holderItem.dateTextView.text =
            getDateFromMilliseconds(earthquakeList[position].milliseconds)
        holderItem.timeTextView.text =
            getTimeFromMilliseconds(earthquakeList[position].milliseconds)

        holderItem.earthQuakeRelativeLayout.setOnClickListener {
            openUrl(position, holderItem.context)
        }
    }

    private fun openUrl(position: Int, context: Context) {
        val webPage = Uri.parse(earthquakeList[position].url)
        val urlIntent = Intent(Intent.ACTION_VIEW, webPage)
        if (urlIntent.resolveActivity(context.packageManager) != null) {
            startActivity(context, urlIntent, Bundle.EMPTY)
        }
    }

    private fun getMagnitudeColor(magnitude: Double): Int {
        return when (magnitude.toInt()) {
            0, 1 -> R.color.magnitude1
            2 -> R.color.magnitude2
            3 -> R.color.magnitude3
            4 -> R.color.magnitude4
            5 -> R.color.magnitude5
            6 -> R.color.magnitude6
            7 -> R.color.magnitude7
            8 -> R.color.magnitude8
            9 -> R.color.magnitude9
            else -> R.color.magnitude10plus
        }
    }

    private fun getDateFromMilliseconds(milliseconds: Long): String {
        val formatter = SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)
        return formatter.format(Date(milliseconds))
    }

    private fun getTimeFromMilliseconds(milliseconds: Long): String {
        val formatter = SimpleDateFormat("HH:mm aa", Locale.ENGLISH)
        return formatter.format(Date(milliseconds))
    }

}

class EarthquakeViewHolder(view: View) : RecyclerView.ViewHolder(view)



