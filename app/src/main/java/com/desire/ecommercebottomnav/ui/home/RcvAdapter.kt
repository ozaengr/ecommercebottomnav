package com.desire.ecommercebottomnav.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.desire.ecommercebottomnav.databinding.RcvListBinding

class RcvAdapter(val rcvArray: ArrayList<RcvModel>) :
    RecyclerView.Adapter<RcvAdapter.RcvViewHolder>() {

    var onItemClick : ((RcvModel) -> Unit)?= null
    class RcvViewHolder(var view: RcvListBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(rcvModel: RcvModel, onItemClick: ((RcvModel) -> Unit)? = null) {
            view.rcvName.text = rcvModel.category
            view.rcvPrize.text = rcvModel.price.toString()
            Glide.with(view.rcvImage).load(rcvModel.image).into(view.rcvImage)
            view.ratingBar.rating = rcvModel.rating.rate.toFloat()

            view.mainCardView.setOnClickListener {
                onItemClick?.invoke(rcvModel)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RcvViewHolder {
        var view: RcvListBinding =
            RcvListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RcvViewHolder(view)
    }


    override fun getItemCount(): Int {
        return rcvArray.size
    }


    override fun onBindViewHolder(holder: RcvViewHolder, position: Int) {
        holder.bind(rcvArray[position], onItemClick)
    }
}