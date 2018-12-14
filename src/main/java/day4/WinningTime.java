package day4;

/**
 * @author Luke.Garrigan
 * @since 06/12/2018
 */
public class WinningTime {

    private int minute;
    private int time;

    public WinningTime(int minute, int time) {
        this.minute = minute;
        this.time = time;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
