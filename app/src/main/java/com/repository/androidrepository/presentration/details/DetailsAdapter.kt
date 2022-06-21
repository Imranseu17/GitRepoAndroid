package com.repository.androidrepository.presentration.details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.repository.androidrepository.databinding.DetailsScreenBinding
import com.repository.androidrepository.models.Items
import java.text.SimpleDateFormat

class DetailsAdapter: PagerAdapter() {
    //Context object
    var context: Context? = null

    //Array of images
    var item: Items? = null


    //Viewpager Constructor
    fun ViewPagerAdapter(context: Context, items: Items) {
        this.context = context
        this.item = items
    }

    override fun getCount(): Int {
        //return the number of images
        return 1
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding: DetailsScreenBinding =
            DetailsScreenBinding.
            inflate(LayoutInflater.from(container.context), container, false)

        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("MM-dd-yy HH:mm:ss")
        val output: String = formatter.format(parser.parse(item?.pushedAt))

        Glide.with(binding.root).
        load(item?.owner?.owner_avatarUrl)
            .into(binding.photo)
        binding.name.text = "Name: "+item?.fullName
        binding.lastUpdateDate.text = "Last update Date: "+output
        binding.description.text = "Description: "+item?.description

        container.addView(binding.root)

        return binding.root
    }




}