package objet;
import etu2091.annotation.*;

@AnnotationType("Valeur Customiser")
public class Emp {

    @AnnotationMethod
    public void functemp(){
        System.out.println("employer");
    }
    @AnnotationMethod
    public void functEmpList(){
        System.out.println("employerList");
    }
}


