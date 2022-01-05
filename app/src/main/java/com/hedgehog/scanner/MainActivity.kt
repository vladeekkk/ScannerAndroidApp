package com.hedgehog.scanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hedgehog.scanner.presentation.GreetingsFragment



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, GreetingsFragment())
            .commit()
    }
}
