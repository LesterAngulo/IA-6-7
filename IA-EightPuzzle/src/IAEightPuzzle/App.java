package IAEightPuzzle;

public class App {
   
    public static void main(String[] args) {
        String estadoInicial = "325806147";
        String estadoFinal = "123804765";
        
        long STime = System.currentTimeMillis();
        SearchTree search = new SearchTree(new Node(estadoInicial), estadoFinal);
        search.BFS();
        
        long FTime = System.currentTimeMillis();
        long TTime = FTime - STime;
        System.out.println("Tiempo  :" + TTime);

    }
}
