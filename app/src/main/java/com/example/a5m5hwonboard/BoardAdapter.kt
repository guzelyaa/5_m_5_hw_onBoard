package com.example.a5m5hwonboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a5m5hwonboard.databinding.ItemBoardBinding

class BoardAdapter(
    private val list: ArrayList<BoardModel>,
    private val listener: ItemClickListener
) :
    RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {

    inner class BoardViewHolder(private val binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(boardModel: BoardModel) {
            binding.textView.text = boardModel.text
            binding.btnNext.setOnClickListener {
                if (adapterPosition == list.size - 1) {
                    listener.itemClick()
                }
            }

        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(
            ItemBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}