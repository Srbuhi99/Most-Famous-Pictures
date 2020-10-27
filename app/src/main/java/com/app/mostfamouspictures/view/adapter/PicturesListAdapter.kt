package com.app.mostfamouspictures.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.mostfamouspictures.databinding.PicturesListItemBinding
import com.app.mostfamouspictures.model.Picture

class PicturesListAdapter(val context: Context,private var picturesList:ArrayList<Picture>)
    :RecyclerView.Adapter<PicturesListAdapter.ViewHolder>() {

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


    inner class ViewHolder(private var binding:PicturesListItemBinding):RecyclerView.ViewHolder(binding.root) {

        private var pictureModel: Picture? = null

        fun bind( picture: Picture){
            pictureModel = picture
            setUpItem()
        }

        fun setUpItem(){
            binding.model = pictureModel
        }


    }

}

