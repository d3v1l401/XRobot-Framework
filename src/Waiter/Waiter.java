package Waiter;

public class Waiter
{
   public static void Counter(int i)
   {
      long Start = System.currentTimeMillis();
      while((System.currentTimeMillis() - Start) < (i * 1000))
      {}
      return;
   }
}
