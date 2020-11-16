package com.app.mostfamouspictures.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.mostfamouspictures.R
import com.app.mostfamouspictures.model.Picture
import com.app.mostfamouspictures.view.adapter.PicturesListAdapter
import com.app.mostfamouspictures.viewmodel.PicturesListViewModel
import com.app.mostfamouspictures.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_pictures_list.*


class PicturesListFragment : Fragment() {

    lateinit var picturesListViewModel: PicturesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pictures_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        observLiveData()
    }

    private fun setupViewModel() {
        picturesListViewModel= ViewModelProvider(
            this,
            ViewModelFactory()
        ).get(PicturesListViewModel::class.java)
    }

    fun observLiveData(){
       picturesListViewModel.getpicturesList().observe(viewLifecycleOwner, Observer {
           addDataToAdapter(it)
       })
    }

    fun addDataToAdapter(data:ArrayList<Picture>){

        StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        ).apply {
            pictures_recview.layoutManager = this
        }

        pictures_recview.adapter = PicturesListAdapter(requireContext(),data)

    }

}