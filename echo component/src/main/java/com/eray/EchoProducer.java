package com.eray;

import org.apache.camel.Exchange;

import org.apache.camel.support.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoProducer extends DefaultProducer {


    private static final Logger LOG = LoggerFactory.getLogger(EchoProducer.class);
    private EchoEndpoint endpoint;


    public EchoProducer(EchoEndpoint endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        boolean upperCase = endpoint.isUpperCase();
        String body = exchange.getIn().getBody(String.class);
        body = upperCase ? body.toUpperCase() : body;
        LOG.info(body);

        exchange.getIn().setBody(body);

    }
}
