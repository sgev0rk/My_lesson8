import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun main() {
    val retrofit = Retrofit.Builder()
            .baseUrl("https://cat-fact.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val service = retrofit.create(CatService::class.java)
    service.getAllCats()
            .enqueue(object : Callback<List<CatInfo>> {
                override fun onFailure(call: Call<List<CatInfo>>?, t: Throwable?) {
                    println("Retrofit fail")
                }

                override fun onResponse(call: Call<List<CatInfo>>, response: Response<List<CatInfo>>) {
                    if (response?.code() != null
                            && response.isSuccessful
                            && response.body() != null) {
                        var allCats: List<CatInfo>? = null
                        allCats = response.body()
                        allCats?.forEach {
                            println(it)
                        }
                    } else {
                        println("Something wrong with response")
                    }
                }
            })
}

interface CatService {
    @GET("/facts/")
    fun getAllCats(): Call<List<CatInfo>>
}