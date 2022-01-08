package edu.keepaneye.uttermarvel.retrofit

import edu.keepaneye.uttermarvel.utils.Constants
import edu.keepaneye.uttermarvel.utils.Constants.Companion.API_KEY
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object  RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(provideOkHttpClient())
                .build()
        }
        return retrofit!!
    }
}

private fun provideOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient.Builder()
        .addInterceptor(ApiInterceptor())
        .addInterceptor(interceptor)
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
}

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request()
        val url = req.url.newBuilder()
            .addEncodedQueryParameter("ts", Constants.timestamp)
            .addEncodedQueryParameter("apikey", API_KEY)
            .addEncodedQueryParameter("hash", Constants.hash())
            .build()
        val request = req.newBuilder().url(url).build()
        return chain.proceed(request)
    }

}