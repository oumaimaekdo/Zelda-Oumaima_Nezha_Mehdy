package oumaima_nezha_mehdy.zelda.modele.Univers;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import oumaima_nezha_mehdy.zelda.Vue.VueChamp;
import oumaima_nezha_mehdy.zelda.controleur.Controleur;
import oumaima_nezha_mehdy.zelda.controleur.VueArmes;
import oumaima_nezha_mehdy.zelda.modele.Armes.Armes;

import java.util.ArrayList;
import java.util.Arrays;

public class Champ {

    private int[] champ;

    private ArrayList<Bloc> listBloc =new ArrayList<>();

    private ArrayList<Acteur> listActeur = new ArrayList<>();

    private ArrayList<Integer> pointDeCollision;

    private Acteur link;
    private Sbir sbir;

    private int longueur;

    private int largeur;

    private int tT;

    private VueArmes vueArmes;
    private Armes arme;

    public Champ(int L , int l,int[] map){
        this.largeur=l;
        this.longueur=L;
        this.champ = map;
        this.link = new Acteur("Link",0,700,this);
        this.sbir = new Sbir("Squelette",50,650,this,true);
        this.tT=64;
        this.pointDeCollision = new ArrayList<Integer>(Arrays.asList(5,6,7,8));

    }



    public void ajouterActeur(Acteur a){
        listActeur.add(a);
    }

    public void afficherMap(){
        for(int i=0; i<champ.length;i++) {
            if(i%longueur==0) {
                System.out.println("");
            }
            System.out.print(champ[i]);
            System.out.print("\t");
        }
    }



    public boolean coordonnéPossible(int x, int y) {
        // Define the boundary offsets
        final int haut = 20;
        final int gauche = 20;
        final int bas = -20;
        final int droite = -10;

        // Check initial boundary conditions
        if (x < 0 || y < 0 || x + 15 >= this.longueur * tT || y + 15 >= this.largeur * tT) {
            return false;
        }

        // Calculate grid indices once
        int indexHautGauche = ((x + gauche) / tT) + ((y + haut) / tT) * this.longueur;
        int indexBasDroite = ((x - droite) / tT) + ((y - bas) / tT) * this.longueur;

        // Check for collisions
        boolean collisionHautGauche = champ[indexHautGauche] != 1;
        boolean collisionBasDroite = champ[indexBasDroite] != 1;

        // Return the final condition
        return collisionHautGauche && collisionBasDroite;
    }

    public boolean presenceArme(int x, int y){

        final int haut = 20;
        final int gauche = 20;
        final int bas = -20;
        final int droite = -10;

        int indexHautGauche = ((x + gauche) / tT) + ((y + haut) / tT) * this.longueur;
        int indexBasDroite = ((x - droite) / tT) + ((y - bas) / tT) * this.longueur;

        boolean presenceHautGauche = champ[indexHautGauche] == 2;
        boolean presenceBasDroite = champ[indexBasDroite] == 2;

        if(presenceHautGauche && presenceBasDroite){
            champ[indexHautGauche]=0;
            champ[indexBasDroite] = 0;

        }

        return (presenceHautGauche && presenceBasDroite);

    }

    public int[] getChamp(){return champ;}

    public ArrayList<Acteur> getListActeur() {
        return listActeur;
    }



    public Acteur getLink() {
        return link;
    }
    public Sbir getSbir() {
        return sbir;
    }



    public int getLongueur(){return longueur;}
    public int getLargeur(){return largeur;}

    public int gettT() {
        return tT;
    }
}