package day2;

import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lukegarrigan on 14/12/2018.
 */
public class ChecksumTest extends TestCase {


    private Checksum checksum = new Checksum();

    private List<String> actualData;

    public void setUp() throws FileNotFoundException {
        this.actualData = getActualData();
    }


    public List<String> getActualData() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/test/java/day2/data.txt"));
        List<String> actualDataInput = new ArrayList<>();
        while(scanner.hasNext()) {
            actualDataInput.add(scanner.next());
        }
        return actualDataInput;
    }

    // *******************************************************************
    // *********************** Part One **********************************
    // *******************************************************************

    public void testSimpleChecksum() {
        String[] inputs = {"aabbb"};
        assertEquals(1, checksum.calculateChecksum(inputs));
    }

    public void testTheirGivenExample() {
        String []inputs = {"abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"};
        assertEquals(12, checksum.calculateChecksum(inputs));
    }


    public void testActualData() {
        assertEquals(6000, checksum.calculateChecksum(actualData.toArray(new String[0])));
    }



    // *******************************************************************
    // *********************** Part Two **********************************
    // *******************************************************************
    public void testGetBoxesThatDifferByOne() {
        String[] inputs = {"aabbb", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz"};
        assertEquals("fgij", checksum.getBoxesThatDifferByOneLetter(inputs));
    }

    public void testGetBoxesWithActualData(){
        assertEquals("pbykrmjmizwhxlqnasfgtycdv",checksum.getBoxesThatDifferByOneLetter(this.actualData.toArray(new String[0])));
    }

}