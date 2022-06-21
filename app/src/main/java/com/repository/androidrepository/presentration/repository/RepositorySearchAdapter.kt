package com.repository.androidrepository.presentration.repository

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.repository.androidrepository.databinding.ItemRepositoryBinding
import com.repository.androidrepository.models.Items
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList

class RepositorySearchAdapter() :
    RecyclerView.Adapter<ItemsViewHolder>(),Filterable
{

    private lateinit var itemList:ArrayList<Items>
    private lateinit var itemListFilter: ArrayList<Items>
    private lateinit var context:Context
    private lateinit var listener:ItemsItemListener

    constructor(context: Context,items: ArrayList<Items>,listener: ItemsItemListener) : this() {
        this.itemListFilter = items
        this.itemList = items
        this.listener = listener
        this.context = context

    }


    interface ItemsItemListener {
        fun onClickedItemss(item: Items)
    }


    fun setItems(items: ArrayList<Items>) {
        this.itemList?.clear()
        this.itemList?.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val binding: ItemRepositoryBinding=
            ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemsViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = itemListFilter.size

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) =
        holder.bind(itemListFilter[position])


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                       itemListFilter = itemList
                } else {
                    val filteredList: ArrayList<Items> = ArrayList()
                    for (row in itemList) {

                        if (row.name!!
                                .contains(charSequence)
                            || row.pushedAt
                                !!.contains(charSequence)
                        ) {
                            filteredList.add(row)
                        }
                    }
                    itemListFilter = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = itemListFilter
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                itemListFilter = filterResults.values as ArrayList<Items>

                // refresh the list with filtered data
                notifyDataSetChanged()
            }
        }
    }
}

class ItemsViewHolder(private val itemBinding: ItemRepositoryBinding,
                     private val listener: RepositorySearchAdapter.ItemsItemListener) :
    RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var Items: Items

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Items) {
        this.Items = item
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("MM-dd-yy HH:mm:ss")
        val output: String = formatter.format(parser.parse(item?.pushedAt))
        itemBinding.name.text = "Owner: "+item.name
        itemBinding.access.text = "Last Update Date: "+output
        itemBinding.address.text = "Description: "+ item.description
        Glide.with(itemBinding.root)
            .load(item.owner?.owner_avatarUrl)
            .into(itemBinding.image)
    }

    override fun onClick(v: View?) {
       listener.onClickedItemss(Items)
    }


}

