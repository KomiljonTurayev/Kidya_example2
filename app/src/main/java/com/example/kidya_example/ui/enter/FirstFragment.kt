package com.example.kidya_example.ui.enter

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.kidya_example.R
import kotlinx.android.synthetic.main.fragment_first2.*

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            /* Create an Intent that will start the Menu-Activity. */
            Toast.makeText(requireContext(), "Handler", Toast.LENGTH_SHORT).show()

            imageViewFirst.animate().rotationBy(360f).setDuration(300).start()
            imageViewFirst.animate().yBy(210f).setDuration(400).start()
            imageViewFirst.animate().scaleX(1f).setDuration(400).start()
            imageViewFirst.animate().scaleY(1f).setDuration(400).start()
            imageViewFirst.visibility = View.INVISIBLE
            imageViewFirstTop.visibility = View.VISIBLE
            some_id.visibility = View.VISIBLE
            about_auth.visibility = View.VISIBLE
            materialCardView2.visibility = View.VISIBLE
            btnAuth.visibility = View.VISIBLE
            textAuto.visibility = View.VISIBLE
            imageViewFacebook.visibility = View.VISIBLE
            imageViewGoogle.visibility = View.VISIBLE

        }, 3000)
//        imageViewFirst.visibility = View.INVISIBLE

        var auth = false
        btnAuth.setOnClickListener {
            if (auth) {
                view.findNavController().popBackStack()
                view.findNavController().navigate(R.id.nav_home)

            } else {
                editPhoneNumber.hint = "998 93 004 10 24"
                textCode.visibility = View.VISIBLE
                materialCardView3.visibility = View.VISIBLE
                imageViewFacebook.visibility = View.INVISIBLE
                imageViewGoogle.visibility = View.INVISIBLE
                btnAuth.text = "Авторизироваться"
                auth = true
            }
        }
    }

    companion object {

    }
}