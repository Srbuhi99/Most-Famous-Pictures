package com.app.mostfamouspictures.view.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.app.mostfamouspictures.R
import com.app.mostfamouspictures.databinding.PicturesListItemBinding
import com.app.mostfamouspictures.model.Picture
import com.app.mostfamouspictures.utils.ItemClickListener
import kotlinx.android.synthetic.main.pictures_list_item.view.*

class PicturesListAdapter(val context: Context,private var picturesList:ArrayList<Picture>)
    :RecyclerView.Adapter<PicturesListAdapter.ViewHolder>(),ItemClickListener {

    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var inflater = LayoutInflater.from(context)
        var binding = PicturesListItemBinding.inflate(inflater,parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     holder.bind(picturesList[position])
     holder.binding.listener = this
    }

    override fun getItemCount(): Int {
       return  picturesList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }



    inner class ViewHolder( var binding:PicturesListItemBinding):RecyclerView.ViewHolder(binding.root) {

        private var pictureModel: Picture? = null

        fun bind( picture: Picture){
            pictureModel = picture
            setUpItem()
        }

        fun setUpItem(){
            binding.model = pictureModel
        }

    }

    override fun itemClickListener(view: View) {
      var bundle = Bundle()
      var imageId = view.image_id.text.toString()
      bundle.putString("imageId",imageId)
      Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_detailPictureFragment,bundle)
    }

}

