/*
 */
package com.microsoft.hpc.soam;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 *
 * @author v-dafu
 */
public class TaskContext {

    private String m_userData = "";
    private byte[] m_input;
    private byte[] m_output;

    public String getUserData() {
        return m_userData;
    }

    public void setUserData(String m_userData) {
        this.m_userData = m_userData;
    }

    public void setInput(byte[] soamInput) {
        m_input = soamInput;
    }

    public byte[] getOutput() {
        return m_output;
    }

    public void populateTaskInput(Message input) throws SoamException {
        if (m_input == null) {
            throw new SoamException("No input data bytes.");
        }
        if(input == null){
            throw new SoamException("Input object is null.");
        }
        
        ByteArrayInputStream bais = new ByteArrayInputStream(m_input);
        input.onDeserialize(bais);
    }

    public void setTaskOutput(Message output) throws SoamException {
        if(output == null){
            throw new SoamException("Output object is null.");
        }
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        output.onSerialize(baos);
        m_output = baos.toByteArray();
    }

}
