package com.example.newstesttask.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.newstesttask.MyApp
import com.example.newstesttask.R
import com.example.newstesttask.presentation.interfaces.ListNewsViewModel
import com.example.newstesttask.viewmodel.ListNewsViewModelFactory
import com.example.newstesttask.viewmodel.ListNewsViewModelImpl
import javax.inject.Inject

class ListNewsFragment : Fragment() {

    @Inject
    lateinit var vmFactory: ListNewsViewModelFactory
    private lateinit var viewModel: ListNewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerViewNews: RecyclerView = view.findViewById(R.id.recyclerViewNews)

        (requireContext().applicationContext as MyApp).appComponent.inject(this)
        viewModel = ViewModelProvider(this, vmFactory)[ListNewsViewModelImpl::class.java]

        (viewModel as ListNewsViewModelImpl).adapter.observe(viewLifecycleOwner) {
            recyclerViewNews.adapter = it
        }
        viewModel.getAdapter("123")
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListNewsFragment().apply {
            arguments = Bundle().apply {}
        }
    }
}