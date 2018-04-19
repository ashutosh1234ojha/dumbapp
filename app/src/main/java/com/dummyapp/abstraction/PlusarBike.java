package com.dummyapp.abstraction;

import java.lang.ref.WeakReference;

/**
 * Created by Ashutosh Ojha on 3/6/18.
 */

public abstract class PlusarBike  {

 abstract void  ab();
  void  ed(){

  }

  static  void  met(){
      Bike bike=new Bike();
      WeakReference<Bike> weakReference=new WeakReference<Bike>(bike);

      Runnable runnable=()->{};

      Runnable r=new Runnable() {
          @Override
          public void run() {

          }
      };

  }



}
