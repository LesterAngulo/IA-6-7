package IAEightPuzzle;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MyQueue<Item> implements Iterable<Item> {
    private Node<Item> primero;    
    private Node<Item> ultimo;     
    private int N;              

    private static class Node<Item> {
        private Item item;
        private Node<Item> siguiente;
    }

    public MyQueue() {
        primero = null;
        ultimo = null;
        N = 0;
    }

    public void Limpiar() {
        primero = null;
        ultimo = null;
         N= 0;
    }

  
    public boolean Vacio() {
        return primero == null;
    }

  
    public int Tamaño() {
        return N;
    }

  
    public Item peek() {
        if (Vacio()) throw new NoSuchElementException("Queue underflow");
        return primero.item;
    }

   
    public void enqueue(Item item) {

        Node<Item> vUltimo = ultimo;
        ultimo = new Node<Item>();
        ultimo.item = item;
        ultimo.siguiente = null;
        if (Vacio()) primero = ultimo;
        else vUltimo.siguiente = ultimo;
        N++;
    }

    
    public Item dequeue() {
        if (Vacio()) throw new NoSuchElementException("Queue underflow");
        Item item = primero.item;
        primero = primero.siguiente;
        N--;
        if (Vacio()) ultimo = null;   // to avoid loitering
        return item;
    }


    public Iterator<Item> iterator() {
        return new ListIterator<Item>(primero);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> actual;

        public ListIterator(Node<Item> primero) {
            actual = primero;
        }

        public boolean hasNext() {
            return actual != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = actual.item;
            actual = actual.siguiente;
            return item;
        }
    }

    public void addQueue(MyQueue<Item> queue) {
        if (!queue.Vacio()) {


            Node<Item> vPrimero = primero;

            if (Vacio()) {
                primero = queue.primero;
                ultimo = queue.ultimo;
            } else {
                primero = queue.primero;
                queue.ultimo.siguiente = vPrimero;
            }

            N = N + queue.Tamaño();
        }

    }

}
