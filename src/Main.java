// You have to import each motor you need.
import Motors.Motor;
import LCD.LCDHandler;
import Waiter.Waiter;

@SuppressWarnings("unused")
public class Main
{
   private static Motor      m_MoA = new Motor(Motor.MOTOR_SLOT_A);
   // Our project does not have any Motor in slot B.
   //private static Motor m_MoB      = new Motor(Motor.MOTOR_SLOT_B);
   private static Motor      m_MoC = new Motor(Motor.MOTOR_SLOT_C);
   private static LCDHandler m_LCD = new LCDHandler();
   
   
   public static void main(String Args[])
   {
      // There are NO ARGUMENTS PARSED in LEGO software.
      Initializer.SetTimeout(1);
      // A super villain is a villain who can make glorious presentations.
      Initializer.PrintCreditsAndLogo();
      
      m_MoA.start();
      m_MoC.start();
      
      //Movements Mov = new Movements(m_MoA, m_MoC);
      
      // A valid alternative to sleep().
      // We don't want to pause the main thread, because if so, the entire software
      // even the Motors threads would stop (if Main Thread dies, every slave dies).
      // So we just let him wait by counting the time elapsed.
      Waiter.Counter((byte)2);
      
      
   }
}
