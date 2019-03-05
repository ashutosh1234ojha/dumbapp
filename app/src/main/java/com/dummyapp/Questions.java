package com.dummyapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Vector;

/**
 * Created by cl-macmini-86 on 9/28/17.
 */

public class Questions extends AppCompatActivity {

    int no = 1, count = 0;
    volatile int a = 50;
    final private int c = 6;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout);


        int a = 5;
        Number c = a;

        String bigArray[] = {"1000021020", "10021021", "1000021022", "81000021023"};
        Log.d("Tag", bigSum(4, bigArray) + "Sum");

        Vector vector = new Vector(5, 2);
        ArrayList arrayList = new ArrayList(1);
        HashSet hashSet = new HashSet(5, 2);

        int[] input = {6, 2, 5};
//        quicksort(input, 0, 2);

//        rotation();

//        nextGreaterElement();
//
//        kRuggedOrRoughNumber(11, 11);
//
//        pattern();
//
//
//        subString();

        bubble();
        Log.d("Anagram", anagram() + "");

        Log.d("Palindrem", check() + "");
        check();


        replace();

        printNo();

        removeDuplicatedWords();

        Person person = new Person();

        person.setName("ashutosh");
        Log.d("Person", person.getName() + " before passing");
        Log.d("Person", a + " before passing");
        Log.d("Person", person.getName() + " after passing");
        Log.d("Person", a + " after passing");


        print();

        pattern1(10);

    }


    void pattern1(int n) {
//        int count=10;
//        for(int i=0;i<n;i++){
//
//            for(int j=0;j<n;j++){
//
//                if(i-j>=0){
//                    System.out.print("\t");
//                }else {
//                    System.out.print(count--+" ");
//
//                }
//
//                System.out.println("\n");
//
//            }
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if((n-1)-j<=i){
                    System.out.print("*");

                }else {
                    System.out.print(" ");

                }

            }
            System.out.println("\n");

        }

    }

    private void removeDuplicatedWords() {
        String input = "ashutosh is geek is ashutosh geek";

        String[] inputArray = input.split(" ");
        HashSet<String> hashSet = new HashSet<>();

//        arrayList.addAll(Arrays.asList(inputArray));

        //            Log.d("Duplicated",  ""+inputArray[i]);
        hashSet.addAll(Arrays.asList(inputArray));

        for (final String aHashSet : hashSet) {
            Log.d("Duplicated", "" + aHashSet);

        }
//        ArrayList<String> arrayList=inputArray.a

    }

