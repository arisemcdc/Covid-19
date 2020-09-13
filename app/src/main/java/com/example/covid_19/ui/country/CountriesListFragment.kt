package com.example.covid_19.ui.country

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid_19.Adapters.CountriesListAdapter
import com.example.covid_19.R
/*import com.example.covid_19.data.ApiServiceCountries
import com.example.covid_19.data.CountriesApi*/
import com.example.covid_19.data.Country
import com.example.covid_19.data.Covid19Api
import com.example.covid_19.data.DataResult
import com.example.covid_19.databinding.FragmentCountryBinding
import com.example.covid_19.databinding.FragmentHomeBinding
import com.example.covid_19.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_country.*
import kotlinx.android.synthetic.main.fragment_country.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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
    private var _binding: FragmentCountryBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
       // dashboardViewModel =
                //ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        _binding = FragmentCountryBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        val view = binding.root
        binding.root.countryCovidListRecyclerView.layoutManager = LinearLayoutManager(context)
       /* countriesListAdapter = CountriesListAdapter(countries)
        root.countryCovidListRecyclerView.adapter = countriesListAdapter*/
       viewModel.countries.observe(viewLifecycleOwner, Observer {result ->
           if (result is DataResult.Success) {
                countriesListAdapter = CountriesListAdapter(result.data, this)
                countryCovidListRecyclerView.adapter = countriesListAdapter
                countryCovidListRecyclerView.visibility=View.VISIBLE
                errorTextView.visibility = View.GONE
            }
           else {
               countryCovidListRecyclerView.visibility=View.GONE
               errorTextView.visibility = View.VISIBLE
               errorTextView.text = "Error!"
           }

       })
        return view
    }

   /* fun showData(countries: List<Country>) {
       countryCovidListRecyclerView.layoutManager = LinearLayoutManager(context)
       countriesListAdapter = CountriesListAdapter(countries, this)
       countryCovidListRecyclerView.adapter = countriesListAdapter
   }*/
    /*fun getCountriesScores() {
        GlobalScope.launch {

                val data = Covid19Api.retrofitService.fetchAllCountries()


        }
       *//*val call = CountriesApi.retrofitService.fetchAllCountries()
           call.enqueue(
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
        )*//*
    }*/
   override fun onDestroyView() {
       super.onDestroyView()
       _binding = null
   }

    override fun onClickCountry(country: Country) {
       val action = CountriesListFragmentDirections.actionNavigationCountryToDetailCountryFragment(country.id)
        findNavController().navigate(action)
    }
}



