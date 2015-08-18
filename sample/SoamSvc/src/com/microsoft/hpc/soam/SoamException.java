/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microsoft.hpc.soam;

/**
 *
 * @author v-dafu
 */
public class SoamException extends Exception {

    public SoamException(Exception ex) {
        super(ex);
    }
    
    public SoamException(String message) {
        super(message);
    }
}
