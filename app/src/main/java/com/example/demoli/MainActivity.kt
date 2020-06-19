package com.example.demoli

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TouchDelegate
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llName.post {

            val rect = Rect(llName.left, llName.top, 840, llName.bottom)

            llName.touchDelegate =
                TouchDelegate(rect, tvName)


            tvName.setOnClickListener {
                Toast.makeText(this, "tvName 被点击", Toast.LENGTH_LONG).show()
            }
        }

//        llName.setOnClickListener {
//            Toast.makeText(this, "llName 被点击", Toast.LENGTH_LONG).show()
//        }
    }
}
