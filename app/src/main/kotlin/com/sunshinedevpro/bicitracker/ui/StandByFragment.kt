package com.sunshinedevpro.bicitracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.sunshinedevpro.R
import kotlinx.android.synthetic.main.fragment_stand_by.*

class StandByFragment : Fragment() {

    private lateinit var bottomSheetBehaviour: BottomSheetBehavior<ViewGroup>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stand_by, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBottomSheetView()
    }

    private fun initBottomSheetView() {
        bottomSheetBehaviour = BottomSheetBehavior.from(layout_bottom_sheet)
    }
}