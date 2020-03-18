/* Universidad del Valle de Guatemala
Maria Jose Morales 19145
Hoja de Trabajo No. 7
Traductor 
Main*/
//Se importan los paquetes necesarios 
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.Collections;
import java.util.*; 
public class main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);//instance a scanner that reads what the user writes when we ask them to 
		String archive = "texto.txt";
		File fichero = new File(archive);
		Scanner s = null;
		String linea = "";
		String[] ingles = null;
		String[] diccionario = null;
		//we create a try that tries to read txt that catches if the txt does not exist
		try {
			//the scanner reads the file
			s = new Scanner(fichero);
			while(s.hasNextLine()){
				//what the scanner reads it saves it on linea
				linea = s.nextLine();
			}
			ingles = linea.split(" "); //texto en ingles 
		}
		//if the txt does not exist it prints the exception message
		catch (Exception ex) { 
			System.out.println("Mensaje: " + ex.getMessage());
		}
		//FInally we close the txt
		finally {
			try {
				if (s != null) {
					s.close();
				}
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
		archive = "diccionario.txt"; 
		fichero = new File(archive); 
		try {
			//the scanner reads the file
			s = new Scanner(fichero);
			linea = ""; 
			while(s.hasNextLine()){
				//what the scanner reads it saves it on linea
				linea += s.nextLine() +"\n";
			}
			diccionario = linea.split("\n"); //texto en ingles 
		}
		//if the txt does not exist it prints the exception message
		catch (Exception ex) { 
			System.out.println("Mensaje: " + ex.getMessage());
		}
		//FInally we close the txt
		finally {
			try {
				if (s != null) {
					s.close();
				}
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
		
		//HACE EL ARBOL DE DICCIONARIO
		binaryTree<association<String,String>> arbol = null;
		for (int i = 0; i<diccionario.length; i++){
			binaryTree<association<String,String>> temp = arbol;
			association<String,String> a = new association<String,String>(); 
			String palabra = diccionario[i];
			String llave = palabra.substring(1,palabra.indexOf(','));
			String valor = palabra.substring(palabra.indexOf(',')+1, palabra.length()-1);
			a.setKey(llave);
			a.setValue(valor);
			binaryTree<association<String,String>> rama = new binaryTree<association<String,String>>();
			rama.setValor(a);
			if(temp == null){
				arbol = rama;
				System.out.println("centro");
			}
			else{
				if(temp.getValor().getKey().compareTo(llave) < 0){
					if(arbol.getDerecha()==null){
						temp.addDerecha(rama);
						System.out.println("der");
					}
					else if(arbol.getDerecha()!=null){
						temp = temp.getDerecha();
						System.out.println("no der");
					}
				}
				else{
					if(arbol.getIzquierda()==null){
						temp.addIzquierda(rama);
						System.out.println("izq");
					}
					else if(arbol.getIzquierda()!=null){
						temp = temp.getIzquierda();
						System.out.println("no izq");
					}
				}
			}
		}
		System.out.println("valor "+ arbol.getValor());
		System.out.println("Diccionario inorder: "+ arbol.inOrder(arbol));
	}
}






