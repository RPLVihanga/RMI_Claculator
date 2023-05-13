package com.ictec.client;

import com.ictec.calc.Calculator;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try {
            //1. Locate the registry
            Registry myReg = LocateRegistry.getRegistry("localhost",54321);
            //2. Locating the remote object
            Calculator myCal = (Calculator) myReg.lookup("MyCalculatorServer");
            //3. Invoke the methods
            Scanner scanner = new Scanner(System.in);

            System.out.println("Java RMI Calculator");
            System.out.println("Available Operations");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("Enter operation number: ");

            int op =scanner.nextInt();

            System.out.println("Enter the first number: ");
            int x = scanner.nextInt();

            System.out.println("Enter the second number: ");
            int y = scanner.nextInt();

            int result = 0;

            switch (op){
                case 1:
                    result=myCal.addTwoIntegers(x,y);
                    break;
                case 2:
                    result=myCal.subtractTwoIntegers(x,y);
                    break;
                case 3:
                    result=myCal.multiplyTwoIntegers(x,y);
                    break;
                case 4:
                    result=myCal.divideTwoIntegers(x,y);
                    break;
                default:
                    System.out.println("Invalid operation");
                    System.exit(1);
            }

            System.out.println("Result is : " +result);
            scanner.close();

        } catch (RemoteException e) {
            System.out.println("Exception in Client..."+ e.getMessage());
        } catch (NotBoundException e) {
            System.out.println("Remote object not bound..."+ e.getMessage());
        }catch (ArithmeticException e){
            System.out.println("Divide by Zero..."+ e.getMessage());
        }
    }
}
