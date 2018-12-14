package day4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luke.Garrigan
 * @since 06/12/2018
 */
public class Shift {

    private String date;
    private List<Boolean> moments = new ArrayList<>();

    public Shift(String date) {
        this.date = date;
        for (int i = 0; i < 60; i++) {
            moments.add(false);
        }
    }

    public void updateTimeAsleep(String timeFellAsleep, String timeWokeUp) {
        int start = Integer.parseInt(timeFellAsleep);
        int end = Integer.parseInt(timeWokeUp);

        for (int i = start; i < end; i++) {
            moments.set(i, true);
        }

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Boolean> getMoments() {
        return moments;
    }

    public void setMoments(List<Boolean> moments) {
        this.moments = moments;
    }
}
