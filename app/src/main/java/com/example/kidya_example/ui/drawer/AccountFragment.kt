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

class AccountFragment : Fragment(), DatePickerDialog.OnDateSetListener{

    //val k:clickListener?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lin = view.findViewById<View>(R.id.rlMain) as LinearLayout

        date_text.setOnClickListener {
            showDatePickerDialog()


        }

        imageAccountBack.setOnClickListener {
            view.findNavController().popBackStack(R.id.nav_home, false)
        }

        addDialogText.setOnClickListener {
            showListDialog()


        }

        var i = 0

        val mNum = getArguments()?.getInt("num");
        val textView = TextView(requireContext())
        textView.text = "textview# ${i++} $mNum"
        lin.addView(textView)

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

        val dialog = DrawerAddChildFragment()
        dialog.getClickItem { pos1, pos2, pos3 ->
//            Toast.makeText(requireContext(), "$pos1, $pos2, $pos3 ", Toast.LENGTH_SHORT).show()
          val kk   = pos1
            Log.d("kkk",kk)
            Toast.makeText(requireContext(), "pos1, pos2, pos3", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showListDialog() {
        val dialog = DrawerAddChildFragment()

        fragmentManager?.let { dialog.show(it, "example2") }
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




}