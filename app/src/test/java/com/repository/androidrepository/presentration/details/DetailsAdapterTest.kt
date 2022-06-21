package com.flickrSearch.image.presentration.fullImage

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.google.common.truth.Truth
import com.repository.androidrepository.models.Items
import com.repository.androidrepository.presentration.details.DetailsAdapter
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class DetailsAdapterTest{

    @Test
    fun  whenViewPagerIsValid(context: Context){
        val context = context
        val items = Items()
        val adapter = DetailsAdapter()
        val result = adapter.ViewPagerAdapter(context,items)
        Truth.assertThat(result).isEqualTo(true)
    }

    @Test
    fun  whenViewPagerIsInValid(context: Context){
        val context = context
        val items = Items()
        val adapter = DetailsAdapter()
        val result = adapter.ViewPagerAdapter(context,items)
        Truth.assertThat(result).isEqualTo(false)
    }

    @Test
    fun  whenViewPagerGetCount(){
        val adapter = DetailsAdapter()
        val result = adapter.count
        Truth.assertThat(result).isEqualTo(true)
    }

    @Test
    fun  whenViewPagerNotGetCount(){
        val adapter = DetailsAdapter()
        val result = adapter.count
        Truth.assertThat(result).isEqualTo(false)
    }

    @Test
    fun  whenViewFromObject(view: View, `object`: Any){
        val adapter = DetailsAdapter()
        val result = adapter.isViewFromObject(view, `object`)
        Truth.assertThat(result).isEqualTo(true)
    }

    @Test
    fun  whenNotViewFromObject(view: View, `object`: Any){
        val adapter = DetailsAdapter()
        val result = adapter.isViewFromObject(view, `object`)
        Truth.assertThat(result).isEqualTo(false)
    }

    @Test
    fun  wheninstantiateItem(container: ViewGroup){
        val adapter = DetailsAdapter()
        val result = adapter.instantiateItem(container,1)
        Truth.assertThat(result).isEqualTo(true)
    }

    @Test
    fun  whenNotinstantiateItem(container: ViewGroup){
        val adapter = DetailsAdapter()
        val result = adapter.instantiateItem(container,0)
        Truth.assertThat(result).isEqualTo(false)
    }
}