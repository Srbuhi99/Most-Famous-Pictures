package com.app.mostfamouspictures.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.app.mostfamouspictures.R
import com.app.mostfamouspictures.databinding.ArtistsListItemBinding
import com.app.mostfamouspictures.model.Artist
import com.app.mostfamouspictures.utils.ItemClickListener

class ArtistListAdapter(val context: Context, private var artistList:ArrayList<Artist>)
    :RecyclerView.Adapter<ArtistListAdapter.ViewHolder>(),ItemClickListener{

    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(context)
        var binding = ArtistsListItemBinding.inflate(inflater,parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(artistList[position])
        holder.binding.listener = this
    }

    override fun getItemCount(): Int {
       return artistList.size
    }

    inner class ViewHolder( var binding:ArtistsListItemBinding):RecyclerView.ViewHolder(binding.root){
        private var artistModel: Artist? = null

        fun bind( artist: Artist){
            artistModel = artist
            setUpItem()
        }

        fun setUpItem(){
            binding.model = artistModel
        }
    }

    override fun itemClickListener(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_detailArtistFragment)
    }

}