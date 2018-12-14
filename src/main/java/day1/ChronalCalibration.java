package day1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukegarrigan on 03/12/2018.
 */
public class ChronalCalibration {


    /**
     * Part 1
     * @param input
     * @return
     */
    public int getResultantFrequency(String input) {
        String[] numbers = input.split("\n");

        int total = 0;
        for (String number: numbers) {
            total = addNumberToTotal(total, number);
        }
        return total;

    }


    /**
     * Part 2
     * @param input
     * @return
     */
    public int getFrequencyHitFirst(String input) {
        List<Integer> frequenciesHit  = new ArrayList<>();
        String[] numbers = input.split("\n");
        int total = 0;
        frequenciesHit.add(total);

        int i = 0;
        while (true) {

            String number = numbers[i];

            total = addNumberToTotal(total, number);

            if (!frequenciesHit.contains(total)) {
                frequenciesHit.add(total);
            } else {
                return total;
            }

            i++;
            if (i==numbers.length) {
                i = 0;
            }
        }

    }

    private int addNumberToTotal(int total, String number) {
        if (number.charAt(0) == '+') {
            total +=  Integer.parseInt(number.substring(1, number.length()));
        } else {
            total -= Integer.parseInt(number.substring(1, number.length()));
        }
        return total;
    }


}
