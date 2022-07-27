package com.tcoding.catsapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tcoding.catsapp.R
import com.tcoding.catsapp.model.CatInfo

class CatAdapter(val itemClick : ((position : Int)->Unit)?): RecyclerView.Adapter<CatAdapter.CatViewHolder>(){

    var catInfoList = ArrayList<CatInfo>()

    fun updateList(catInfoList: ArrayList<CatInfo>) {
        this.catInfoList = catInfoList
        notifyDataSetChanged()
    }

    class CatViewHolder(itemView: View, itemClick: ((position: Int) -> Unit)?): RecyclerView.ViewHolder(itemView) {

        var ivImage: ImageView
        var tvName: TextView
        var tvDescription: TextView
        var tvUlke: TextView

        init {
            ivImage = itemView.findViewById(R.id.ivImage)
            tvName = itemView.findViewById(R.id.tvName)
            tvUlke = itemView.findViewById(R.id.tvUlke)
            tvDescription = itemView.findViewById(R.id.tvDescription)


            itemView.setOnClickListener {
                itemClick!!(adapterPosition)
            }
        }

        fun bindData(cat: CatInfo) {
            tvName.setText(cat.name)
            tvDescription.setText(cat.description)
            tvUlke.setText(cat.origin)


            Picasso.get()
                .load(cat.image?.url)
                .into(ivImage)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_item_row, parent, false)
        return CatViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {

        holder.bindData(catInfoList.get(position))

    }

    override fun getItemCount(): Int {
      return catInfoList.size
    }

}