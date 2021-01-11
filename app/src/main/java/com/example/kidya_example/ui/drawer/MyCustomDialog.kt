package com.example.kidya_example.ui.drawer

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.kidya_example.R

class MyCustomDialog(var listener:OnInputListener) : DialogFragment() {
    /* Its a good practice to create callback interface within the fragment that host an activity must implement.
    As you can see below we have created OnInputListener interface. Also you must override on onAttach handler to
    obtain a reference to the host activity, confirming that it implement the required interface.
     */
    interface OnInputListener {
        fun sendInput(input: String)
    }

    var onInputListener: OnInputListener? = null

    // widgets
    private var mInput: EditText? = null
    private var mActionOk: TextView? = null
    private var mActionCancel: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_my_custom, container, false)
        mActionCancel = view.findViewById(R.id.action_cancel)
        mActionOk = view.findViewById(R.id.action_ok)
        mInput = view.findViewById(R.id.input)
        mActionCancel?.setOnClickListener(View.OnClickListener {
            Log.d(TAG, "onClick: closing dialog")
            dialog!!.dismiss()
        })
        mActionOk?.setOnClickListener(View.OnClickListener {
            val input = mInput?.getText().toString()
           // onInputListener!!.sendInput(input)
            listener.sendInput(input)
            dialog!!.dismiss()
        })
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            onInputListener = activity as OnInputListener?
        } catch (e: ClassCastException) {
            Log.e(TAG, "onAttach: " + e.message)
        }
    }

    companion object {
        private const val TAG = "MyCustomDialog"
    }
}