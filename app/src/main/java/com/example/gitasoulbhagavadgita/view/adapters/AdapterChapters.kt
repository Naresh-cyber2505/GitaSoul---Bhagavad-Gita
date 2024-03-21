package com.example.gitasoulbhagavadgita.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.gitasoul_bhagavadgita.R
import com.example.gitasoul_bhagavadgita.databinding.ItemViewChaptersBinding
import com.example.gitasoulbhagavadgita.models.ChaptersItem

class AdapterChapters : RecyclerView.Adapter<AdapterChapters.ChaptersViewHolder>() {
    class ChaptersViewHolder(val binding: ItemViewChaptersBinding) : ViewHolder(binding.root)

    val diffUtil = object : DiffUtil.ItemCallback<ChaptersItem>() {
        override fun areItemsTheSame(oldItem: ChaptersItem, newItem: ChaptersItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ChaptersItem, newItem: ChaptersItem): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, diffUtil)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChaptersViewHolder {
//        return ChaptersViewHolder(ItemViewChaptersBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        val layoutBinding: ItemViewChaptersBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_view_chapters,
            parent,
            false
        )
        return ChaptersViewHolder(layoutBinding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ChaptersViewHolder, position: Int) {

        holder.binding.model = differ.currentList[position]


    }
}