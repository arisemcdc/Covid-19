package com.example.covid_19.Adapters

import android.net.sip.SipSession
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19.R
import com.example.covid_19.data.Country
import kotlinx.android.synthetic.main.item_list_covid_country.view.*

class CountriesListAdapter(val countries: List<Country>, val listener: Listener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface Listener {
        fun onClickCountry(country: Country)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        /*return MissionHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.mission_item, parent, false)
        )*/
        val viewHolder = CountryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_covid_country, parent, false)
        )
        viewHolder.itemView.setOnClickListener {
            if (viewHolder.country != null)
               listener.onClickCountry(viewHolder.country!!)
        }
        return viewHolder
    }

    override  fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CountryViewHolder)
            holder.country= countries?.get(position)
    }
}
class CountryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var country: Country? = null
        set(value) {
            field = value
            itemView.countryNameTextView.text = value?.name
            itemView.illsScoreTextView.text = value?.cases.toString()
        }
}