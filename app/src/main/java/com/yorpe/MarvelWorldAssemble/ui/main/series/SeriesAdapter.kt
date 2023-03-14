package com.yorpe.MarvelWorldAssemble.ui.main.series

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yorpe.MarvelWorldAssemble.R
import com.yorpe.MarvelWorldAssemble.data.model.series.ResultSResp
import com.yorpe.MarvelWorldAssemble.databinding.ItemSeriesBinding

class SeriesAdapter(
    private val seriesList: MutableList<ResultSResp> = mutableListOf(),
    private val clickListener: (ResultSResp) -> Unit
): RecyclerView.Adapter<SeriesAdapter.ViewHolder>() {

    fun updateSeriesAdapter(newSerie: List<ResultSResp>){
        seriesList.clear()
        seriesList.addAll(newSerie)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val items: ItemSeriesBinding) :
        RecyclerView.ViewHolder(items.root) {
        fun fillInfo(seriesResponse: ResultSResp) {
            val charImg = seriesResponse.thumbnail?.path +"."+seriesResponse.thumbnail?.extension
            with(itemView) {
                Glide.with(context)
                    .load(charImg)
                    .placeholder(R.drawable.animate_loading)
                    .centerCrop()
                    .override(600,500)
                    .into(items.serieThumbnail)
            }
            items.serieName.text = seriesResponse.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemSeriesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = seriesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fillInfo(seriesList[position])
    }
}