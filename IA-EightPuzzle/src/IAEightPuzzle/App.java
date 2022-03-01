package IAEightPuzzle;

public class App {
   
    public static void main(String[] args) {
        String rootState = "325806147";
        long STime = System.currentTimeMillis();

        SearchTree search = new SearchTree(new Node(rootState), "123804765");
        search.breadthFirstSearch();

        long FTime = System.currentTimeMillis();
        long TTime = FTime - STime;
        System.out.println("Tiempo  :" + TTime);


    }
}
