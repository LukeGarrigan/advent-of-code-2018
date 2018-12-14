package day8;

import java.util.ArrayList;
import java.util.List;

public class Memory {



 /*   2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2
      A----------------------------------
          B----------- C-----------
                           D-----

    */


    public List<Node> processData(int[] numbers) {

        int i = 0;
        Node parent = null;
        while(i < numbers.length) {
            int numberOfChildren = numbers[i];
            int numberOfMetaData = numbers[i+1];

            Node node = new Node(numberOfChildren, numberOfMetaData, 0, parent);
            parent = node;

            if (numberOfChildren == 0) {
                for (int j = i+2; j < i + node.getMetaCount()+2; j++) {
                    node.addMetaData(numbers[j]);
                }
                i += 2 + node.getMetaCount();
            } else {
                i += 2;
            }

        }
        return new ArrayList<>();
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
