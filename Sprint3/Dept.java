package objet;
import etu2091.annotation.*;

@AnnotationType("Valeur Customiser")
public class Dept {

    @AnnotationMethod
    public void functDept(){
        System.out.println("departement");
    }
    @AnnotationMethod
    public void functDeptList(){
        System.out.println("deprteList");
    }
}