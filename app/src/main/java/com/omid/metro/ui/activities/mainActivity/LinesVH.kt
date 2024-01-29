package com.omid.metro.ui.activities.mainActivity

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.omid.metro.R

class LinesVH(itemView: View) : RecyclerView.ViewHolder(itemView){
    val selectLine = itemView.findViewById<ConstraintLayout>(R.id.select_line)!!
    val titlePersian = itemView.findViewById<AppCompatTextView>(R.id.title_persian)!!
    val titleEnglish = itemView.findViewById<AppCompatTextView>(R.id.title_english)!!
}