package org.pbreakers.mobile.marvelheros.data.network.provider

import android.os.Debug
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.pbreakers.mobile.marvelheros.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import java.util.concurrent.TimeUnit

fun makeRetrofit(): Retrofit = Retrofit.Builder()
    .baseUrl("http://gateway.marvel.com/v1/public/")
    .client(makeHttpClient())
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

fun makeHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(60, TimeUnit.SECONDS)
    .readTimeout(60, TimeUnit.SECONDS)
    .addInterceptor(makeHeaderInterceptor())
    .addInterceptor(makeAddSecurityQueryInterceptor())
    .addInterceptor(makeLoggingInterceptor())
    .build()

fun makeAddSecurityQueryInterceptor(): Interceptor = Interceptor {

    val originalRequest = it.request()
    val timeStamp = System.currentTimeMillis()

    // Add query to the url
    val url = originalRequest.url().newBuilder()
        .addQueryParameter("apiKey", BuildConfig.PUBLIC_KEY)
        .addQueryParameter("ts", "$timeStamp")
        .addQueryParameter("hash", calculatedMd5("$timeStamp" + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY))
        .build()

    val newRequest = originalRequest
        .newBuilder()
        .url(url)
        .build()

    return@Interceptor it.proceed(newRequest)
}

fun makeLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
}

fun makeHeaderInterceptor(): Interceptor = Interceptor {
    it.proceed(it.request().newBuilder()
        .addHeader("Accept", "application/json")
        .addHeader("Accept-Language", "en")
        .addHeader("Content-Type", "application/json").build()
    )
}


fun calculatedMd5(text: String): String {
    val messageDigest = getMd5Digest(text)
    val md5 = BigInteger(1, messageDigest).toString(16)
    return "0" * (32 - md5.length) + md5 // 1
}

private fun getMd5Digest(str: String): ByteArray = MessageDigest.getInstance("MD5").digest(str.toByteArray())

private operator fun String.times(i: Int) = (1..i).fold("") { acc, _ -> acc + this }