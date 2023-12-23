/***
import java.time.*;
import java.time.format.DateTimeFormatter;
    public class Duration {
        public String StartTime ="08:00";
        public String EndTime = "23:00";
        public String NewStart = "00:00";
        static public int Increment = 0;

        public Duration(){
            LocalTime start = LocalTime.parse(StartTime);
            LocalTime end = LocalTime.parse(EndTime);
            LocalTime IncrementedStart = start.plusMinutes(Increment * 30L);
            Increment ++;
            DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");
            NewStart = tf.format(IncrementedStart);
        }

    /*public void setStartTime(String start){
        StartTime = start;
    }
    public void setEndTime(String end){
        EndTime = end;
    }


        public String getStartTime(){
            return NewStart;
        }
        public String getEndTime(){
            return EndTime;
        }
    }
*/

