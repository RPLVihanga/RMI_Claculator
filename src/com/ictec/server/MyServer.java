package com.ictec.server;

import com.ictec.calc.Calculator;
import com.ictec.calc.MyCalculator;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyServer {
    public static void main(String[] args) {

        try {
            //1. Create the registry
            Registry myReg = LocateRegistry.createRegistry(54321);
            //2. Binding the remote object
            Calculator myCal = new MyCalculator();
            myReg.rebind("MyCalculatorServer", myCal);

            //To identify server is running
            System.out.println("My Calculator Server is Running...");
        } catch (RemoteException e) {
            System.out.println("Exception in creating registry..." + e.getMessage());
        }
    }
}
