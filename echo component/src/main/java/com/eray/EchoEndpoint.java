package com.eray;

import org.apache.camel.*;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.DefaultEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * echo component writes every thing .
 * echo component writes every thing .
 * echo component writes every thing .
 */
@UriEndpoint(
        firstVersion = "2.3.0",
        scheme = "echo",
        title = "ECHO",
        syntax = "echo:message",
        producerOnly = true ,
        category = {Category.COMPUTING},
        lenientProperties = true
)
public class EchoEndpoint extends DefaultEndpoint {
    public EchoEndpoint(String endpointUri, Component component) {
        super(endpointUri, component);

    }

    private static final Logger LOG = LoggerFactory.getLogger(EchoEndpoint.class);

    public boolean isUpperCase() {
        return upperCase;
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }

    @UriParam(label = "formatting", defaultValue = "false", description = "Show upper case strings")
    private boolean upperCase=false;

    @Override
    public Producer createProducer() throws Exception {
        return new EchoProducer(this);
    }

    @Override
    public Consumer createConsumer(Processor processor) throws Exception {
        throw  new NullPointerException("cant , consumer this ");
    }
}
