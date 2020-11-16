package com.app.mostfamouspictures.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.mostfamouspictures.R
import com.app.mostfamouspictures.databinding.FragmentDetailPictureBinding
import com.app.mostfamouspictures.utils.ShareLogicUtil
import com.app.mostfamouspictures.viewmodel.DetailPictureViewModel
import com.app.mostfamouspictures.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.content_scroll_picture.view.*


class DetailPictureFragment : Fragment() {

    private lateinit var dataBinding : FragmentDetailPictureBinding
    lateinit var detailPictureViewModel: DetailPictureViewModel

    var imageId = ""
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
       detailPictureViewModel = ViewModelProvider(this,
               ViewModelFactory()).get(DetailPictureViewModel::class.java)
                                       detailPictureViewModel.fetch(imageId)
    }

    fun observLiveData(){
        detailPictureViewModel.picture.observe(viewLifecycleOwner, Observer {

            //init include variables
            Glide.with(requireActivity())
                    .load(it.imageUrl)
                    .into(dataBinding.detailPictureImv)
            dataBinding.pictureDesScrollView.picture_description.text = it.description
            text = it.description

            //init model variable
            dataBinding.model = it

        })
    }

    fun addListenerToShareBtn(){
        dataBinding.pictureDesScrollView.picture_share_btn.setOnClickListener {
            shareIntent()
        }
    }

    fun shareIntent(){
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        shareIntent.putExtra(Intent.EXTRA_TEXT, text)
        shareIntent.putExtra(Intent.EXTRA_STREAM, ShareLogicUtil(requireContext(),
                             dataBinding.detailPictureImv, requireActivity()).shareContent())
        shareIntent.type = "image/jpg"
        startActivity(Intent.createChooser(shareIntent, "Share image via"))
    }


}