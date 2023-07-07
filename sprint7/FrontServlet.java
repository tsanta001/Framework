package etu2091.framework.servlet;

import etu2091.framework.Mapping;
import etu2091.obj.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.lang.reflect.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import etu2091.obj.Utilitaire;

public class FrontServlet extends HttpServlet {

    //-----------------------------------------------------------------------------------------------
    HashMap<String, Mapping> mappingUrls;
    Utilitaire u = new Utilitaire();


    //-----------------------------------------------------------------------------------------------
    public void init() {
        try{
            
            String p = this.getServletContext().getRealPath("");

            this.mappingUrls = u.getUrls(u.allMapping(p), u.allUrl(p));      
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //------------------------------------------------------------------------------------------------
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String wordsPath = u.getLastOfPath(String.valueOf(request.getRequestURL()), request.getContextPath());

        out.println(wordsPath+"<br>");
        

        try{
            init();
            for(Map.Entry<String, Mapping> entry : mappingUrls.entrySet()){
                out.println("Annotation "+entry.getKey()+"\tClasse: "+entry.getValue().getClassName()+"\tMethod: "+entry.getValue().getMethod()+"<br>");
            }
            
            Mapping mapping=u.getMapping(wordsPath, mappingUrls);
            out.println("mapping className : "+mapping.getClassName());
            out.print("<br>");
            out.println("mapping methode: "+mapping.getMethod());


            Class classe=Class.forName(mapping.getClassName());
            Object instance=classe.newInstance();
            Field[] fields = instance.getClass().getDeclaredFields();

            for(int i=0; i<fields.length; i++){

                String value =  request.getParameter(fields[i].getName());

                if(value!=null){
                    out.println(value);
                  if(fields[i].getType().getSimpleName().equals("int")){

                    int values=Integer.valueOf(value);

                    fields[i].setAccessible(true);
                    fields[i].set(instance,values);
                    out.println("Tafiditra le donner"+"<br>");

                  }else{
                    fields[i].setAccessible(true);
                    fields[i].set(instance,value);
                    out.println("Tafiditra le donner"+"<br>");
                  }
                }
            }  
            
            ModelView invomethode=u.invocationMethode(mapping, instance);

            out.println("methode: /"+ invomethode.getView());
                
            for(HashMap.Entry<String, Object> entry : invomethode.getData().entrySet()) {
                request.setAttribute(entry.getKey(), entry.getValue());
            }
            RequestDispatcher dispat = request.getRequestDispatcher("./"+ invomethode.getView());
            dispat.forward(request, response);    
        }catch(Exception e){
            out.print(e);
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
