package Sensors;
import Waiter.Waiter;

public class SensorHandler extends Thread implements Runnable
{
   public final static byte SENSOR_TOUCH = 1;
   public final static byte SENSOR_VIEW  = 2;
   public final static byte SENSOR_LIGHT = 3;
   public final static byte SENSOR_TEST  = 4;
   
   private boolean m_BumpSignal = false;
   private byte    m_SensorType = 0;
   
   public SensorHandler(byte SensorType)
   {
      // Including 4 just for testing purpose.
      if (SensorType <= 4 | SensorType >= 1)
         this.m_SensorType = SensorType;
   }
   
   private void CheckBump()
   {
      switch (this.m_SensorType)
      {
         case SENSOR_TOUCH:
            
            
            
            break;
         case SENSOR_VIEW:
            
            
            
            break;
         case SENSOR_LIGHT:
            
            
            
            break;
         case SENSOR_TEST:

            boolean GiveIT = true;
            if (GiveIT == true)
               this.m_BumpSignal = true;
            
            break;
         default:
            return;
      }
   }
   
   public boolean WaitSignal()
   {
      do
         this.CheckBump();
      while (!this.m_BumpSignal);
      
      return true;
   }
   
   public void run()
   {
      // This will NOT returns the actual status, but will let you know it went ok
      // when the thread will die.
      this.WaitSignal();
   }
}
