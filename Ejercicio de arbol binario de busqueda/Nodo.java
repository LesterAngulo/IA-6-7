package IA;
public class Nodo <T>{

    public T nodo;
    private Nodo<T> Izquierdo;
    private Nodo<T> Derecho;

    public Nodo(T nodo) {
        this.nodo = nodo;
        this.Izquierdo = null;
        this.Derecho = null;
    }
    public T getNodo() {
        return nodo;
    }
    public void setNodo(T nodo) {
        this.nodo = nodo;
    }
    public Nodo<T> getIzquierdo() {
        return Izquierdo;
    }
    public void setIzquierdo(Nodo<T> Izquierdo) {
        this.Izquierdo = Izquierdo;
    }
    public Nodo<T> getDerecho() {
        return Derecho;
    }
    public void setDerecho(Nodo<T> Derecho) {
        this.Derecho = Derecho;
    }

    public boolean vacio(){
        if(nodo == null){
            return true;
        }
        return false;
    }
}