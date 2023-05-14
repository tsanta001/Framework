package etu2091.utilitaire;

import java.io.*;
import java.util.*;
import etu2091.framework.Mapping;
import etu2091.annotation.*;
import java.lang.reflect.*;


public  class Utilitaire {
    

//---------------------------------------------------------------------

    public String getUtile(String path,String context){
        
      String[] paths = path.split(context);
      String fin = new String();
      for(int i=0; i<paths.length;i++){fin=paths[1];}
      char[] lettre=fin.toCharArray();
      char[]lettretapanyvolo;
      
      for(int i =0;i<lettre.length;i++){
          
          if(lettre[i]=='?')
              {lettretapanyvolo= new char[i];
              for(int j =0;j<lettre.length;j++)
                {if(lettre[j]!='?')
                    {lettretapanyvolo[j] = lettre[j];
                     fin=new String(lettretapanyvolo.toString());
                    }
                  else break;
                }
              }     
      }
      
     return fin;   
    }
    
    
 //--------------------------------------------------------------------------
    
      public static Vector<String> maka_package_rehetra(String path){
        Vector<String> valiny = new Vector<String>();
		String paths = path+"\\WEB-INF\\classes\\";
		File file= new File(paths);
		File[] fileTab= file.listFiles();
                for(int i=0; i<fileTab.length ;i++){
                    String packageName=fileTab[i].getName();
                    if(!packageName.contains("."))
                        {valiny.add(packageName);}
                }  
          
        return valiny;      
    }
    
    
//---------------------------------------------------------------------------
    public static Vector<String> maka_class_rehetra(String path,String pack){
                    Vector<String> val2 = new Vector<String>();
                
                    String paths2 = path+"\\WEB-INF\\classes\\"+pack;
                    File file2= new File(paths2);
                    File[] fileTab2= file2.listFiles();
                    for(int j=0; j<fileTab2.length ;j++){
                        String packageName2=fileTab2[j].getName();
                        if(packageName2.contains("."))
                            val2.add(packageName2);
                    }
                
        return val2;      
    }

    
//-------------------------------------------------------------------------------------
      
	public static Vector<Mapping> maka_ClassMethod_misy_annotation_apetraka_anaty_mapping(String path) throws Exception{
            Vector<Mapping> valeur1=new Vector<Mapping>();    
            Vector<String>  package_rehetra = maka_package_rehetra(path);

             
            for(int a=0;a<package_rehetra.size();a++){
                String anaran_le_package=package_rehetra.get(a);
                
                Vector<String> class_rehetra=maka_class_rehetra(path,anaran_le_package);
                for(int i=0; i<class_rehetra.size();i++){
                    
                     String fileName=anaran_le_package+"."+class_rehetra.get(i).split(".class")[0];
                    //_______________CLASS___________________
                        Class<?> classes=Class.forName(fileName);
                            if(classes.getAnnotation(AnnotationType.class)!= null) {
                                String class_misy_annotation= classes.getName();
                                //________________METHOD____________________
                                Method[] method=classes.getDeclaredMethods();
                                        for(int j=0; j<method.length ;j++){
                                            if(method[j].getAnnotation(AnnotationMethod.class) != null){
                                                String method_misy_annotation=method[j].getName();

                                                Mapping mapping =new Mapping();
                                                mapping.setclassName(class_misy_annotation);
                                                mapping.setmethod(method_misy_annotation);

                                                valeur1.add(mapping);

                                            }
                                        }
                            }
                   }
                
            }    
		
        return valeur1;		
	}

        

//--------------------------------------------------------------------------------------------------
	public static HashMap<String,Mapping> Maka_Url_Annotation(Vector<Mapping> allMaps) {
		HashMap<String,Mapping> allUrls=new HashMap<String,Mapping>();
			
		for(int i=0; i<allMaps.size();i++){
			Mapping m=allMaps.get(i);
                        String url = " "+i; 
			allUrls.put(url,m);
		}
		return allUrls;

	}

//--------------------------------------------------------------------------------------------------
}
