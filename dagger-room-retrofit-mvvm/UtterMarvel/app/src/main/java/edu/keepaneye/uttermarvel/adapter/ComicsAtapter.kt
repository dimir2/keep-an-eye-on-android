package edu.keepaneye.uttermarvel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.keepaneye.uttermarvel.R
import edu.keepaneye.uttermarvel.model.ComicsItem
import kotlinx.android.synthetic.main.rv_comics_item.view.*

class ComicsAtapter : RecyclerView.Adapter<ComicsAtapter.ComicsViewHolder>() {
    inner class ComicsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<ComicsItem>() {
        override fun areItemsTheSame(oldItem: ComicsItem, newItem: ComicsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ComicsItem, newItem: ComicsItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        return ComicsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_comics_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        val comics = differ.currentList[position]
        holder.itemView.apply {
            Glide
                .with(this)
                .load("${comics.thumbnail.path}.${comics.thumbnail.extension}")
                .into(ivItemImage)
            tvItemTitle.text = comics.title
            setOnClickListener {
                onItemClickListener?.let { it(comics) }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((ComicsItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (ComicsItem) -> Unit) {
        onItemClickListener = listener
    }
}