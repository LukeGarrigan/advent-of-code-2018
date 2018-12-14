package day4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Luke.Garrigan
 * @since 06/12/2018
 */
public class SleepyGuard {


    private List<Guard> allGuards = new ArrayList<>();


    public int strategyTwo(List<String> allGuardsShifts) {

        allGuardsShifts = sortByDates(allGuardsShifts);
        processAllGuardsShifts(allGuardsShifts);


        WinningTime winningTime = null;
        int guardId = 0;
        int biggestTimeSoFar = Integer.MIN_VALUE;
        for (Guard currentGuard : allGuards) {
            WinningTime guardsBest = currentGuard.whatMinuteDoesTheGuardSpendAlseepTheMost();
            if (guardsBest.getTime() > biggestTimeSoFar) {
                winningTime = guardsBest;
                biggestTimeSoFar = guardsBest.getTime();
                guardId = Integer.parseInt(currentGuard.getId());
            }
        }


        return winningTime.getMinute() * guardId;
    }

    public int strategyOne(List<String> allGuardsShifts) {

        allGuardsShifts = sortByDates(allGuardsShifts);
        processAllGuardsShifts(allGuardsShifts);

        Guard guardWhoSleptTheMost = getGuardWhoSleptTheMost();

        int id = Integer.parseInt(guardWhoSleptTheMost.getId());
        int favoriteSleepMinute = guardWhoSleptTheMost.whatMinuteDoesTheGuardSpendAlseepTheMost().getMinute();

        return id * favoriteSleepMinute;

    }


    public List<String> sortByDates(List<String> allGuardsShifts) {

        Collections.sort(allGuardsShifts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                try {
                    if (getDate(o1).getTime() > getDate(o2).getTime()) {
                        return 1;
                    } else if (getDate(o1).getTime() == getDate(o2).getTime()) {
                        return 0;
                    } else {
                        return -1;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                    return -1;
                }
            }

        });
        return allGuardsShifts;

    }

    public Date getDate(String input) throws ParseException {
        String dateAsString = input.substring(1, input.indexOf("]"));


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        Date date = dateFormat.parse(dateAsString);
        return date;
    }

    public void processAllGuardsShifts(List<String> allShifts) {
        List<String> oneGuardsShift = new ArrayList<>();
        for (int i = 0; i < allShifts.size(); i++) {
            String line = allShifts.get(i);
            if (getAction(line) == GuardAction.STARTS_SHIFT || i == allShifts.size()-1) {

                if (i == allShifts.size()-1) {
                    oneGuardsShift.add(line);
                }

                if (!oneGuardsShift.isEmpty()) {
                    processGuardsShift(oneGuardsShift);
                }
                oneGuardsShift = new ArrayList<>();
            }

            oneGuardsShift.add(line);
        }

    }


    public void processGuardsShift(List<String> shiftAsLines) {
        String startShiftLine = shiftAsLines.get(0);
        String guardId = getGuardId(startShiftLine);

        Guard guard = getGuard(guardId);

        if (guard == null) {
            guard = new Guard(guardId);
            allGuards.add(guard);
        }

        Shift shift = guard.addShift(getDay(startShiftLine) + "-" + getMonth(startShiftLine));

        for (int i = 1; i < shiftAsLines.size(); i++) {
            String currentLine = shiftAsLines.get(i);
            if (getAction(currentLine) == GuardAction.FALLS_ASLEEP) {
                processGuardFallingAsleep(currentLine, i, shiftAsLines, guard, shift);
            }
        }

    }


    public Guard getGuardWhoSleptTheMost() {
        int highest = Integer.MIN_VALUE;
        Guard guard = null;
        for (Guard allGuard : allGuards) {
            if (allGuard.getTotalSleepTime() > highest) {
                highest = allGuard.getTotalSleepTime();
                guard = allGuard;
            }
        }
        return guard;
    }

    private void processGuardFallingAsleep(String currentShiftAsString, int i, List<String> shift, Guard guard, Shift actualShift) {
        String startedAsleep = getMinute(currentShiftAsString);


        String wakeupTime = null;
        String date = null;
        for (int j = i; j < shift.size(); j++) {
            String currentLine = shift.get(j);
            if (getAction(currentLine) == GuardAction.WAKES_UP) {
                wakeupTime = getMinute(currentLine);
                break;
            }
        }

        if (wakeupTime != null) {
            actualShift.updateTimeAsleep(startedAsleep, wakeupTime);
        }


    }

    private Guard getGuard(String guardId) {
        for (Guard allGuard : allGuards) {
            if (allGuard.getId().equals(guardId)) {
                return allGuard;
            }
        }
        return null;
    }


    public String getGuardId(String input) {
        return input.substring(input.indexOf('#') + 1, input.indexOf('b') - 1);
    }

    public String getMonth(String input) {
        int firstDash = input.indexOf('-');
        return input.substring(firstDash + 1, input.indexOf('-', firstDash + 1));
    }

    public String getDay(String input) {
        int firstDash = input.indexOf('-');
        int secondDash = input.indexOf('-', firstDash + 1);
        return input.substring(secondDash + 1, input.indexOf(" "));
    }


    public GuardAction getAction(String input) {
        if (input.contains("wakes up")) {
            return GuardAction.WAKES_UP;
        } else if (input.contains("falls asleep")) {
            return GuardAction.FALLS_ASLEEP;
        } else {
            return GuardAction.STARTS_SHIFT;
        }
    }


    public String getMinute(String input) {
        return input.substring(input.indexOf(':') + 1, input.indexOf(']'));
    }

    public List<Guard> getAllGuards() {
        return allGuards;
    }


}
