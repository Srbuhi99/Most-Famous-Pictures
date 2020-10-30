package com.app.mostfamouspictures.view.activity

import android.os.Bundle
import android.os.Process
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.app.mostfamouspictures.R

class MainActivity : AppCompatActivity() {

     lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init navController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController.navigate(R.id.mainFragment)
    }

}