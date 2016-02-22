package ru.easybrash.testserver.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.easybrash.testserver.frontend.Frontend;

/**
 * Created by tagnik'zur on 03.09.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("server start");
        Frontend frontend = new Frontend();

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);

        context.addServlet(new ServletHolder(frontend), "/data");

        server.start();
        server.join();
    }
}
