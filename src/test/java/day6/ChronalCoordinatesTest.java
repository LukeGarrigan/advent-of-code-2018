package day6;

import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lukegarrigan on 14/12/2018.
 */
public class ChronalCoordinatesTest extends TestCase {



    private final String PATH_TO_DATA = "src/test/java/day6/data.txt";

    private ChronalCoordinates chronalCoordinates = new ChronalCoordinates();

    public void testWorldBuilding() {
        String[][] chars = chronalCoordinates.buildWorld(new ArrayList<>(), 10);
    }

    public void testGetX() {
        String input = "1, 2";
        assertEquals(1, chronalCoordinates.getX(input));
    }

    public void testGetY() {
        String input = "1, 2";
        assertEquals(2, chronalCoordinates.getY(input));
    }


    public void testVisualWithTheirTestData() {
        String input = "1, 1\n" +
                "1, 6\n" +
                "8, 3\n" +
                "3, 4\n" +
                "5, 5\n" +
                "8, 9";

        String[] split = input.split("\n");

        List<String> coordinates = Arrays.asList(split);

        chronalCoordinates.buildWorld(coordinates, 10);
    }


    public void testManhattanDistance() {
        int x = 4;
        int y = 0;

        int x1 = 1;
        int y1 = 1;

        assertEquals(4, chronalCoordinates.calculateManhattanDistance(x, y, x1, y1));
    }

    public void testGetInifinitePoints() {
        String input = "1, 1\n" +
                "1, 6\n" +
                "8, 3\n" +
                "3, 4\n" +
                "5, 5\n" +
                "8, 9";
        String[] split = input.split("\n");

        List<String> coordinates = Arrays.asList(split);
        String[][] currentWorld = chronalCoordinates.buildWorld(coordinates, 10);
        String[][] worldWithAllPointsMarked = chronalCoordinates.processDistanceBetweenPointsForWorld(currentWorld);

        chronalCoordinates.getInfinitePoints(worldWithAllPointsMarked);


    }

    public void testPartOneWithTheirTestData() {
        String input = "1, 1\n" +
                "1, 6\n" +
                "8, 3\n" +
                "3, 4\n" +
                "5, 5\n" +
                "8, 9";

        String[] split = input.split("\n");

        List<String> coordinates = Arrays.asList(split);

        assertEquals(17, chronalCoordinates.doPartOne(coordinates, 10));
    }

    public void testPartOneWithActualData() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(PATH_TO_DATA));
        List<String> coordinates = new ArrayList<>();
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            coordinates.add(line);
        }

        assertEquals(3238, chronalCoordinates.doPartOne(coordinates, 400));
    }


    public void testPartTwoWithTheirMockData() {
        String input = "1, 1\n" +
                "1, 6\n" +
                "8, 3\n" +
                "3, 4\n" +
                "5, 5\n" +
                "8, 9";

        String[] split = input.split("\n");

        List<String> coordinates = Arrays.asList(split);

        assertEquals(16, chronalCoordinates.doPartTwo(coordinates, 10, 32));
    }


    public void testPartTwoWithActualData() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(PATH_TO_DATA));
        List<String> coordinates = new ArrayList<>();
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            coordinates.add(line);
        }

        assertEquals(45046, chronalCoordinates.doPartTwo(coordinates, 400,10000));
    }

}