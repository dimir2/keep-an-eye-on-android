package edu.keepaneye.uttermarvel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.keepaneye.uttermarvel.R
import edu.keepaneye.uttermarvel.model.CharacterItem
import kotlinx.android.synthetic.main.rv_character_item.view.*

class CharactersAtapter : RecyclerView.Adapter<CharactersAtapter.CharactersViewHolder>() {
    inner class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<CharacterItem>() {
        override fun areItemsTheSame(oldItem: CharacterItem, newItem: CharacterItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CharacterItem, newItem: CharacterItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_character_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val character = differ.currentList[position]
        holder.itemView.apply {
            Glide
                .with(this)
                .load("${character.thumbnail.path}.${character.thumbnail.extension}")
                .into(ivItemImage)
            tvItemName.text = character.name
            setOnClickListener {
                onItemClickListener?.let { it(character) }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((CharacterItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (CharacterItem) -> Unit) {
        onItemClickListener = listener
    }
}