import customClass.*;


class Tir
{
    int X;
    int Y;
    boolean hit;
}

public class Bateau
{
    int positionX;
    int positionY;
    int longueur;

    boolean sunk;

    /* 
    public class Tir
    {
        int X;
        int Y;
        boolean hit;
    }*/


    public static Bateau Bateauini(int longueur)
    {
        //crée un bateau avec un longueur pré definie et l'affect a un Bateau

        Bateau bateau = new Bateau();

        switch(longueur)
        {
            case 2:
            Ecran.afficher("quelle est la position X (torpilleur) ?: ");
            bateau.positionX = Clavier.saisirInt();

            Ecran.afficher("quelle est la postition Y (torpilleur) ?: ");
            bateau.positionY = Clavier.saisirInt();
            break;

            case 3:
            Ecran.afficher("quelle est la postition X (sousMarins) ?: ");
            bateau.positionY = Clavier.saisirInt();

            Ecran.afficher("quelle est la postition Y (sousMarins) ?: ");
            bateau.positionY = Clavier.saisirInt();
        }

        bateau.longueur = longueur;
        bateau.sunk = false;

        return bateau;
    }
    public static void main(String args [])
    {
        Bateau torpilleurJ1 = new Bateau();
        torpilleurJ1 = Bateauini(2);

        Bateau sousMarinsJ1_1 = new Bateau();
        sousMarinsJ1_1 = Bateauini(3);

        Tir tir = new Tir();

        affichageGrille(torpilleurJ1,sousMarinsJ1_1);

        while(endGame(torpilleurJ1, sousMarinsJ1_1) == false)
        {
            tir = saisieTir();
            affichageJeux(torpilleurJ1, sousMarinsJ1_1,tir);            

            

        }
    }

    public static Tir saisieTir()
    {
        Tir tir = new Tir();


        Ecran.afficher("ou voulez vous tiré en X: ");
        tir.X = Clavier.saisirInt();
        Ecran.afficher("ou voulez vous tiré en Y: ");
        tir.Y = Clavier.saisirInt();

        tir.hit = false;

        return tir;
    }

    public static void affichageJeux(Bateau torpilleurJ1, Bateau sousMarinsJ1_1,Tir tir)
    {
        int valeurCase;
        int nbTir = 0;
        int nbTirPr = 0;

        boolean estPosBateau;
        for (int Y = 0; Y < 10; Y++)
        {
            for (int X = 0; X < 10; X++) 
            {
                valeurCase = valeurCase(X, Y,torpilleurJ1, sousMarinsJ1_1);

                    if(valeurCase(X,Y,torpilleurJ1,sousMarinsJ1_1) == 1 && tir.X == X && tir.Y == Y)
                    {
                        if(nbTir >= nbTirPr)
                        {
                            nbTir = nbTir +1;
                            //nbTirPr = nbTir;
                            valeurCase = 0;
                        }                          
                    }
                    else
                    {
                        if(valeurCase(X,Y,torpilleurJ1,sousMarinsJ1_1) == 1 && tir.X != X && tir.Y != Y && nbTir > nbTirPr)
                        {
                            valeurCase = 0;
                            

                            
                            
                        }
                    }
                
                affichageCase(valeurCase);    
            } 
            Ecran.afficherln();   
        }
    }
 



    public static boolean endGame(Bateau torpilleurJ1, Bateau sousMarinsJ1_1)
    {
        if(torpilleurJ1.sunk = true && sousMarinsJ1_1.sunk == true)
        {
            return true;
        }
        return false;
    }

    public static boolean tir(int X, int Y)
    {
        return false;
    }

    public static void nextRound()
    {
        int X = Clavier.saisirInt();
        int Y = Clavier.saisirInt();

    }

    public static int valeurCase(int X, int Y, Bateau torpilleurJ1, Bateau sousMarinsJ1_1)
    {
        if(estPosBateau(X, Y, torpilleurJ1) == 1 || estPosBateau(X, Y, sousMarinsJ1_1) == 1)
        {
            return 1;
        }

        return 0;        
    }

    public static void affichageGrille(Bateau torpilleurJ1,Bateau sousMarinsJ1_1)
    {
        int valeurCase;

        boolean estPosBateau;
        for (int Y = 0; Y < 10; Y++)
        {
            for (int X = 0; X < 10; X++) 
            {
                valeurCase = valeurCase(X, Y,torpilleurJ1, sousMarinsJ1_1);
                affichageCase(valeurCase);    
            } 
            Ecran.afficherln();   
        }
    }


    public static void affichageCase(int valeurCase)
    {
        switch(valeurCase)
        {
            case 0:
                Ecran.afficher(" ~ ");
            break;

            case 1:
                Ecran.afficher(" 0 ");
            break;
        }
    }

    public static int estPosBateau(int X,int Y,Bateau bateau)
    {      
            if(X == bateau.positionX && Y == bateau.positionY)
            {   
                    return 1;  
            }else
            {
                if(X == bateau.positionX && Y > bateau.positionY && Y < bateau.positionY + bateau.longueur)
                {
                    if(X == bateau.positionX && Y > (bateau.positionY + bateau.longueur) - bateau.positionY)
                    {
                            return 1;
                    }   
                }
            }
        
        return 0;
    }
}