package com.wso2.gayanw.axis2;

import org.apache.axis2.AxisFault;

import javax.xml.namespace.QName;

public class ServiceFault {

    private static String namespaceURI = "http://axis2.gayanw.wso2.com";

    public static AxisFault newNoSuchOrderFault() {
        return newFaultFromLocalPart("NoSuchOrderFault");
    }

    public static AxisFault newNoSuchProductFault() {
        return newFaultFromLocalPart("NoSuchProductFault");
    }

    private static AxisFault newFaultFromLocalPart(String localPart) {
        AxisFault axisFault = AxisFault.makeFault(new Throwable());
        axisFault.setFaultCode(new QName(namespaceURI, localPart));
        return axisFault;
    }
}
