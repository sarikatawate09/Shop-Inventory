package prod;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

public class Product_Management {
	Scanner sc=new Scanner(System.in);
	
	
		String args[]= {};
		String newName ;
		String price;
		String Company_name;
		long newNumber;
		
		
		
		 String nameNumberString;
         String name;
         long number;
         String Pprice;
         int index;
         
         
	void addProduct()
	{
		try {
			 
            // Get the name of the contact to be updated
            // from the Command line argument
           
            System.out.println("Enter Product Name");
            newName=sc.next();
 
            // Get the number to be updated
            // from the Command line argument
        
            System.out.println("Enter Product Number");
            newNumber=sc.nextLong();
            System.out.println("Enter Product Price");
            price=sc.next();
            System.out.println("Enter Company Name");
            Company_name=sc.next();
            
 
           
 
            // Using file pointer creating the file.
            File file = new File("inventory.txt");
 
            if (!file.exists()) {
 
                // Create a new file if not exists.
                file.createNewFile();
            }
 
            // Opening file in reading and write mode.
 
            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");
            boolean found = false;
 
            // Checking whether the name
            // of contact already exists.
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {
 
                // reading line from the file.
                nameNumberString = raf.readLine();
 
                // splitting the string to get name and
                // number
                String[] lineSplit
                    = nameNumberString.split("!");
 
                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
 
                // if condition to find existence of record.
                if (name == newName
                    || number == newNumber) {
                    found = true;
                    break;
                }
            }
 
            if (found == false) {
 
                // Enter the if block when a record
                // is not already present in the file.
                nameNumberString
                    = newName + "!"
                      + String.valueOf(newNumber)+"!"+price+"!"+Company_name;
 
                // writeBytes function to write a string
                // as a sequence of bytes.
                raf.writeBytes(nameNumberString);
 
                // To insert the next record in new line.
                raf.writeBytes(System.lineSeparator());
                
 
                // Print the message
                System.out.println(" Product added. ");
 
                // Closing the resources.
                raf.close();
            }
            // The contact to be updated
            // could not be found
            else {
 
                // Closing the resources.
                raf.close();
 
                // Print the message
                System.out.println(" Input name"
                                   + " does not exists. ");
            }
        }
 
        catch (IOException ioe) {
 
            System.out.println(ioe);
        }
        catch (NumberFormatException nef) {
 
            System.out.println(nef);
        }
		finally {
			
			
			main(args);
		}
	}
	
	
	void buyProduct()
	{
		try {
			 
            // Get the name of the contact to be updated
            // from the Command line argument
           System.out.println("Please Enter Product Name and Product Number as shown in above Product List.....\n");
            System.out.println("Enter Product Name");
            newName=sc.next();
 
            // Get the number to be updated
            // from the Command line argument
        
            System.out.println("Enter Product Number");
            newNumber=sc.nextLong();
           
            
            String cardnumber;
            System.out.println("Enter Card Number");
            cardnumber=sc.next();
            
            String cvv;
            System.out.println("Enter CVV");
            cvv=sc.next();
           
 
            // Using file pointer creating the file.
            File file = new File("orders.txt");
 
            if (!file.exists()) {
 
                // Create a new file if not exists.
                file.createNewFile();
            }
 
            // Opening file in reading and write mode.
 
            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");
            boolean found = false;
 
            // Checking whether the name
            // of contact already exists.
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {
 
                // reading line from the file.
                nameNumberString = raf.readLine();
 
                // splitting the string to get name and
                // number
                String[] lineSplit
                    = nameNumberString.split("!");
 
                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
 
                // if condition to find existence of record.
                if (name == newName
                    || number == newNumber) {
                    found = true;
                    break;
                }
            }
 
            if (found == false) {
 
                // Enter the if block when a record
                // is not already present in the file.
                nameNumberString
                    = newName + "!"
                      + String.valueOf(newNumber)+"!"+cardnumber+"!"+cvv+"!"+price;
 
                // writeBytes function to write a string
                // as a sequence of bytes.
                raf.writeBytes(nameNumberString);
 
                // To insert the next record in new line.
                raf.writeBytes(System.lineSeparator());
                
 
                // Print the message
                System.out.println(" Product purchased. ");
 
                // Closing the resources.
                raf.close();
            }
            // The contact to be updated
            // could not be found
            else {
 
                // Closing the resources.
                raf.close();
 
                // Print the message
                System.out.println("Product"
                                   + " does not exists. ");
            }
        }
 
        catch (IOException ioe) {
 
            System.out.println(ioe);
        }
        catch (NumberFormatException nef) {
 
            System.out.println(nef);
        }
		finally {
			
			
			main(args);
		}
	}
	
