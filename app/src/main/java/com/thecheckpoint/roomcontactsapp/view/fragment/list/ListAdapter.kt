package com.thecheckpoint.roomcontactsapp.view.fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thecheckpoint.roomcontactsapp.R
import com.thecheckpoint.roomcontactsapp.data.Contact
import org.w3c.dom.Text

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    private var contactList = emptyList<Contact>()


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = contactList[position]
        holder.itemView.findViewById<TextView>(R.id.tv_id).text = currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.tv_name).text = currentItem.name.toString()
        holder.itemView.findViewById<TextView>(R.id.tv_number).text = currentItem.number.toString()
        holder.itemView.findViewById<TextView>(R.id.tv_mail).text = currentItem.mail.toString()



    }

    override fun getItemCount(): Int {
       return contactList.size

    }
    fun setData(contact: List<Contact>){
        this.contactList = contact
        notifyDataSetChanged()
    }
}