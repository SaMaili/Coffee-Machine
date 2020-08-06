class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        minutes++;
        if (minutes >= 60) {
            minutes -= 60;
            if (++hours > 12) {
                hours = 1;
            }
        }
        //String formattedHours = (hours < 10 ? "0" + hours : String.valueOf(hours));
        //String formattedMinutes = (minutes < 10 ? "0" + minutes : String.valueOf(minutes));
        //System.out.println("time is " + formattedHours + ":" + formattedMinutes);
    }
}
