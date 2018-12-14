package day7;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node>{


    @Override
    public int compare(Node o1, Node o2) {
        if (o1.getChildren().contains(o2)) {
            return -1;
        }

        if (o2.getChildren().contains(o1)) {
            return 1;
        }

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int firstNodeIndex = -10;
        int secondNodeIndex = -10;
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == o1.getId()) {
                firstNodeIndex = i;
            }
            if (alphabet.charAt(i) == o2.getId()) {
                secondNodeIndex = i;
            }
        }
        if (firstNodeIndex > secondNodeIndex) {
            return 1;
        } else if (firstNodeIndex == secondNodeIndex) {
            return 0;
        }else {
            return -1;
        }
    }
}
