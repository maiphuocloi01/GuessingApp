package com.example.guessinggame.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.navGraphViewModels
import com.example.guessinggame.R
import com.example.guessinggame.databinding.FragmentGameBinding
import com.example.guessinggame.viewmodel.GameViewModel
import com.example.guessinggame.viewmodel.PlayerViewModel

class GameFragment : Fragment() {
    private val playerViewModel by navGraphViewModels<PlayerViewModel>(R.id.nav_graph)
    private val gameViewModel by navGraphViewModels<GameViewModel>(R.id.nav_graph)
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.playersViewModel = playerViewModel
        binding.gameViewModel = gameViewModel
        binding.tvPlayer.setOnClickListener {
            showDialog(it)
        }
        binding.ivChangePlayer.setOnClickListener {
            showDialog(it)
        }

        return binding.root
    }
    fun showDialog(view: View){
        view.findNavController().navigate(R.id.action_gameFragment_to_changePlayerDialogFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}