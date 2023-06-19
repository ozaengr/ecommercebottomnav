package com.desire.ecommercebottomnav.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.desire.ecommercebottomnav.R
import com.desire.ecommercebottomnav.databinding.ViewNumberCounterBinding


class CustomNumberCounterView(context: Context, attributeSet: AttributeSet?) : ConstraintLayout(context, attributeSet) {
    lateinit var binding: ViewNumberCounterBinding

    var onMyClickListener: OnClickListener? = null

    interface OnClickListener {
        fun onIncrement() {}
        fun onDecrement() {}
        fun getCounterValue(number: Int)
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onMyClickListener = onClickListener
    }

    init {
        binding = ViewNumberCounterBinding.inflate(LayoutInflater.from(context), this, true)
            .apply {
                val attrs =
                    context.obtainStyledAttributes(
                        attributeSet,
                        R.styleable.CustomNumberCounterView
                    )
                attrs.getColor(R.styleable.CustomNumberCounterView_textColor, -1)
                    .takeIf { it != -1 }
                    ?.also { tvCounter.setTextColor(it) }
                attrs.recycle()
            }
        binding.ivPlus.setOnClickListener { increaseInteger() }
        binding.ivMinus.setOnClickListener { decreaseInteger() }
    }


    fun increaseInteger() {
        display(binding.tvCounter.text.toString().toInt() + 1)
    }

    fun decreaseInteger() {
        var cnt = binding.tvCounter.text.toString().toInt()
        if (cnt <= 0) {
            Toast.makeText(context, "Enter Quantity", Toast.LENGTH_SHORT).show()
        } else {
            display(cnt - 1)
        }
    }

    private fun display(number: Int) {
        onMyClickListener?.getCounterValue(number)
        binding.tvCounter.setText("$number")
    }
}