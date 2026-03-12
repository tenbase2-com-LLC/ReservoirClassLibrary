/*******************************************************************
 * Created by the JDE: Thu Mar 12 11:56:30 EDT 2026
 * WARNING: If you are editing this file from outside the JDE, you
 * should make sure to load the changes back into the JDE by setting
 * the preference "Check for outside changes..." in the "Text Editor"
 * preference tab or reload the component manually.
 * Otherwise you will lose your changes next time the file is generated.
 *******************************************************************/

package ReservoirLibrary;

import DebugLibrary.*;
import aos.cojack.configuration.*;

/**
 * 
 */
public plan GetValuePlan extends Plan {

    #handles event GetValueEvent gve;
    #uses interface ReservoirAgent enc;
    
    static boolean relevant(GetValueEvent gve)
    {
        return true;
    }
    
    context()
    {
        true;
    }

    #reasoning method
    grabValue()
    {         
         try
         {            
            if (bDebug)
            {
                System.out.println("Inside GrabReservoirValuePlan grabValue");
            }
            
            String GEORGE_PARAMETER = "george_parameter";
           
            long lTime = getAgent().timer.getTime();
            
            if (bDebug)
            {
                System.out.println(getAgent().toString() + "\n");           
            }
            
            ValueCalculator vc = Configuration.getValueCalculator(getAgent().getId(), "ReservoirAgent", GEORGE_PARAMETER);
        
            double v = vc.getValueDoubleAt(lTime);
            
            if (bDebug)
            {
                System.out.println(getAgent().toString() + ": reserboir value: [" + Double.toString(v) + "]\n");           
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }        
    }

    #reasoning method
    body()
    {
        try
        {   
            if (bDebug)
            {
                System.out.println("Inside GetValuePlan: before debug");
            }         
            
            logical boolean $debug;
            DebugBeliefSet debug = enc.GetDebugBeliefSet();
            debug.get(0, $debug).next();
        
            bDebug = $debug.as_boolean();
            
            if (bDebug)
            {
                System.out.println("Inside GetValuePlan.");
            }         
            
            while(true)
            {
                @wait_for(elapsedMillis(TIME_OUT));
                grabValue();            
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();     
        }
    }
    private static long TIME_OUT = 500;
    private boolean bDebug = false;

}
