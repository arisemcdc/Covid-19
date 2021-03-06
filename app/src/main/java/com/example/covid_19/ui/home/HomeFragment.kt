package com.example.covid_19.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.covid_19.R
import com.example.covid_19.data.DataResult
import com.example.covid_19.databinding.FragmentHomeBinding
import com.example.covid_19.ui.EventObserver
import com.example.covid_19.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*


/*import com.example.covid_19.databinding.HomeBinding*/

class HomeFragment : Fragment() {
    val viewModel : HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        val view = binding.root
        binding.lifecycleOwner = this
        /*viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it)
                view.progressBar.visibility = View.VISIBLE
            else
                view.progressBar.visibility = View.GONE
        })*/

        /*if (viewModel.totalScores is DataResult.Success(viewModel.totalScores.isFromCache)) {

                Toast.makeText(context, "Данные получены из кэша", Toast.LENGTH_SHORT).show()
        }*/
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showToastLiveData.observe(viewLifecycleOwner, EventObserver{text->
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}