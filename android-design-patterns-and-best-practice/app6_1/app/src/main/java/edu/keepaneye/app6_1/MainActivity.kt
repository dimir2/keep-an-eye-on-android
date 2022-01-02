package edu.keepaneye.app6_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.keepaneye.app6_1.fillings.buildCheeseList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val adapter: DataAdapter = DataAdapter(buildCheeseList())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(ItemDivider(this, R.drawable.item_divider))
//        recyclerView.layoutManager =
//            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
//        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
    }
}