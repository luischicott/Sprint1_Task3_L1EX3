package n1exercici3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class S1_T3_N1EX3_Luis_Chicott {
	
	static ArrayList<String> countriesKeys = new ArrayList(); 
	static HashMap<String, String> countries = new HashMap<>();

	public static void main(String[] args) {
		
		String name; 
		String capital; 
		int score = 0; 
		loadCountriesFromFile("countries.txt");

		Scanner input = new Scanner(System.in); 

	    
		
        
     countriesKeys.addAll(countries.keySet()); 
       
       	name = JOptionPane.showInputDialog("Ingrese su nombre:");
       	
        
        for (int i = 0; i < 10; i++) {
        	String randomCountry = randomCountry(); 
        	String randomCapital = countries.get(randomCountry);
        	capital = JOptionPane.showInputDialog(name + ", diga la capital de " + randomCountry ); 
        	
        	if (capital.equalsIgnoreCase(randomCapital)) {
        		JOptionPane.showMessageDialog(null, "¡Correcto! Has sumado 1 punto");
                score++;
            } else {
            	JOptionPane.showMessageDialog(null, "Incorrecto. La capital correcta es: " + randomCapital);
            }
        }
        
        result(name,score); 
        
  
        }

	
	
	public static String randomCountry() {
        Random randomCountry = new Random();
        return  countriesKeys.get(randomCountry.nextInt(countriesKeys.size()));

    }
	
	public static void result(String name, int score) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt", true));
            writer.write("Nombre: " + name + " - Puntos: " + score + "\n");
            writer.close();
            System.out.println("Resultado guardado en el archivo 'result.txt'.");
        } catch (IOException e) {
            System.out.println("Error al guardar el resultado en el archivo.");
            e.printStackTrace();
        }
    }
	
	
	public static void loadCountriesFromFile(String filename) {
	    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            int spaceIndex = line.indexOf(' ');
	            if (spaceIndex != -1) {
	                String country = line.substring(0, spaceIndex);
	                String capital = line.substring(spaceIndex + 1);
	                countries.put(country, capital);
	                countriesKeys.add(country);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


}
