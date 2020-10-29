package com.app.mostfamouspictures.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class BindingAdapter {

    companion object{

        @JvmStatic
        @BindingAdapter("app:url")
        fun loadImage(view: ImageView, url:String){
          Glide.with(view.context)
              .load(url)
              .into(view)
        }

        @JvmStatic
        @BindingAdapter("app:profileUrl")
        fun artistImage(view: ImageView, url:String){
            Glide.with(view.context)
                .load(url)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(90)))
                .into(view)
        }
    }
}