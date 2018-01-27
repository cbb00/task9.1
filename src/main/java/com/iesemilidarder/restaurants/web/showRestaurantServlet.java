package com.iesemilidarder.restaurants.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class showRestaurantServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("id"));

        ArrayList<Restaurante> al = LeeBD.readRestaurants();

        Restaurante r = al.get(id);

        request.setAttribute("restaurante", r);

        // Actual logic goes here.
        request.getRequestDispatcher("showRestaurant.jsp").forward(request, response);


    }
}
