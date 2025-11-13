package com.example.indigo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FlightDetailsFragment: Fragment() {
    private lateinit var view : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.item_details, container, false)

        val depCode = arguments?.getString("depCode")
        val arrCode = arguments?.getString("arrCode")
        val duration = arguments?.getString("duration")
        val depTime = arguments?.getString("depTime")

        view.findViewById<TextView>(R.id.depCode).text = depCode
        view.findViewById<TextView>(R.id.arrCode).text = arrCode
        view.findViewById<TextView>(R.id.duration).text = duration
        view.findViewById<TextView>(R.id.depTime).text = depTime

        return view

        return view
    }


}