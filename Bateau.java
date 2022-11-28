import customClass.*;

//Duflos Matthias I2-B


//TO DO 
/*
 * selection de la positon du bateau
 * 
 */

public class Bateau
{
        int positionX;
        int positionY;
        boolean verticale;
        int longueur;

        public Bateau()
        {

        }

        public Bateau(int longueur)
        {
            //crée un bateau avec un longueur pré definie

            Bateau bateau = new Bateau();

            Ecran.afficher("quelle est la position X ?: ");
            bateau.positionX = Clavier.saisirInt();

            Ecran.afficher("quelle est la postition Y ?: ");
            bateau.positionY = Clavier.saisirInt();

            bateau.verticale = orientation();

            bateau.longueur = longueur;
        }

        public static Bateau placagBateau(Bateau bateau)
        {


            return bateau;
        }
    

        public class Tir
        {
            int X;
            int Y;
            boolean hit;
        }
    public static void main(String args [])
    {
        initialisation();
    }
    public static Bateau Bateauini(int longueur)
    {
        //crée un bateau avec un longueur pré definie et l'affect a un Bateau

        Bateau bateau = new Bateau();

        Ecran.afficher("quelle est la position X ?: ");
        bateau.positionX = Clavier.saisirInt();

        Ecran.afficher("quelle est la postition Y ?: ");
        bateau.positionY = Clavier.saisirInt();

        bateau.verticale = orientation();

        bateau.longueur = longueur;

        return bateau;
    }

    public static void initialisation()
    {
        Bateau torpilleurJ1 = new Bateau();
        torpilleurJ1 = Bateauini(2);

        //Bateau sousMarinsJ1_1 = new Bateau(3);
        //Bateau sousMarinsJ1_2 = new Bateau(3);

        //Bateau croiseurJ1 = new Bateau(4);

        //Bateau port_Avion = new Bateau(5);

        affichageGrille(torpilleurJ1);
    }

    public static boolean orientation()
    {
        boolean orientation = true;

        return true;
    }


    //to do ne pas afficher un bateau qui est coulé
    public static void affichageGrille(Bateau torpilleurJ1)
    {
        //affiche une grille est change la case si il sagit d'un bateau

        for (int Y = 1; Y < 10; Y++) 
        {
            Ecran.afficher(Y, " ");
            for (int X = 1; X < 10; X++) 
            {
                //Ecran.afficher(X);
                if(estPosBateau(X,Y,torpilleurJ1))
                {
                    Ecran.afficher("0 ");
                }else
                {
                    Ecran.afficher("~ ");
                }    
            } 
            Ecran.afficherln();   
        }
    }


    public static boolean estPosBateau(int X,int Y,Bateau bateau)
    {
        //retourne vrai si X et Y sont des coordonée de bateau
        boolean estPosBateau = false;
        //Ecran.afficher(bateau.positionX,bateau.positionY);
        //Ecran.afficher(bateau.verticale);
        if(X == bateau.positionX && Y == bateau.positionY)
        {
            if(bateau.verticale == true) 
            {
                //Ecran.afficher(bateau.longueur);
                /* 
                if(X == bateau.positionX && Y < (bateau.positionY + bateau.longueur) - bateau.positionY)
                {

                    return true;
                }
                */
                
                return true;
            }else
            {
                /* 
                while(Y == bateau.positionY && X < (bateau.positionX + bateau.longueur) - bateau.positionX)
                {
                    return true;
                }
                */
            }
        }else
        {
            if(X == bateau.positionX && Y > bateau.positionY && Y < bateau.positionY + bateau.longueur)
            {
                if(bateau.verticale == true) 
                {
                    //Ecran.afficher(bateau.longueur);
                    while(X == bateau.positionX && Y > (bateau.positionY + bateau.longueur) - bateau.positionY)
                    {
                        return true;
                    }   
                }

            }
        }

        return estPosBateau;
    }

    public static int positionXAllBoat()
    {
        int positionX = 0;

        return positionX;
    }

    public static int colision(Bateau bateau, int tirX, int tirY)
    {
        int colision = 0;

        if(tirX == bateau.positionX && tirY == bateau.positionY)
        {
            colision = 1;
        }

        return colision;
    }
}