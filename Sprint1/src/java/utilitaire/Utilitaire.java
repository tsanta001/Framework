package utilitaire;

import etu2091.framework.servlet.*;

public class Utilitaire {
    
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
    
}
