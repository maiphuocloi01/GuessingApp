package com.example.guessinggame.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.example.guessinggame.R
import com.example.guessinggame.databinding.FragmentChangePlayerDialogBinding
import com.example.guessinggame.viewmodel.PlayerViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ChangePlayerDialogFragment : BottomSheetDialogFragment() {
    private val playerViewModel by navGraphViewModels<PlayerViewModel>(R.id.nav_graph)
    private var _binding: FragmentChangePlayerDialogBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChangePlayerDialogBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.playerViewModel = playerViewModel
        binding.btnDialogClose.setOnClickListener {
            dismiss()
        }
        return binding.root
    }
}