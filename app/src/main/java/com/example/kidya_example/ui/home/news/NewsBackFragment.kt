package com.example.kidya_example.ui.home.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.kidya_example.R
import kotlinx.android.synthetic.main.fragment_news_back.*

class NewsBackFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_back, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageNewsBack.setOnClickListener {
//             view.findNavController().popBackStack(R.id.nav_home,false)
            view.findNavController().navigate(R.id.nav_news_back_list)
            Toast.makeText(requireContext(), "nav_news_back_list", Toast.LENGTH_SHORT).show()
        }
    }
}