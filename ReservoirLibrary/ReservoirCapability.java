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
import SetFormulaLibrary.*;
import aos.jack.util.thread.Semaphore;

/**
 * 
 */
public capability ReservoirCapability extends Capability {
    #has capability DebugCapability dc;
    #has capability SetFormulaCapability sfc;
    #handles event InitReservoirEvent;
    #posts event InitReservoirEvent ire;
    #handles event GetValueEvent;
    #posts event GetValueEvent gve;
    #handles event AddValueEvent;
    #posts event AddValueEvent ave;
    #uses plan InitReservoirPlan;
    #uses plan GetValuePlan;
    #uses plan AddValuePlan;
    #imports data Semaphore mutex();
    #private data BeliefSet1 BeliefSet1();

}
