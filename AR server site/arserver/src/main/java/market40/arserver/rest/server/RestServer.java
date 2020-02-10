package market40.arserver.rest.server;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import market40.arserver.rest.services.MainServiceEntryPoint;
import market40.arserver.rest.services.Projects;

public class RestServer {

    public static void main(String[] args) throws Exception {
        PropertiesConfiguration properties = new PropertiesConfiguration("restProperties.properties");

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(properties.getInt("serverPort"));
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        //jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", MainServiceEntryPoint.class.getCanonicalName());
        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", Projects.class.getCanonicalName());
        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", MainServiceEntryPoint.class.getCanonicalName());

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}
