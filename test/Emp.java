package objet;
import java.util.*;
import etu2091.annotation.*;
import etu2091.framework.Mapping;
import etu2091.framework.ModelView;



@AnnotationType("Valeur Customiser")
public class Emp {

    String nom;
	String prenom;

	public Emp(String nom, String prenom){
		this.nom = nom;
		this.prenom = prenom;
	}
    public Emp(){}

    public String getNom() {return nom;}
    public String getPrenom() {return prenom;}

    public void setNom(String nom) {this.nom = nom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}



    @AnnotationMethod(value="hello6")
    public void functemp(){
        System.out.println("employer");
    }

    //---------------------------------------------
    @AnnotationMethod(value="hello1")
    public void functEmpList(){
        System.out.println("employerList");
    }

    //---------------------------------------------
    public Vector<Emp> listEmp() {
        Vector<Emp> list = new Vector<Emp>();
        Emp e1 = new Emp("ANDRIAMALALA", "Tsanta");
        list.add(e1);
        return list;
    }


    @AnnotationMethod(value="hello-emp")
    public ModelView modelview(){
        ModelView view=new ModelView();
        view.setview("hello.jsp");
        view.addItem("list", this.listEmp());

        return view; 
    }
}


