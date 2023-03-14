package com.yorpe.MarvelWorldAssemble.ui.main.comics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yorpe.MarvelWorldAssemble.R
import com.yorpe.MarvelWorldAssemble.data.model.comics.ResultComRes
import com.yorpe.MarvelWorldAssemble.databinding.ItemComicsBinding

class ComicsAdapter(
    private val comicsList: MutableList<ResultComRes> = mutableListOf(),
    private val clickListener: (ResultComRes) -> Unit
) : RecyclerView.Adapter<ComicsAdapter.ViewHolder>(){

    fun updateComicsAdapter(newComic: List<ResultComRes>){
        comicsList.clear()
        comicsList.addAll(newComic)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val items: ItemComicsBinding) :
        RecyclerView.ViewHolder(items.root) {

        fun fillInfo(comicsResponse: ResultComRes) {
            items.comicName.text = comicsResponse.title

            val charImg = comicsResponse.thumbnail?.path +"."+comicsResponse.thumbnail?.extension
            with(itemView) {
                Glide.with(context)
                    .load(charImg)
                    .placeholder(R.drawable.animate_loading)
                    .centerCrop()
                    .override(600,500)
                    .into(items.comicThumbnail)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemComicsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = comicsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fillInfo(comicsList[position])
    }
}