//    ArrayList<Integer> list = Arrays.stream(inputArray).boxed().collect(Collectors.toList());

    private void object(final Person person, final int a) {

        Log.d("Person", person.getName() + " before change");

        person.setName("rahul");

        Log.d("Person", person.getName() + " after change");

    }

    private void printNo() {
        int a = 3, b = 2, digit = 1;


        String output = "2,3,22,23,32,33,222,223,232,233,323,332,333";

        if (isContained(3, 2)) {
            count++;
            if (digit == count) {
                Log.d("Output", String.valueOf(no));
                Log.d("Output", String.valueOf(no).length() + " length");
                return;
            }
        }

        ++no;
        printNo();
    }

    private boolean isContained(final int... a) {
        boolean isFalse = false;

        for (int i = 0; i < String.valueOf(no).length(); i++) {
//            boolean isFalse=false;
            for (int j = 0; j < a.length; j++) {
                if ((Character.getNumericValue(String.valueOf(no).charAt(i)) == a[j])) {
                    isFalse = true;
                    break;
                } else {
                    isFalse = false;
                }
            }
            if (!isFalse)
                return false;

//            return isFalse;
        }

        return true;

    }

    private void replace() {
        String replace = "ram";
        StringBuilder replacement = new StringBuilder();
        for (int i = 0; i < replace.length(); i++) {
            replacement.append("*");
        }


        String input = "ram is a good boy. Ram need food.";

        input.replace("ram", replacement);

        String[] splittedInput = input.split(" ");

        for (int i = 0; i < splittedInput.length; i++) {

            if (replace.equalsIgnoreCase(splittedInput[i])) {
                splittedInput[i] = String.valueOf(replacement);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        String output = "";

        for (int i = 0; i < splittedInput.length; i++) {

            stringBuilder.append(splittedInput[i] + " ");

            output = output + " " + splittedInput[i];
        }
        Log.d("Output", stringBuilder + " ");
        Log.d("Output", output + " ");


    }

    private boolean check() {
        String str = "madam";
        int len = str.length();
        int min = len / 2;
        boolean isEven = len % 2 == 0;

        int count;
        if (isEven) {
            count = len / 2;
        } else {
            count = (len / 2) + 1;

        }

        for (int i = 0; i < count; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private boolean anagram() {
        String str1 = "abc";
        String str2 = "Abc";

        int diff = 0;

        if (str1.length() == str2.length()) {
            for (int i = 0; i < str1.length(); i++) {

                Log.d("Anagram", str1.charAt(i) + "  str1");
                Log.d("Anagram", str2.charAt(i) + "  str2");

                int a = str1.charAt(i);

                diff = diff + str1.charAt(i) - str2.charAt(i);
            }

            if (diff == 0) {
                return true;
            } else {
                Log.d("Anagram", diff + "  values");

                return false;
            }
        } else {
            return false;
        }
    }

    private void bubble() {
        int arr[] = {7, 2, -1, 4, 8, 0};

        Log.d("Bubble", Arrays.toString(arr) + " before sorting");

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        Log.d("Bubble", Arrays.toString(arr) + " after sorting");
    }

    /**
     * &
     * &&
     * &&&
     * &
     * &
     */
    private void pattern() {

        int arr[] = {5, 4, 3, 2, 1};

        Log.d("Tag", Arrays.toString(arr) + " before sorting");
        sort(arr, 0, arr.length - 1);

        Log.d("Tag", Arrays.toString(arr) + " after sorting");

    }

    private void sort(final int[] arr, final int start, final int end) {

//        if(end<=start){
//            return;
//        }

        if (start < end) {
            int m = (start + end) / 2;

            sort(arr, start, m);
            sort(arr, m + 1, end);
            add(arr, start, m, end);

        }

    }

    private void add(final int[] arr, final int start, final int m, final int end) {
        int left[] = new int[m + 1];
        int right[] = new int[end - m];
        int k = 0;
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[start + i];
        }


        for (int i = 0; i < right.length; i++) {
            right[i] = arr[end + start + i];
        }


        if (left.length < right.length) {
            for (int i = 0; i < left.length; i++) {

                if (left[i] < right[i]) {
                    arr[k] = left[i];
                } else {
                    arr[k] = right[i];

                }
                k++;
            }

            for (int i = left.length; i < right.length; i++) {
                arr[k] = right[i];
                k++;
            }
        } else {
            for (int i = 0; i < right.length; i++) {

                if (left[i] < right[i]) {
                    arr[k++] = left[i];
                    arr[k] = right[i];
                } else {
                    arr[k++] = right[i];
                    arr[k] = left[i];


                }
                k++;
            }

            for (int i = right.length; i < left.length; i++) {
                arr[k] = left[i];
                k++;
            }
        }
    }

    private void subString() {

        String input = "ashutosh";
        int length = input.length();

        for (int i = 0; i < length; i++) {

            for (int j = i + 1; j <= length; j++) {

                Log.d("Substring", input.substring(i, j));
            }
        }

    }

    private void kRuggedOrRoughNumber(final int n, final int k) {

        boolean isRagged = false;
        for (int i = 1; i < n; i++) {


            if (n % i == 0 && isPrime(i) && i == k) {
                isRagged = true;
//                Log.d("Ragged","is ragged true");
            }
        }

        if (isRagged) {
            Log.d("Ragged", "is ragged true");

        } else {
            Log.d("Ragged", "is ragged false");

        }
    }

    private boolean isPrime(int i) {


        for (int j = 2; j < i; j++) {

            if (i % j == 0) {
                return false;

            }
        }
        return true;
    }

    private void nextGreaterElement() {

        ArrayList<String> temp;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("4");
        arrayList.add("8");
        arrayList.add("3");
        arrayList.add("5");
        int input[] = {1, 2, 3, 4};
        int output[] = new int[4];


        Log.d("input", Arrays.toString(input) + "  input array");

        for (int i = 0; i < input.length; i++) {

            int swappingIndex = -1;
            int min = -1;
            for (int j = 0; j < input.length; j++) {

                int diff = input[j] - input[i];

                if (diff < min) {
                    swappingIndex = j;
                    min = diff;
                }

            }

            if (swappingIndex != -1) {
                output[i] = input[swappingIndex];
            }
        }


        //////////
        temp = arrayList;
        Collections.sort(arrayList);

        for (int i = 0; i < arrayList.size(); i++) {

            if (i == arrayList.size() - 1) {
                arrayList.set(i, "-");

            } else {
                arrayList.set(i, arrayList.get(i++));

            }
        }

        ArrayList<String> outputArray = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            if (arrayList.contains(temp.get(i))) {

                int index = arrayList.indexOf(temp.get(i));
                outputArray.add(arrayList.get(index));
            } else {
                outputArray.add("-");
            }
        }


        Log.d("Output", outputArray + "  output array");
    }

    /*  a[] is the array, p is starting index, that is 0,
and r is the last index of array.
 int[] input = {6, 2, 5, 1, 4};
*/

    void quicksort(int a[], int p, int r) {
        if (p < r) {
            int q;
            q = partition(a, p, r);
            quicksort(a, p, q);
            quicksort(a, q + 1, r);
        } else

            for (int i = 0; i < a.length; i++) {
                Log.d("Quick sort", a[i] + " index" + i);
            }
    }

    int partition(int a[], int p, int r) {
        int i, j, pivot, temp;
        pivot = a[p];
        i = p;
        j = r;
        while (true) {
            while (a[i] < pivot && a[i] != pivot)
                i++;
            while (a[j] > pivot && a[j] != pivot)
                j--;
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            } else {
                return i;
            }
        }
    }

    void rotation() {
        int a[] = {33, 23, 5, 6, 42, 674};
        int k = 2;
        int b[] = new int[5];

        ArrayList<Integer> input = new ArrayList<Integer>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        input.add(33);
        input.add(23);
        input.add(5);
        input.add(6);
        input.add(42);
        input.add(674);

        Log.d("Before rotation", input + "");

        for (int j = 0; j < k; j++) {
            for (int i = 0; i < input.size(); i++) {

                if (i == input.size() - 1) {
                    output.add(0, input.get(i));
                } else {
                    b[i + 1] = a[i];
                    output.add(i, input.get(i));
                }
            }

//            System.arraycopy(a, 0, b, 0, b.length);
//            b=new int[5];
            input.clear();
            input.addAll(output);

            if (j != k - 1)
                output.clear();

        }
        Log.d("after rotation", output + "");
    }


//    private int[] quickSort(final int[] input) {
//
//        int length = input.length;
//        if (length == 0) {
//            return input;
//        }
//
//        if (length == 1) {
//            return input;
//        }
//
//        int pivot = length / 2 == 0 ? length / 2 + 1 : (length + 1) / 2;
//
//
//        return sort(0, input);
//    }

    private int[] sort(final int pivot, final int[] input) {

        return null;

    }

    private void findAllThePermutations(String input) {

        int length = input.length();
        int noOfCombinations = length;

        while (length != 1) {
            length = length - 1;
            noOfCombinations = noOfCombinations * length;

        }

        Log.d("Permutations", noOfCombinations + "Total");

        for (int i = 0; i < length; i++) {

            Log.d("Permutations", input.charAt(i) + "");

        }
    }

    private void checkIfNoIsPowerOfTwo(int input) {


        while (input % 2 == 0 && input > 0) {

            if (input != 2) {
                input = input / 2;
            } else {
                input = 0;
            }
        }

        Log.d("Tag", input + "");
    }

    private void checkPalindrome(int input) {

        Log.d("Palindrome", input + " input");
        int newNumber = 0;

        while (input != 0) {
            int remainder = input % 10;
            input = input / 10;

            newNumber = newNumber * 10 + remainder;

        }

        Log.d("Palindrome", newNumber + " new number");


    }

    /**
     * 1
     * 12
     * 123
     * 1234
     * 12345
     */
    private void getTypeOne(int row) {

        for (int i = 1; i <= row; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j + "\t");
            }


            System.out.print("\n");
        }
    }


    /**
     * 1
     * 12
     * 123
     * 1234
     * 12345
     * 1234
     * 123
     * 12
     * 1
     */
    private void getTypeTwo(int row) {
        for (int i = 1; i <= row; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j + "\t");
            }


            System.out.print("\n");
        }

        for (int i = row - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "\t");
            }
            System.out.print("\n");
        }
    }

    /**
     * 11111
     * 11122
     * 11333
     * 14444
     * 55555
     */

    private void getTypeThree(int count) {

//        for(int i=1;i<=count;i++){
//
//            for(int j=1;j<=count;j++){
//
//
//                if(i+count-1==count)
//                {
//                    System.out.print(i + "\t");
//                }else {
//                    System.out.print(j + "\t");
//                }
//            }
//            System.out.print( "\n");
//        }

        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= count - i; j++) {
                System.out.print(1);
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(i);
            }
            System.out.println();
        }

    }

    public static void permuteString(String beginningString, String endingString) {
        if (endingString.length() <= 1)
            System.out.println(beginningString + endingString);
        else
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);

                    permuteString(beginningString + endingString.charAt(i), newString);
                } catch (StringIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
    }


    public void sortNumericArray(final int[] arrayInput) {

        int size = arrayInput.length;

        for (int anArrayInput : arrayInput) {
            System.out.println(" unsorted array");
            System.out.print(anArrayInput);
        }


        for (int j = 0; j <= size; j++) {
            for (int i = 0; i <= j; i++) {

                if ((i + 1) < (size - 1)) {
                    if (arrayInput[i] < arrayInput[i + 1]) {
                        int a = arrayInput[i];
                        arrayInput[i] = arrayInput[i + 1];
                        arrayInput[i + 1] = a;
                    }
                }

            }

        }


        for (int anArrayInput : arrayInput) {
            System.out.println("sorted array");
            System.out.print(anArrayInput);
        }

    }


    public String bigSum(int n, String[] ar) {
        String y = String.valueOf(ar[0]);
        int carry = 0;
        for (int i = 1; i < n; i++) {
            String x = String.valueOf(ar[i]);

//            String x = "1000000001";
//            String y = "1000000002";

            int xL = x.length();
            int yL = y.length();


            if (xL > yL) {
                String temp = "";
                int dL = xL - yL;
                for (int j = xL - 1; j >= 0; j--) {


                    if (j - dL < 0) {

                        Log.d("TAG", x.substring(0, j + 1) + " sUBTRING");
                        temp = x.substring(0, j + 1) + temp;
                    } else {

                        Log.d("Tag", j + "");
                        Log.d("Tag", (j - dL) + "");
                        int a = Integer.parseInt(x.charAt(j) + "");

                        int b = Integer.parseInt((y.charAt(j - dL) + ""));

                        String sum = String.valueOf(a + b + carry);
                        if (sum.length() > 1) {
                            carry = Integer.parseInt(sum.charAt(0) + "");

                            temp = Integer.parseInt(String.valueOf(sum.charAt(1))) + temp;
                        }
                        carry = 0;
                        temp = Integer.parseInt(String.valueOf(sum.charAt(0))) + temp;
                    }

                }

                y = temp;
            } else if (xL < yL) {

                String temp = "";
                int dL = yL - xL;
                for (int j = yL - 1; j >= 0; j--) {
                    if (j - dL < 0) {
                        Log.d("TAG", y.substring(0, j + 1) + " sUBTRING");
                        temp = y.substring(0, j + 1) + temp;
                    } else {
                        int a = Integer.parseInt(x.charAt(j - dL) + "");
                        int b = Integer.parseInt((y.charAt(j) + ""));

                        String sum = String.valueOf(a + b + carry);
                        if (sum.length() > 1) {
                            carry = Integer.parseInt(sum.charAt(0) + "");

                            temp = Integer.parseInt(String.valueOf(sum.charAt(1))) + temp;
                        }
                        carry = 0;
                        temp = Integer.parseInt(String.valueOf(sum.charAt(0))) + temp;
                    }

                }

                y = temp;

            } else {
                String temp = "";
                for (int j = xL - 1; j >= 0; j--) {
                    int a = Integer.parseInt(x.charAt(j) + "");
                    int b = Integer.parseInt((y.charAt(j) + ""));

                    String sum = String.valueOf(a + b + carry);
                    if (sum.length() > 1) {
                        carry = Integer.parseInt(sum.charAt(0) + "");

                        temp = Integer.parseInt(String.valueOf(sum.charAt(1))) + temp;
                    }
                    carry = 0;
                    temp = Integer.parseInt(String.valueOf(sum.charAt(0))) + temp;
                }
                y = temp;
            }
        }
        return y;
    }

    class Person {
        String name = "sadf";


        public Person() {

        }

        public String getName() {


            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }
    }

    void print() {
        int count = 10;
        for (int i = 0; i < 4; i++) {


            for (int j = 0; j < 4; j++) {

                if (j < i) {
                    System.out.print("\t");
                } else {
                    System.out.print("" + count--);

                }

            }
            System.out.print("\n");

        }
    }
}


