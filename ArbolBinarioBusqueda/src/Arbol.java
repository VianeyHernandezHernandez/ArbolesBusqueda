/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vianey
 */
public class Arbol {
     private NodoArbol raiz;

    public Arbol(int valor) {
        this.raiz = new NodoArbol(valor);
    }

    public Arbol(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

//    public void agregar(NodoArbol nodo, NodoArbol raiz) {
//        if (raiz == null) {
//            this.setRaiz(nodo);
//        } else {
//            if (nodo.getDato() <= raiz.getDato()) {
//                if (raiz.getHijoIzquierdo()== null) {
//                    raiz.setHijoIzquierdo(nodo);
//                } else {
//                    agregar(nodo, raiz.getHijoIzquierdo());
//                }
//            } else {
//                if (raiz.getHijoDerecho()== null) {
//                    raiz.setHijoDerecho(nodo);
//                } else {
//                    agregar(nodo, raiz.getHijoDerecho());
//                }
//            }
//        }
//    }
//
//    public void agregarNodo(NodoArbol nodo) {
//        this.agregar(nodo, this.raiz);
//    }
//
    public void recorrerPreorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        } else {
        }
        System.out.println("Dato: " + nodo.getDato());
        recorrerPreorden(nodo.getHijoIzquierdo());
        recorrerPreorden(nodo.getHijoDerecho());
    }

    public void recorrerPosorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        } else {
            recorrerPosorden(nodo.hijoIzquierdo);
            recorrerPosorden(nodo.hijoDerecho);
            System.out.println("Dato: " + nodo.getDato());
        }
    }

    public void recorrerInorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        } else {
            recorrerInorden(nodo.hijoIzquierdo);
            System.out.println("Dato: " + nodo.getDato());
            recorrerInorden(nodo.hijoDerecho);
        }
    }
}
