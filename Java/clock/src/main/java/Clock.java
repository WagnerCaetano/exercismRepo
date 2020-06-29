import java.util.Objects;

public class Clock{

    private int hours;
    private int minutes;

    public Clock(int hours,int minutes)
    {
        addHours(hours);
        add(minutes);
    }
    // ATENÇÃO MUDEI O NOME DESSE MÉTODO DE add PARA addMinutes
    public void add(int minutes)
    {
        if(minutes>0){
            for (int i = 0; i < minutes; i++) {
                addOneMinute();
            }
        }
        else
            removeMinutes(minutes);
    }
    private void addOneMinute(){
        this.minutes++;
        if(this.minutes>=60) {
            addOneHour();
            this.minutes = 0;
        }
    }
    public void addHours(int hours)
    {
        if(hours>0){
            for (int i = 0; i < hours; i++) {
                addOneHour();
            }
        }
        else{
            removeHours(hours);
        }
    }
    private void addOneHour(){
        this.hours++;
        if(this.hours>=24) {
            this.hours = 0;
        }
    }
    private void removeHours(int hoursToRemove){
        hoursToRemove = modulo(hoursToRemove);
        for(;hoursToRemove>0;hoursToRemove--){
            removeOneHour();
        }
    }
    private void removeOneHour(){
        this.hours--;
        if(this.hours<0){
            this.hours = 23;
        }
    }
    private void removeMinutes(int minutesToRemove){
        minutesToRemove = modulo(minutesToRemove);
        for (;minutesToRemove>0;minutesToRemove--) {
            removeOneMinute();
        }
    }
    private void removeOneMinute()
    {
        this.minutes--;
        if(this.minutes<0) {
            removeOneHour();
            this.minutes = 59;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Clock clock = (Clock) o;
        return hours == clock.hours && minutes == clock.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes);
    }

    @Override
    public String toString() {
        String hours = "";
        String minutes = "";
        if(this.hours<10) {
            hours = new StringBuilder().append("0").append(this.hours).toString();
        }
        else{
            hours = this.hours+"";
        }
        if(this.minutes<10){
            minutes = new StringBuilder().append("0").append(this.minutes).toString();
        }
        else {
            minutes = this.minutes+"";
        }
        return new StringBuilder()
                .append(hours).append(":").append(minutes).toString();
    }

    public static int modulo(int inteiroNegativo)
    {
        return inteiroNegativo*(-1);
    }
}