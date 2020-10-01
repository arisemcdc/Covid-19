package com.example.covid_19.ui.detailcountryfragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.covid_19.R
import com.example.covid_19.data.DataResult
import com.example.covid_19.ui.home.HomeViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.detail_country_fragment.*
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
        viewModel.setCountryId(args.countryId)


        root=inflater.inflate(R.layout.detail_country_fragment, container, false)
        //root.nav_view.visibility = View.GONE
        viewModel.country.observe(viewLifecycleOwner, Observer{country ->
            if (country != null){
                root.countryNameValue.setText(country.name)
                root.casesTextViewValue.setText(country.cases.toString())
                root.todayCasesTextViewValue.setText(country.todayCases.toString())
                root.deathsTextViewValue.setText(country.deaths.toString())
                root.todayDeathTextViewValue.setText(country.deaths.toString())
                root.recoveredTextViewValue.setText(country.recovered.toString())
                root.todayRecoveredTextViewValue.setText(country.recovered.toString())
                root.testsTextViewValue.setText(country.tests.toString())
                root.populationTextViewValue.setText(country.population.toString())
                root.containerDetailContry.visibility = View.VISIBLE
                Picasso.with(context)
                    .load(country.info.flag)
                    .placeholder(R.drawable.ic_dashboard_black_24dp)
                    .error(R.drawable.ic_home_black_24dp)
                    .into(flagImageView, object: com.squareup.picasso.Callback{
                        override fun onSuccess() {

                        }

                        override fun onError() {
                            //Toast.makeText(this , "Could not download image", Toast.LENGTH_SHORT).show()
                        }
                    })
                root.errorTextView.visibility = View.GONE
               /* if (viewModel.country is DataResult.Success<> {
                    Toast.makeText(context, "Данные получены из кэша", Toast.LENGTH_SHORT).show()
                }**/
            } else{
                root.errorTextView.visibility = View.VISIBLE
                root.containerDetailContry.visibility = View.GONE
            }
        })


        return root
    }

   /* override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailCountryViewModel::class.java)
        // TODO: Use the ViewModel
    }*/


}