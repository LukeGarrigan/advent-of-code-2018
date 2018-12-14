package day7;

import java.util.*;

public class SantasSleigh {


    public String doPartOne(List<String> instructions) {
        List<Node> nodes = processInstructions(instructions);
        printSteps(nodes);
        List<Node> parentNodes = findParentNode(nodes);
        return findOrderOfExecution(parentNodes);
    }

    private void printSteps(List<Node> nodes) {

        for (Node node : nodes) {
            System.out.print(node.getId());
        }


    }

    private List<Node> findParentNode(List<Node> allNodes) {

        Set<Node> parents = new HashSet<>();

        for (Node allNode : allNodes) {
            Node parentNode = allNode;
            while (allNode.getParent() != null) {
                parentNode = allNode.getParent();
                allNode = allNode.getParent();
            }
            parents.add(parentNode);

        }

        List<Node> orderedParents = new ArrayList<>();
        orderedParents.addAll(parents);
        Collections.sort(orderedParents, new NodeComparator());
        return orderedParents;
    }

    private String findOrderOfExecution(List<Node> parentNode) {

        StringBuilder order = new StringBuilder();
        List<Node> closedSet = new ArrayList<>();

        List<Node> openSet = new ArrayList<>();
        openSet.addAll(parentNode);
        while (!openSet.isEmpty()) {
            Node node = openSet.get(0);
            closedSet.add(node);
            openSet.remove(node);

            order.append(node.getId());
            for (Node child : node.getChildren()) {
                if (!closedSet.contains(child) && !openSet.contains(child)) {
                    openSet.add(child);
                }
            }
            Collections.sort(openSet, new NodeComparator());
            //openSet.sort(new NodeComparator());
        }

        return order.toString();
    }


    public List<Node> processInstructions(List<String> instructions) {
        List<Node> nodes = new ArrayList<>();
        for (String instruction : instructions) {
            String step = getStep(instruction);
            String child = getBeforeLetter(instruction);
            Node parentNode = new Node(step.charAt(0));
            Node childNode = new Node(child.charAt(0));

            if (!nodes.contains(parentNode)) {
                nodes.add(parentNode);
            }
            if (!nodes.contains(childNode)) {
                nodes.add(childNode);
            }

            Node theParentNode = getNode(step, nodes);
            Node theChildNode = getNode(child, nodes);

            theParentNode.addChild(theChildNode);
            theChildNode.setParent(theParentNode);
        }

        return nodes;
    }

    private Node getNode(String step, List<Node> nodes) {
        for (Node node : nodes) {
            if (node.getId() == step.charAt(0)) {
                return node;
            }
        }
        return null;
    }


    public String getStep(String line) {
        return line.substring(line.indexOf("p") + 2, line.indexOf("p") + 3);
    }

    public String getBeforeLetter(String line) {
        return line.substring(line.indexOf("c") - 2, line.indexOf("c") - 1);
    }



}
