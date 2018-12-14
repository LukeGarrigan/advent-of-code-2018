package day3;

import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lukegarrigan on 14/12/2018.
 */
public class FabricTest extends TestCase {

    private Fabric fabric = new Fabric();

    private List<String> actualData = new ArrayList<>();

    public void setUp() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/test/java/day3/data.txt"));

        while(scanner.hasNext()) {
            actualData.add(scanner.nextLine());
        }

    }

    // *******************************************************************
    // *********************** Part One **********************************
    // *******************************************************************

    public void testGetID() {
        String input = "#14324 @ 10,3: 4x4";
        assertEquals(14324, fabric.getId(input));
    }


    public void testGetX() {
        String input = "#1 @ 10,3: 4x4";
        assertEquals(10, fabric.getX(input));
    }

    public void testGetY() {
        String input = "#1 @ 10,30: 4x4";
        assertEquals(30, fabric.getY(input));
    }

    public void testGetWidth() {
        String input = "#1 @ 10,30: 4x4";
        assertEquals(4, fabric.getWidth(input));
    }

    public void testGetHeight() {
        String input = "#1 @ 10,30: 4x4";
        assertEquals(4, fabric.getHeight(input));
    }

    public void testEightByEight() {
        fabric.initialiseCanvas(8, 8);
        fabric.processClaim("#1 @ 1,3: 4x4");
        fabric.visualiseCanvas();
    }


    public void testCollisions() {
        String firstInput = "#1 @ 1,3: 4x4";
        String secondInput = "#2 @ 3,1: 4x4";
        fabric.initialiseCanvas(8, 8);
        fabric.processClaim(firstInput);
        fabric.processClaim(secondInput);
        fabric.visualiseCanvas();
    }


    public void testCollisionsAndGetTotal() {
        String firstInput = "#1 @ 1,3: 4x4";
        String secondInput = "#2 @ 3,1: 4x4";
        fabric.initialiseCanvas(8, 8);

        List<String> inputs = new ArrayList<>();
        inputs.add(firstInput);
        inputs.add(secondInput);

        int total = fabric.processClaimsAndGetTotal(inputs);

        fabric.visualiseCanvas();
        assertEquals(4, total);
    }

    public void testWithActualData() {
        fabric.initialiseCanvas(2000, 2000);
        assertEquals(124850, fabric.processClaimsAndGetTotal(this.actualData));
    }


    // *******************************************************************
    // *********************** Part Two **********************************
    // *******************************************************************

    public void testGetFabricThatWasntCompromised() {
        String firstInput = "#1 @ 1,3: 4x4";
        String secondInput = "#2 @ 3,1: 4x4";
        String thirdInput = "#3 @ 5,5: 2x2";
        fabric.initialiseCanvas(8, 8);

        List<String> inputs = new ArrayList<>();
        inputs.add(firstInput);
        inputs.add(secondInput);
        inputs.add(thirdInput);

        int uncompromised = fabric.processClaimsAndGetFabricWhichIsntCompromised(inputs);
        fabric.visualiseCanvas();
        assertEquals(3,uncompromised);


    }

    public void testProcessClaimsAndGetFabricWhichIsntCompromised() {
        fabric.initialiseCanvas(2000, 2000);
        assertEquals(1097,fabric.processClaimsAndGetFabricWhichIsntCompromised(this.actualData));
    }


}