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
import SetFormula.*;
import WaitLibrary.*;
import aos.cojack.base.CatMan;
import aos.cojack.configuration.*;
import aos.jack.jak.util.timer.DilatedClock;
import aos.jack.util.thread.Semaphore;

/**
 * 
 */public agent ReservoirAgent extends Agent {
    #has capability ReservoirCapability rc;
    #has capability WaitCapability wc;
    #private data Semaphore mutex();

    public ReservoirAgent(String strAgentName, double dThreshold1)
    {
        super(strAgentName);
        dThreshold = dThreshold1;
       
        Init();
    }
    private boolean bDebug = false;
    public final static String GEORGE_PARAMETER = "george_parameter";
    private double dThreshold = 2.0;
    #uses taskmanager CatMan(this);

    public void Init()
    {
        this.timer = new DilatedClock(1d, this.timer);
        this.timer.setTime(0L);  
    }

    public void InitReservoir()
    {          
        postEvent(rc.ire.post());
        mutex.threadWait();
    }

    public void PrintValues()
    {          
        postEvent(rc.gve.post());
    }

    public void AddValue(double dAmount)
    {          
        postEvent(rc.ave.post(dAmount));
        mutex.threadWait();
    }

    public boolean bGreaterThanEqualTo()
    {
        boolean ret = false;
        
        try 
        {            
            if (GetValue() >= dThreshold)
            {
                ret = true;
            }
        }
        catch (Exception ex)
        {
            
        }
        
        if (bDebug)
        {
            System.out.println(getAgent() + ": Perform task: " + ret);   
        }
        
        return ret;
    }

    public boolean bLessThan()
    {
        return !bGreaterThanEqualTo();
    }

    public double GetValue() throws Exception
    {
        long lTime = this.timer.getTime();
            
        ValueCalculator vc = Configuration.getValueCalculator(this.getId(), "ReservoirAgent", GEORGE_PARAMETER);
        double v = vc.getValueDoubleAt(lTime);
    
        return v;
    }

    public void SetReservoirFormula(String strModeratorType, String strFormula)
    {
        postEvent(rc.sfc.srfe.post(strModeratorType, "", strFormula, true));
        mutex.threadWait();
    }

    public void SetCognitiveFormula(String strModeratorType, String strPlanName, String strFormula)
    {
        postEvent(rc.sfc.srfe.post(strModeratorType, strPlanName, strFormula, false));
        mutex.threadWait();
    }

    public DebugBeliefSet GetDebugBeliefSet()
    {        
        return rc.dc.debug;       
    }

    public DebugBeliefSet GetDebugBeliefSetFormulaCap()
    {        
        return rc.sfc.dc.debug;       
    }

    public void Wait(double dAmount)
    {
        postEvent(wc.we.post(dAmount));
        mutex.threadWait();
    }

    public void SetDebug(boolean bDebug1)
    {
        bDebug = bDebug1;
        postEvent(rc.dc.sde.post(bDebug1));
        mutex.threadWait();               
    
        postEvent(rc.sfc.dc.sde.post(bDebug1));
        mutex.threadWait();
    }

}
