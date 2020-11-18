package com.example.demoli

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SingleTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_task)
    }

    fun jumpSingleTask(view: View) {
        startActivity(Intent(this, SingleTaskActivity::class.java))
    }

    fun jumpSingleTaskAffinity(view: View) {
        startActivity(Intent(this, TaskAffinityActivity::class.java))
    }

    fun jumpToThird(view: View) {
        val intent = Intent(this, ThirdActivity::class.java)
        startActivity(intent)
    }}