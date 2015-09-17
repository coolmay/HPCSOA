/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author v-dafu
 */
public class DummyAdapter extends XmlAdapter<JAXBElement<byte[]>, JAXBElement<byte[]>> {

    public JAXBElement<byte[]> unmarshal(JAXBElement<byte[]> val) throws Exception {
        return val;
    }

    public JAXBElement<byte[]> marshal(JAXBElement<byte[]> val) throws Exception {
        return val;
    }

}
