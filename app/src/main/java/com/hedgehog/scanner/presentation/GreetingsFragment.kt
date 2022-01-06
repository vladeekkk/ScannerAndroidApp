package com.hedgehog.scanner.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.hedgehog.scanner.R

class GreetingsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.greetings_fragment, container, false)
        val button = view.findViewById<ImageButton>(R.id.scan_button)

        button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragmentContainer, ScanResultFragment())
                .commitAllowingStateLoss()
        }
        return view
    }

}