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
public class association<K,V>{
	K llave;
	V valor; 
	public association(){
		
	}
	public void setKey(K key){
		llave = key;
	}
	public void setValue(V value){
		valor = value;
	}
	public K getKey(){
		return llave;
	}
	public V getValue(){
		return valor;
	}
}