package day5;

/**
 * @author Luke.Garrigan
 * @since 06/12/2018
 */
public class AlchemicalReduction {


    public int improvedPolymerReduction(String polymer){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int bestScore = Integer.MAX_VALUE;

        for (int i = 0; i < alphabet.length(); i++) {
            char currentAlphabetLetter = alphabet.charAt(i);

            String polymerMinusTheLetter = removeAllOfCharacterFromPolymer(polymer, currentAlphabetLetter);

            String reducedPolymer = processPolymer(polymerMinusTheLetter);

            if (reducedPolymer.length() < bestScore) {
                bestScore = reducedPolymer.length();
            }
        }
        return bestScore;
    }



    public String removeAllOfCharacterFromPolymer(String polymer, char toBeRemoved) {
        char upperCasedToBeRemoved = Character.toUpperCase(toBeRemoved);
        StringBuilder output = new StringBuilder();
        String upperCasePolymer = polymer.toUpperCase();

        for (int i = 0; i < polymer.length() ; i++) {
            char currentCharacter = upperCasePolymer.charAt(i);

            if (currentCharacter != upperCasedToBeRemoved) {
                output.append(polymer.charAt(i));
            }
        }
        return output.toString();

    }


    public String processPolymer(String polymer) {
        while(true) {
            String postProcess = processSinglePolyerReduction(polymer);

            if (postProcess.length() < polymer.length()) {
                polymer = postProcess;
            } else {
                return polymer;
            }
        }
    }


    public String processSinglePolyerReduction(String polymer) {

        for (int i = 0; i < polymer.length()-1; i++) {
            char current = polymer.charAt(i);
            char next = polymer.charAt(i+1);

            if (Character.toUpperCase(current) == Character.toUpperCase(next)) {

                if (isOppositePolarity(current, next)) {
                  polymer = removeAdjacentCharacter(i, polymer);
                  break;
                }
            }
        }

        return polymer;
    }

    private boolean isOppositePolarity(char current, char next) {
        return Character.isUpperCase(current) && Character.isLowerCase(next) || Character.isUpperCase(next) && Character.isLowerCase(current);
    }


    public String removeAdjacentCharacter(int i, String randomString) {
        return randomString.substring(0, i) + randomString.substring(i+2, randomString.length());
    }
}
