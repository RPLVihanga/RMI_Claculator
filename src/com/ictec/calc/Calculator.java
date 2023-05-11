package com.ictec.calc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    //Add two integers
    public int addTwoIntegers(int x, int y) throws RemoteException;

    public int subtractTwoIntegers(int x, int y) throws RemoteException;

    public int multiplyTwoIntegers(int x, int y) throws RemoteException;

    public int divideTwoIntegers(int x, int y) throws RemoteException;

}
