package com.example.kidya_example.ui.drawer

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.kidya_example.R
import kotlinx.android.synthetic.main.fragment_account.*
import java.util.*

class AccountFragment : Fragment(), DatePickerDialog.OnDateSetListener,
    DrawerAddChildFragment.OnInputListener2 {
   private var parentView: LinearLayout? = null
   private var parentView2: LinearLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentView = view.findViewById(R.id.ll_left) as LinearLayout
        parentView2 = view.findViewById(R.id.ll_right) as LinearLayout

        date_text.setOnClickListener {
            setUserVisible()
            showDatePickerDialog()
        }

        imageAccountBack.setOnClickListener {
            view.findNavController().popBackStack(R.id.nav_home, false)
        }

        addDialogText.setOnClickListener {

            showListDialog()

        }

        spinner(view)


    }

    private fun spinner(view: View) {

        val spinner: Spinner = view.findViewById(R.id.planets_spinner)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.gender,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        val spinner2: Spinner = view.findViewById(R.id.planets_spinner2)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = adapter
        }
        val spinner3: Spinner = view.findViewById(R.id.planets_spinner3)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner3.adapter = adapter
        }
    }

    private fun showListDialog() {
        val dialog = DrawerAddChildFragment(this)

        //fragmentManager?.let { dialog.show(it, "example2") }
        dialog.show(childFragmentManager, "diLOG")
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
        val date = "$month/$dayOfMonth/$year"
        date_text.text = date
    }


    fun setUserVisible() {
        fragmentManager?.beginTransaction()?.detach(this)?.attach(this)?.commit();
        Log.i("IsRefresh", "Yes")
    }


    companion object {
        private const val TAG = "FirstActivity"
        var komiljon = ""
    }

    override fun sendInputs(name: String, gender: String, age: String) {
        Log.d("komiljon", "$name $gender $age")

        val lin = parentView
        val lin_left = parentView2

        if (name.isNotEmpty()) {
            var i = 0
            val textView_name = TextView(requireContext())
            val textView_gender = TextView(requireContext())
            val textView_age = TextView(requireContext())
            textView_name.text = "textview# ${i++} $name"
            textView_gender.text = "textview# ${i++} $gender"
            textView_age.text = "textview# ${i++} $age"
            lin?.addView(textView_name)
            lin?.addView(textView_gender)
            lin_left?.addView(textView_age)
        }else{
            Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
        }
    }
}


