package com.omid.metro.ui.customViews

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.Toast
import com.omid.metro.databinding.SelectPathLine1Binding
import com.omid.metro.databinding.SelectPathLine4Binding

class Dialogs {

    companion object {

        fun lineOneAlert(activity: Activity) {
            val alert = AlertDialog.Builder(activity)
            val binding = SelectPathLine1Binding.inflate(LayoutInflater.from(activity))
            alert.setView(binding.root)

            binding.clTaToKah.setOnClickListener {
                Toast.makeText(activity, "tajrish to kahrizak OK", Toast.LENGTH_LONG).show()
            }
            binding.clTaToAftab.setOnClickListener {
                Toast.makeText(activity, "tajrish to aftab OK", Toast.LENGTH_LONG).show()
            }
            val typeface = Typeface.createFromAsset(activity.assets, "font/IRANSansMobile(FaNum).ttf")
            binding.txtTitleFa.typeface = typeface
            binding.txtTitleEn.typeface = typeface
            binding.txtNameFa1.typeface = typeface
            binding.txtNameFa2.typeface = typeface
            binding.txtNameEn1.typeface = typeface
            binding.txtNameEn2.typeface = typeface
            val dialog = alert.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }

        fun lineFourAlert(activity: Activity) {
            val alert = AlertDialog.Builder(activity)
            val binding = SelectPathLine4Binding.inflate(LayoutInflater.from(activity))
            alert.setView(binding.root)
            binding.clKoToEram.setOnClickListener {
                Toast.makeText(activity, "kolahdoz to erame sabz OK", Toast.LENGTH_LONG).show()
            }
            binding.clKoToMehrabad.setOnClickListener {
                Toast.makeText(activity, "kolahdoz to Mehrabad OK", Toast.LENGTH_LONG).show()
            }
            val typeface = Typeface.createFromAsset(activity.assets, "font/IRANSansMobile(FaNum).ttf")
            binding.txtTitleFa.typeface = typeface
            binding.txtTitleEn.typeface = typeface
            binding.txtNameFa1.typeface = typeface
            binding.txtNameFa2.typeface = typeface
            binding.txtNameEn1.typeface = typeface
            binding.txtNameEn2.typeface = typeface
            val dialog = alert.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }
    }
}