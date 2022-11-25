package com.example.a5m5hwonboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a5m5hwonboard.databinding.FragmentBoardBinding

class BoardFragment : Fragment(), ItemClickListener {

    private lateinit var binding: FragmentBoardBinding

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

    }

    override fun itemClick() {
        findNavController().navigate(R.id.secondFragment)
    }


}