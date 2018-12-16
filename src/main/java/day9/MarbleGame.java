package day9;

import java.util.ArrayList;
import java.util.List;

public class MarbleGame {


    public int doPartOne(String input) {
        int numberOfPlayers = getNumberOfPlayers(input);
        int lastPoints = getLastMarblePoints(input);

        return findHighestScore(numberOfPlayers, lastPoints);
    }

    public int findHighestScore(int numberOfPlayers, int lastPoints) {
        int[] playersScores = new int[numberOfPlayers];
        List<Integer> board = new ArrayList<>();
        board.add(0);
        board.add(1);
        int index = 1;
        int moves = 1;
        for (int i = 2; i <= lastPoints; i++) {
            moves++;
            int currentPlayerIndex = moves % numberOfPlayers;
            if (i % 23 == 0) {
                playersScores[currentPlayerIndex] += i;

                int indexOfMarbleToBeRemoved = (index - 7 + board.size()) % board.size();
                playersScores[currentPlayerIndex] += board.remove(indexOfMarbleToBeRemoved);

                index = (indexOfMarbleToBeRemoved) % board.size();
            } else {
                index += 2;
                if (index == board.size()) {
                    board.add(i);
                } else {
                    index = index % board.size();
                    board.add(index, i);
                }
            }

           // printMarble(board, index, currentPlayerIndex+1);
        }




        int highestScore = Integer.MIN_VALUE;
        for (int playersScore : playersScores) {
            if (playersScore > highestScore) {
                highestScore = playersScore;
            }
        }
        return highestScore;
    }

    private void printMarble(List<Integer> board, int index, int currentPlayerIndex) {

        System.out.println();
        System.out.print("["+currentPlayerIndex+ "] ");
        for (int i = 0; i < board.size(); i++) {

            if (i == index) {
                System.out.print(" ("+board.get(i)+")");
            } else {
                System.out.print(" "+board.get(i));
            }
        }

    }


    // 10 players; last marble is worth 1618 points";
    public int getNumberOfPlayers(String input) {
        return Integer.parseInt(input.substring(0, input.indexOf("p") - 1));
    }

    public int getLastMarblePoints(String input) {
        return Integer.parseInt(input.substring(input.indexOf("h") + 2, input.lastIndexOf("p") - 1));
    }


}
