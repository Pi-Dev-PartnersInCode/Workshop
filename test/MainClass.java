
import entities.Member;
import entities.Trainer;
import entities.Workshop;
import services.MemberCRUD;
import services.TrainerCRUD;
import services.WorkshopCRUD;




public class MainClass {
      public static void main(String[] args) {
          
       //   MemberCRUD m2 = new MemberCRUD();
          //Member m = new Member(9,"meyarroum",9,7,7);
         // m2.ajouterMember(m);
          //m2.supprimerMember(m);
    
          
        //  TrainerCRUD t2 = new TrainerCRUD();
       //  Trainer t = new Trainer(13,"ahmed",03,"biking");
          
        //  t2.ajouterTrainer(t);
        // t2.modifierTrainer(t);
          //t2.supprimerTrainer(t);
     //     System.out.println(t2.afficherTrainer());
         WorkshopCRUD p = new WorkshopCRUD();
      
             
        //      System.out.println(p.rechercherWorkshopByID(20));
               
         //     Workshop w = new Workshop ("yoga",7,"20/10/2001","4 hours/week ","selyena",t);
//        
//       p.supprimerWorkshop(10);
//        
 System.out.println(p.afficherWorkshop());
   
      
      
      }
}
