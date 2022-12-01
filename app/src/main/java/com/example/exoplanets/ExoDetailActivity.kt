package com.example.exoplanets

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

class ExoDetailActivity: AppCompatActivity() {
    companion object{
        const val SELECTED_ITEM = "SELECTED_ITEM"
    }
    var selectedItem = "Не выбрано"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE){
            finish()
            return
        }

        setContentView(R.layout.activity_exo_detail)

        val extras: Bundle? = intent.extras
        selectedItem = extras?.getString(SELECTED_ITEM).toString()
    }
    override fun onResume() {
        super.onResume()

        val fragment: ExoDetailActivity =
            supportFragmentManager.findFragmentById(R.id.exoDetailFragment) as
                    ExoDetailActivity
        fragment?.setSelectedItem(selectedItem)

    }


}