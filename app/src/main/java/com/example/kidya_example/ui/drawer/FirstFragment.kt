package com.example.kidya_example.ui.drawer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kidya_example.R

class FirstFragment : Fragment(), MyCustomDialog.OnInputListener {

    // widgets
    var mOpenDialog: Button? = null
    var mInputDisplay: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mOpenDialog = view.findViewById(R.id.open_dialog)
        mInputDisplay = view.findViewById(R.id.input_display)
        mOpenDialog?.setOnClickListener {
//            val dialog = MyCustomDialog()
//            dialog.show(supportFragmentManager, "MyCustomDialog")
//            fragmentManager?.let { dialog.show(it, "MyCustomDialog") }
            showListDialog()
        }
    }

    override fun sendInput(input: String) {
        Log.e(TAG, "got the input: $input")
        mInputDisplay!!.text = input
    }


    companion object {
        private const val TAG = "FirstActivity"
    }

    private fun showListDialog() {
        val dialog = MyCustomDialog(this)

        //fragmentManager?.let { dialog.show(it, "example2") }
        dialog.show(childFragmentManager,"diLOG")
    }

}
