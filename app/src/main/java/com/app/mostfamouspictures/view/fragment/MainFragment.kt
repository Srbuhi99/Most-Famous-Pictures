package com.app.mostfamouspictures.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.mostfamouspictures.R
import com.app.mostfamouspictures.view.adapter.MainViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
        setupTabLayout()
    }

    private fun setupViewPager() {

        val adapter = MainViewPagerAdapter(
            childFragmentManager
        )
        main_view_pager.adapter = adapter

    }

    private fun setupTabLayout(){

        main_tab_layout.tabGravity = TabLayout.GRAVITY_FILL

        main_view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(main_tab_layout))

        main_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onTabSelected(tab: TabLayout.Tab) {

                main_view_pager.currentItem = tab.position

                when(tab.position){

                    //change tabs color when swiching
                    0 -> main_tab_layout.background = context!!.resources.getDrawable(R.drawable.ic_head_art)
                    1 -> main_tab_layout.background = context!!.resources.getDrawable(R.drawable.ic_head_artist)

                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }


}