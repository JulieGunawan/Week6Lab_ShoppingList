/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 751682
 */
public class ShoppingListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session= request.getSession();
        String action="";
        
        if(request.getParameter("action")==null ){
            action ="register";
        }
        else {
            action = request.getParameter("action");
        }
        
        if (action.equals("logout")){
            request.getSession().invalidate();
            response.sendRedirect("?=register");
            return;
        }
        
        if(session.getAttribute("username") == null){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request,response);
        }
            
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
            .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String action="";
        HttpSession session = request.getSession();
        
        if(request.getParameter("action")== null){
            response.sendRedirect("ShoppingList");
            return;
        }
        else{
            action=request.getParameter("action");
        }
        
        if (action.equals("register") && request.getParameter("username")!= null){
            session.setAttribute("username", request.getParameter("username"));
            ArrayList<String> list = new ArrayList<String>();
            session.setAttribute("list", list);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
        }
        else if (action.equals("add")&& request.getParameter("item")!=null ){
            ArrayList<String> list = new ArrayList<String>();
            list= (ArrayList<String>) session.getAttribute("list");
            list.add(request.getParameter("item"));
            session.setAttribute("list",list);
            response.sendRedirect("ShoppingList");
            return;
        }
        else if (action.equals("delete")&& request.getParameter("deleteitem")!= null){
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
            list.remove(request.getParameter("deleteitem"));
            
            session.setAttribute("list", list);
            response.sendRedirect("ShoppingList");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
            .forward(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
