package comparatorComparable;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by Ashutosh Ojha on 5/17/18.
 */

public class Student implements Comparable<Student>{
    int rollNo;
    String name;

    public Student(final int rollNo, final String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(final int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }


    @Override
    public int compareTo(@NonNull final Student student) { return this.rollNo-student.rollNo; }


    public static Comparator<Student> nameComparator=new Comparator<Student>() {
        @Override
        public int compare(final Student student, final Student t1) {
            return student.name.compareTo(t1.getName());
        }
    };


    public static Comparator<Student> rollNoComparator=new Comparator<Student>() {
        @Override
        public int compare(final Student student, final Student t1) {
            return student.getRollNo()-t1.getRollNo();
        }
    };


    @Override
    public String toString() {
        return "Name :"+this.name+" "+"Roll No: "+this.rollNo;
    }
}
