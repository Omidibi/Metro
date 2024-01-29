package com.omid.metro.ui.activities.stationsListActivity

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.omid.metro.R

class StationVH(itemView: View) : RecyclerView.ViewHolder(itemView){
    val stationsLL = itemView.findViewById<ConstraintLayout>(R.id.stations_cl)!!
    val namePersian = itemView.findViewById<AppCompatTextView>(R.id.name_persian)!!
    val nameEnglish = itemView.findViewById<AppCompatTextView>(R.id.name_english)!!
    val imgCross = itemView.findViewById<AppCompatImageView>(R.id.img_cross)!!
    val clCross = itemView.findViewById<ConstraintLayout>(R.id.cl_cross)!!

}