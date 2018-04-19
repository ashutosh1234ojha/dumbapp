package com.dummyapp.rxjava.rxretrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dummyapp.R;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ashutosh Ojha on 4/17/18.
 */

public class RxRetrofitActivity extends AppCompatActivity {

    private Button btnRx;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        btnRx=findViewById(R.id.btnRx);

        btnRx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                setRetrofit();
            }
        });

    }

    private void setRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://dummy.restapiexample.com/")
                .client(client)
                .build();

        WeatherSerivce weatherSerivce=retrofit.create(WeatherSerivce.class);

        Observable<WeatherData> observable=weatherSerivce.getWeatherReport();

        observable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<WeatherData>() {
            @Override
            public void onSubscribe(final Disposable d) {
                Log.d("Tag",d.toString()+"   onSubscribe");

            }

            @Override
            public void onNext(final WeatherData weatherData) {

                Log.d("Tag",weatherData.getId()+"   onNext");
            }

            @Override
            public void onError(final Throwable e) {
                Log.d("Tag",e.getMessage()+"   onError");

            }

            @Override
            public void onComplete() {
                Log.d("Tag","onComplete");

            }
        });

    }

}
