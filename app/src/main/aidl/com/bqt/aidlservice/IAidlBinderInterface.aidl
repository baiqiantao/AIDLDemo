package com.bqt.aidlservice;
interface IAidlBinderInterface {
    boolean callMethodInService(in int money);//Primitives are in by default , and connot be otherwise
}