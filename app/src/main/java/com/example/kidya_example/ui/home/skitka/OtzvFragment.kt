package com.example.kidya_example.ui.home.skitka

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.RatingBar.OnRatingBarChangeListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kidya_example.R


class OtzvFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otzv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ratingBar: RatingBar = view.findViewById(R.id.ratingBar3)

        ratingBar.onRatingBarChangeListener =
            OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                Toast.makeText(
                    requireContext(),
                    rating.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

}