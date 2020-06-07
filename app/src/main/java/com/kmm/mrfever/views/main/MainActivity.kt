package com.kmm.mrfever.views.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kmm.mrfever.LoginActivity
import com.kmm.mrfever.R
import com.kmm.mrfever.base.BaseActivity

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
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

    override fun instantiatePresenter(): MainPresenter {
        return MainPresenter(this)
    }

}
