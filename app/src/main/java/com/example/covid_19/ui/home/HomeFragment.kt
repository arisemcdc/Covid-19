package com.example.covid_19.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.covid_19.R
import com.example.covid_19.data.Response.TotalScoresResponse
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


/*import com.example.covid_19.databinding.HomeBinding*/

class HomeFragment : Fragment() {
    lateinit var root: View
    //private lateinit var homeViewModel: HomeViewModel
    val viewModel : HomeViewModel by viewModels()
    //var binding:FragmentHomeBinding? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        /*homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)*/
        root = inflater.inflate(R.layout.fragment_home, container, false)
       root.totalDeathsScore.setText(viewModel.responseTotalCases.value?.deaths.toString())
       root.totalConfirmedScore.setText(viewModel.responseTotalCases.value?.cases.toString())
        root.totalRecoveredScore.setText(viewModel.responseTotalCases.value?.recovered.toString())
       /* root.totalDeathsScore.setText("привет")
        root.totalConfirmedScore.setText("привет")
        root.totalRecoveredScore.setText("привет")*/
       /* totalConfirmedScore.text = viewModel.responseTotalCases.toString()
        totalDeathsScore.text = viewModel.responseTotalDeaths.toString()
        totalRecoveredScore.text = viewModel.responseTotalRecovered.toString()*/
        /*viewModel.responseTotalCases.observe(viewLifecycleOwner, Observer {
            totalConfirmedScore.text = it.toString()
            totalDeathsScore.text = it.toString()
            totalRecoveredScore.text = it.toString()
        })*/






     /*   viewModel.responseTotalCases.value?.deaths.observe(viewLifecycleOwner, Observer {
            totalDeathsScore.text = it.toString()
        })
        viewModel.responseTotalRecovered.observe(viewLifecycleOwner, Observer {
            totalRecoveredScore.text = it.toString()
        })*/
        return root
    }

}