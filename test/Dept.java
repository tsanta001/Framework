package objet;
import etu2091.annotation.*;
import etu2091.framework.ModelView;


@AnnotationType("Valeur Customiser")
public class Dept {

    @AnnotationMethod(value="hello2")
    public void functDept(){
        System.out.println("departement");
    }
    @AnnotationMethod(value="hello3")
    public void functDeptList(){
        System.out.println("deprteList");
    }
}