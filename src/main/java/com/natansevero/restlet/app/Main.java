/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natansevero.restlet.app;

import com.natansevero.restlet.app.resources.PersonResource;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

/**
 *
 * @author natan
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int port = 8080;

        Component component = new Component();
        component.getServers().add(Protocol.HTTP, port);

        Application app = new Application();
        component.getDefaultHost().attach("/app", app);

        Router router = new Router();
        router.attach("/persons", PersonResource.class);

        app.setInboundRoot(router);

        component.start();
    }
}
