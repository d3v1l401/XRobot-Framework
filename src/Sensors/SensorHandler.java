package Sensors;
import Waiter.Waiter;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class SensorHandler extends Thread implements Runnable
{
   public final static byte SENSOR_TOUCH = 1;
   public final static byte SENSOR_VIEW  = 2;
   public final static byte SENSOR_LIGHT = 3;
   public final static byte SENSOR_TEST  = 4;
   
   public final static byte SENSOR_SLOT_1 = 1;
   public final static byte SENSOR_SLOT_2 = 2;
   public final static byte SENSOR_SLOT_3 = 3;
   public final static byte SENSOR_SLOT_4 = 4;
   
   private boolean m_BumpSignal = false;
   private byte    m_SensorType = 0;
   private byte    m_Port       = 0;
   private byte    g_LightLimit = 50;
   
   private LightSensor m_LightSense;
   
   public void SetBumpLimit(byte Value)
   {
      if (Value >= 0 | Value <= 100)
         this.g_LightLimit = Value;
   }
   
   public SensorHandler(byte SensorType, byte Port)
   {
      // Including 4 just for testing purpose.
      if (SensorType <= 4 | SensorType >= 1)
         this.m_SensorType = SensorType;
      
      if (Port <= 4 | Port >= 1)
         this.m_Port = Port;
      
      if (this.m_SensorType == SENSOR_LIGHT)
      {
         switch (Port)
         {
            case SENSOR_SLOT_1:
               this.m_LightSense = new LightSensor(SensorPort.S1);
               break;
               
            case SENSOR_SLOT_2:
               this.m_LightSense = new LightSensor(SensorPort.S2);
               break;
               
            case SENSOR_SLOT_3:
               this.m_LightSense = new LightSensor(SensorPort.S3);
               break;
   
            case SENSOR_SLOT_4:
               this.m_LightSense = new LightSensor(SensorPort.S4);
               break;
             default:
                return;
         }
         
      }
      
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
            
            if (this.m_LightSense.getLightValue() > this.g_LightLimit)
               this.m_BumpSignal = true;
            else
               this.m_BumpSignal = false;
            
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
