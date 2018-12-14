package day8;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private int childCount;
    private int metaCount;
    private List<Node> children = new ArrayList<>();
    private List<Integer> metaData = new ArrayList<>();
    private int childId;
    private Node parent;

    public Node(int childCount, int metaCount, int childId, Node parent) {
        this.childCount = childCount;
        this.metaCount = metaCount;
        this.childId = childId;
        this.parent = parent;
    }

    public Node getParent() {
        return this.parent;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public void addMetaData(Integer metaData) {
        this.metaData.add(metaData);
    }

    public void setMetaData(List<Integer> metaData) {
        this.metaData = metaData;
    }

    public int getChildCount() {
        return childCount;
    }

    public int getMetaCount() {
        return metaCount;
    }
}
