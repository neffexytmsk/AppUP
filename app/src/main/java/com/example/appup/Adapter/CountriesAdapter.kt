package com.example.appup.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appup.Models.MyCountry
import com.example.appup.R
import com.squareup.picasso.Picasso

class CountriesAdapter(private var countriesList: List<MyCountry>) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {
    fun setData(newCountries: List<MyCountry>) {
        countriesList = newCountries
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return countriesList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${countriesList.size} ")


        return holder.bind(countriesList[position])

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var imageView = itemView.findViewById<ImageView>(R.id.ic_logo_flag)
        var tvTitle = itemView.findViewById<TextView>(R.id.name_country)
        var tvPopulation = itemView.findViewById<TextView>(R.id.country_population)
        fun bind(country: MyCountry) {

            val name = "Население :${country.population.toString()}\n" + "Регион: ${country.region.toString()}\n" +
                        "Часовой пояс: ${country.timezones.toString()}\n"
            tvTitle.text = country.name
            tvPopulation.text = name
            Picasso.get().load(country.flags.png).into(imageView)
        }

    }
}