package edu.keepaneye.uttermarvel.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.keepaneye.uttermarvel.R
import edu.keepaneye.uttermarvel.model.ResponseDTO
import edu.keepaneye.uttermarvel.retrofit.ApiInterface
import kotlinx.android.synthetic.main.activity_utter_marvel.*
import retrofit2.Call
import retrofit2.Callback

class UtterMarvelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utter_marvel)

        bottomNavigationView.setupWithNavController(marvelNavHostFragment.findNavController())

        val apiInterface = ApiInterface.create().getComicsList()
        apiInterface.enqueue(object : Callback<ResponseDTO> {
            override fun onResponse(call: Call<ResponseDTO>, response: retrofit2.Response<ResponseDTO>) {
                if (response.body() != null) {

                }
            }

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}