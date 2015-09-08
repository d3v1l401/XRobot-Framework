package Motors;
import lejos.nxt.MotorPort;

public class Motor extends Thread implements Runnable
{
   public final static byte DIRECTION_FORWARD    = 2;
   public final static byte DIRECTION_BACKWARD   = 1;
   public final static byte DIRECTION_STOP       = 3;
   
   public final static byte MOTOR_SLOT_A         = 1;
   public final static byte MOTOR_SLOT_B         = 2;
   public final static byte MOTOR_SLOT_C         = 3;
   
   private byte m_Motor     = 0;
   private byte m_Speed     = 100;
   private byte m_Direction = DIRECTION_FORWARD;
   
   public Motor(byte MotorSlot)
   {
      if (MotorSlot <= 3 | MotorSlot >= 1)
         this.m_Motor = MotorSlot;
   }
   
   public void SetSpeed(byte Speed)
   {
      if (Speed <= 100 | Speed >= 1)
         this.m_Speed = Speed;
   }
   
   public void run()
   {
      while (this.m_Direction != DIRECTION_STOP)
      {
         switch (this.m_Motor)
         {
            case MOTOR_SLOT_A:
               MotorPort.A.controlMotor(this.m_Speed, this.m_Direction);
               break;
            case MOTOR_SLOT_B:
               MotorPort.B.controlMotor(this.m_Speed, this.m_Direction);
               break;
            case MOTOR_SLOT_C:
               MotorPort.C.controlMotor(this.m_Speed, this.m_Direction);
               break;
            default:
               break;
         }
      }
   }
   
   /*
    *  x * 100
    *  _______ = amount of ticks needed to make x meters
    *   6*3,14
    * 
    */
   
   public int GetRotationTicks()
   {
      int Degrees = -1;
      switch (this.m_Motor)
      {
         case MOTOR_SLOT_A:
            Degrees = MotorPort.A.getTachoCount();
         case MOTOR_SLOT_B:
            Degrees = MotorPort.B.getTachoCount();
         case MOTOR_SLOT_C:
            Degrees = MotorPort.C.getTachoCount();
      }
      return Degrees;
   }
   
   // Use the finals, pls.
   public void SetDirection(byte DirectionID)
   {
      if (DirectionID <= 3 | DirectionID >= 1)
         this.m_Direction = DirectionID;
   }
   
   public void Stop()
   {
      switch (this.m_Motor)
      {
         case MOTOR_SLOT_A:
            MotorPort.A.controlMotor(1, DIRECTION_STOP);
            break;
         case MOTOR_SLOT_B:
            MotorPort.B.controlMotor(1, DIRECTION_STOP);
            break;
         case MOTOR_SLOT_C:
            MotorPort.C.controlMotor(1, DIRECTION_STOP);
            break;
         default:
            break;
      }
      this.m_Direction = DIRECTION_STOP;
   }
}