	void removeProduct()
	{
		try {
			 
            // Get the name of the contact to be updated
            // from the Command line argument
           
            System.out.println("Enter Product Name");
            newName=sc.next();
 
           
 
            // Using file pointer creating the file.
            File file = new File("inventory.txt");
 
            if (!file.exists()) {
 
                // Create a new file if not exists.
                file.createNewFile();
            }
 
            // Opening file in reading and write mode.
            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");
            boolean found = false;
 
            // Checking whether the name of contact exists.
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {
 
                // reading line from the file.
                nameNumberString = raf.readLine();
 
                // splitting the string to get name and2
                
                // number
                String[] lineSplit
                    = nameNumberString.split("!");
 
                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                // if condition to find existence of record.
                if (name.equals(newName)) {
                    found = true;
                    break;
                }
            }
 
            // Delete the contact if record exists.
            if (found == true) {
 
                // Creating a temporary file
                // with file pointer as tmpFile.
                File tmpFile = new File("temp.txt");
 
                // Opening this temporary file
                // in ReadWrite Mode
                RandomAccessFile tmpraf
                    = new RandomAccessFile(tmpFile, "rw");
 
                // Set file pointer to start
                raf.seek(0);

                // Traversing the friendsContact.txt file
                while (raf.getFilePointer()
                       < raf.length()) {
 
                    // Reading the contact from the file
                    nameNumberString = raf.readLine();
 
                    index = nameNumberString.indexOf('!');
                    name = nameNumberString.substring(
                        0, index);
 
                 
				
					// Check if the fetched contact
                    // is the one to be deleted
                    if (name.equals(newName)) {
 
                        // Skip inserting this contact
                        // into the temporary file
                        continue;
                    }
             
 
                    // Add this contact in the temporary
                    // file
                    tmpraf.writeBytes(nameNumberString);
 
                    // Add the line separator in the
                    // temporary file
                    tmpraf.writeBytes(
                        System.lineSeparator());
                }
 
                // The contact has been deleted now
                // So copy the updated content from
                // the temporary file to original file.
 
                // Set both files pointers to start
                raf.seek(0);
                tmpraf.seek(0);
 
                // Copy the contents from
                // the temporary file to original file.
                while (tmpraf.getFilePointer()
                       < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
 
                // Set the length of the original file
                // to that of temporary.
                raf.setLength(tmpraf.length());
 
                // Closing the resources.
                tmpraf.close();
                raf.close();
 
                // Deleting the temporary file
                tmpFile.delete();
 
                System.out.println(" Product deleted. ");
            }
 
            // The contact to be deleted
            // could not be found
            else {
 
                // Closing the resources.
                raf.close();
 
                // Print the message
                System.out.println(" Input"
                                   + " does not exists. ");
            }
        }
 
        catch (IOException ioe) {
            System.out.println(ioe);
        }
		finally {
			
			
			main(args);
		}
	}
	void displayProduct()
	{

        try {
 
           
 
            // Using file pointer creating the file.
            File file = new File("inventory.txt");
 
            if (!file.exists()) {
 
                // Create a new file if not exists.
                file.createNewFile();
            }
 
            // Opening file in reading and write mode.
 
            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");
            boolean found = false;
 
            // Traversing the file
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {
 
                // reading line from the file.
                nameNumberString = raf.readLine();
 
                // splitting the string to get name and
                // number
                String[] lineSplit
                    = nameNumberString.split("!");
 
                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
                Pprice =lineSplit[2];
                Company_name=lineSplit[3];
                
                // Print the contact data
                System.out.println(
                    "Prodct Name: " + name + "\n"
                    + "Product Number: " + number + "\n"
                    + "Product Price: " + Pprice + "\n"
                    + "Product Company_Name: " + Company_name + "\n");
            }
        }
 
            catch (IOException ioe)
            {
 
                System.out.println(ioe);
            }
            catch (NumberFormatException nef)
            {
 
                System.out.println(nef);
            }
      
        
	}
	
	void updateProduct()
	{
		 try {
			 
	            // Get the name of the contact to be updated
	            // from the Command line argument
		
	            System.out.println("Enter Product Id whose data want to Update");
	            newNumber=sc.nextLong();
	            
	         
	            System.out.println("Enter Product Name whose data want to Update");
	            newName=sc.next();
	 
	            // Get the number to be updated
	            // from the Command line argument
	           
	 
	           
	 
	            // Using file pointer creating the file.
	            File file = new File("inventory.txt");
	 
	            if (!file.exists()) {
	 
	                // Create a new file if not exists.
	                file.createNewFile();
	            }
	 
	            // Opening file in reading and write mode.
	            RandomAccessFile raf
	                = new RandomAccessFile(file, "rw");
	            boolean found = false;
	 
	            // Checking whether the name
	            // of contact already exists.
	            // getFilePointer() give the current offset
	            // value from start of the file.
	            while (raf.getFilePointer() < raf.length()) {
	 
	                // reading line from the file.
	                nameNumberString = raf.readLine();
	 
	                // splitting the string to get name and
	                // number
	                String[] lineSplit
	                    = nameNumberString.split("!");
	 
	                // separating name and number.
	                name = lineSplit[0];
	                number = Long.parseLong(lineSplit[1]);
	 
	                // if condition to find existence of record.
	                if (number == newNumber) {
	                    found = true;
	                    break;
	                }
	            }
	 
	            // Update the contact if record exists.
	            if (found == true) {
	 
	                // Creating a temporary file
	                // with file pointer as tmpFile.
	                File tmpFile = new File("temp.txt");
	 
	                // Opening this temporary file
	                // in ReadWrite Mode
	                RandomAccessFile tmpraf
	                    = new RandomAccessFile(tmpFile, "rw");
	 
	                // Set file pointer to start
	                raf.seek(0);
	 
	                // Traversing the friendsContact.txt file
	                while (raf.getFilePointer()
	                       < raf.length()) {
	 
	                    // Reading the contact from the file
	                    nameNumberString = raf.readLine();
	 
	                    index = nameNumberString.indexOf('!');
	                    name = nameNumberString.substring(
	                        0, index);
	 
	                    // Check if the fetched contact
	                    // is the one to be updated
	                    if (name.equals(newName)) {
	 
	                        // Update the number of this contact
	                        nameNumberString
	                            = name + "!"
	                              + String.valueOf(newNumber);
	                    }
	 
	                    // Add this contact in the temporary
	                    // file
	                    tmpraf.writeBytes(nameNumberString);
	 
	                    // Add the line separator in the
	                    // temporary file
	                    tmpraf.writeBytes(
	                        System.lineSeparator());
	                }
	 
	                // The contact has been updated now
	                // So copy the updated content from
	                // the temporary file to original file.
	 
	                // Set both files pointers to start
	                raf.seek(0);
	                tmpraf.seek(0);
	 
	                // Copy the contents from
	                // the temporary file to original file.
	                while (tmpraf.getFilePointer()
	                       < tmpraf.length()) {
	                    raf.writeBytes(tmpraf.readLine());
	                    raf.writeBytes(System.lineSeparator());
	                }
	 
	                // Set the length of the original file
	                // to that of temporary.
	                raf.setLength(tmpraf.length());
	 
	                // Closing the resources.
	                tmpraf.close();
	                raf.close();
	 
	                // Deleting the temporary file
	                tmpFile.delete();
	 
	                System.out.println("Product updated. ");
	            }
	 
	            // The contact to be updated
	            // could not be found
	            else {
	 
	                // Closing the resources.
	                raf.close();
	 
	                // Print the message
	                System.out.println(" Input name"
	                                   + " does not exists. ");
	            }
	        }
	 
	        catch (IOException ioe) {
	            System.out.println(ioe);
	        }
	 
	        catch (NumberFormatException nef) {
	            System.out.println(nef);
	        }
		 finally {
				
				
				main(args);
			}
	}
	
	void displayProductByName()
	{

        try {
        	
        
            System.out.println("Enter Product Name");
            newName=sc.next();
 
        	
 
            // Using file pointer creating the file.
            File file = new File("inventory.txt");
 
            if (!file.exists()) {
 
                // Create a new file if not exists.
                file.createNewFile();
            }
 
            // Opening file in reading and write mode.
 
            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");
            boolean found = false;
 
            // Traversing the file
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {
 
                // reading line from the file.
                nameNumberString = raf.readLine();
 
                // splitting the string to get name and
                // number
                String[] lineSplit
                    = nameNumberString.split("!");
 
                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
                price = lineSplit[2];
                Company_name = lineSplit[3];
                if(name.equals(newName)) {
                // Print the contact data
                System.out.println(
                    "Product Name: " + name + "\n"
                    + "Product Number: " + number + "\n"
                    + "Product Price " + price + "\n"
                    + "Company_Name: " + Company_name + "\n");
                }
                else
                {
                	System.out.println("Invalid Name");
                }
            }
        }
 
            catch (IOException ioe)
            {
 
                System.out.println(ioe);
            }
            catch (NumberFormatException nef)
            {
 
                System.out.println(nef);
            }
        finally {
		
			
			main(args);
		}
        
	}
	public static void main(String args [])
	{
		Scanner sc=new Scanner(System.in);
		Product_Management pm=new Product_Management();
		int i;
		System.out.println("Welcome Users!!! Select your role \n 1. Customer \n 2.Shopkeeper");
		i=sc.nextInt();
		
		
		switch(i)
		{
		case 1:
			System.out.println("Hey Customer!!! What you want to do......... \n 1.See All Products \n 2.Search Product By Nmae \n 3.Buy Product ");
			i=sc.nextInt();
			switch(i)
			{
			case 1:
				pm.displayProduct();
				break;
			case 2:
				pm.displayProductByName();
				break;
			case 3:
				pm.displayProduct();
				pm.buyProduct();
				break;
			default:
				System.out.println("Invalid Choice");
				main(args);
			}
			
			
			break;
		case 2:
			
			System.out.println("Hey shopkeeper !!! What you want do............\n 1.Add new Product \n 2. Remove Product By Name \n 3.List of All Products \n 4.Search the Product by Name \n 5.Edit Product By Id");
			i=sc.nextInt();
			switch(i)
			{
			case 1:
				pm.addProduct();
				break;
			case 2:
				pm.removeProduct();
				break;
			case 3:
				pm.displayProduct();
				break;
			case 4:
				pm.displayProductByName();
				break;
			case 5:
				pm.updateProduct();
				break;
				default:
					System.out.println("Invalid Choice");
					main(args);
					
				
				
			}
			
			break;
			default:
				System.out.println("Invalid Choice");
				main(args);
				
		}
		sc.close();
	}

}
