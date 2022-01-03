package edu.keepaneye.app6_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import edu.keepaneye.app6_1.fillings.Cheese

class DataAdapter(private val cheeses: MutableList<Cheese>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(cheeses[position].image)
        holder.textView.text = cheeses[position].name
    }

    override fun getItemCount(): Int {
        return cheeses.size
    }

    fun removeItem(position :Int) {
        cheeses.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, cheeses.size)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: AppCompatImageView = itemView.findViewById(R.id.item_image)
        val textView: AppCompatTextView = itemView.findViewById(R.id.item_name)

    }
}

