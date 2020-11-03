package com.app.mostfamouspictures.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.mostfamouspictures.R
import com.app.mostfamouspictures.databinding.FragmentDetailPictureBinding
import com.app.mostfamouspictures.utils.ShareLogicUtil
import com.app.mostfamouspictures.viewmodel.DetailPictureViewModel
import com.app.mostfamouspictures.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


class DetailPictureFragment : Fragment() {

    var imageId = ""
    private lateinit var dataBinding : FragmentDetailPictureBinding
    lateinit var detailPictureViewModel: DetailPictureViewModel
    var text = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_picture, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.let {
             imageId = it.getString("imageId")!!
        }


        setupViewModel()
        observLiveData()
        addListenerToShareBtn()
    }


    private fun setupViewModel() {
       detailPictureViewModel = ViewModelProvider(
            this,
            ViewModelFactory()
        ).get(DetailPictureViewModel::class.java)
        detailPictureViewModel.fetch(imageId)
    }

    fun observLiveData(){
        detailPictureViewModel.picture.observe(viewLifecycleOwner, Observer {

            Glide.with(requireActivity()).load(it.imageUrl)
                .into(dataBinding.detailPictureImv)
            text = it.description

        })
    }

    fun addListenerToShareBtn(){
        dataBinding.pictureShareBtn.setOnClickListener {
            shareIntent()
        }
    }

    fun shareIntent(){
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        shareIntent.putExtra(Intent.EXTRA_TEXT, text)
        shareIntent.putExtra(Intent.EXTRA_STREAM, ShareLogicUtil(requireContext(),dataBinding.detailPictureImv,requireActivity()).shareContent())
        shareIntent.type = "image/png"
        startActivity(Intent.createChooser(shareIntent, "Share image via"))
    }


}