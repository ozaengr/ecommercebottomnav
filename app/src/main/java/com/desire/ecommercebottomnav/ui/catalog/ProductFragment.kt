package com.desire.ecommercebottomnav.ui.catalog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.desire.ecommercebottomnav.databinding.FragmentProductBinding
import com.desire.ecommercebottomnav.ui.home.RcvModel
import com.desire.ecommercebottomnav.widget.CustomNumberCounterView


class ProductFragment : Fragment() {

    private lateinit var binding: FragmentProductBinding
    lateinit var adapter: Adapter
    var arrayListOfItems = arrayListOf<RcvModel>()

    private val args by navArgs<ProductFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(layoutInflater)
        backScreen()
     //   counter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("test", "onViewCreated: ${args.productDetailsRCV.title}")

        binding.textPrice1.text = args.productDetailsRCV.price.toString()
        Glide.with(binding.imgRcvId).load(args.productDetailsRCV.image).into(binding.imgRcvId)

        binding.customCounterView.setOnClickListener(
            object : CustomNumberCounterView.OnClickListener {
                override fun getCounterValue(number: Int) {
                    Log.d("", "getCounterValue: ${number}")
                    binding.textPriceTotal.text = multiply(number).toString()
                }
            }
        )

    }

    private fun backScreen() {
        binding.ivCancel.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    /*private fun counter() {
        binding.ivPlus.setOnClickListener { increaseInteger() }
        binding.ivMinus.setOnClickListener { decreaseInteger() }
    }

    fun increaseInteger() {
        display(binding.tvCounter.text.toString().toInt() + 1)
    }

    fun decreaseInteger() {
        var cnt = binding.tvCounter.text.toString().toInt()
        if (cnt <= 0) {
            Toast.makeText(requireContext(), "Enter Quantity", Toast.LENGTH_SHORT).show()

        } else {
            display(cnt - 1)
        }
    }

    private fun display(number: Int) {
        binding.tvCounter.setText("$number")
    }*/

    private fun multiply(counter : Int ): Float {
        val number1 = binding.textPrice1.text.toString()
        val mul = number1.toFloat() * counter
        return mul
    }
}