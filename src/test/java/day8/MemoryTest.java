package day8;

import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by lukegarrigan on 14/12/2018.
 */
public class MemoryTest extends TestCase {

    private Memory memory = new Memory();

    private String actualInput;

    public void setUp() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/test/java/day8/data.txt"));
        actualInput = scanner.nextLine();
    }

    public void testParseData() {
        String input = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2";

        int[] ints = memory.processInput(input);

        assertEquals(input.split(" ").length, ints.length);
    }

    public void testPartOneWithTheirTestData() {

        String input = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2";

        int[] ints = memory.processInput(input);

        assertEquals(138, memory.partOne(ints));
    }

    public void testActualData() {
        int[] ints = memory.processInput(actualInput);
        assertEquals(44893, memory.partOne(ints));
    }


    public void testPartTwoWithTheirTestData() {
        String input = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2";

        int[] ints = memory.processInput(input);
        assertEquals(66, memory.partTwo(ints).getValue());
    }


    public void testPartTwoWithActualTestData() {
        int[] ints = memory.processInput(actualInput);
        assertEquals(27433, memory.partTwo(ints).getValue());
    }
}