package com.example.kidya_example.ui.order

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.example.kidya_example.R
import kotlinx.android.synthetic.main.fragment_order_dialog.*

class OrderDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        getDialog()?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        return inflater.inflate(R.layout.fragment_order_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageBackHome.setOnClickListener {
            dialog?.dismiss()
        }
        btnAddCommit.setOnClickListener {
            dialog?.dismiss()
        }
    }
}