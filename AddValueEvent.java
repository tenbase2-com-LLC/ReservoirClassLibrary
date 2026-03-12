/*******************************************************************
 * Created by the JDE: Thu Mar 12 11:34:52 EDT 2026
 * WARNING: If you are editing this file from outside the JDE, you
 * should make sure to load the changes back into the JDE by setting
 * the preference "Check for outside changes..." in the "Text Editor"
 * preference tab or reload the component manually.
 * Otherwise you will lose your changes next time the file is generated.
 *******************************************************************/

package ReservoirLibrary;


/**
 * 
 */public event AddValueEvent extends BDIGoalEvent {
    public double dAmount = 0;

    #posted as
    post(double dAmount1)
    {
        dAmount = dAmount1;        
    }


}
