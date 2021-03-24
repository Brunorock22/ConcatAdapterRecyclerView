package com.example.concatadapterrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import com.example.concatadapterrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var programmingLanguagesAdapter: ProgrammingLanguagesAdapter
    lateinit var tipAdapter: TipAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        programmingLanguagesAdapter = ProgrammingLanguagesAdapter()
        tipAdapter = TipAdapter()
        tipAdapter.apply {
            gotItItemClickListener = {
                dismissTip(it)
            }
        }
        binding.recyclerFeed.adapter =
            ConcatAdapter( tipAdapter, programmingLanguagesAdapter)
        programmingLanguagesAdapter.submitList(programmingLanguage)
        tipAdapter.submitList(tips)
    }

    private fun dismissTip(positon: Int) {
        tipAdapter.notifyItemRemoved(positon)
        programmingLanguage[positon].name = "AAAHHHHHHHHH"
        programmingLanguagesAdapter.submitList(programmingLanguage)
        programmingLanguagesAdapter.notifyDataSetChanged()

    }
}