package objet;
import etu2091.annotation.*;
import etu2091.framework.Mapping;
import etu2091.framework.ModelView;



@AnnotationType("Valeur Customiser")
public class Emp {

    @AnnotationMethod
    public void functemp(){
        System.out.println("employer");
    }

    @AnnotationMethod(value="hello1")
    public void functEmpList(){
        System.out.println("employerList");
    }

    @AnnotationMethod(value="hello-emp")
    public ModelView modelview(){
        ModelView view=new ModelView();
        view.setview("hello.jsp");

        return view;
    }
}


