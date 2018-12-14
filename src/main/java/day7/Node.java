package day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

    private char id;
    private Node parent;
    private List<Node> children = new ArrayList<>();


    public Node(char id) {
        this.id = id;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public List<Node> getChildren() {
        return children;
    }

    public char getId() {
        return id;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Node) obj).getId() == this.id;
    }


    private int compareNodeIndex(int firstNodeIndex, int secondNodeIndex) {
        if (firstNodeIndex > secondNodeIndex) {
            return 1;
        } else if (firstNodeIndex == secondNodeIndex) {
            return 0;
        }else {
            return -1;
        }
    }
}
