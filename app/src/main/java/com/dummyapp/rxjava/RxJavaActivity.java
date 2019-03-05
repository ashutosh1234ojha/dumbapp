package com.dummyapp.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dummyapp.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;


/**
 * Created by cl-macmini-86 on 7/12/17.
 */

public class RxJavaActivity extends AppCompatActivity {

    private TextView tvRx, tvRxTwo;
    private Button btnRx;
    private String msg;
    private Observable<String> observable;
    private EditText etEmail;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        tvRxTwo = (TextView) findViewById(R.id.tvRxTwo);
        tvRx = (TextView) findViewById(R.id.tvRx);
        btnRx = (Button) findViewById(R.id.btnRx);
        etEmail = findViewById(R.id.etEmail);

        btnRx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                String[] strArray = {"a", "b"};

                observable = Observable.fromArray(strArray);

//                observable = Observable.just("ONE", "TWO");

                observer();
                consumer();
                single();

                timer();
                textWatcher();

                distinct();

                int arr[] = {4, 3, 2, 1};

                fun(arr, 0, 3);
            }
        });
    }

    private void distinct() {
        Observable<Integer> observable=Observable.just(1,2,3,4,5,6,7,8,9,12);
        Observable<String> observable1=Observable.just("a","b","c","d","e","f","g","h","i");

        Observable observable2=Observable.merge(observable,observable1);

        observable2.subscribe(new Observer<Object>() {
           @Override
           public void onSubscribe(final Disposable d) {

           }

           @Override
           public void onNext(final Object integer) {

               Log.d("Merge",integer+"@ ");
           }

           @Override
           public void onError(final Throwable e) {

           }

           @Override
           public void onComplete() {

           }
       });

    }

    private void fun(final int[] arr, final int startIndex, final int endIndex) {

        if (startIndex < endIndex) {
            return;
        }

        int mid = (startIndex + endIndex) / 2;
        fun(arr, startIndex, mid);
        fun(arr, mid + 1, endIndex);

        add(arr, startIndex, mid, endIndex);

    }

    private void add(final int[] arr, final int startIndex, final int mid, final int endIndex) {

        int left[] = new int[mid + 1];
        int right[] = new int[endIndex + 1];

        System.arraycopy(arr, 0, left, 0, mid);

        System.arraycopy(arr, 0, right, 0, endIndex);


        if (left.length > right.length) {

            for (int i = 0; i < left.length; i++) {

                if (left[i] < right[i]) {
                    arr[i] = left[i];
                } else {

                }
            }
        }


    }

    private void textWatcher() {


        final PublishSubject<String> publishSubject = PublishSubject.create();
        final ReplaySubject<String> replaySubject = ReplaySubject.create();


        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

            }

            @Override
            public void onTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {

                replaySubject.onNext(editable.toString());
            }
        });

//        publishSubject.subscribe(new Consumer<String>() {
//            @Override
//            public void accept(final String name) throws Exception {
//
//
//                if(name.length()<2){
//                    etEmail.setError("atleast two char");
//                }else if(name.contains("@")){
//                    etEmail.setError("special char not allowed");
//
//                }
//            }
//        });

        replaySubject.subscribe((String name) -> {
            if (name.length() < 2) {
                etEmail.setError("atleast two char");
            } else if (name.contains("@")) {
                etEmail.setError("special char not allowed");

                replaySubject.subscribe(getObserver());

            }

        });
    }

    Observer<String> getObserver() {


        return new Observer<String>() {
            @Override
            public void onSubscribe(final Disposable d) {

            }

            @Override
            public void onNext(final String s) {

                tvRxTwo.setText(s);
            }

            @Override
            public void onError(final Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


    }

    private void timer() {

        Observable<Integer> observable = Observable.just(2);


    }


    private void single() {
//        Single<Integer> single=new Single<Integer>() {
//            @Override
//            protected void subscribeActual(final SingleObserver<? super Integer> observer) {
//
//            }
//        };

        Single<Integer> single = Single.just(12);
        SingleObserver<Integer> singleObserver = new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(final Disposable d) {

            }

            @Override
            public void onSuccess(final Integer integer) {
                Log.d("RX", "single" + integer);
            }

            @Override
            public void onError(final Throwable e) {

            }
        };


        single.subscribe(singleObserver);

    }

    private void consumer() {

//        Consumer<String> consumer=new Consumer<String>() {
//            @Override
//            public void accept(final String s) {
//                Log.d("RX","accept"+s);
//            }
//        };

//        Consumer<String> consumer=(String s)-> Log.d("RX","accept"+s);

        observable.subscribe(s -> {
            Log.d("RX", "accept" + s);
        });


    }

    private void observer() {

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(final Disposable d) {
                Log.d("RX", "onSubscribe");

            }

            @Override
            public void onNext(final String s) {

                Log.d("RX", s);
            }

            @Override
            public void onError(final Throwable e) {
                Log.d("RX", e.getMessage());

            }

            @Override
            public void onComplete() {
                Log.d("RX", "complete");
            }
        };

        observable.subscribe(observer);
    }


}