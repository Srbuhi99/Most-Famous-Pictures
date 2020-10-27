package com.app.mostfamouspictures.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.app.mostfamouspictures.view.fragment.ArtistsListFragment
import com.app.mostfamouspictures.view.fragment.PicturesListFragment

class MainViewPagerAdapter( fragmentManager: FragmentManager):FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var picturesListFragment = PicturesListFragment()
    var artistsListFragment = ArtistsListFragment()

    override fun getCount(): Int {
       return 2
    }

    override fun getItem(position: Int): Fragment {
       when(position){
           0 -> return picturesListFragment
           1 -> return artistsListFragment
       }
        return picturesListFragment
    }
}