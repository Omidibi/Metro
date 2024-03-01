package com.omid.metro.ui.activities.mainActivity

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omid.metro.R
import com.omid.metro.model.models.LinesItem
import com.omid.metro.ui.activities.stationsListActivity.StationsListActivity
import com.omid.metro.utils.colors.Colors
import com.omid.metro.utils.configuration.AppConfiguration

class LineAdapter(private val linesList: List<LinesItem>, private val activity: Activity) : RecyclerView.Adapter<LinesVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinesVH {
        val view = LayoutInflater.from(AppConfiguration.getContext()).inflate(R.layout.lines_row,null)
        return LinesVH(view)
    }

    override fun getItemCount(): Int {
        return linesList.size
    }

    override fun onBindViewHolder(holder: LinesVH, position: Int) {
        val myLines = linesList[position]
        holder.apply {
            titlePersian.text = myLines.title
            titleEnglish.text = myLines.titleEnglish

            Colors.lineCardColorSetter(holder, myLines)

            selectLine.setOnClickListener {
                // Dialogs.lineOneAlert(activity)
                //  Dialogs.lineFourAlert(activity)
                val intent = Intent(AppConfiguration.getContext(), StationsListActivity::class.java)
                intent.putExtra("myLines", myLines)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                AppConfiguration.getContext().startActivity(intent)
            }
        }
    }
}