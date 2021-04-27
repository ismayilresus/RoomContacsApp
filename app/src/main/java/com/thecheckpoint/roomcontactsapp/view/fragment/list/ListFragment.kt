package com.thecheckpoint.roomcontactsapp.view.fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.thecheckpoint.roomcontactsapp.R
import com.thecheckpoint.roomcontactsapp.data.Contact
import com.thecheckpoint.roomcontactsapp.databinding.FragmentListBinding
import com.thecheckpoint.roomcontactsapp.viewmodel.ContactViewModel


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var mContactViewModel: ContactViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding= FragmentListBinding.inflate(layoutInflater)
        val view =  binding.root

        // Recycler View
        val adapter = ListAdapter()
        val recyclerView = binding.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //ViewModel
        mContactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)
        mContactViewModel.allData.observe(viewLifecycleOwner, Observer { Contact ->
            adapter.setData(Contact)
        })

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }


}