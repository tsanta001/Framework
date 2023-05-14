package etu2091.framework.servlet;

import objet.*;
import java.util.*;
import etu2091.utilitaire.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import etu2091.framework.Mapping;


public class FrontServlet extends HttpServlet {


    HashMap<String,Mapping> mappinngUrls;
    Vector<Mapping> classMethod_misy_annot;
    
    public void init(){
        try{
                classMethod_misy_annot=Utilitaire.maka_ClassMethod_misy_annotation_apetraka_anaty_mapping(this.getServletContext().getRealPath(""));
                mappinngUrls=Utilitaire.Maka_Url_Annotation(classMethod_misy_annot);
        }catch(Exception e){}
    }

    //-------------------------------------------------------------------------------------------------------

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out= response.getWriter();
        Utilitaire utilitaire= new Utilitaire();
        String dernierUrl= utilitaire.getUtile(request.getRequestURI(),request.getContextPath());
        //out.print(fct);
        
        try{
            
            init();      
                  for(Map.Entry<String,Mapping> entry : mappinngUrls.entrySet()){
                        out.println("classe "+entry.getValue().getclassName());
                        out.print("<br>");
                        out.print("-Method "+entry.getValue().getmethod());
                        out.print("<br>");
                }
            
            
        }catch(Exception e){
            out.print(e);
        }
        
    }



	




//----------------------------------------------------------------------------------------------------


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    }

}
