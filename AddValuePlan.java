/*******************************************************************
 * Created by the JDE: Thu Mar 12 11:34:52 EDT 2026
 * WARNING: If you are editing this file from outside the JDE, you
 * should make sure to load the changes back into the JDE by setting
 * the preference "Check for outside changes..." in the "Text Editor"
 * preference tab or reload the component manually.
 * Otherwise you will lose your changes next time the file is generated.
 *******************************************************************/

package ReservoirLibrary;

import DebugLibrary.*;
import aos.cojack.configuration.*;
import aos.jack.jak.beliefset.BeliefSetException;
import aos.jack.util.thread.Semaphore;

/**
 * 
 */public plan AddValuePlan extends Plan {

    #handles event AddValueEvent ev;
    #uses interface ReservoirAgent enc;
    #modifies data BeliefSet1 BeliefSet1;
    #uses data Semaphore mutex;
    
    static boolean relevant(AddValueEvent ev)
    {
        return true;
    }
    
    context()
    {
        true;
    }

    #reasoning method
    body()
    {       
        try
        {       
            logical boolean $debug;
            DebugBeliefSet debug = enc.GetDebugBeliefSet();
            debug.get(0, $debug).next();
        
            boolean bDebug = $debug.as_boolean();
     
            //System.out.println("AddValuePlan bDebug: " + bDebug);
     
            if (bDebug)
            {
                System.out.println("Inside AddValuePlan.");
            }
        
            //collect event data, such as moderator and the amount to add to the current reservoir
    
            String strModerator = "Value"; //ev.strModerator;
        
            double dValue = ev.dAmount;
    
            long lTime = agent.timer.getTime();
    
            //compute the value of the moderator reservoir at this very moment
        
            double dReservoir = Configuration.moderatorCurrentReservoir(agent.getId(), strModerator, lTime);
    
            //add the event amount to the current reservoir and update the moderator
             
            if (bDebug)
            {
                System.out.println("Injecting " + dValue + "+" + dReservoir + " @ " + lTime+"\n");
            }
       
            dReservoir = dReservoir + dValue;
            
            Configuration.moderatorReservoirAgentUpdate(agent.getId(), strModerator, dReservoir, lTime);
            
            dReservoir = Configuration.moderatorCurrentReservoir(agent.getId(), strModerator, lTime);
             
            if (bDebug)
            {
                System.out.println(dReservoir + " is the amount for " + agent.getBasename() + " " + dValue + "\n");           
            }           
        }
        catch (BeliefSetException e)
        {
            e.printStackTrace();
        }
        finally
        {
            mutex.signal();           
        }
    }

}
