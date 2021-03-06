package com.microsoft.hpc.genericservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.3.1
 * Thu Mar 17 19:45:34 CST 2011
 * Generated source version: 2.3.1
 * 
 */
 
@WebService(targetNamespace = "http://hpc.microsoft.com/GenericService", name = "IGenericService")
@XmlSeeAlso({com.microsoft.schemas._2003._10.serialization.ObjectFactory.class, ObjectFactory.class, com.microsoft.hpc.session.ObjectFactory.class})
public interface IGenericService {

    @WebResult(name = "GenericOperationResult", targetNamespace = "http://hpc.microsoft.com/GenericService")
    @Action(input = "http://hpc.microsoft.com/GenericService/IGenericService/GenericOperation", output = "http://hpc.microsoft.com/GenericService/IGenericService/GenericOperationResponse", fault = {@FaultAction(className = IGenericServiceGenericOperationRetryOperationErrorFaultFaultMessage.class, value = "http://hpc.microsoft.com/session/RetryOperationError"), @FaultAction(className = IGenericServiceGenericOperationAuthenticationFailureFaultFaultMessage.class, value = "http://hpc.microsoft.com/session/AuthenticationFailure")})
    @RequestWrapper(localName = "GenericOperation", targetNamespace = "http://hpc.microsoft.com/GenericService", className = "com.microsoft.hpc.genericservice.GenericOperation")
    @WebMethod(operationName = "GenericOperation", action = "http://hpc.microsoft.com/GenericService/IGenericService/GenericOperation")
    @ResponseWrapper(localName = "GenericOperationResponse", targetNamespace = "http://hpc.microsoft.com/GenericService", className = "com.microsoft.hpc.genericservice.GenericOperationResponse")
    public java.lang.String genericOperation(
        @WebParam(name = "args", targetNamespace = "http://hpc.microsoft.com/GenericService")
        java.lang.String args
    ) throws IGenericServiceGenericOperationRetryOperationErrorFaultFaultMessage, IGenericServiceGenericOperationAuthenticationFailureFaultFaultMessage;
}
