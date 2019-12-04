
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vianey
 */
public class ArbolBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol=new ArbolBinarioBusqueda();
        Scanner sc =new Scanner(System.in);
        int n=0, d=0;
        System.out.println("Ingrese el numero de datos que tendra su arbol ");
        n=sc.nextInt();
        //insertando nodos
        Arbol ar=new Arbol(n);
        
        System.out.println("Ingrese los datos");
        d=sc.nextInt();
        
        ar.recorrerPreorden(ar.getRaiz());
        ar.recorrerar.recorrerPreorden(ar.getRaiz());(ar.getRaiz());
    }
    
}
