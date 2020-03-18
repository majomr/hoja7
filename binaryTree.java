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
public class binaryTree<E>{
	
	binaryTree<E> izquierda;
	binaryTree<E> derecha;
	E valor;
	public binaryTree(){
		izquierda = null;
		derecha = null;
		valor = null; 
	}
	
	public void addDerecha(binaryTree<E> rama){
		derecha = rama;
	}
	public void addIzquierda(binaryTree<E> rama){
		izquierda = rama;
	}	 
	
	public binaryTree<E> getIzquierda(){
       return izquierda;
    }
   
	public binaryTree<E> getDerecha(){
	   return derecha;
	}
	
	public E getValor(){
		return valor;
	}
	
	public void setValor(E v){
       valor = v;
   }
   
   public String inOrder(binaryTree<association<String, String>> tree){
       if(tree != null)
       {
		   String re ="";
		   re = re+ inOrder(tree.getIzquierda()) + " (" +  tree.getValor().getKey() + ", " +  tree.getValor().getValue() + ") " + inOrder(tree.getDerecha());
		   return re;
       }
       else{
           return "";
       }
   }
   
}