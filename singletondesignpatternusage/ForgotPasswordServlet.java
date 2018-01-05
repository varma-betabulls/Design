/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.forgotPwdServlet;

import com.servlet.viewregistration.Cache;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<String> citiesList = new ArrayList<String>();
            List<String> statesList = new ArrayList<String>();
            List<String> countriesList = new ArrayList<String>();
            Cache instance = null;
            instance = Cache.getInstance();
            if (instance != null && !instance.dataMap.isEmpty()) {
                System.out.println("fetching data from Cache");
                if (instance.getContainsKey("cities")) {
                    citiesList = instance.getObject("cities");
                }
                if (instance.getContainsKey("states")) {
                    statesList = instance.getObject("states");
                }
                if (instance.getContainsKey("countries")) {
                    countriesList = instance.getObject("countries");
                }
            }
            req.setAttribute("citiesList", citiesList);
            req.setAttribute("statesList", statesList);
            req.setAttribute("countriesList", countriesList);
            req.getRequestDispatcher("/ForgotPwdPage.jsp").forward(req, resp);
        } catch (Exception e) {

        }
    }
}
