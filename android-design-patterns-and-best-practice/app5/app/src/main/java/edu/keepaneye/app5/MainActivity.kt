package edu.keepaneye.app5

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate

data class Filling(val image: Int, val name: Int)

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var dataAdapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fillings: Array<Filling> = arrayOf(
            Filling(R.drawable.cheese, R.string.cheese),
            Filling(R.drawable.ham, R.string.ham),
            Filling(R.drawable.tomato, R.string.tomato)
        )

        dataAdapter = DataAdapter()
        dataAdapter.fillings = fillings

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = dataAdapter
    }
}

class DataAdapter : RecyclerView.Adapter<ViewHolder>() {

    lateinit var fillings:Array<Filling>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context: Context = parent.context
        val inflater: LayoutInflater = LayoutInflater.from(context)

        val v: View = inflater.inflate(R.layout.item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filling = fillings[position]
        val imageView: AppCompatImageView = holder.imageView
        imageView.setImageResource(filling.image)
        val textView: AppCompatTextView = holder.textView
        textView.setText(filling.name)
    }

    override fun getItemCount(): Int {
        return fillings.size
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: AppCompatImageView = itemView.findViewById(R.id.item_image)
    var textView: AppCompatTextView = itemView.findViewById(R.id.item_text)
}