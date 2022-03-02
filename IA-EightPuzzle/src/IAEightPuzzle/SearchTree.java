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
        Set<String> stateSets = new HashSet<String>();
        int totalCost = 0;
        int time = 0;
        Node nodo = new Node(raiz.getEstado());
        Queue<Node> queue = new LinkedList<Node>();
        Node NodoActual = nodo;
        while (!NodoActual.getEstado().equals(estadoObjetivo)) {
            stateSets.add(NodoActual.getEstado());
            List<String> nodeSuccessors = NodeUtil.getSucesor(NodoActual.getEstado());
            for (String n : nodeSuccessors) {
                if (stateSets.contains(n))
                    continue;
                stateSets.add(n);
                Node child = new Node(n);
                NodoActual.addChild(child);
                child.setPadre(NodoActual);
                queue.add(child);
            }
            NodoActual = queue.poll();
            time += 1;
        }
        NodeUtil.ImprimirSolucion(NodoActual, raiz);
    }
}