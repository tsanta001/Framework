package model;

import etu2091.annotation.*;
import etu2091.obj.FileUpload;
import etu2091.obj.ModelView;

import java.util.ArrayList;
import etu2091.obj.*;

@ClassAnnotation
public class Emp {
    int id;
	String nom;
	String prenom;
    int age;
    FileUpload fileUp;

	public Emp(int id, String nom, String prenom, int age,FileUpload fileUp){
		this.id = id;
        this.nom = nom;
		this.prenom = prenom;
        this.age = age;
        this.fileUp=fileUp;
	}

    public Emp(int id, String nom, String prenom, int age){
		this.id = id;
        this.nom = nom;
		this.prenom = prenom;
        this.age = age;
	}
    public Emp(){}

    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public int getAge() {
        return age;
    }
    public FileUpload getFile() {
        return fileUp;
    }


    public void setid(int id) {
        this.id = id;
    }
    public void setnom(String nom) {
        this.nom = nom;
    }
    public void setprenom(String prenom) {
        this.prenom = prenom;
    }
    public void setage(int age) {
        this.age = age;
    }
    public void setfile(FileUpload fileUp) {
        this.fileUp = fileUp;
    }

    @MyAnnotation(value = "emp-findAll")
    public ModelView findAll(int id){
        System.out.println("findAll");
        ModelView view = new ModelView();
        view.setView("details.jsp");
        view.addItem("emp", this.listEmp().get(id));
        return view;
    }
    
    @MyAnnotation(value = "emp-add")
    public void add(){
        System.out.println("add");
        System.out.println("Id "+this.getId());
        System.out.println("Nom "+this.getNom());
        System.out.println("Prenom "+this.getPrenom());
        System.out.println("Age "+this.getAge());
        System.out.println("File "+this.getFile());

    }

    public ArrayList<Emp> listEmp() {
        ArrayList<Emp> list = new ArrayList<Emp>();
        Emp e1 = new Emp(0, "RASOLOMANANA", "Celine", 20);
        Emp e2 = new Emp(1, "ANDRIAMALALA", "Fitia", 21);
        list.add(e1);
        list.add(e2);
        return list;
    }

    @MyAnnotation(value = "emp-view")
    public ModelView getView(){
    	ModelView view = new ModelView();
    	view.setView("hello.jsp");
    	view.addItem("list", this.listEmp());
    	return view;
    }

    public ModelView save(){
        ModelView modelview =new ModelView("fileUp.jsp");
        modelview.addItem("tsyAttribut", this.getFile().getName());
        return modelview;
    }
}
