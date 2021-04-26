package com.thecheckpoint.roomcontactsapp.view.fragment.add

import android.app.Application
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.thecheckpoint.roomcontactsapp.R
import com.thecheckpoint.roomcontactsapp.data.Contact
import com.thecheckpoint.roomcontactsapp.databinding.FragmentAddBinding
import com.thecheckpoint.roomcontactsapp.viewmodel.ContactViewModel



class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    // private lateinit var mContactViewModel: ContactViewModel
    val mContactViewModel: ContactViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
         binding = FragmentAddBinding.inflate(layoutInflater)
         val view = binding.root


        //mContactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

       binding.btnAdd.setOnClickListener{
           insertData()
       }

        return view
    }


    private fun insertData() {
       val name = binding.etName.text.toString()
       val mail = binding.etMail.text.toString()
       val number = binding.etNumber.text.toString()

       if(inputCheck(name,mail,number)){
           val contact = Contact(0,name,mail,number)
           mContactViewModel.addContact(contact)
           Toast.makeText(requireContext(),"Contact added.", Toast.LENGTH_LONG).show()
           findNavController().navigate(R.id.action_addFragment_to_listFragment)
       }else{Toast.makeText(requireContext(),"Enter all information.", Toast.LENGTH_SHORT).show()}

    }

    private fun inputCheck(name: String ,mail: String ,number: String): Boolean {
       return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(mail) && TextUtils.isEmpty(number) )
    }
}