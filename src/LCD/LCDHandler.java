package LCD;
import lejos.nxt.LCD;
import lejos.nxt.Button;

@SuppressWarnings("unused")
public class LCDHandler
{
   public final static byte INPUT_ANY           = 1;
   public final static byte INPUT_ORANGE_BOX    = 2;
   public final static byte INPUT_ARROW_LEFT    = 3;
   public final static byte INPUT_ARROW_RIGHT   = 4;
   public final static byte INPUT_ARROW_DOWN    = 5;
   
   private final byte m_ScreenSize  = 100; // 100x200 pixels
   
   private byte m_Sections          = 0;
   private byte m_AxysFactor        = 100;
   
   // Don't mind about this, it's just for testing purpose.
   public void TestLCD()
   {
      for (int i = 0; i <= this.m_ScreenSize; i++)
      {
         for (int k = 0; k <= (this.m_ScreenSize + 100); k++)
         {
            LCD.setPixel(i, k, 1);
         }
      }
   }
   
   public void Write(String Message)
   {
      LCD.drawString(Message, 1, 1);
   }
   
   public void Clean()
   {
      LCD.clear();
   }
   
   public void WaitForInput(byte InputType)
   {
      switch (InputType)
      {
         case INPUT_ANY:
            Button.waitForAnyPress();
            break;
         case INPUT_ORANGE_BOX:
            // TODOs.
            break;
            
      }
   }
   
   public void Initialize(byte Sections)
   {
      this.m_Sections = Sections;
      for (int i = 0; i <= Sections; i++)
      {
         this.m_AxysFactor /= i;
      }
   }
}
