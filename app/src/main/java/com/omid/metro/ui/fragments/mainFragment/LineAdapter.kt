package com.omid.metro.ui.fragments.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.omid.metro.R
import com.omid.metro.model.models.LinesItem
import com.omid.metro.utils.colors.Colors
import com.omid.metro.utils.configuration.AppConfiguration

class LineAdapter(private val linesList: List<LinesItem>, private val fragment: Fragment) : RecyclerView.Adapter<LinesVH>() {

    private val bundle = Bundle()

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
                bundle.putParcelable("myLines",myLines)
                fragment.findNavController().navigate(R.id.action_mainFragment_to_stationsListFragment,bundle)
            }
        }
    }
}