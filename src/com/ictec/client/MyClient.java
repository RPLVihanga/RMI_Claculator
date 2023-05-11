package com.ictec.client;

import com.ictec.calc.Calculator;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient {
    public static void main(String[] args) {
        try {
            //1. Locate the registry
            Registry myReg = LocateRegistry.getRegistry("localhost",54321);
            //2. Locating the remote object
            Calculator myCal = (Calculator) myReg.lookup("MyCalculatorServer");
            //3. Invoke the methods
            int addition = myCal.addTwoIntegers(12,20);
            System.out.println("Addition of Two Numbers : "+addition);

            int subtraction = myCal.subtractTwoIntegers(12,20);
            System.out.println("Subtract of Two Numbers : "+subtraction);

            int multiplication = myCal.multiplyTwoIntegers(12,20);
            System.out.println("Multiply of Two Numbers : "+multiplication);

            int division = myCal.divideTwoIntegers(12,0);
            System.out.println("Divide of Two Numbers : "+division);

        } catch (RemoteException e) {
            System.out.println("Exception in Client..."+ e.getMessage());
        } catch (NotBoundException e) {
            System.out.println("Remote object not bound..."+ e.getMessage());
        }catch (ArithmeticException e){
            System.out.println("Divide by Zero..."+ e.getMessage());
        }
    }
}
