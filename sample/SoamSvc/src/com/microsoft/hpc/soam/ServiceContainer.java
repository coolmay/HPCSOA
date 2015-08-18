/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microsoft.hpc.soam;

import java.util.Date;
import sample.common.MyInput;
import sample.common.MyOutput;

/**
 *
 * @author v-dafu
 */
public abstract class ServiceContainer {

    /**
     * Not used.
     */
    public void run() {
        return;
    }

    public abstract void onCreateService(ServiceContext serviceContext) throws SoamException;

    public abstract void onSessionEnter(SessionContext sessionContext) throws SoamException;

    public abstract void onInvoke(TaskContext taskContext) throws SoamException;

    public abstract void onSessionLeave() throws SoamException;

    public abstract void onDestroyService() throws SoamException;

    public abstract void onApplicationAttach(ServiceContext serviceContext) throws SoamException;

    public abstract void onApplicationDetach() throws SoamException;

}
