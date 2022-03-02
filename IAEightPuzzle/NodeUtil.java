package IAEightPuzzle;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class NodeUtil {
    public static List<String> getSucesor(String state) {
        List<String> sucesor = new ArrayList<String>();

        switch (state.indexOf("0")) {
            case 0: {
                sucesor.add(state.replace(state.charAt(0), '*').replace(state.charAt(1), state.charAt(0)).replace('*', state.charAt(1)));
                sucesor.add(state.replace(state.charAt(0), '*').replace(state.charAt(3), state.charAt(0)).replace('*', state.charAt(3)));
                break;
            }
            case 1: {
                sucesor.add(state.replace(state.charAt(1), '*').replace(state.charAt(0), state.charAt(1)).replace('*', state.charAt(0)));
                sucesor.add(state.replace(state.charAt(1), '*').replace(state.charAt(2), state.charAt(1)).replace('*', state.charAt(2)));
                sucesor.add(state.replace(state.charAt(1), '*').replace(state.charAt(4), state.charAt(1)).replace('*', state.charAt(4)));
                break;
            }
            case 2: {

                sucesor.add(state.replace(state.charAt(2), '*').replace(state.charAt(1), state.charAt(2)).replace('*', state.charAt(1)));
                sucesor.add(state.replace(state.charAt(2), '*').replace(state.charAt(5), state.charAt(2)).replace('*', state.charAt(5)));
                break;
            }
            case 3: {
                sucesor.add(state.replace(state.charAt(3), '*').replace(state.charAt(0), state.charAt(3)).replace('*', state.charAt(0)));
                sucesor.add(state.replace(state.charAt(3), '*').replace(state.charAt(4), state.charAt(3)).replace('*', state.charAt(4)));
                sucesor.add(state.replace(state.charAt(3), '*').replace(state.charAt(6), state.charAt(3)).replace('*', state.charAt(6)));
                break;
            }
            case 4: {
                sucesor.add(state.replace(state.charAt(4), '*').replace(state.charAt(1), state.charAt(4)).replace('*', state.charAt(1)));
                sucesor.add(state.replace(state.charAt(4), '*').replace(state.charAt(3), state.charAt(4)).replace('*', state.charAt(3)));
                sucesor.add(state.replace(state.charAt(4), '*').replace(state.charAt(5), state.charAt(4)).replace('*', state.charAt(5)));
                sucesor.add(state.replace(state.charAt(4), '*').replace(state.charAt(7), state.charAt(4)).replace('*', state.charAt(7)));
                break;
            }
            case 5: {
                sucesor.add(state.replace(state.charAt(5), '*').replace(state.charAt(2), state.charAt(5)).replace('*', state.charAt(2)));
                sucesor.add(state.replace(state.charAt(5), '*').replace(state.charAt(4), state.charAt(5)).replace('*', state.charAt(4)));
                sucesor.add(state.replace(state.charAt(5), '*').replace(state.charAt(8), state.charAt(5)).replace('*', state.charAt(8)));
                break;
            }
            case 6: {
                sucesor.add(state.replace(state.charAt(6), '*').replace(state.charAt(3), state.charAt(6)).replace('*', state.charAt(3)));
                sucesor.add(state.replace(state.charAt(6), '*').replace(state.charAt(7), state.charAt(6)).replace('*', state.charAt(7)));
                break;

            }
            case 7: {
                sucesor.add(state.replace(state.charAt(7), '*').replace(state.charAt(4), state.charAt(7)).replace('*', state.charAt(4)));
                sucesor.add(state.replace(state.charAt(7), '*').replace(state.charAt(6), state.charAt(7)).replace('*', state.charAt(6)));
                sucesor.add(state.replace(state.charAt(7), '*').replace(state.charAt(8), state.charAt(7)).replace('*', state.charAt(8)));
                break;
            }
            case 8: {
                sucesor.add(state.replace(state.charAt(8), '*').replace(state.charAt(5), state.charAt(8)).replace('*', state.charAt(5)));
                sucesor.add(state.replace(state.charAt(8), '*').replace(state.charAt(7), state.charAt(8)).replace('*', state.charAt(7)));
                break;
            }
        }

        return sucesor;


    }

    public static void ImprimirSolucion(Node NodoObjetivo, Node raiz) {
        int totalCost = 0;
        Stack<Node> Resultados = new Stack<Node>();
        Resultados.push(NodoObjetivo);
        while (!NodoObjetivo.getEstado().equals(raiz.getEstado())) {
            Resultados.push(NodoObjetivo.getPadre());
            NodoObjetivo = NodoObjetivo.getPadre();
        }
        String estadoInicial = raiz.getEstado();
        String destinationState;
        int cost = 0;
        for (int i = Resultados.size() - 1; i >= 0; i--) {
            System.out.println("=====================================================================");
            destinationState = Resultados.get(i).getEstado();
            if (!estadoInicial.equals(destinationState)) {
                cost = Character.getNumericValue(destinationState.charAt(estadoInicial.indexOf('0')));
                totalCost += cost;
            }
            estadoInicial = destinationState;
            System.out.println("Costo: " + cost);
            System.out.println("-------");
            System.out.println("| " + Resultados.get(i).getEstado().substring(0, 3)+" |");
            System.out.println("| " + Resultados.get(i).getEstado().substring(3, 6)+" |");
            System.out.println("| "+ Resultados.get(i).getEstado().substring(6, 9)+" |");
            System.out.println("-------");
        }
        System.out.println("=====================================================================");
        System.out.println("-- Numero nodos creados:  " + (Resultados.size() - 1));
        System.out.println("-- Total de costo: " + totalCost);
        System.out.println("=====================================================================");
    }
}



