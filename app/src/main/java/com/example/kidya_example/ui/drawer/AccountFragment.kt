package com.example.kidya_example.ui.drawer

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.kidya_example.R
import com.example.kidya_example.util.inflate
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.item_input.*
import java.util.*
import kotlin.collections.ArrayList

class AccountFragment : Fragment(), DatePickerDialog.OnDateSetListener,
    DrawerAddChildFragment.OnInputListener2 {
    private var parentView: LinearLayout? = null
    private var parentView2: LinearLayout? = null
    private var content: LinearLayout? = null
    private var image_close: ImageView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        months.add("январь")
        months.add("февраль")
        months.add("март")
        months.add("апрель")
        months.add("май")
        months.add("июнь")
        months.add("июль")
        months.add("август")
        months.add("сентябрь")
        months.add("октябрь")
        months.add("ноябрь")
        months.add("декабрь")

        parentView = view.findViewById(R.id.ll_left) as LinearLayout
        parentView2 = view.findViewById(R.id.ll_right) as LinearLayout
//        parentView2 = view.findViewById(R.id.layoutGroup) as LinearLayout
        content = view.findViewById(R.id.ll_child)
        image_close = view.findViewById(R.id.imageBack)


        date_text.setOnClickListener {
            setUserVisible()
            showDatePickerDialog()
        }

        imageAccountBack.setOnClickListener {
            view.findNavController().popBackStack(R.id.nav_home, false)
        }

        addDialogText.setOnClickListener {

            showListDialog()

            content?.visibility = View.VISIBLE
            image_close?.visibility = View.VISIBLE

        }

        spinner(view)

    }

    override fun sendInputs(name: String, gender: String, age: String) {
        Log.d("komiljon", "$name $gender $age")
        val lin_right = parentView
        val lin_left = parentView2
//        lin?.inflate(R.layout.item_input) {
//
//            textViewName.text = name + "\n"
//            textViewGender.text = gender.toString()
//            textViewAge.text = age.toString()
//
//        }

//            inputText.setText("")

//        val lin = parentView
//        val lin_left = parentView2
//
        if (name.isNotEmpty()) {


            var i = 0
            val textView_name = TextView(requireContext())
            val textView_gender = TextView(requireContext())
            val textView_age = TextView(requireContext())
            textView_name.text = "textview# ${i++} $name"
            textView_gender.text = "textview# ${i++} $gender"
            textView_age.text = "textview# ${i++} $age"
            lin_left?.getChildAt(R.id.textViewName)
            lin_right?.getChildAt(R.id.textViewAge)
            lin_left?.getChildAt(R.id.textViewGender)

            lin_left?.addView(textView_name)
            lin_right?.addView(textView_age)
            lin_left?.addView(textView_gender)
        }else{
            Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
        }
    }
//}


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
        val date = "$dayOfMonth ${months[month]} $year"
        date_text.text = date
    }

    fun setUserVisible() {
        fragmentManager?.beginTransaction()?.detach(this)?.attach(this)?.commit();
        Log.i("IsRefresh", "Yes")
    }

    companion object {        private const val TAG = "FirstActivity" ;  val months = ArrayList<String>() }

}


