package day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Luke.Garrigan
 * @since 06/12/2018
 */
public class Guard {

    private List<Shift> shifts = new ArrayList<>();
    private String id;
    public Guard(String id) {
        this.id = id;
    }


    public Shift addShift(String date) {
        Shift shift = new Shift(date);
        shifts.add(shift);
        return shift;
    }


    public String getId() {
        return id;
    }

    public Shift getShift(String date) {
        for (Shift shift : shifts) {
            if (shift.getDate().equals(date)) {
                return shift;
            }
        }
        return null;
    }

    public int getTotalSleepTime() {

        int total = 0;
        for (Shift shift : shifts) {
            List<Boolean> moments = shift.getMoments();
            for (Boolean moment : moments) {
                if (moment) total ++;
            }
        }

        return total;
    }



    public WinningTime whatMinuteDoesTheGuardSpendAlseepTheMost() {
        Map<Integer, Integer> minuteAsleepCount = new HashMap<>();
        for (Shift shift : shifts) {

            for (int i = 0; i < shift.getMoments().size(); i++) {


                Boolean wasAsleep = shift.getMoments().get(i);

                if (wasAsleep) {
                    if (minuteAsleepCount.get(i) == null) {
                        minuteAsleepCount.put(i, 1);
                    } else {
                        minuteAsleepCount.put(i,minuteAsleepCount.get(i) +1);
                    }
                }
            }
        }



        return findLargestCount(minuteAsleepCount);
    }

    private WinningTime findLargestCount(Map<Integer, Integer> minuteAsleepCount) {
        int biggest = Integer.MIN_VALUE;
        int minute = 0;

        for (Map.Entry<Integer, Integer> moments : minuteAsleepCount.entrySet()) {
            if (moments.getValue() > biggest) {
                biggest = moments.getValue();
                minute = moments.getKey();
            }
        }

        WinningTime winner = new WinningTime(minute, biggest);
        return winner;
    }
}
