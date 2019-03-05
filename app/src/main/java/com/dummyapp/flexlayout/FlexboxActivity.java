package com.dummyapp.flexlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dummyapp.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by Ashutosh Ojha on 5/15/18.
 */

public class FlexboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexbox);

        HashSet<Integer> hashSet=new HashSet<>();
        hashSet.add(5);
//        Log.d("Tag","next Iterator");
        ArrayList<Integer> arrayList=new ArrayList<>(6);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        LinkedList<Integer> linkedList=new LinkedList<>();
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(3);

        Stack<Integer> stack=new Stack<>();
        stack.push(2);
        stack.push(3);

        Log.d("Tag","Stack size"+stack.size());

        Log.d("Tag","Stack"+stack.pop());
        Log.d("Tag","Stack size"+stack.size());
        Log.d("Tag","Stack"+stack.pop());
        Log.d("Tag","Stack size"+stack.size());


        HashSet<String> hashSet1=new HashSet();
        hashSet1.add("ram");
        hashSet1.add("shaym");
        hashSet1.add("ashu");

       Set<String> integers= new TreeSet<String>(hashSet1);

        System.out.println(hashSet1+ " set");
        System.out.println(integers+ " se1t");

        LinkedHashSet<String> linkedHashSet=new LinkedHashSet<>();
        linkedHashSet.add("1");
        linkedHashSet.add("2");
        linkedHashSet.add("1");


        Log.d("Tag","linked hash size"+linkedHashSet);

        ArrayList arrayList1=new ArrayList<String>();
        arrayList1.add("a");
        arrayList1.add(1);

        for(Object o:arrayList1){
            Log.d("Tag","Heterogenou"+o);

        }

        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();

        System.out.println("String :"+s);

    }
}
