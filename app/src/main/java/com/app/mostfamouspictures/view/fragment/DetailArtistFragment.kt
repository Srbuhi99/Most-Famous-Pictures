package com.app.mostfamouspictures.view.fragment

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.mostfamouspictures.R
import com.app.mostfamouspictures.databinding.FragmentDetailArtistBinding
import com.app.mostfamouspictures.utils.ShareLogicUtil
import com.app.mostfamouspictures.viewmodel.DetailArtistViewModel
import com.app.mostfamouspictures.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.content_scrolling.view.*
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream


class DetailArtistFragment : Fragment() {

      lateinit var databinding : FragmentDetailArtistBinding
      lateinit var detailArtistViewModel: DetailArtistViewModel

      var  artistId = ""
      var  body = ""
      var  url =""

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
        addListenerToAristShareBtn()
    }

    fun setUpViewModel(){
        detailArtistViewModel =
            ViewModelProvider(this, ViewModelFactory())
                .get(DetailArtistViewModel::class.java)
                 detailArtistViewModel.fetch(artistId)
    }

    fun observLiveData(){
        detailArtistViewModel.artist.observe(viewLifecycleOwner, Observer {

            // init include view variables
            Glide.with(requireActivity())
                    .load(it.url)
                    .into(databinding.detailArtistImv)

            databinding.inqludeView.biograppi.text = it.biography
            databinding.inqludeView.education_info.text = it.education
            databinding.inqludeView.personal_info.text = it.personalLife
            databinding.inqludeView.art_info.text = it.art

            //init share data
            body = it.biography
            url = it.url

            //init model variable
            databinding.model = it
        })
    }

    fun addListenerToAristShareBtn(){
        databinding.artistShareBtn.setOnClickListener {
             shareIntent()
        }
    }

    fun shareIntent(){
        val intent = Intent(Intent.ACTION_SEND)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtra(Intent.EXTRA_TEXT, body)
        intent.putExtra(Intent.EXTRA_STREAM, ShareLogicUtil(requireContext(),
                        databinding.detailArtistImv,requireActivity()).shareContent())
        intent.type = "image/png"
        startActivity(Intent.createChooser(intent, "Share image via"))
    }


}