package com.example.kidya_example.ui.drawer

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.kidya_example.R
import kotlinx.android.synthetic.main.fragment_account.date_text
import kotlinx.android.synthetic.main.fragment_drawer_add_child.*
import java.util.*


class DrawerAddChildFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    //    var onItemClick: ((MockData.SkitkaModel) -> Unit)? = null
//    var mListener: NoticeDialogListener? = null
    private var clickListener: ((name: String, gender: String, age: String) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return inflater.inflate(R.layout.fragment_drawer_add_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = editTextName?.text

        date_text.setOnClickListener {
            showDatePickerDialog()
        }

        imageBackHome.setOnClickListener {
            dialog?.dismiss()
        }


        val userList: MutableList<String> = ArrayList()
        userList.add("Пол")
        userList.add("Женский пол")
        userList.add("Мужской пол")
        val spinner = planets_spinner
        val spinnerArrayAdapter =
            ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                userList
            )

        //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerArrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position).toString()


                spinner_ = selectedItem
                if (selectedItem == "Add new category") {
                    // do your stuff
                }
            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        //Add Button
        btnAdd.setOnClickListener {
            Log.d("ttt", "$year_")
            Log.d("ttt", "$spinner_")
            Log.d("ttt", "$name")

            if (name?.isNotEmpty() == true && year_.isNotEmpty() && spinner_.isNotEmpty()) {
//                Toast.makeText(requireContext(), "btnAdd$year_ $spinner_ $name", Toast.LENGTH_SHORT)
//                    .show()


                clickListener?.invoke(name.toString(), spinner_, year_)

                dialog?.dismiss()
            } else {
                Toast.makeText(requireContext(), "Please full it", Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun getClickItem(f: (String, String, String) -> Unit) {
        clickListener = f
    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun showDatePickerDialog() {

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            this,
            Calendar.getInstance()[Calendar.YEAR],
            Calendar.getInstance()[Calendar.MONTH],
            Calendar.getInstance()[Calendar.DAY_OF_MONTH]
        )
        datePickerDialog.show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

        year_ = "$year"
        date_text.text = "$month/$dayOfMonth/$year"
    }

    companion object {
        var year_ = ""
        var spinner_ = ""
    }



//    interface NoticeDialogListener {
//        fun onDialogPositiveClick(name: String, gender: String, age: String)
//    }


}