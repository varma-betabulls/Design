/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.viewregistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class Cache {

    public static Cache instance = null;
    public static Map<String, List<String>> dataMap = null;

    private Cache() {
        dataMap = new HashMap<String, List<String>>();
        try {
            List<String> citiesList = new ArrayList<String>();
            List<String> statesList = new ArrayList<String>();
            List<String> countriesList = new ArrayList<String>();
            Class clazz = null;
            ResultSet resultSet = null;
            Connection con = null;
            Statement stmt = null;
            System.out.println("fetching data from Database");
            //Loading the driver
            clazz = Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?useSSL=true", "root", "root");
            stmt = con.createStatement();
            stmt.executeQuery("select * from cities");
            resultSet = stmt.getResultSet();
            while (resultSet.next()) {
                String city = resultSet.getString("name");
                citiesList.add(city);
            }
            instance.dataMap.put("cities", citiesList);
            stmt.executeQuery("select * from states");
            resultSet = stmt.getResultSet();
            while (resultSet.next()) {
                String state = resultSet.getString("name");
                statesList.add(state);
            }
            instance.dataMap.put("states", statesList);
            stmt.executeQuery("select * from countries");
            resultSet = stmt.getResultSet();
            while (resultSet.next()) {
                String country = resultSet.getString("name");
                countriesList.add(country);
            }
            instance.dataMap.put("countries", countriesList);
            con.close();
            stmt.close();
        } catch (Exception e) {
        }
    }

    public synchronized static Cache getInstance() {
        if (instance == null) {
            instance = new Cache();
        }
        return instance;
    }

    public synchronized void put(String key, List<String> value) {
    }

    public synchronized boolean getContainsKey(String key) {
        return dataMap.containsKey(key);
    }

    public synchronized List<String> getObject(String key) {
        return dataMap.get(key);
    }

}
