package day9;

import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MarbleGameTest extends TestCase {


    private MarbleGame marbleGame = new MarbleGame();

    public void testGetNumberPlayers() {
        String input = "10 players; last marble is worth 1618 points";
        assertEquals(10, marbleGame.getNumberOfPlayers(input));
    }
    public void testGetLastMarblePoints() {
        String input = "10 players; last marble is worth 1618 points";
        assertEquals(1618, marbleGame.getLastMarblePoints(input));
    }

    public void testPartOne() {
        assertEquals(32,marbleGame.findHighestScore(9, 25));
    }


    public void testWithTheirData1() {
        assertEquals(8317,marbleGame.doPartOne("10 players; last marble is worth 1618 points"));
    }

    public void testWithTheirData2() {
        assertEquals(146373,marbleGame.doPartOne( "13 players; last marble is worth 7999 points"));
    }

    public void testActualData() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/test/java/day9/data.txt"));

        String input = scanner.nextLine();
        assertEquals(405143,marbleGame.doPartOne(input));
    }




}