package com.thecheckpoint.roomcontactsapp.view.fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.thecheckpoint.roomcontactsapp.R
import com.thecheckpoint.roomcontactsapp.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding= FragmentListBinding.inflate(layoutInflater)
        val view =  binding.root
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }


}