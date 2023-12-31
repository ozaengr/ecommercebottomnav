package com.desire.ecommercebottomnav.retrofit

import com.desire.ecommercebottomnav.request.ProductReq
import com.desire.ecommercebottomnav.response.ProductRes
import com.desire.ecommercebottomnav.ui.home.RcvModel
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PartMap
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    //https://fakestoreapi.com/products
    @GET("products")
    fun getData(): Call<ArrayList<RcvModel>>


    //https://fakestoreapi.com/products/1

    @GET("products/{id}")
    fun getproductwithpid(@Path("id") id: Int): Call<RcvModel>

    //https://fakestoreapi.com/products?limit=5
    /*

    @GET("/products")
    fun getproductsLimit(@Query("limit") limit:Int):Call<ArrayList<RcvModel>>
*/

    /*//https://fakestoreapi.com/products
    @POST("products")
    fun addproduct(@Body productReq: ProductReq): Call<ProductRes>

    @FormUrlEncoded
    @POST("products")
    fun addproduct(@Body productReq: ProductReq): Call<ProductRes>

    @GET("/api/searchtypes/{iddd}/filters")
    fun getFilterList(
        @Path("iddd") customerId: Long,
        @Query("Type") responseType: String?,
        @Query("SearchText") searchText: String?
    ): Call<ProductRes?>?

    @POST("products")
    fun addproduct(@PartMap productReq: HashMap<String, RequestBody>): Call<ProductRes>?*/
    /*
/*

    @POST("products")
    fun addNewProduct(@Body addProductRequest: AddProductRequest):Call<AddProductResponce>

    @DELETE("products/{id}")
    fun deleteProduct(@Path("id") id: Int):Call<DeleteProductResponce>*/


 */
}