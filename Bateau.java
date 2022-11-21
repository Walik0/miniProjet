import customClass.*;

//Duflos Matthias I2-B

public class Bateau
{
        int positionX;
        int positionY;
        int typeBateau;

        public Bateau()
        {

        }
    
    public static void main(String args [])
    {
        Bateau bateau = new Bateau();
        affichageGrille(bateau);
        
    }

    public static void affichageGrille(Bateau bateau)
    {
        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                Ecran.afficher("[ ]");    
            } 
            Ecran.afficherln();   
        }
    }
}