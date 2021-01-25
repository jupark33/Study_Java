 
public class DateUtil {

  // Java7
  public static long diffDays(Date a, Date b) {
    long diff = Math.abs(a.getTime() - b.getTime());
    long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLESECONDS);
    return days;
  }
}
