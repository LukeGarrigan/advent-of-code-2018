package day4;

import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lukegarrigan on 14/12/2018.
 */
public class SleepyGuardTest extends TestCase {


    private SleepyGuard sleepyGuard = new SleepyGuard();


    private List<String> actualData = new ArrayList<>();
    public void setUp() throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader("src/test/java/day4/data.txt"));
        while(scanner.hasNext()) {
            actualData.add(scanner.nextLine());
        }


    }
    public void testGetMonth() {
        String input = "[1518-11-01 00:00] Guard #10 begins shift";
        assertEquals("11", sleepyGuard.getMonth(input));
    }

    public void testGetDay() {
        String input = "[1518-11-01 00:00] Guard #10 begins shift";
        assertEquals("01", sleepyGuard.getDay(input));
    }


    public void testGetActionBeginsShift() {
        String input = "[1518-11-01 00:00] Guard #10 begins shift";
        assertEquals(GuardAction.STARTS_SHIFT, sleepyGuard.getAction(input));
    }

    public void testGetActionFallsAsleep() {
        String input = "[1518-11-01 00:00] falls asleep";
        assertEquals(GuardAction.FALLS_ASLEEP, sleepyGuard.getAction(input));
    }

    public void testGetActionWakesUp() {
        String input = "[1518-11-01 00:00] wakes up";
        assertEquals(GuardAction.WAKES_UP, sleepyGuard.getAction(input));
    }

    public void testGetGuardId() {
        String input = "[1518-11-01 00:00] Guard #10 begins shift";
        assertEquals("10", sleepyGuard.getGuardId(input));
    }

    public void testGetMinute() {
        String input = "[1518-11-01 00:13] Guard #10 begins shift";
        assertEquals("13", sleepyGuard.getMinute(input));
    }


    public void testProcessGuardShift() {

        String shift = "[1518-11-01 00:00] Guard #10 begins shift\n" +
                "[1518-11-01 00:05] falls asleep\n" +
                "[1518-11-01 00:25] wakes up\n" +
                "[1518-11-01 00:30] falls asleep\n" +
                "[1518-11-01 00:55] wakes up";

        List<String> guardsShift = Arrays.asList(shift.split("\n"));

        sleepyGuard.processGuardsShift(guardsShift);


        assertEquals(45, sleepyGuard.getAllGuards().get(0).getTotalSleepTime());
    }


    public void testProcessAllGuardsShifts() {
        String shift = "[1518-11-01 00:00] Guard #10 begins shift\n" +
                "[1518-11-01 00:05] falls asleep\n" +
                "[1518-11-01 00:25] wakes up\n" +
                "[1518-11-01 00:30] falls asleep\n" +
                "[1518-11-01 00:55] wakes up\n" +
                "[1518-11-01 23:58] Guard #99 begins shift\n" +
                "[1518-11-02 00:40] falls asleep\n" +
                "[1518-11-02 00:50] wakes up\n" +
                "[1518-11-03 00:05] Guard #10 begins shift\n" +
                "[1518-11-03 00:24] falls asleep\n" +
                "[1518-11-03 00:29] wakes up\n" +
                "[1518-11-04 00:02] Guard #99 begins shift\n" +
                "[1518-11-04 00:36] falls asleep\n" +
                "[1518-11-04 00:46] wakes up\n" +
                "[1518-11-05 00:03] Guard #99 begins shift\n" +
                "[1518-11-05 00:45] falls asleep\n" +
                "[1518-11-05 00:55] wakes up";


        List<String> guardsShifts = Arrays.asList(shift.split("\n"));
        sleepyGuard.processAllGuardsShifts(guardsShifts);


        assertEquals("10",sleepyGuard.getGuardWhoSleptTheMost().getId());



    }


    public void testMinuteSpendAsleepTheMost() {
        String shift = "[1518-11-01 00:00] Guard #10 begins shift\n" +
                "[1518-11-01 00:05] falls asleep\n" +
                "[1518-11-01 00:25] wakes up\n" +
                "[1518-11-01 00:30] falls asleep\n" +
                "[1518-11-01 00:55] wakes up\n" +
                "[1518-11-01 23:58] Guard #99 begins shift\n" +
                "[1518-11-02 00:40] falls asleep\n" +
                "[1518-11-02 00:50] wakes up\n" +
                "[1518-11-03 00:05] Guard #10 begins shift\n" +
                "[1518-11-03 00:24] falls asleep\n" +
                "[1518-11-03 00:29] wakes up\n" +
                "[1518-11-04 00:02] Guard #99 begins shift\n" +
                "[1518-11-04 00:36] falls asleep\n" +
                "[1518-11-04 00:46] wakes up\n" +
                "[1518-11-05 00:03] Guard #99 begins shift\n" +
                "[1518-11-05 00:45] falls asleep\n" +
                "[1518-11-05 00:55] wakes up";


        List<String> guardsShifts = Arrays.asList(shift.split("\n"));
        sleepyGuard.processAllGuardsShifts(guardsShifts);


        assertEquals(24,sleepyGuard.getGuardWhoSleptTheMost().whatMinuteDoesTheGuardSpendAlseepTheMost().getMinute());

    }


    public void testStrategyOne() {
        String shift = "[1518-11-01 00:00] Guard #10 begins shift\n" +
                "[1518-11-01 00:05] falls asleep\n" +
                "[1518-11-01 00:25] wakes up\n" +
                "[1518-11-01 00:30] falls asleep\n" +
                "[1518-11-01 00:55] wakes up\n" +
                "[1518-11-01 23:58] Guard #99 begins shift\n" +
                "[1518-11-02 00:40] falls asleep\n" +
                "[1518-11-02 00:50] wakes up\n" +
                "[1518-11-03 00:05] Guard #10 begins shift\n" +
                "[1518-11-03 00:24] falls asleep\n" +
                "[1518-11-03 00:29] wakes up\n" +
                "[1518-11-04 00:02] Guard #99 begins shift\n" +
                "[1518-11-04 00:36] falls asleep\n" +
                "[1518-11-04 00:46] wakes up\n" +
                "[1518-11-05 00:03] Guard #99 begins shift\n" +
                "[1518-11-05 00:45] falls asleep\n" +
                "[1518-11-05 00:55] wakes up";

        List<String> guardsShifts = Arrays.asList(shift.split("\n"));
        assertEquals(240,sleepyGuard.strategyOne(guardsShifts));

    }


    public void testGetDate() throws ParseException {
        String input = "[1518-11-01 00:10] Guard #10 begins shift";

        assertEquals(-14236645800000L, sleepyGuard.getDate(input).getTime());

    }

    public void testSortDates() {
        String shift = "[1518-11-01 23:58] Guard #99 begins shift\n" +
                "[1518-11-02 00:40] falls asleep\n" +
                "[1518-11-02 00:50] wakes up\n" +
                "[1518-11-01 00:00] Guard #10 begins shift\n" +
                "[1518-11-01 00:05] falls asleep\n" +
                "[1518-11-01 00:25] wakes up\n" +
                "[1518-11-01 00:30] falls asleep\n" +
                "[1518-11-01 00:55] wakes up";

        List<String> guardsShifts = Arrays.asList(shift.split("\n"));
        List<String> sortedDates = sleepyGuard.sortByDates(guardsShifts);
    }


    public void testActualDataForPartOne() {
        assertEquals(19830, sleepyGuard.strategyOne(this.actualData));
    }




    public void testMinuteSpentAsleepTheMost() {
        String shift = "[1518-11-01 00:00] Guard #10 begins shift\n" +
                "[1518-11-01 00:05] falls asleep\n" +
                "[1518-11-01 00:25] wakes up\n" +
                "[1518-11-01 00:30] falls asleep\n" +
                "[1518-11-01 00:55] wakes up\n" +
                "[1518-11-01 23:58] Guard #99 begins shift\n" +
                "[1518-11-02 00:40] falls asleep\n" +
                "[1518-11-02 00:50] wakes up\n" +
                "[1518-11-03 00:05] Guard #10 begins shift\n" +
                "[1518-11-03 00:24] falls asleep\n" +
                "[1518-11-03 00:29] wakes up\n" +
                "[1518-11-04 00:02] Guard #99 begins shift\n" +
                "[1518-11-04 00:36] falls asleep\n" +
                "[1518-11-04 00:46] wakes up\n" +
                "[1518-11-05 00:03] Guard #99 begins shift\n" +
                "[1518-11-05 00:45] falls asleep\n" +
                "[1518-11-05 00:55] wakes up";

        List<String> guardsShifts = Arrays.asList(shift.split("\n"));

        assertEquals(4455, sleepyGuard.strategyTwo(guardsShifts));
    }

    public void testActualDataStrategyTwo() {
        assertEquals(43695, sleepyGuard.strategyTwo(this.actualData));
    }



}