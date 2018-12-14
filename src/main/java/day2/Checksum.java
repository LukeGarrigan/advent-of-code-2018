package day2;

import java.util.HashMap;
import java.util.Map;

public class Checksum {


    /**
     * Part 1
     * @param inputs
     * @return
     */
    public int calculateChecksum(String[] inputs) {

        int two = 0;
        int three = 0;

        for(String input: inputs) {
            Map<Character, Integer> letterCounts = new HashMap<>();
            computeCountsForLine(input, letterCounts);
            boolean hasTwo = false;
            boolean hasThree = false;
            for (Map.Entry<Character, Integer> countForLetter : letterCounts.entrySet()) {
                if (countForLetter.getValue() == 2) {
                    hasTwo = true;
                } else if(countForLetter.getValue() == 3) {
                    hasThree = true;
                }
            }
            if (hasTwo) two++;
            if (hasThree) three++;
        }

        return  two*three;
    }

    private void computeCountsForLine(String input, Map<Character, Integer> letterCounts) {
        for (int i = 0; i < input.length(); i++) {
            char currentLetter = input.charAt(i);
            letterCounts.merge(currentLetter, 1, (a, b) -> a + b);
        }
    }


    /**
     * Part Two
     * @return
     */
    public String getBoxesThatDifferByOneLetter(String[] input) {
        for (int i = 0; i < input.length-1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                boolean differsByOne = doTwoBoxesDifferByOneLetter(input[i], input[j]);
                if (differsByOne) {
                    return getStringWithMixedLetterRemoved(input[i], input[j]);
                }

            }
        }
        return "";
    }


    private boolean doTwoBoxesDifferByOneLetter(String boxOne, String boxTwo) {
        int numberOfDifferences = 0;

        for (int i = 0; i < boxOne.length(); i++) {

            if (boxOne.charAt(i) != boxTwo.charAt(i)) numberOfDifferences++;

            if (numberOfDifferences > 1) return false;
        }
        return true;
    }


    private String getStringWithMixedLetterRemoved(String boxOne, String boxTwo) {

        StringBuilder trimmedBoxId = new StringBuilder();
        for (int i = 0; i < boxOne.length(); i++) {
            if (boxOne.charAt(i) == boxTwo.charAt(i)) {
                trimmedBoxId.append(boxOne.charAt(i));
            }
        }

        return trimmedBoxId.toString();

    }
}
