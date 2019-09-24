package com.weisente.hook;

import com.saurik.substrate.MS;
import com.saurik.substrate.MS.MethodHook;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Copyright (C)
 *
 * FileName: Main
 *
 * Author: san
 *
 * Date: 2019-09-24 14:57
 *
 * Description: ${DESCRIPTION}
 */
public class Main {
  static void initialize(){
    MS.hookClassLoad("com.weisente.myapplication.MainActivity", new MS.ClassLoadHook() {
      public void classLoaded(Class<?> _class) {
        Method text;
        try {
          text = _class.getMethod("str");

        }catch (Exception e){
          text = null;
        }
        if(text != null){
          MS.MethodPointer<Object, Object> objectObjectMethodPointer = new MS.MethodPointer<>();
          MS.hookMethod(_class,text, new MethodHook<Object,Object>() {
            @Override public Object invoked(Object o, Object... objects) throws Throwable {
              return "hhh";
            }
          },objectObjectMethodPointer);

        }
      }
    });
  }
}
