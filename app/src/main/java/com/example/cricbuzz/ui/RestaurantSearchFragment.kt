package com.example.cricbuzz.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cricbuzz.adapter.RestaurantlistAdapter
import com.example.cricbuzz.databinding.FragmentRestaurantSearchBinding
import com.example.cricbuzz.utils.DataState
import com.example.cricbuzz.viewmodels.ActivityViewModel
import com.example.localdatabase.models.Restaurant

class RestaurantSearchFragment : Fragment()  {
    val activityViewModel: ActivityViewModel by activityViewModels()
    var restaurantlistAdapter: RestaurantlistAdapter? = null
    lateinit var fragmentRestaurantSearchBinding: FragmentRestaurantSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentRestaurantSearchBinding=FragmentRestaurantSearchBinding.inflate(inflater,container,false)
        return fragmentRestaurantSearchBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityViewModel.listOfRestaurantLiveData.value=DataState.Loading
        observeRestaurantData()
        activityViewModel.getRestaurantList()
        fragmentRestaurantSearchBinding.searchview.setQueryHint("Search Restaurant")
        fragmentRestaurantSearchBinding.searchview.setIconified(false)
        fragmentRestaurantSearchBinding.searchview.clearFocus()
        fragmentRestaurantSearchBinding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                if(newText.length>=3) {
                    activityViewModel.moreThanThreeLetterTyped=true
                    activityViewModel.filterResult(newText)
                }
                else if(activityViewModel.moreThanThreeLetterTyped || newText.isEmpty()) {
                    activityViewModel.moreThanThreeLetterTyped=false
                    activityViewModel.filterResult("")
                }
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })
    }
    fun observeRestaurantData()
    {
        activityViewModel.listOfRestaurantLiveData.observe(viewLifecycleOwner, Observer {dataState ->
            when (dataState) {
                is DataState.Success<ArrayList<Restaurant>> -> {
                    fragmentRestaurantSearchBinding.progressbar.visibility = View.GONE
                    fragmentRestaurantSearchBinding.tvEmptymsg.visibility = View.GONE
                    fragmentRestaurantSearchBinding.recyclerview.visibility=View.VISIBLE
                    setAdapter(dataState.data)
                }
                is DataState.Error -> {
                    fragmentRestaurantSearchBinding.progressbar.visibility = View.GONE
                    fragmentRestaurantSearchBinding.tvEmptymsg.visibility = View.VISIBLE
                    fragmentRestaurantSearchBinding.recyclerview.visibility=View.GONE
                }
                is DataState.Loading -> {
                    if (!fragmentRestaurantSearchBinding.progressbar.isVisible)
                        fragmentRestaurantSearchBinding.progressbar.visibility = View.VISIBLE
                    fragmentRestaurantSearchBinding.tvEmptymsg.visibility = View.GONE
                }
            }
        })

    }

    fun setAdapter(listOfAllItem: List<Restaurant>) {
        activityViewModel.listOfRestaurantFilter.clear()
        activityViewModel.listOfRestaurantFilter.addAll(listOfAllItem)
       if (restaurantlistAdapter == null) {
            val linearLayoutManager = LinearLayoutManager(requireActivity())
            fragmentRestaurantSearchBinding.recyclerview.setLayoutManager(linearLayoutManager)
            restaurantlistAdapter = RestaurantlistAdapter(
                requireActivity(),
                activityViewModel.listOfRestaurantFilter
            )
            fragmentRestaurantSearchBinding.recyclerview.adapter = restaurantlistAdapter
        }
        else {
            fragmentRestaurantSearchBinding.recyclerview.adapter?.notifyDataSetChanged()
        }
    }
    }