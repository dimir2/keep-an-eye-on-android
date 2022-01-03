package edu.keepaneye.app6_1

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.Callback
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback
import androidx.recyclerview.widget.ItemTouchHelper.LEFT
import androidx.recyclerview.widget.ItemTouchHelper.RIGHT
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.keepaneye.app6_1.fillings.Cheese
import edu.keepaneye.app6_1.fillings.buildCheeseList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = DataAdapter(buildCheeseList())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(ItemDivider(this, R.drawable.item_divider))
//        recyclerView.layoutManager =
//            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
//        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
//        recyclerView.setHasFixedSize(true)
        initItemTouchHelper(recyclerView, adapter)
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        buildDialog(fab)
    }

    private fun buildDialog(fab: FloatingActionButton) {
        fab.setOnClickListener {
            val inflater = this.layoutInflater
            val builder = AlertDialog.Builder(this)
            builder.setView(inflater.inflate(R.layout.checkout_layout, null))
                .setPositiveButton(R.string.action_ok_text) { _: DialogInterface, _: Int ->
                    val intent = Intent(this, CheckoutActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton(R.string.action_cancel_text) { _: DialogInterface, _: Int ->
                    //SYSTEM DISMISSES DIALOG
                }
            val dialog = builder.create()
            dialog.show()

            val cancelButton = dialog.getButton(DialogInterface.BUTTON_NEGATIVE)
            cancelButton.setTextColor(resources.getColor(R.color.colorAccent))
            val okButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE)
            okButton.setTextColor(resources.getColor(R.color.colorAccent))
        }
    }
    private fun initItemTouchHelper(recyclerView: RecyclerView, adapter: DataAdapter) {
        val callback: Callback = object:SimpleCallback(0, LEFT  or RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position: Int = viewHolder.adapterPosition
                adapter.removeItem(position)
            }
        }
        ItemTouchHelper(callback).attachToRecyclerView(recyclerView)
    }
}