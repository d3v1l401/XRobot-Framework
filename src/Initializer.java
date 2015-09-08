import lejos.nxt.LCD;

public class Initializer
{
   private static String m_InitString = 
           "[X]Robot Fram.\n" // Please, leave this here as it is.
         + "by Luca M. Fran.\n"
         + "(240068@via.dk)\n";
   
   // Logo task is NOT easy (use online generators but will not be enough).
   // Remember it's display is 100x100 px.
   private static String m_Logo =
         "          ,--.!,\n       __/   -*-\n     ,d08b.  '|`\n     0088MM     \n     `9MMP'     \n\n  LMF (240068)   \n";
   
   // We do not have a big amount of memory, let's save as much bytes as possible.
   // sizeof(byte) = 1 instead of sizeof(int) = 4.
   private static byte m_Timeout = 1;
   
   private static void Sleep()
   {
      // I hate this thread sleep with mandatory try.
      try
      {
        Thread.sleep(m_Timeout * 1000);
      } catch (InterruptedException e) {
        System.out.print(e.getMessage().toString());
      }
   }
   
   public static void SetTimeout(int Value)
   {
      m_Timeout = (byte)Value;
   }
   
   // Prints just the credits.
   public static void PrintCredits()
   {
      LCD.drawString(m_InitString, 0, 0);
      Sleep();
      LCD.clear();
   }
   
   // Prints the credits AND the logo after x amount of seconds.
   public static void PrintCreditsAndLogo()
   {
       PrintCredits();
       LCD.refresh();
       Sleep();
       
       LCD.drawString(m_Logo, 0, 0);
       LCD.refresh();
       Sleep();
       LCD.clear();
   }
}
