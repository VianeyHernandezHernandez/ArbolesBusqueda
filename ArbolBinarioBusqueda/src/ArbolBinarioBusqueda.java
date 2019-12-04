/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vianey
 */
public class ArbolBinarioBusqueda {

    NodoArbol raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    public NodoArbol Buscar(int d, NodoArbol r) {
        if (raiz == null) {
            return null;
        } else if (r.dato == d) {
            return r;
        } else if (r.dato < d) {
            return Buscar(d, r.hijoDerecho);
        } else {
            return Buscar(d, r.hijoIzquierdo);
        }
    }

    //metodo para obtener factor de equilibrio
    public int ObtenerFE(NodoArbol x) {
        if (x == null) {
            return -1;
        } else {
            return x.fe;
        }
    }

    //Metodo Rotacion simple izquierda
    public NodoArbol rotacionIzquierda(NodoArbol c) {
        NodoArbol auxiliar = c.hijoIzquierdo;
        c.hijoIzquierdo = auxiliar.hijoDerecho;
        auxiliar.hijoDerecho = c;
        c.fe = Math.max(ObtenerFE(c.hijoIzquierdo), ObtenerFE(c.hijoDerecho)) + 1;
        c.fe = Math.max(ObtenerFE(auxiliar.hijoIzquierdo), ObtenerFE(auxiliar.hijoDerecho)) + 1;
        return auxiliar;
    }

    //Metodo rotacion simple derecha
    public NodoArbol rotacionDerecha(NodoArbol c) {
        NodoArbol auxiliar = c.hijoDerecho;
        c.hijoDerecho = auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo = c;
        c.fe = Math.max(ObtenerFE(c.hijoIzquierdo), ObtenerFE(c.hijoDerecho)) + 1;
        c.fe = Math.max(ObtenerFE(auxiliar.hijoIzquierdo), ObtenerFE(auxiliar.hijoDerecho)) + 1;
        return auxiliar;
    }

    // Rotacion doble a la Derecha
    public NodoArbol rotacionDobleIzquierda(NodoArbol c) {
        NodoArbol temporal;
        c.hijoIzquierdo = rotacionDerecha(c.hijoIzquierdo);
        temporal = rotacionDobleIzquierda(c);
        return temporal;
    }

    // Rotacion doble a la Izquierda
    public NodoArbol rotacionDobleDerecha(NodoArbol c) {
        NodoArbol temporal;
        c.hijoDerecho = rotacionIzquierda(c.hijoDerecho);
        temporal = rotacionDobleDerecha(c);
        return temporal;
    }

    //Metodo Insertar Modo Balanceado
    public NodoArbol insertarAVL(NodoArbol nuevo, NodoArbol subAr) {
        NodoArbol nuevoPadre = subAr;
        if (nuevo.dato < subAr.dato) {
            if (subAr.hijoIzquierdo == null) {
                subAr.hijoIzquierdo = nuevo;
            } else {
                subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
                if ((ObtenerFE(subAr.hijoIzquierdo) - ObtenerFE(subAr.hijoDerecho) == 2)) {
                    if (nuevo.dato < subAr.hijoIzquierdo.dato) {
                        nuevoPadre = rotacionIzquierda(subAr);
                    } else {
                        nuevoPadre = rotacionDobleIzquierda(subAr);
                    }
                }
            }
        } else if (nuevo.dato > subAr.dato) {
            if (subAr.hijoDerecho == null) {
                subAr.hijoDerecho = nuevo;
            } else {
                subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
                if ((ObtenerFE(subAr.hijoDerecho) - ObtenerFE(subAr.hijoIzquierdo) == 2)) {
                    if (nuevo.dato > subAr.hijoDerecho.dato) {
                        nuevoPadre = rotacionDerecha(subAr);
                    } else {
                        nuevoPadre = rotacionDobleDerecha(subAr);
                    }
                }
            }
        } else {
            System.out.println("Nodo Duplicado");
        }

        //Actualizando la altura
        if ((subAr.hijoIzquierdo == null) && (subAr.hijoDerecho != null)) {
            subAr.fe = subAr.hijoDerecho.fe + 1;
        } else if ((subAr.hijoDerecho==null) && (subAr.hijoIzquierdo != null)) {
            subAr.fe=subAr.hijoIzquierdo.fe+1;
        }else{
            subAr.fe=Math.max(ObtenerFE(subAr.hijoIzquierdo),ObtenerFE(subAr.hijoDerecho))+1;
        }
        return nuevoPadre;
    }
    
    //metodo insertar
    public void insertar(int d){
        NodoArbol nuevo=new NodoArbol(d);
        if (raiz==null) {
            raiz=nuevo;
        } else {
            raiz=insertarAVL(nuevo, raiz);
        }
    }
}
