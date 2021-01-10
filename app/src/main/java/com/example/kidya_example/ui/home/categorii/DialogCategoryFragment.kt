package com.example.kidya_example.ui.home.categorii

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kidya_example.R
import com.example.kidya_example.adapters.DialogCheckAdapter
import com.example.kidya_example.adapters.DialogColorAdapter
import com.example.kidya_example.adapters.DialogSizeAdapter
import kotlinx.android.synthetic.main.fragment_dialog_category.*

class DialogCategoryFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        getDialog()?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        return inflater.inflate(R.layout.fragment_dialog_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerDialogColor.adapter = DialogColorAdapter()
        recyclerDialogColor.layoutManager = GridLayoutManager(requireContext(), 2,GridLayoutManager.HORIZONTAL,false)

        recyclerDialogMaterial.adapter = DialogCheckAdapter()
        recyclerDialogMaterial.layoutManager = GridLayoutManager(requireContext(), 2)

        recyclerDialogSize.adapter = DialogSizeAdapter()
        recyclerDialogSize.layoutManager = GridLayoutManager(requireContext(), 2,GridLayoutManager.HORIZONTAL,false)

        imageBackHome.setOnClickListener {
            dialog?.dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
    }
}