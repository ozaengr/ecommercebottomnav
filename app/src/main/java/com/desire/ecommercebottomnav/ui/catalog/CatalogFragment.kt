package com.desire.ecommercebottomnav.ui.catalog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.desire.ecommercebottomnav.databinding.FragmentCatalogBinding
import com.desire.ecommercebottomnav.ui.home.RcvAdapter
import com.desire.ecommercebottomnav.ui.home.RcvModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatalogFragment : Fragment() {

    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: RcvCatalogAdapter
    var arrayListOfItems = arrayListOf<RcvModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textCatalog
        catalogViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (binding.rcvCatalog.adapter == null) {
            getProducts()
        } else {
            setAdapter()
        }
        ivBack()
    }

    private fun getProducts() {
        var call: Call<ArrayList<RcvModel>> =
            com.desire.ecommercebottomnav.retrofit.Retrofit.api.getData()
        call.enqueue(object : Callback<ArrayList<RcvModel>> {
            override fun onResponse(
                call: Call<ArrayList<RcvModel>>,
                response: Response<ArrayList<RcvModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        arrayListOfItems.addAll(it)
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
        binding.rcvCatalog.layoutManager = GridLayoutManager(this@CatalogFragment.context, 2)
        adapter = RcvCatalogAdapter(arrayListOfItems)
        binding.rcvCatalog.setHasFixedSize(true)
        binding.rcvCatalog.adapter = adapter
        adapter.onItemClick = {
            findNavController().navigate(
                CatalogFragmentDirections.navigationCatalogToNavigationProduct(
                    productDetailsRCV = it,
                    desc = "asdsd"
                )
            )
        }

    }

    private fun ivBack() {
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}