import customClass.*;

public class Bateau
{
    int positionX;
    int positionY;
    int longueur;

    boolean sunk;

    public class Tir
    {
        int X;
        int Y;
        boolean hit;
    }


    public static Bateau Bateauini(int longueur)
    {
        //crée un bateau avec un longueur pré definie et l'affect a un Bateau

        Bateau bateau = new Bateau();

        Ecran.afficher("quelle est la position X ?: ");
        bateau.positionX = Clavier.saisirInt();

        Ecran.afficher("quelle est la postition Y ?: ");
        bateau.positionY = Clavier.saisirInt();

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

        affichageGrille(torpilleurJ1,sousMarinsJ1_1);

        while(endGame(torpilleurJ1, sousMarinsJ1_1) == false)
        {
            nextRound();
            affichageGrille(torpilleurJ1, sousMarinsJ1_1);

            

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