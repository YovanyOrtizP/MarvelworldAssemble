package com.yorpe.MarvelWorldAssemble.ui.main.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yorpe.MarvelWorldAssemble.R
import com.yorpe.MarvelWorldAssemble.data.model.characters.ResultCResp
import com.yorpe.MarvelWorldAssemble.databinding.ItemCharactersBinding


class CharactersAdapter(
    private val marvelList: MutableList<ResultCResp> = mutableListOf(),
    private val clickListener: (ResultCResp) -> Unit
) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    fun updateCharactersAdapter(newCharacter: List<ResultCResp>){
        marvelList.clear()
        marvelList.addAll(newCharacter)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val items: ItemCharactersBinding) :
        RecyclerView.ViewHolder(items.root) {
        fun fillInfo(charactersResponse: ResultCResp) {
            val charImg = charactersResponse.thumbnail?.path +"."+charactersResponse.thumbnail?.extension
            with(itemView) {
                Glide.with(context)
                    .load(charImg)
                    .placeholder(R.drawable.animate_loading)
                    .centerCrop()
                    .override(600,500)
                    .into(items.characterThumbnail)
            }
            items.characterName.text = charactersResponse.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemCharactersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = marvelList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fillInfo(marvelList[position])
    }
}