package ua.opnu;


public class TimeSpan {

    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            return;
        }

        int currentTotalMinutes = this.hours * 60 + this.minutes;
        int addedTotalMinutes = hours * 60 + minutes;
        int newTotalMinutes = currentTotalMinutes + addedTotalMinutes;

        this.hours = newTotalMinutes / 60;
        this.minutes = newTotalMinutes % 60;
    }

    public void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    public double getTotalHours() {
        return this.hours + (this.minutes / 60.0);
    }

    public int getTotalMinutes() {
        return this.hours * 60 + this.minutes;
    }

    public void subtract(TimeSpan span) {
        int thisAsMinutes = this.getTotalMinutes();
        int spanAsMinutes = span.getTotalMinutes();

        if (thisAsMinutes < spanAsMinutes) {
            return;
        }

        int resultAsMinutes = thisAsMinutes - spanAsMinutes;
        this.hours = resultAsMinutes / 60;
        this.minutes = resultAsMinutes % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) {
            return;
        }
        int totalMinutes = this.getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}
