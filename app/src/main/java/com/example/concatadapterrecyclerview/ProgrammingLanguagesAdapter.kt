package com.example.concatadapterrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapterrecyclerview.databinding.ItemProgramingLanguageBinding

class ProgrammingLanguagesAdapter :
    ListAdapter<ProgrammingLanguage, ProgrammingLanguagesAdapter.ProgrammingViewHolder>(
        DIFF_CALLBACK
    ) {

    class ProgrammingViewHolder(private val binding: ItemProgramingLanguageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(programmingLanguage: ProgrammingLanguage) {
            binding.run {
                linguage.text = programmingLanguage.name
                linguageDescription.text = programmingLanguage.paradigm
            }
        }

        companion object {
            fun create(parent: ViewGroup): ProgrammingViewHolder {
                val itemBinding = ItemProgramingLanguageBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)

                return ProgrammingViewHolder(itemBinding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        return ProgrammingViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ProgrammingLanguage>() {
            override fun areItemsTheSame(
                oldItem: ProgrammingLanguage,
                newItem: ProgrammingLanguage
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: ProgrammingLanguage,
                newItem: ProgrammingLanguage
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}
