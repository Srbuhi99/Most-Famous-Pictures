package com.app.mostfamouspictures.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.mostfamouspictures.R
import com.app.mostfamouspictures.databinding.FragmentDetailArtistBinding
import com.app.mostfamouspictures.viewmodel.DetailArtistViewModel
import com.app.mostfamouspictures.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.content_scrolling.view.*


class DetailArtistFragment : Fragment() {

      lateinit var databinding : FragmentDetailArtistBinding
      lateinit var detailArtistViewModel: DetailArtistViewModel
      var artistId = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        databinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_artist, container, false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            artistId = it.getString("artistId")!!
        }


        setUpViewModel()
        observLiveData()

    }

    fun setUpViewModel(){
        detailArtistViewModel =
            ViewModelProvider(this,ViewModelFactory())
                .get(DetailArtistViewModel::class.java)
        detailArtistViewModel.fetch(artistId)
    }

    fun observLiveData(){
        detailArtistViewModel.artist.observe(viewLifecycleOwner, Observer {
            Glide.with(requireActivity()).load(it.url).into(databinding.detailArtistImv)
            databinding.inqludeView.biograppi.text = it.biography
            databinding.inqludeView.education_info.text = it.education
            databinding.inqludeView.personal_info.text = it.personalLife
            databinding.inqludeView.art_info.text = it.art
            databinding.model = it
        })
    }



}