// You have to import each motor you need.
import Motors.Motor;
import Sensors.SensorHandler;
import LCD.LCDHandler;
import Waiter.Waiter;



@SuppressWarnings("unused")
public class Main
{
   private static Motor         m_MoA = new Motor(Motor.MOTOR_SLOT_A);
   // Our project does not have any Motor in slot B.
   //private static Motor m_MoB      = new Motor(Motor.MOTOR_SLOT_B);
   private static Motor         m_MoC = new Motor(Motor.MOTOR_SLOT_C);
   private static LCDHandler    m_LCD = new LCDHandler();
   private static SensorHandler m_SHt = new SensorHandler(SensorHandler.SENSOR_TEST);
   
   
   public static void main(String Args[])
   {
      // There are NO ARGUMENTS PARSED in LEGO software.
      Initializer.SetTimeout(1);
      // A super villain is a villain who can make glorious presentations.
      Initializer.PrintCreditsAndLogo();
      
      //Movements Mov = new Movements(m_MoA, m_MoC);
      
      m_LCD.Write("Awaiting...");
      
      // A valid alternative to sleep().
      // We don't want to pause the main thread, because if so, the entire software
      // even the Motors threads would stop (if Main Thread dies, every slave dies).
      // So we just let him wait by counting the time elapsed.
      Waiter.Counter(2);
      
      m_LCD.Clean();
      
      boolean StartedMotors = false;
      
      while (true)
      {
         // this
         if (!StartedMotors)
         {
            m_MoA.start();
            m_MoC.start();
            StartedMotors = true;
         }
         m_LCD.AWrite("Test Routine");
         Waiter.Counter(1);
         
         if (StartedMotors)
         {
            m_LCD.AWrite("Stopping motor A");
            m_MoA.SetDirection(Motor.DIRECTION_STOP);
            
            Waiter.Counter(2);
            
            m_LCD.AWrite("Stopping motor C");
            m_MoA.Resume();
            m_MoC.SetDirection(Motor.DIRECTION_STOP);
            
            Waiter.Counter(2);
            
            m_LCD.AWrite("Stopping motors");
            
            m_MoA.SetDirection(Motor.DIRECTION_STOP);
            
            Waiter.Counter(2);
            
            
            m_LCD.AWrite("Backwarding");
            m_MoA.SetDirection(Motor.DIRECTION_BACKWARD);
            m_MoC.SetDirection(Motor.DIRECTION_BACKWARD);
            
            m_MoA.Resume();
            m_MoC.Resume();
            
         }
         
         
         if (m_SHt.WaitSignal())
         {
            m_LCD.AWrite("SIGNAL.");
            // A signal has been parsed, meaning? We received a bump to the sensor.
            // So we actually got something.
            
         }
      }
      
   }
}
