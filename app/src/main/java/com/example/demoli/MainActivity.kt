package com.example.demoli

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sub_base.showVersionDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun jumpHeightLimitActivity(view: View) {
        startActivity(Intent(this, HeightLimitActivity::class.java))
    }

    fun jumpSingleTaskAffinity(view: View) {
        startActivity(Intent(this, TaskAffinityActivity::class.java))
    }

    fun showDevice(view: View) {
        showVersionDialog(this)
    }
}

