package com.example.a5m5hwonboard

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a5m5hwonboard.databinding.FragmentBoardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BoardFragment : Fragment(), ItemClickListener {

    private lateinit var binding: FragmentBoardBinding

    @Inject
    lateinit var shared: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf<BoardModel>()
        list.add(BoardModel("h"))
        list.add(BoardModel("e"))
        list.add(BoardModel("l"))
        list.add(BoardModel("l"))
        val boardAdapter = BoardAdapter(list, this)
        binding.viewPager.adapter = boardAdapter


        if (shared.getBoolean("isShow", false)) {
            findNavController().navigate(R.id.secondFragment)
        }
    }

    override fun itemClick() {
        shared.edit().putBoolean("isShow", true).apply()
        findNavController().navigate(R.id.secondFragment)
    }


}