package IAEightPuzzle;
import java.util.ArrayList;

public class Node {
    private boolean visitado;

    private String estado;
    private ArrayList<Node> hijo;
    private Node padre;
    private int costo;
    private int costoEstimadoDeObjetivo;
    private int totalcosto;
    private int profundidad;

    public int getProfundidad() {
        return profundidad;
    }
    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
    public boolean esVisitado() {
        return visitado;
    }
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    public int getTotalcosto() {
        return totalcosto;
    }
    public void setTotalcosto(int totalcosto) {
        this.totalcosto = totalcosto;
    }
    public void setTotalcosto(int costo, int estimatedcosto) {
        this.totalcosto = costo + estimatedcosto;
    }
    public int getcostoEstimadoDeObjetivo() {
        return costoEstimadoDeObjetivo;
    }
    public void setcostoEstimadoDeObjetivo(int costoEstimadoDeObjetivo) {
        this.costoEstimadoDeObjetivo = costoEstimadoDeObjetivo;
    }
    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Node getPadre() {
        return padre;
    }
    public void setPadre(Node padre) {
        this.padre = padre;
    }
    public Node(String estado) {
        this.estado = estado;
        hijo = new ArrayList<Node>();
    }
    public String getEstado() {
        return estado;
    }
    public ArrayList<Node> getHijo() {
        return hijo;
    }
    public void addHijo(Node child) {
        hijo.add(child);
    }
}