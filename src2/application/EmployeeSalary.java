package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import entities.Employee;

public class EmployeeSalary {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		System.out.print("Enter reference salary: ");
		double referenceSalary = sc.nextDouble();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Employee> list = new ArrayList<>();
			
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			List<String> emails = list.stream().filter(x -> x.getSalary() > referenceSalary).map(x -> x.getEmail()).sorted().collect(Collectors.toList());
			
			System.out.println("\nEmail of people whose salary is more than " + String.format("%.2f", referenceSalary) + ":");
			emails.forEach(System.out::println);
			
			System.out.print("\nEnter the first letter of a valid name: ");
			char c = sc.next().toUpperCase().charAt(0);
			
			double sum = list.stream().filter(x -> x.getName().charAt(0) == c).map(x -> x.getSalary()).reduce(0.0, (x, y) -> x + y);
			
			System.out.println("Sum of salary from people whose name starts with " + c + ": " + String.format("%.2f", sum));
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
