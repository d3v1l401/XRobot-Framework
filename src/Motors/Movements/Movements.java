package Motors.Movements;
import Motors.Motor;

public class Movements
{
   public static final byte TURN_DIRECTION_LEFT    = 1;
   public static final byte TURN_DIRECTION_RIGHT   = 2;
   public static final byte TURN_DIRECTION_FORWARD = 3;
   
   private Motor m_EngineA;
   private Motor m_EngineB;
   
   public Movements(Motor MainEngineA, Motor MainEngineB)
   {
      this.m_EngineA = MainEngineA;
      this.m_EngineB = MainEngineB;
   }
   
   public void Turn(byte Direction)
   {
      switch (Direction)
      {
         case TURN_DIRECTION_LEFT:
            this.m_EngineA.Stop();
            this.m_EngineB.SetDirection(this.m_EngineB.DIRECTION_FORWARD);
            this.m_EngineB.start();
            
            break;
         case TURN_DIRECTION_RIGHT:
            this.m_EngineB.Stop();
            this.m_EngineA.SetDirection(this.m_EngineA.DIRECTION_FORWARD);
            this.m_EngineA.start();
            
            break;
         case TURN_DIRECTION_FORWARD:
            this.m_EngineA.SetDirection(this.m_EngineA.DIRECTION_FORWARD);
            this.m_EngineB.SetDirection(this.m_EngineB.DIRECTION_FORWARD);
            this.m_EngineA.start();
            this.m_EngineB.start();
            
            break;
         default:
            // We don't give a duck.
            break;
      }
   }
}
