package org.alvas.driver;
import java.util.*;

import org.alvas.service.service;
public class Driver {

	public static void main(String[] args) {
		boolean flag=true;
		
		System.out.println(" WELCOME TO HOSPITAL DATABASE MANAGEMENT SYSTEM ");
		
		while(flag) {
		
		System.out.println(" SELECT WHICH OPERATION YOU WANT TO PERFORM ");
		
		System.out.println(" 1. INSERT DOCTOR DATA " + "\n");
		System.out.println(" 2. UPDATE DOCTOR DATA " + "\n");
		System.out.println(" 3. DELETE DOCTOR DATA " + "\n");
		System.out.println(" 4. DISPLAY DOCTOR DATA " + "\n");
		System.out.println(" 5. EXIT" + "\n");
		
		Scanner sc=new Scanner(System.in);
		int select=sc.nextInt();
		
		
		switch(select) {
		case 1:{
			service.saveData();
			System.out.println(" DATA STORED SUCCESFULLY ");
		}
			break;
		case 2:{
			service.updateData();
			System.out.println(" DATA UPDATED SUCCESFULLY ");
		}
			break;
		case 3:{
			service.deleteData();
			System.out.println(" DATA DELETED SUCCESFULLY ");
		}
			break;
		case 4:{
			service.displayData();
			System.out.println(" DATA DISPLAYED SUCCESFULLY ");
		}
		break;
        case 5:
            System.out.println("DO YOU WANT TO EXIT? 1. YES 2. NO");
            int exitChoice = sc.nextInt();
            if (exitChoice == 1) {
                flag = false;
                System.out.println("THANK YOU FOR USING OUR APPLICATION");
            }
            break;
        default:
            System.out.println("INVALID CREDENTIALS");
    }
}

	}
}