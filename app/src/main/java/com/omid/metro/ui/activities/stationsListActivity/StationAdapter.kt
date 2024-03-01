package com.omid.metro.ui.activities.stationsListActivity

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omid.metro.R
import com.omid.metro.model.models.LinesItem
import com.omid.metro.model.models.StationsItem
import com.omid.metro.ui.activities.stationInfoActivity.StationInfoActivity
import com.omid.metro.utils.check.Check
import com.omid.metro.utils.configuration.AppConfiguration

class StationAdapter(private val stationList: List<StationsItem>, private val myLine : LinesItem): RecyclerView.Adapter<StationVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationVH {
     val view = LayoutInflater.from(AppConfiguration.getContext()).inflate(R.layout.stations_row,null)
        return StationVH(view)
    }

    override fun getItemCount(): Int {
        return stationList.size
    }

    override fun onBindViewHolder(holder: StationVH, position: Int) {
        val myStations = stationList[position]
        holder.namePersian.text = myStations.title
        holder.nameEnglish.text = myStations.titleEnglish
        holder.stationsLL.setBackgroundColor(Color.parseColor(myLine.color))

        Check.crossCheck(myStations,holder)

        holder.stationsLL.setOnClickListener {
            val intent = Intent(AppConfiguration.getContext(), StationInfoActivity::class.java)
            intent.putExtra("stationsItem",myStations)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            AppConfiguration.getContext().startActivity(intent)
        }
    }
}