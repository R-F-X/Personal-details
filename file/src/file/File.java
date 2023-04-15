package file;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class File {
     
    Scanner userIn = new Scanner(System.in);

    // ATTRIBUTES
    String name, surname, dob;
    double mass, height, bmi;
    int idNum;
    
    
    // METHODS
    public void uInput(){
        System.out.print("Enter your name: ");
        name = userIn.nextLine();
        // System.out.println("> " + name);

        System.out.print("Enter your surname: ");
        surname = userIn.nextLine();
        
        System.out.print("Enter your DOB (dd/mm/yyyy): ");
        dob = userIn.nextLine();

        System.out.print("Enter your ID number: ");
        idNum = userIn.nextInt();
        
        System.out.print("Enter your mass (kg): ");
        mass = userIn.nextDouble();
        
        System.out.print("Enter your height (cm): ");
        height = userIn.nextDouble();
    }


    public double bmiCalc(double m, double h){
        h = h/ 100;
        bmi = m / (Math.pow(h, 2)); 
        return bmi; 
    }
    
    public String bmiDetails(){
        double num = bmiCalc(mass, height);
        String result = "";
        
        if (num < 18.5){
            // System.out.println("Underweight");
            result = "Underweight"; 
        }
        else if (num > 18.5 && num < 24.9){
            result = "Healthy weight"; 

        }
        else if (num > 25 && num < 29.9){
            result =  "Overweight"; 

        }
        else if (num > 30){
            result = "Obese"; 
        }
        
        return result; 
    }
     
    
    public void record() {

//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter("new.txt"));
//            bw.write("testing...");
//            bw.write("\nName: " + name);
//            bw.write("\nSurname: " + surname);
//            bw.close();
//    }
       
        // appending to the same text file
        try (FileWriter fw = new FileWriter("myfile.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) 
        {
                out.println("");
                
                bw.write("\nName: \t\t" + name);
                bw.write("\nSurname: \t" + surname);
                bw.write("\nDOB: \t\t" + dob);
                bw.write("\nID number: \t" + idNum);
                bw.write("\nMass: \t\t" + mass + " kg");
                bw.write("\nHeight: \t" + height + " cm");
                
                double bmi1 = bmiCalc(mass, height); 
                bmi1 = (Math.round(bmi1 * 100)) / 100;
                bw.write("\nBMI: \t\t" + bmi1 + " (" + bmiDetails() + ")");

                String line = "\n===============================================\n";
                bw.write(line);
                
                System.out.println("\n*Details recorded*");
            } 
            
        catch (Exception e) {
            System.out.println("\n*An error has occurred*");
        }
    }
}
