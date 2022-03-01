package IAEightPuzzle;
import java.util.*;

public class SearchTree {
    private Node root;
    private String goalSate;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public String getGoalSate() {
        return goalSate;
    }

    public void setGoalSate(String goalSate) {
        this.goalSate = goalSate;
    }

    public SearchTree(Node root, String goalSate) {
        this.root = root;
        this.goalSate = goalSate;
    }

    public void breadthFirstSearch() {
        Set<String> stateSets = new HashSet<String>();
        int totalCost = 0;
        int time = 0;
        Node node = new Node(root.getEstado());
        Queue<Node> queue = new LinkedList<Node>();
        Node currentNode = node;
        while (!currentNode.getEstado().equals(goalSate)) {
            stateSets.add(currentNode.getEstado());
            List<String> nodeSuccessors = NodeUtil.getSuccessors(currentNode.getEstado());
            for (String n : nodeSuccessors) {
                if (stateSets.contains(n))
                    continue;
                stateSets.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setPadre(currentNode);
                queue.add(child);

            }
            currentNode = queue.poll();
            time += 1;
        }

        NodeUtil.printSolution(currentNode, stateSets, root, time);

    }

   
    public void depthFirstSearch() {
        Set<String> stateSets = new HashSet<String>();
        int totalCost = 0;
        int time = 0;
        Node node = new Node(root.getEstado());
        MyQueue<Node> mainQueue = new MyQueue<>();
        MyQueue<Node> successorsQueue = new MyQueue<>();
        Node currentNode = node;
        while (!currentNode.getEstado().equals(goalSate)) {
            stateSets.add(currentNode.getEstado());
            List<String> nodeSuccessors = NodeUtil.getSuccessors(currentNode.getEstado());
            for (String n : nodeSuccessors) {
                if (stateSets.contains(n))
                    continue;
                stateSets.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setPadre(currentNode);
                successorsQueue.enqueue(child);

            }
            mainQueue.addQueue(successorsQueue);
            successorsQueue.Limpiar();
            currentNode = mainQueue.dequeue();
            time += 1;
            nodeSuccessors.clear();
        }
        NodeUtil.printSolution(currentNode, stateSets, root, time);

    }


    public void aStar(Heuristic heuristic) {
        Set<String> stateSets = new HashSet<String>();
        int totalCost = 0;
        int time = 0;
        Node node = new Node(root.getEstado());
        node.setTotalcosto(0);

        NodePriorityComparator nodePriorityComparator = new NodePriorityComparator();

        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<Node>(10, nodePriorityComparator);
        Node currentNode = node;
        while (!currentNode.getEstado().equals(goalSate)) {
            stateSets.add(currentNode.getEstado());
            List<String> nodeSuccessors = NodeUtil.getSuccessors(currentNode.getEstado());
            for (String n : nodeSuccessors) {
                if (stateSets.contains(n))
                    continue;
                stateSets.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setPadre(currentNode);

                if (heuristic == Heuristic.H_ONE)
                    child.setTotalcosto(currentNode.getTotalcosto() + Character.getNumericValue(child.getEstado().charAt(child.getPadre().getEstado().indexOf('0'))), heuristicOne(child.getEstado(), goalSate));
                nodePriorityQueue.add(child);

            }
            currentNode = nodePriorityQueue.poll();
            time += 1;
        }
        NodeUtil.printSolution(currentNode, stateSets, root, time);
    }
 
    private int heuristicOne(String currentState, String goalSate) {
        int difference = 0;
        for (int i = 0; i < currentState.length(); i += 1)
            if (currentState.charAt(i) != goalSate.charAt(i))
                difference += 1;
        return difference;
    }


}