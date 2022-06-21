package com.repository.androidrepository.presentration.details

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.repository.androidrepository.R
import com.repository.androidrepository.databinding.FragmentDetailsBinding
import com.repository.androidrepository.models.Items
import com.repository.androidrepository.usecase.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var binding: FragmentDetailsBinding by autoCleared()
    private lateinit var adapter: DetailsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getView()?.setFocusableInTouchMode(true)
        getView()?.requestFocus()
        getView()?.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                return if (keyCode == KeyEvent.KEYCODE_BACK) {
                    findNavController().navigate(
                        R.id.Repository_list_search
                    )
                    true
                } else false
            }
        })
        //Initializing the ViewPagerAdapter
        //Initializing the ViewPagerAdapter
        adapter = DetailsAdapter()
        var items:Items = arguments!!.getParcelable("item")!!
        adapter.ViewPagerAdapter(requireContext(), items)
        //Adding the Adapter to the ViewPager

        //Adding the Adapter to the ViewPager
        binding.pager.setAdapter(adapter)

        binding.backButton.setOnClickListener{
            findNavController().navigate(
                R.id.Repository_list_search
            )
        }

    }


}