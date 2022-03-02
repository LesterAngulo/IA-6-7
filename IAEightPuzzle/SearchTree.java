package IAEightPuzzle;
import java.util.*;

public class SearchTree {
    private Node raiz;
    private String estadoObjetivo;
    
    public SearchTree(Node raiz, String estadoObjetivo) {
        this.raiz = raiz;
        this.estadoObjetivo = estadoObjetivo;
    }
    public void BFS() {
        Set<String> NodosEncontrados = new HashSet<String>();
        int time = 0;
        Node nodo = new Node(raiz.getEstado());
        Queue<Node> queue = new LinkedList<Node>();
        Node NodoActual = nodo;
        
        while (!NodoActual.getEstado().equals(estadoObjetivo)) {
            NodosEncontrados.add(NodoActual.getEstado());
            List<String> nodeSuccessors = NodeUtil.getSucesor(NodoActual.getEstado());
            for (String n : nodeSuccessors) {
                if (NodosEncontrados.contains(n))
                    continue;
                NodosEncontrados.add(n);
                Node hijo = new Node(n);
                NodoActual.addHijo(hijo);
                hijo.setPadre(NodoActual);
                queue.add(hijo);
            }
            NodoActual = queue.poll();
            time += 1;
        }
        NodeUtil.ImprimirSolucion(NodoActual, raiz);
    }
}