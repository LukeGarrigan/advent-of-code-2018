package day5;

import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by lukegarrigan on 14/12/2018.
 */
public class AlchemicalReductionTest extends TestCase {


    private final String PATH_TO_DATA = "src/test/java/day5/data.txt";

    private AlchemicalReduction alchemicalReduction = new AlchemicalReduction();


    public void testRemoveAdjacentCharactersFromString() {
        String randomString = "abcdef";
        assertEquals("abef", alchemicalReduction.removeAdjacentCharacter(2, randomString));
    }

    public void testRemoveFirstTwoLettersFromString() {
        String firstTwoLettersString = "abcdef";
        assertEquals("cdef", alchemicalReduction.removeAdjacentCharacter(0, firstTwoLettersString));
    }


    public void testRemoveLastTwoLettersFromString() {
        String lastTwoLetters = "abcdef";
        assertEquals("abcd", alchemicalReduction.removeAdjacentCharacter(4, lastTwoLetters));
    }

    public void testOneTimePassOfPolymerRemoval() {
        assertEquals("dabAaCBAcCcaDA", alchemicalReduction.processSinglePolyerReduction("dabAcCaCBAcCcaDA"));
    }

    public void testFullReductionOfPolymers() {
        assertEquals("dabCBAcaDA", alchemicalReduction.processPolymer("dabAcCaCBAcCcaDA"));
    }


    /**
     * Part 1
     * @throws FileNotFoundException
     */
    public void testWithActualData() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(PATH_TO_DATA));

        String actualData = scanner.nextLine();

        assertEquals(10804, alchemicalReduction.processPolymer(actualData).length());
    }


    public void testRemoveAllOfCharacterFromPolymer() {
        assertEquals("dabAaBAaDA", alchemicalReduction.removeAllOfCharacterFromPolymer("dabAcCaCBAcCcaDA",'c'));
    }

    public void testRemoveAllOfCharacterWithUpperCaseFromPolymer() {
        assertEquals("dabAaBAaDA", alchemicalReduction.removeAllOfCharacterFromPolymer("dabAcCaCBAcCcaDA",'C'));
    }

    public void testImprovedPolymerReduction() {
        assertEquals(4, alchemicalReduction.improvedPolymerReduction("dabAcCaCBAcCcaDA"));
    }


    /**
     * Part 2
     * @throws FileNotFoundException
     */
    public void testWithActualDataPartTwo() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(PATH_TO_DATA));

        String actualData = scanner.nextLine();

        assertEquals(6650, alchemicalReduction.improvedPolymerReduction(actualData));
    }


}