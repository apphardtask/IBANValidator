package com.example.myapplication.networking

import com.example.ibanvalidator.APILayerKey
import com.example.ibanvalidator.BASE_URL
import com.example.ibanvalidator.SHA256_1
import com.example.ibanvalidator.SHA256_2
import com.example.ibanvalidator.SHA256_3
import com.example.ibanvalidator.SHA256_4
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Collections
import java.util.concurrent.TimeUnit


class JetPackAPICall {

    companion object {

        lateinit var retrofit: Retrofit

        private fun getClient(): Retrofit {

//            val url = URL(BASE_URL)
//            val serverHostname = url.host
//            val connection = url.openConnection() as HttpsURLConnection
//            connection.sslSocketFactory = TrustKit.getInstance().getSSLSocketFactory(serverHostname)

            val certificatePinner: CertificatePinner = CertificatePinner.Builder()
                .add(BASE_URL.replace("https://", ""), SHA256_1)
                .add(BASE_URL.replace("https://", ""), SHA256_2)
                .add(BASE_URL.replace("https://", ""), SHA256_3)
                .add(BASE_URL.replace("https://", ""), SHA256_4)
                .build()

            val interceptor = HttpLoggingInterceptor()

            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .certificatePinner(certificatePinner)
                .connectTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .addInterceptor(Interceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                        .addHeader("apikey", APILayerKey)
                        .build()
                    chain.proceed(newRequest)
                })
                .protocols(Collections.singletonList(Protocol.HTTP_1_1))
                .addInterceptor(interceptor)
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit
        }

        fun apiInterface(): JetPackAPIInterface? {
            return getClient().create(JetPackAPIInterface::class.java)
        }

    }

}