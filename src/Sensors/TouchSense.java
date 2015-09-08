package Sensors;
import lejos.nxt.ADSensorPort;
import lejos.nxt.TouchSensor;

public class TouchSense extends Thread implements Runnable
{
   private byte m_IsPressed    = -1;
   private byte m_IsDown       = -1;
   
   private TouchSensor m_TSensor = null;
   private ADSensorPort m_ADSP = null;
   
   protected boolean s_ActiveCheck = false;
   
   public TouchSense(boolean ActivateCheck)
   {
      this.s_ActiveCheck = ActivateCheck;
   }
   
   public void run()
   {
      while (this.s_ActiveCheck)
      {
         
      }
   }
}
