package com.example.covid_19.ui.detailcountryfragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.covid_19.R
import com.example.covid_19.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.detail_country_fragment.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class DetailCountryFragment : Fragment() {
    lateinit var root: View
    val viewModel : DetailCountryViewModel by viewModels()
    companion object {
        fun newInstance() =
            DetailCountryFragment()
    }

    //private lateinit var viewModel: DetailCountryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args: DetailCountryFragmentArgs by navArgs()
        args.countryId
        root=inflater.inflate(R.layout.detail_country_fragment, container, false)
        root.countryNameValue.setText(viewModel.responseDetailCountry.value?.country)
        root.casesTextViewValue.setText(viewModel.responseDetailCountry.value?.cases.toString())
        root.todayCasesTextViewValue.setText(viewModel.responseDetailCountry.value?.todayCases.toString())
        root.deathsTextViewValue.setText(viewModel.responseDetailCountry.value?.deaths.toString())
        root.todayDeathTextViewValue.setText(viewModel.responseDetailCountry.value?.deaths.toString())
        root.recoveredTextViewValue.setText(viewModel.responseDetailCountry.value?.recovered.toString())
        root.todayRecoveredTextViewValue.setText(viewModel.responseDetailCountry.value?.recovered.toString())
        root.testsTextViewValue.setText(viewModel.responseDetailCountry.value?.tests.toString())
        root.populationTextViewValue.setText(viewModel.responseDetailCountry.value?.population.toString())
        //return inflater.inflate(R.layout.detail_country_fragment, container, false)
        return root
    }

   /* override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailCountryViewModel::class.java)
        // TODO: Use the ViewModel
    }*/


}