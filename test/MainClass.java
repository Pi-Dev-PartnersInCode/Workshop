
import edu.projet.entities.Member;
import edu.projet.entities.Trainer;
import edu.projet.entities.Workshop;
import edu.projet.servicies.MemberCRUD;
import edu.projet.servicies.TrainerCRUD;
import edu.projet.servicies.WorkshopCRUD;




public class MainClass {
      public static void main(String[] args) {
          
          MemberCRUD m2 = new MemberCRUD();
          Member m = new Member();
    
          TrainerCRUD t2 = new TrainerCRUD();
          Trainer t = new Trainer(13,"ahmed",03,"biking");
          
        //  t2.ajouterTrainer(t);
        // t2.modifierTrainer(t);
          //t2.supprimerTrainer(t);
     //     System.out.println(t2.afficherTrainer());
          
//        WorkshopCRUD p = new WorkshopCRUD();
//       Workshop w = new Workshop ("yoga",7,"20/10/2001","4 hours/week ","selyena",10);
//        
//       p.supprimerWorkshop(10);
//        
//        System.out.println(p.afficherWorkshop());
    }
}
