package com.example.appup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appup.Adapter.CountriesAdapter
import com.example.appup.Api.CountryService
import com.example.appup.Api.ServiceBuilder
import com.example.appup.Models.MyCountry
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)
        val backGoToMain = findViewById<ImageView>(R.id.back_go_main)
        backGoToMain.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        onSearchButtonClick()
        loadCountries()
    }
    fun onSearchButtonClick() {
        val search_action = findViewById<EditText>(R.id.action_search)
        val countryName = search_action.text.toString()
        searchCountryByName(countryName)
    }
    private fun loadCountries() {
        val destinationService  = ServiceBuilder.buildService(CountryService::class.java)
        val requestCall =destinationService.getAllCountryList()
        val country_recycler = findViewById<RecyclerView>(R.id.country_recycler)
        requestCall.enqueue(object : Callback<List<MyCountry>> {
            override fun onResponse(call: Call<List<MyCountry>>, response: Response<List<MyCountry>>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val countryList  = response.body()!!
                    Log.d("Response", "countrylist size : ${countryList.size}")
                    country_recycler.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@CountryActivity,1)
                        adapter = CountriesAdapter(response.body()!!)
                    }
                }else{
                    Toast.makeText(this@CountryActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<MyCountry>>, t: Throwable) {
                Toast.makeText(this@CountryActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun searchCountryByName(name: String) {
        val destinationService  = ServiceBuilder.buildService(CountryService::class.java)
        val call = destinationService.getAllCountryUpdateList(name)
        val country_recycler = findViewById<RecyclerView>(R.id.country_recycler)
        call.enqueue(object : Callback<List<MyCountry>> {
            override fun onResponse(call: Call<List<MyCountry>>, response: Response<List<MyCountry>>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val countryList  = response.body()!!
                    Log.d("Response", "countrylist size : ${countryList.size}")
                    val countryAdapter = CountriesAdapter(emptyList())
                    countryAdapter.setData(countryList) // Установка нового набора данных в адаптере
                    countryAdapter.notifyDataSetChanged()
                    country_recycler.adapter = countryAdapter
                }else{
                    Log.d("UnResponse", "Failed")
                }
            }

            override fun onFailure(call: Call<List<MyCountry>>, t: Throwable) {
                Log.d("UnResponse", "Failed")
            }
        })
    }

}