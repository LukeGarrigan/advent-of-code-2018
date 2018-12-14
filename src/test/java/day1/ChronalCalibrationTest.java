package day1;

import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by lukegarrigan on 14/12/2018.
 */
public class ChronalCalibrationTest extends TestCase {


    private ChronalCalibration chronalCalibration = new ChronalCalibration();

    private String actualData;


    public void setUp() throws Exception {
        Scanner scanner = new Scanner(new FileReader("src/test/java/day1/data.txt"));
        StringBuilder builder  = new StringBuilder();
        while(scanner.hasNext()) {
            builder.append(scanner.next());
            builder.append("\n");
        }
        this.actualData = builder.toString();
    }


    // *******************************************************************
    // *********************** Part One **********************************
    // *******************************************************************
    public void testSimpleAdditions() {
        String input = "+2\n+1";
        assertEquals(3, chronalCalibration.getResultantFrequency(input));
    }


    public void testSimpleAdditionAndSubtraction() {
        String input = "+2\n+1\n-2";
        assertEquals(1, chronalCalibration.getResultantFrequency(input));
    }


    public void testActualData() throws FileNotFoundException {
        assertEquals(505, chronalCalibration.getResultantFrequency(this.actualData));
    }



    // *******************************************************************
    // *********************** Part Two **********************************
    // *******************************************************************
    public void testFrequencyDuplication() {
        String input = "+3\n+3\n+4\n-2\n-4";
        assertEquals(10, chronalCalibration.getFrequencyHitFirst(input));
    }

    public void testFrequencyDuplicationTwo() {
        String input = "-6\n+3\n+8\n+5\n-6";
        assertEquals(5, chronalCalibration.getFrequencyHitFirst(input));
    }

    public void testFrequencyDuplicationThree() {
        String input = "+1\n-1";
        assertEquals(0, chronalCalibration.getFrequencyHitFirst(input));
    }

    public void testFrequencyDuplicationActualData() throws FileNotFoundException {
        assertEquals(72330, chronalCalibration.getFrequencyHitFirst(this.actualData));
    }


}