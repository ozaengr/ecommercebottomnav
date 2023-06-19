package com.desire.ecommercebottomnav.ui.catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.desire.ecommercebottomnav.databinding.RcvCatalogListBinding
import com.desire.ecommercebottomnav.response.MyProductListItem
import com.desire.ecommercebottomnav.ui.home.RcvModel

class RcvCatalogAdapter(val rcvArray: ArrayList<RcvModel>) :
    RecyclerView.Adapter<RcvCatalogAdapter.RcvViewHolder>() {

    var onItemClick: ((RcvModel) -> Unit)? = null
    class RcvViewHolder(var view: RcvCatalogListBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(rcvCatalogModel: RcvModel, onItemClick: ((RcvModel) -> Unit)?) {
            view.rcvName1.text = rcvCatalogModel.category
            view.textPrize1.text = rcvCatalogModel.price.toString()
            Glide.with(view.rcvImage1).load(rcvCatalogModel.image).into(view.rcvImage1)
            view.catalogCardview.setOnClickListener {
                onItemClick?.invoke(rcvCatalogModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RcvViewHolder {
        var view: RcvCatalogListBinding =
            RcvCatalogListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RcvViewHolder(view)
    }


    override fun getItemCount(): Int {
        return rcvArray.size
    }


    override fun onBindViewHolder(holder: RcvViewHolder, position: Int) {
        holder.bind(rcvArray[position], onItemClick)
    }
}