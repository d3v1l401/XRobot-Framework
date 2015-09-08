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
   
   protected byte m_Motor   = 0;
   private byte m_Speed     = 100;
   private byte m_Direction = DIRECTION_FORWARD;
   private int  m_Ticks     = 0;
   
   protected byte p_WheelDiameter = 4;
   
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
   
   public byte GetRequiredTicks(byte MetersAmount)
   {
      return (byte)((MetersAmount * 100) / (this.p_WheelDiameter * Math.PI));
   }
   
   public byte GetDoneMeters()
   {
      return -1; // TODO
   }
   
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
   
   public class Movements
   {
      public static final byte TURN_DIRECTION_LEFT    = 1;
      public static final byte TURN_DIRECTION_RIGHT   = 2;
      public static final byte TURN_DIRECTION_FORWARD = 3;
            
      public void Turn(byte Direction)
      {
         switch (Direction)
         {
            case TURN_DIRECTION_LEFT:
               Stop();
               SetDirection(DIRECTION_FORWARD);
               run();
               
               break;
            case TURN_DIRECTION_RIGHT:
               Stop();
               SetDirection(DIRECTION_FORWARD);
               run();
               
               break;
            case TURN_DIRECTION_FORWARD:
               SetDirection(DIRECTION_FORWARD);
               run();
               
               break;
            default:
               // We don't give a duck.
               break;
         }
      }
   }
}