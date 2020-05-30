package com.kmm.mrfever

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChildrenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_children)

        val addChildButton = findViewById<Button>(R.id.add_child_button)
        addChildButton.setOnClickListener{
            val intent = Intent(this, AddChildActivity::class.java)
            startActivity(intent)
        }

        val yourChildrenButton = findViewById<Button>(R.id.your_children_button)
        yourChildrenButton.setOnClickListener{
            val intent = Intent(this, YourChildrenActivity::class.java)
            startActivity(intent)
        }
    }
}