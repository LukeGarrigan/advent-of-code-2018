package day7;

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
public class SantasSleighTest extends TestCase {


    private SantasSleigh santasSleigh = new SantasSleigh();

    public void testGetStep() {
        String line = "Step C must be finished before step A can begin.";
        assertEquals("C", santasSleigh.getStep(line));
    }

    public void testGetBeforeLetter() {
        String line = "Step C must be finished before step A can begin.";
        assertEquals("A", santasSleigh.getBeforeLetter(line));
    }

    public void testBuildList() {

        String input = "Step C must be finished before step A can begin.\n" +
                "Step C must be finished before step F can begin.\n" +
                "Step A must be finished before step B can begin.\n" +
                "Step A must be finished before step D can begin.\n" +
                "Step B must be finished before step E can begin.\n" +
                "Step D must be finished before step E can begin.\n" +
                "Step F must be finished before step E can begin.";


        String[] split = input.split("\n");


        List<String> strings = Arrays.asList(split);


        assertEquals(6, santasSleigh.processInstructions(strings).size());
    }


    public void testPartOneWithTheirTestData() {

        String input = "Step C must be finished before step A can begin.\n" +
                "Step C must be finished before step F can begin.\n" +
                "Step B must be finished before step E can begin.\n" +
                "Step A must be finished before step B can begin.\n" +
                "Step A must be finished before step D can begin.\n" +
                "Step F must be finished before step E can begin.\n"+
                "Step D must be finished before step E can begin.";


        String[] split = input.split("\n");
        List<String> strings = Arrays.asList(split);

        assertEquals("CABDFE", santasSleigh.doPartOne(strings));
    }

    public void testPartOneMyOwnData() {

        String input ="Step E must be finished before step X can begin.\n"+
                "Step C must be finished before step A can begin.\n" +
                "Step C must be finished before step F can begin.\n" +
                "Step B must be finished before step E can begin.\n" +
                "Step A must be finished before step B can begin.\n" +
                "Step A must be finished before step D can begin.\n" +
                "Step F must be finished before step E can begin.\n"+
                "Step D must be finished before step E can begin.\n"+
                "Step E must be finished before step L can begin.\n";



        String[] split = input.split("\n");
        List<String> strings = Arrays.asList(split);

        assertEquals("CABDFELX", santasSleigh.doPartOne(strings));
    }

    public void testPartOneMyOwnDataTwo(){

        String input ="Step A must be finished before step B can begin.\n"+
                "Step A must be finished before step E can begin.\n"+
                "Step E must be finished before step D can begin.\n"+
                "Step B must be finished before step C can begin.\n"+
                "Step C must be finished before step D can begin.\n";

        String[] split = input.split("\n");
        List<String> strings = Arrays.asList(split);

        assertEquals("ABCED", santasSleigh.doPartOne(strings));

    }


    public void testPartOneMyOwnDataThree(){

        String input ="Step A must be finished before step B can begin.\n"+
                "Step A must be finished before step E can begin.\n"+
                "Step E must be finished before step D can begin.\n"+
                "Step B must be finished before step C can begin.\n"+
                "Step C must be finished before step D can begin.\n";

        String[] split = input.split("\n");
        List<String> strings = Arrays.asList(split);

        assertEquals("ABCED", santasSleigh.doPartOne(strings));

    }


    public void testPartOneMyOwnDataFour(){

        String input ="Step A must be finished before step B can begin.\n"+
                "Step A must be finished before step E can begin.\n"+
                "Step B must be finished before step C can begin.\n"+
                "Step E must be finished before step C can begin.\n"+
                "Step C must be finished before step D can begin.\n";

        String[] split = input.split("\n");
        List<String> strings = Arrays.asList(split);

        assertEquals("ABECD", santasSleigh.doPartOne(strings));

    }

    public void testWithOtherData() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/test/java/day7/other-data.txt"));
        List<String> actualData = new ArrayList<>();
        while(scanner.hasNext()) {
            actualData.add(scanner.nextLine());
        }

        //TCVYHRUBJQOWSXINMLAFGPEZKD <- unsorted

        assertEquals("BITRAQVSGUWKXYHMZPOCDLJNFE", santasSleigh.doPartOne(actualData));
    }

    public void testPartOneWithActualData() throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader("src/test/java/day7/data.txt"));
        List<String> actualData = new ArrayList<>();
        while(scanner.hasNext()) {
            actualData.add(scanner.nextLine());
        }
        // Attempted
        // YJKQVXBZDEGAPSUWT
        // CIBEHLFNAMOUDPRYKGQVWZSJTX
        // CIBHNLFAOYQMRXUKVGZPWDSJET
        assertEquals("CIBEHLFNAMOUDPRYKGQVWZSJTX", santasSleigh.doPartOne(actualData));
    }



}