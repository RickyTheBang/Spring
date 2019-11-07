package housekeeping.aspects;

import java.util.Calendar;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {
   private int startHour;
   private int endHour;
  
   @Value("${timeAspect.startHour}")
   public void setStartHour(int startHour) {
      this.startHour = startHour;
   }

   @Value("${timeAspect.endHour}")
   public void setEndHour(int endHour) {
      this.endHour = endHour;
   }
      
   @Before("execution(* housekeeping.VacuumCleaner.doCleanJob(..))")
   public void checkTime() {
      Calendar now = Calendar.getInstance();
      int hour = now.get(Calendar.HOUR_OF_DAY);
      if(hour < startHour || hour >= endHour) {
         throw new TimeException("Operation not allowed at this time of the day");
      }
   }
}
