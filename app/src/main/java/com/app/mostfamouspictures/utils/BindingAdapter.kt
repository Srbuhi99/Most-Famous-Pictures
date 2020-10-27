package com.app.mostfamouspictures.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingAdapter {

    companion object{

        @JvmStatic
        @BindingAdapter("app:url")
        fun loadImage(view: ImageView, url:String){
          Glide.with(view.context)
              .load(url)
              .into(view)
        }
    }
}