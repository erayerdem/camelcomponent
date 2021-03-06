package com.eray;


import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

@org.apache.camel.spi.annotations.Component("echo")
public class EchoComponent extends DefaultComponent {
    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Endpoint endpoint = new EchoEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
