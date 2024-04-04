package n1exercici3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class S1_T3_N1EX3_Luis_Chicott {
	
	static ArrayList<String> countriesKeys = new ArrayList(); 

	public static void main(String[] args) {
		
		String name; 
		String capital; 
		int score = 0; 
		HashMap<String, String> countries = new HashMap<>();

		Scanner input = new Scanner(System.in); 
		
		countries.put("Albania", "Tirana"); 
		countries.put("Andorra", "Andorra_la_Vella");
        countries.put("Armenia", "Ereván");
        countries.put("Austria", "Vienna");
        countries.put("Azerbaijan", "Baku");
        countries.put("Belarus", "Minsk");
        countries.put("Belgium", "Brussels");
        countries.put("Bosnia_and_Herzegovina", "Sarajevo");
        countries.put("Bulgaria", "Sofia");
        countries.put("Croatia", "Zagreb");
        countries.put("Cyprus", "Nicosia");
        countries.put("Czechia", "Prague");
        countries.put("Denmark", "Copenhagen");
        countries.put("Estonia", "Tallin");
        countries.put("Finland", "Helsinki");
        countries.put("France", "Paris");
        countries.put("Georgia", "Atlanta");
        countries.put("Germany", "Berlin");
        countries.put("Greece", "Athens");
        countries.put("Hungary", "Budapest");
        countries.put("Iceland", "Reikiavik");
        countries.put("Ireland", "Dublin");
        countries.put("Italy", "Rome");
        countries.put("Kazakhstan", "Nur-Sultan");
        countries.put("Kosovo", "Pristina");
        countries.put("Latvia", "Riga");
        countries.put("Liechtenstein", "Vaduz");
        countries.put("Lithuania", "Vilnius");
        countries.put("Luxembourg", "Luxembourg");
        countries.put("Malta", "Valletta");
        countries.put("Moldova", "Chisinau");
        countries.put("Monaco", "Monte_Carlo");
        countries.put("Montenegro", "Podgorica");
        countries.put("Netherlands", "Amsterdam");
        countries.put("North_Macedonia", "Skpje");
        countries.put("Norway", "Oslo");
        countries.put("Poland", "Warsaw");
        countries.put("Portugal", "Lisbon");
        countries.put("Romania", "Bucharest");
        countries.put("Russia", "Moscow");
        countries.put("San_Marino", "San_Marino");
        countries.put("Serbia", "Belgrade");
        countries.put("Slovakia", "Bratislava");
        countries.put("Slovenia", "Ljubljana");
        countries.put("Spain", "Madrid");
        countries.put("Sweden", "Stockholm");
        countries.put("Switzerland", "Bern");
        countries.put("Turkey", "Ankara");
        countries.put("Ukraine", "Kyiv");
        countries.put("United_Kingdom", "London");
        countries.put("Vatican_City", "Vatican_City");
        
        countriesKeys.addAll(countries.keySet()); 
        
       
       	name = JOptionPane.showInputDialog("Ingrese su nombre:");
       	
        
        for (int i = 0; i < 3; i++) {
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

}
