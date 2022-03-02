package IAEightPuzzle;
import java.util.Comparator;

public class NodePriorityComparator implements Comparator<Node> {

    @Override
    public int compare(Node x, Node y) {
        if (x.getTotalcosto() < y.getTotalcosto()) {
            return -1;
        }
        if (x.getTotalcosto() > y.getTotalcosto()) {
            return 1;
        }
        return 0;
    }
}

