///////////////////////////////////////////////////////////////////////////////
//
// This file contains code which demonstrates the use of the Hpc Soam Wrapper
// within a service. 
//
///////////////////////////////////////////////////////////////////////////////
package sample.service;

import com.microsoft.hpc.soam.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import sample.common.*;

public class MyService extends ServiceContainer {

    /**
     *
     */
    public MyService() {
        super();
    }

    @Override
    public void onCreateService(ServiceContext serviceContext) throws SoamException {
        /**
         * ******************************************************************
         * Do your service initialization here.
         * ******************************************************************
         */
    }

    @Override
    public void onSessionEnter(SessionContext sessionContext) throws SoamException {
        /**
         * ******************************************************************
         * Do your session-specific initialization here, when common data is
         * provided.
         * ******************************************************************
         */
    }

    @Override
    public void onInvoke(TaskContext taskContext) throws SoamException {
        /**
         * ******************************************************************
         * Do your service logic here. This call applies to each task
         * submission.
         * ******************************************************************
         */

        // Get the input that was sent from the client 
        try {
            MyInput myInput = new MyInput();
            taskContext.populateTaskInput(myInput);

            // Set the output
            MyOutput myOutput = new MyOutput();
            myOutput.setBoolean(!myInput.isBoolean());
            myOutput.setInt(myInput.getInt() * 10);
            myOutput.setFloat(myInput.getFloat() * 10);
            myOutput.setDouble(myInput.getDouble() * 10);
            myOutput.setLong(myInput.getLong() * 10);
            myOutput.setString(myInput.getString().toUpperCase());
            myOutput.setBytes(myOutput.getString().getBytes());
            myOutput.setDate(new Date());

            // Set our output message 
            taskContext.setTaskOutput(myOutput);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SoamException(ex);
        }
    }

    @Override
    public void onSessionLeave() throws SoamException {
        /**
         * ******************************************************************
         * Do your session-specific uninitialization here, when common data is
         * provided.
         * ******************************************************************
         */
    }

    @Override
    public void onDestroyService() throws SoamException {
        /**
         * ******************************************************************
         * Do your service uninitialization here.
         * ******************************************************************
         */
    }

    @Override
    public void onApplicationAttach(ServiceContext serviceContext) throws SoamException {
    }

    public void onApplicationDetach() throws SoamException {
    }

}
