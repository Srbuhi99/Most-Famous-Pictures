package com.app.mostfamouspictures.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.mostfamouspictures.R
import com.app.mostfamouspictures.viewmodel.ArtistsListViewModel
import com.app.mostfamouspictures.viewmodel.ViewModelFactory


class ArtistsListFragment : Fragment() {

    lateinit var artistsListViewModel: ArtistsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artists_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        observLiveData()
    }

    private fun setupViewModel() {
       artistsListViewModel = ViewModelProvider(
            this,
            ViewModelFactory()
        ).get(ArtistsListViewModel::class.java)
    }

    fun observLiveData(){
        artistsListViewModel.getartistsList().observe(viewLifecycleOwner, Observer {

        })
    }



}