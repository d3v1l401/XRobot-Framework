package Waiter;

public class Waiter
{
   public static void Counter(byte Seconds)
   {
      long Start = System.currentTimeMillis();
      while((System.currentTimeMillis() - Start) < (Seconds * 1000))
      {}
      return;
   }
}
