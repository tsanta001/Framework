package etu2091.framework;


public class Mapping {
    String className;
    String methode;
   public Mapping(String className,String method)
   {
     this.className=className;
     this.methode=methode;
   } 
   
   public void setclassName(String className){this.className=className;}
   public void setmethod(String method){this.methode=method;}

   
   public String getclassName(){return this.className;}
   public String getmethod(){return this.methode;}
}
