import ReservoirLibrary.RanschburgEffectAgent;
import aos.jack.jak.util.timer.DilatedClock;
import aos.cojack.configuration.*;

public class Program {
    public static void main( String args[] )
    {
        try
        {   
            boolean bDebug = true;
            
            long begTime =  System.currentTimeMillis();
            
            //ReservoirAgent reservoirAgent = new ReservoirAgent("GeorgeReservoir", 2.0d);          
            RanschburgEffectAgent reservoirAgent = new RanschburgEffectAgent("GeorgeReservoir");
            reservoirAgent.getAgent().SetDebug(bDebug);
            reservoirAgent.getAgent().InitReservoir();
            reservoirAgent.getAgent().PrintValues();
            reservoirAgent.getAgent().AddValue(2.0);
            
            reservoirAgent.Wait(5.0);
                        
            //reservoirAgent.getAgent().SetReservoirFormula("", "");
           
            //ValueCalculator vc = Configuration.getValueCalculator(reservoirAgent.getAgent().getId(), "ReservoirAgent", reservoirAgent.getAgent().GEORGE_PARAMETER);
 
 /*
            for (int i=1; i <= 5; i++)
            {
                System.out.println("RepetitionOccurred #" + i + " @ "+ranschburgAgent.timer.getTime()+"\n");
                ranschburgAgent.RepetitionOccurred(1.0);
                Thread.sleep(500);
            }
*/
/*
            if (bDebug)
            {
                System.out.println("Normal occurrence");
            }
            
            reservoirAgent.Wait(0.5);
            
            if (bDebug)
            {
                System.out.println("Normal occurrence");
            }
            reservoirAgent.Wait(0.5);
            
            if (bDebug)
            {
                System.out.println("Normal occurrence");
            }
            reservoirAgent.Wait(0.5);
            
            if (bDebug)
            {
                System.out.println("RepetitionOccurred #1 @ "+reservoirAgent.getAgent().timer.getTime()+"\n");
            }
            reservoirAgent.RepetitionOccurred(1.0);
            reservoirAgent.Wait(0.5);
            
            if (bDebug)
            {
                System.out.println("Normal occurrence");
            }
            reservoirAgent.Wait(0.5);

            if (bDebug)
            {
                System.out.println("RepetitionOccurred #2 @ "+reservoirAgent.getAgent().timer.getTime()+"\n");
            }
            reservoirAgent.RepetitionOccurred(1.0);
            reservoirAgent.Wait(0.5);
            
            if (bDebug)
            {
                System.out.println("AddValue #3 @ "+reservoirAgent.getAgent().timer.getTime()+"\n");
            }
            reservoirAgent.RepetitionOccurred(1.0);
            reservoirAgent.Wait(0.5);
 
            for (int i=1; i <= 10; i++)
            {
                double dRanschburgValue = reservoirAgent.getAgent().GetValue();
                if (bDebug)
                {
                    System.out.println("RanschburgEffect value: " + i + " " + dRanschburgValue + " @ "+reservoirAgent.getAgent().timer.getTime()+"\n");
                }
                reservoirAgent.getAgent().Wait(0.5);                
            }
  */                      
            long endTime =  System.currentTimeMillis();

            long elapsedTime = endTime - begTime;
            
            System.out.println("\nElapsed time: " + elapsedTime); 
            
        }
        catch (Exception e)
        {
            System.out.println(e);   
        }
        System.exit(0);
    }
}
