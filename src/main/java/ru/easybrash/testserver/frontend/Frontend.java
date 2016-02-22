package ru.easybrash.testserver.frontend;

import ru.easybrash.testserver.model.ValuesFromPhones;
import ru.easybrash.testserver.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tagnik'zur on 03.09.2015.
 */
public class Frontend extends HttpServlet {

    private ValuesFromPhones valuesFromPhone = ValuesFromPhones.getInstance();

    private String login = "";

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

//        Map<String, Object> pageVariables = new HashMap<>();
//        pageVariables.put("lastLogin", login == null ? "" : login);

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("refreshPeriod", "1000");
        pageVariables.put("serverTime", valuesFromPhone.getLast());

        response.getWriter().println(PageGenerator.getPage("data.html", pageVariables));

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");

//        login = request.getParameter("login");
        String requestString = request.getParameter("dev") + " - " + request.getParameter("value");

//        requestString = "htc - 5.454";

        if (!requestString.isEmpty() && requestString != null) {
            valuesFromPhone.addValue(requestString);
        }
//        login = valuesFromPhone.getLast();

//        response.setContentType("text/html;charset=utf-8");

//        if (login == null || login.isEmpty()) {
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        } else {
            response.setStatus(HttpServletResponse.SC_OK);
//        }

//        Map<String, Object> pageVariables = new HashMap<>();
//        pageVariables.put("refreshPeriod", "1000");
//        pageVariables.put("serverTime", valuesFromPhone.getValue(0));

//        response.getWriter();
    }
}