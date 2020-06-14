package com.kmm.mrfever.views.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kmm.mrfever.R
import com.kmm.mrfever.MrFeverApplication
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

   @Inject lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MrFeverApplication).component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterButton = findViewById<Button>(R.id.enter_button)
        enterButton.setOnClickListener{
            presenter.onEnterButtonClicked()
        }

    }

    override fun navigateTo(target: Class<*>) {
        startActivity(Intent(this, target))
    }

}
