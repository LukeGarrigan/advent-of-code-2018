package day8;

import java.util.ArrayList;
import java.util.List;

public class Memory {


    /*  2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2
       A----------------------------------
           B----------- C-----------
                            D-----

     */
    private int index = 0;

    public int partOne(int[] numbers) {
        int sum = 0;
        int numberOfChildren = numbers[index];
        int numberOfMetaData = numbers[index + 1];

        index += 2;
        for (int i = 0; i < numberOfChildren; i++) {
            sum += partOne(numbers);
        }
        for (int i = 0; i < numberOfMetaData; i++) {
            sum += numbers[index];
            index++;
        }

        return sum;
    }


    public Node partTwo(int[] numbers) {
        Node node = new Node();
        int numberOfChildren = numbers[index];
        int numberOfMetaData = numbers[index + 1];

        index += 2;
        if (numberOfChildren == 0) {
            for (int i = 0; i < numberOfMetaData; i++) {
                node.addToValue(numbers[index]);
                index++;
            }
        } else {
            List<Node> children = new ArrayList<>();
            for (int i = 0; i < numberOfChildren; i++) {
                Node childNode = partTwo(numbers);
                children.add(childNode);
            }
            for (int i = 0; i < numberOfMetaData; i++) {
                if (numbers[index]-1 < children.size()) {
                    node.addToValue(children.get(numbers[index]-1).getValue());
                }
                index++;
            }


        }

        return node;


    }



    public int[] processInput(String input) {
        String[] split = input.split(" ");

        int[] numbers = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            String number = split[i];
            numbers[i] = Integer.parseInt(number);
        }
        return numbers;
    }


}
