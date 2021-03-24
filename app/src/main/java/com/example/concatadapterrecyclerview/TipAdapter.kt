package com.example.concatadapterrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapterrecyclerview.databinding.ItemTipBinding

class TipAdapter: ListAdapter<Tip, TipAdapter.TipViewHolder>(DIFF_CALLBACK) {
    var gotItItemClickListener: ((positon: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        return TipViewHolder.create(parent, gotItItemClickListener)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    class TipViewHolder(private val binding: ItemTipBinding, private val gotItItemClickListener: ((positon: Int) -> Unit)?) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tip: Tip, positon: Int) {
            binding.run {
                description.text = tip.description
            }

            binding.understood.setOnClickListener {
                gotItItemClickListener?.invoke(positon)
            }
        }

        companion object {
            fun create(parent: ViewGroup, gotItItemClickListener: ((positon: Int) -> Unit)?): TipViewHolder {
                val itemBinding = ItemTipBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return TipViewHolder(itemBinding, gotItItemClickListener)
            }
        }
    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Tip>(){
            override fun areItemsTheSame(oldItem: Tip, newItem: Tip): Boolean {
                return newItem.description == oldItem.description
            }

            override fun areContentsTheSame(oldItem: Tip, newItem: Tip): Boolean {
                return oldItem == newItem
            }

        }
    }

}