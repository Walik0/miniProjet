import customClass.*;

//Duflos Matthias I2-B

public class Bateau
{
        int positionX;
        int positionY;
        char typeBateau;
        boolean verticale;

        public Bateau()
        {

        }

        public static String typeBateau(int type)
        {

            String typeBateau = "";

            switch(type)
            {
                case 1:
                typeBateau = "*";
                break;

                case 2:
                typeBateau = "°";
                break;

                case 3:
                typeBateau = "&";
                break;

                case 4:
                typeBateau = "%";
                break;
            }

            return typeBateau;
        }

        public static Bateau placagBateau(Bateau bateau)
        {


            return bateau;
        }
    
    public static void main(String args [])
    {
        Bateau bateau = new Bateau();
        affichageGrille();
        
    }

    public static void initialisation()
    {
        Bateau bateauJoueur1 = new Bateau();

        bateauJoueur1 = saisiBateau();
    }

    public static Bateau saisiBateau()
    {
        Bateau bateau = new Bateau();

        Ecran.afficher("quelle est la position X ?: ");
        bateau.positionX = Clavier.saisirInt();

        Ecran.afficher("quelle est la postition Y ?: ");
        bateau.positionY = Clavier.saisirInt();

        Ecran.afficher("quelle est le type du bateu ?: ");
        bateau.typeBateau = Clavier.saisirChar();

        bateau.verticale = orientation();
        return bateau;
    }

    public static boolean orientation()
    {
        boolean orientation = true;

        return orientation;
    }

    public static void affichageGrille()
    {
        //affiche une grille est change la case si il sagit d'un bateau

        for (int X = 0; X < 10; X++) 
        {
            for (int Y = 0; Y < 10; Y++) 
            {
                if(estPosBateau(X,Y) && X < 10 && Y < 10)
                {
                    Ecran.afficher("[*]");
                }else
                {
                    Ecran.afficher("[ ]");
                }    
            } 
            Ecran.afficherln();   
        }
    }


    public static boolean estPosBateau(int X,int Y)
    {
        //retourne vrai si X et Y sont des coordonée de bateau
        boolean estPosBateau = false;

        if(X == 4 && Y == )
        {
            return true;
        }

        return estPosBateau;
    }
}