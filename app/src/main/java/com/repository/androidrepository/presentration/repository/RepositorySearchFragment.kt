package com.repository.androidrepository.presentration.repository

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.repository.androidrepository.R
import com.repository.androidrepository.databinding.RepositorySearchFragmentBinding
import com.repository.androidrepository.models.Items
import com.repository.androidrepository.usecase.Resource
import com.repository.androidrepository.usecase.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepositorysearchFragment : Fragment(), RepositorySearchAdapter.ItemsItemListener{

    private var binding: RepositorySearchFragmentBinding by autoCleared()
    private val viewModel: RepositorysearchViewModel by viewModels()
    private lateinit var adapter:RepositorySearchAdapter
    private var list = ArrayList<Items>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RepositorySearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
            binding.searchNameEt.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    adapter.filter.filter(s)
                }
            })

        getView()?.setFocusableInTouchMode(true)
        getView()?.requestFocus()
        getView()?.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                return if (keyCode == KeyEvent.KEYCODE_BACK) {
                    true
                } else false
            }
        })


    }
    private fun setupRecyclerView() {
        adapter = RepositorySearchAdapter(requireContext(),list,this)
        binding.RepositoryRv.layoutManager = LinearLayoutManager(requireContext())
        binding.RepositoryRv.adapter = adapter

    }



    private fun setupObservers() {
        viewModel.Repositorys.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    binding.shimmerViewContainer.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()){
                        list = it.data as ArrayList<Items>
                        list.sortBy { it.pushedAt }
                        adapter.setItems(it.data)

                    }
                }
                Resource.Status.ERROR ->{
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING ->{
                    binding.progressBar.visibility = View.VISIBLE
                    binding.shimmerViewContainer.visibility = View.VISIBLE
                }

            }
        })
    }



   override fun onPause() {
        super.onPause()
        binding.shimmerViewContainer.stopShimmerAnimation()
    }

  override fun onResume() {
        super.onResume()
        binding.shimmerViewContainer.startShimmerAnimation()
    }



    override fun onClickedItemss(item: Items) {
        findNavController().navigate(
            R.id.action_list_search_to_Repository_view,
            bundleOf("item" to item)
        )
    }

}
