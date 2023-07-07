package model;

import etu2091.annotation.*;
import java.util.ArrayList;
import etu2091.obj.*;

@ClassAnnotation
public class Emp {
	String nom;
	String prenom;

	public Emp(String nom, String prenom){
		this.nom = nom;
		this.prenom = prenom;
	}
    public Emp(){}

    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        System.out.println("miditra tsara");
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @MyAnnotation(value = "emp-findAll")
    public void findAll(){
        System.out.println("findAll");
    }
    
    @MyAnnotation(value = "emp-add")
    public void add(){
        System.out.println(this.nom);
        System.out.println(this.prenom);
        System.out.println("add");
    }

    public ArrayList<Emp> listEmp() {
        ArrayList<Emp> list = new ArrayList<Emp>();
        Emp e1 = new Emp("ANDRIAMALALA", "Tsanta");
        list.add(e1);
        return list;
    }

    @MyAnnotation(value = "emp-view")
    public ModelView getView(){
    	ModelView view = new ModelView();
    	view.setView("hello.jsp");
    	view.addItem("list", this.listEmp());
    	return view;
    }
}
