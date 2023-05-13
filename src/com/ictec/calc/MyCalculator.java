package com.ictec.calc;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyCalculator extends UnicastRemoteObject implements Calculator {

    public MyCalculator() throws RemoteException {
        super();
    }

    @Override
    public int addTwoIntegers(int x, int y) throws RemoteException {
        return x+y ;
    }

    @Override
    public int subtractTwoIntegers(int x, int y) throws RemoteException {
        return x-y;
    }

    @Override
    public int multiplyTwoIntegers(int x, int y) throws RemoteException {
        return x*y;
    }

    @Override
    public int divideTwoIntegers(int x, int y) throws RemoteException,ArithmeticException {
        return x/y;
    }
}
