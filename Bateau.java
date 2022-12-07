import customClass.*;

public class Bateau
{
    int positionX;
    int positionY;
    int longueur;


    public static Bateau Bateauini(int longueur)
    {
        //crée un bateau avec un longueur pré definie et l'affect a un Bateau

        Bateau bateau = new Bateau();

        Ecran.afficher("quelle est la position X ?: ");
        bateau.positionX = Clavier.saisirInt();

        Ecran.afficher("quelle est la postition Y ?: ");
        bateau.positionY = Clavier.saisirInt();

        bateau.longueur = longueur;

        return bateau;
    }
    public static void main(String args [])
    {
        Bateau torpilleurJ1 = new Bateau();
        torpilleurJ1 = Bateauini(2);

        Bateau sousMarinsJ1_1 = new Bateau();
        sousMarinsJ1_1 = Bateauini(3);

        affichageGrille(torpilleurJ1,sousMarinsJ1_1);


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
        int estPosBateau = 0;
           
            if(X == bateau.positionX && Y == bateau.positionY)
            {   
                    return 1;  
            }else
            {
                if(X == bateau.positionX && Y > bateau.positionY && Y < bateau.positionY + bateau.longueur)
                {
                        //Ecran.afficher(bateau.longueur);
                    if(X == bateau.positionX && Y > (bateau.positionY + bateau.longueur) - bateau.positionY)
                    {
                            return 1;
                    }   
                }
            }
        
        return 0;
    }
}