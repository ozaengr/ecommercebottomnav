package com.desire.ecommercebottomnav.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.desire.ecommercebottomnav.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    lateinit var rcvAdapter : RcvAdapter
    var arrayListOfData = arrayListOf<RcvModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val root: View = binding.root

        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        getProducts()
        return root
    }
    private fun getProducts() {
        var call: Call<ArrayList<RcvModel>> = com.desire.ecommercebottomnav.retrofit.Retrofit.api.getData()
        call.enqueue(object : Callback<ArrayList<RcvModel>> {
            override fun onResponse(
                call: Call<ArrayList<RcvModel>>,
                response: Response<ArrayList<RcvModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        arrayListOfData.addAll(it)
                        setAdapter()
                    }
                }
            }
            override fun onFailure(call: Call<ArrayList<RcvModel>>, t: Throwable) {
                Log.i("Test", "Fail")
            }
        })
    }
    private fun setAdapter() {
        binding.rcvMenu.layoutManager = LinearLayoutManager(this@HomeFragment.context,RecyclerView.HORIZONTAL,false)
        binding.rcvMenu.adapter = RcvAdapter(arrayListOfData)
        binding.rcvMenu.setHasFixedSize(true)
        val snapHelper : SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.rcvMenu)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}