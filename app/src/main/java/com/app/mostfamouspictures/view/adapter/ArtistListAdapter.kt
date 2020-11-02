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
import com.app.mostfamouspictures.databinding.ArtistsListItemBinding
import com.app.mostfamouspictures.model.Artist
import com.app.mostfamouspictures.utils.ItemClickListener
import kotlinx.android.synthetic.main.artists_list_item.view.*
import kotlinx.android.synthetic.main.pictures_list_item.view.*

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

        holder.choosingRam(position,context)

    }

    override fun getItemCount(): Int {
       return artistList.size
    }

    inner class ViewHolder( var binding:ArtistsListItemBinding):RecyclerView.ViewHolder(binding.root){
        private var artistModel: Artist? = null
        var i = 0
        fun bind( artist: Artist){
            artistModel = artist
            setUpItem()
        }

        fun setUpItem(){
            binding.model = artistModel
        }

        fun choosingRam(position: Int, context: Context){

            if(i < 1) {
                if (position % 2 == 0) {
                    binding.firstRam.visibility = View.VISIBLE
                }
                if (position % 2 != 0) {
                    binding.secondRam.visibility = View.VISIBLE
                }
                i++
            }
        }
    }

    override fun itemClickListener(view: View) {
        var bundle = Bundle()
        var artistId = view.artist_id.text.toString()
        bundle.putString("artistId", artistId)
        Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_detailArtistFragment,bundle)
    }



}