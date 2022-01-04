package edu.keepaneye.app7_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SequenceCache.loadCache()

        val primeText:TextView = findViewById(R.id.prime_text)
        val fibText:TextView = findViewById(R.id.fib_text)

        val prime = SequenceCache.getSequence("1")
        primeText.text = "${getString(R.string.prime_text)} ${prime.result}"

        val fib = SequenceCache.getSequence("2")
        fibText.text = "${getString(R.string.fib_text)} ${fib.result}"

        Log.d("App7_1_tag", "")
        val bagel: Bread = Bagel()
        val spread:LowFatSpread = LowFatSpread(bagel)
        val toast:Toasted = Toasted(spread)
        val open:Open = Open(toast)
        Log.d("App7_1_tag", "${open.description} ${open.kcal}")

    }
}