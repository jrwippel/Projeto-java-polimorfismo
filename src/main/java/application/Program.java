package application;

import entities.Employee;
import entities.OutsourceEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i =0; i < n;++i){
            System.out.println("Employee #"+(i+1)+" data:");
            System.out.print("Outsourced (y/n)?");
            char ch = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours:");
            Integer hour = sc.nextInt();
            System.out.print("Value per hour:");
            Double valuePerHour = sc.nextDouble();

            if (ch == 'n') {
                Employee employee = new Employee(name, hour, valuePerHour);
                employeeList.add(employee);

            }else{
                System.out.print("Additional charge:");
                double addCharge = sc.nextDouble();
                OutsourceEmployee employee = new OutsourceEmployee(name, hour, valuePerHour, addCharge);
                employeeList.add(employee);
            }
        }

        System.out.println();
        System.out.println("PAYMENTS:");
        for (Employee emp : employeeList){
            System.out.println(emp.getName()+" - $ "+ String.format("%.2f%n", emp.payment()));

        }

        sc.close();

    }
}
