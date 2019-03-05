package comparatorComparable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dummyapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ashutosh Ojha on 5/17/18.
 */

public class ComparatorComparableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Student[] students={new Student(2,"ram"),new Student(1,"ahyam")};


        Integer integer=new Integer(5);

        for(Student student:students){
            Log.d("TAG",student+" array");
        }

        Arrays.sort(students,Student.nameComparator);

        for(Student student:students){
            Log.d("TAG",student+"sorted array");
        }

        List<String> stringList= Collections.synchronizedList(new ArrayList<>());
    }


    class Parent{
       public int a;

        int get(){
            return a;
        }
    }

    class Child extends Parent{
        int b;



        @Override
        int get() {
            return super.get();
        }

        ;

    }
}
