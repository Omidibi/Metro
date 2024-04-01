package com.omid.metro.ui.fragments.stationsListFragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.omid.metro.R
import com.omid.metro.model.models.LinesItem
import com.omid.metro.model.models.StationsItem
import com.omid.metro.utils.check.Check
import com.omid.metro.utils.configuration.AppConfiguration

class StationAdapter(private val stationList: List<StationsItem>, private val myLine: LinesItem, private val fragment: Fragment) : RecyclerView.Adapter<StationVH>() {

    private val bundle = Bundle()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationVH {
        val view = LayoutInflater.from(AppConfiguration.getContext()).inflate(R.layout.stations_row, null)
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

        Check.crossCheck(myStations, holder)

        holder.stationsLL.setOnClickListener {
            bundle.putParcelable("stationsItem", myStations)
            fragment.findNavController().navigate(R.id.action_stationsListFragment_to_stationInfoFragment, bundle)
        }
    }
}