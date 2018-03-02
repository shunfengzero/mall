package com.test;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class TestA {
    public static void main(String[] args) {
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://localhost:8080/services/first?wsdl");
        try {
            Object[] x = client.invoke("print");
            System.out.println(x[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
