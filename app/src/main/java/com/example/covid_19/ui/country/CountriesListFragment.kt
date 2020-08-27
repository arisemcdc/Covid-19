package com.example.covid_19.ui.country

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid_19.Adapters.CountriesListAdapter
import com.example.covid_19.R
import com.example.covid_19.data.ApiServiceCountries
import com.example.covid_19.data.CountriesApi
import com.example.covid_19.data.Country
import com.example.covid_19.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_country.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback

class CountriesListFragment : Fragment(), CountriesListAdapter.Listener {

    //private lateinit var dashboardViewModel: DashboardViewModel
    lateinit var countriesListAdapter: CountriesListAdapter
    lateinit var countries: List<Country>
    val viewModel : CountryListFragmentViewModel by viewModels()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
       // dashboardViewModel =
                //ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_country, container, false)
        /*root.countryCovidListRecyclerView.layoutManager = LinearLayoutManager(context)
        countriesListAdapter = CountriesListAdapter(countries)
        root.countryCovidListRecyclerView.adapter = countriesListAdapter*/
        getCountriesScores()
        return root
    }

    fun showData(countries: List<Country>) {
       countryCovidListRecyclerView.layoutManager = LinearLayoutManager(context)
       countriesListAdapter = CountriesListAdapter(countries, this)
       countryCovidListRecyclerView.adapter = countriesListAdapter
   }
    fun getCountriesScores() {
        CountriesApi.retrofitService.fetchAllCountries().enqueue(
            object:retrofit2.Callback<List<Country>> {
                override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<List<Country>>,
                    response: Response<List<Country>>
                ) {
                    showData(response.body()!!)
                }

            }
        )
    }

    override fun onClickCountry(country: Country) {
       /* val bundle = Bundle()
        bundle.putString("countryId", null)*/
        val action = CountriesListFragmentDirections.actionNavigationCountryToDetailCountryFragment()
        //findNavController().navigate(R.id.action_navigation_country_to_detailCountryFragment, bundle)
        //val action = CountriesListFragmentDirections
        findNavController().navigate(action)
    }
}
