package com.app.mostfamouspictures.utils

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import android.view.View
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

class ShareLogicUtil(var context : Context, var view: View, var activity: Activity) {

    lateinit var bmpUri:Uri

    fun shareContent() : Uri {
        val bitmap = getBitmapFromView(view)

        try {
            val file: File = File(context?.getExternalCacheDir(), "image.png")
            val fOut = FileOutputStream(file)
            bitmap!!.compress(Bitmap.CompressFormat.PNG, 100, fOut)
            fOut.flush()
            fOut.close()
            file.setReadable(true, false)
            bmpUri =  FileProvider.getUriForFile(context,
                    activity.getApplicationContext().getPackageName() + ".provider", file)

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return bmpUri
    }

    private fun getBitmapFromView(view: View): Bitmap? {
        val returnedBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnedBitmap)
        val bgDrawable = view.background
        if (bgDrawable != null) {
            bgDrawable.draw(canvas)
        } else {
            canvas.drawColor(Color.WHITE)
        }
        view.draw(canvas)
        return returnedBitmap
    }

}