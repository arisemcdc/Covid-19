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
    val args: DetailCountryFragmentArgs by navArgs()
    //private lateinit var viewModel: DetailCountryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /*val tempCountry = */
        /*root=inflater.inflate(R.layout.detail_country_fragment, container, false)
        //root.countryNameValue.setText(viewModel.tempCountry.value?.country)
       // root.casesTextViewValue.setText(viewModel.tempCountry.value?.cases.toString())
        //root.todayCasesTextViewValue.setText(viewModel.tempCountry.value?.todayCases.toString())
        //root.deathsTextViewValue.setText(viewModel.tempCountry.value?.deaths.toString())
        root.todayDeathTextViewValue.setText(viewModel.tempCountry.value?.deaths.toString())
        root.recoveredTextViewValue.setText(viewModel.tempCountry.value?.recovered.toString())
        root.todayRecoveredTextViewValue.setText(viewModel.tempCountry.value?.recovered.toString())
        root.testsTextViewValue.setText(viewModel.tempCountry.value?.tests.toString())
        root.populationTextViewValue.setText(viewModel.tempCountry.value?.population.toString())*/

        return root
    }

   /* override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailCountryViewModel::class.java)
        // TODO: Use the ViewModel
    }*/


}