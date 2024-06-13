package oumaima_nezha_mehdy.zelda.Vue;


import javafx.scene.layout.TilePane;
import oumaima_nezha_mehdy.zelda.Vue.VueArmes;


import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import oumaima_nezha_mehdy.zelda.controleur.Controleur;
import oumaima_nezha_mehdy.zelda.modele.Armes.Armes;
import oumaima_nezha_mehdy.zelda.modele.Armes.Bombe;
import oumaima_nezha_mehdy.zelda.modele.Armes.EpeeDeFer;
import oumaima_nezha_mehdy.zelda.modele.Univers.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.HashSet;



public class VueActLink {


    private Acteur link;
    @FXML
    private Pane vueActeur;

    private Champ champ;

    private Pane VueArmesJeu;

    @FXML
    private TilePane armesMap;

    @FXML
    private ImageView vueLink;

    private Image linkNord;
    private Image linkSud;
    private Image linkEst;
    private Image linkOuest;

    private HBox vueCaseInventaire;

    private int tT;

    private VueArmes armeEquipé;

    private Pane vueArmesInventaire;

    private String directionregardé;

    private Timeline gameLoop;

    private ArrayList<VueArmes> vueInventaire;
    private ArrayList<VueArmes> vueItem;

    private HashSet<String> touchePressé;

    private Armes epee ;
    private int numeroImage;



    public VueActLink(Pane pane, Champ c, int tailleTuile, Pane VueArmesJeu, HBox vueCaseInventaire, Pane vueArmesInventaire){
        vueActeur=pane;
        numeroImage=1;
        this.VueArmesJeu = VueArmesJeu;
        this.champ=c;
        //this.armesMap = armesMap;
        this.link=champ.getLink();
        this.tT=tailleTuile;
        this.vueCaseInventaire=vueCaseInventaire;
        this.vueArmesInventaire=vueArmesInventaire;
        this.touchePressé = new HashSet<>();
        this.directionregardé="est";
        this.vueInventaire = new ArrayList<>();
        this.vueItem = new ArrayList<>();
        chargerInventaire();
        link.getInventaire().addListener(new InventaireObs(link,vueArmesInventaire,vueCaseInventaire,this));
        champ.getItem().addListener(new ChampItemObs(VueArmesJeu,this));
        creerlink("file:src/main/resources/images/link_profil.png",link);
        linkNord=new Image("file:src/main/resources/images/Link/NordDefault.png");
        linkSud=new Image("file:src/main/resources/images/Link/SudDefault.png");
        linkEst=new Image("file:src/main/resources/images/Link/EstDefault.png");
        linkOuest=new Image("file:src/main/resources/images/Link/OuestDefault.png");
        VueArmes a = new VueEpee(new EpeeDeFer(champ));
        VueArmesJeu.getChildren().add(a.getArmeVue());
        a.getArme().setX(600);
        a.getArme().setY(550);
        VueArmes b = new VueBombe(new Bombe(champ));
        VueArmesJeu.getChildren().add(b.getArmeVue());
        b.getArme().setX(200);
        b.getArme().setY(750);
        initAnimation();
        gameLoop.play();


    }

    public void ajouterTouche(String key){
        touchePressé.add(key);
    }

    public void DeplacementLink() {
        if (touchePressé.contains("Z")) {
            link.seDeplacer("nord");
            directionregardé="nord";

            this.vueLink.setImage(linkNord);
        }
        if (touchePressé.contains("Q")) {
            link.seDeplacer("ouest");
            directionregardé="ouest";

            this.vueLink.setImage(linkOuest);
        }
        if (touchePressé.contains("S")){
            link.seDeplacer("sud");
            directionregardé="sud";

            this.vueLink.setImage(linkSud);
        }
        if (touchePressé.contains("D")){
            link.seDeplacer("est");
            directionregardé="est";

            this.vueLink.setImage(linkEst);
        }
        if (touchePressé.contains("A")){
            new Thread(() -> {
                try {
                    link.attaquer(armeEquipé,link);
                    armeEquipé.vueAttaque(this,link, armeEquipé.getArme());
                    System.out.println("le perso attaque");
                    Thread.sleep(300);
                   if(armeEquipé.getArme().getNom() != "bombe"){
                       armeEquipé.getArmeVue().setFitWidth(15);
                       armeEquipé.getArmeVue().setFitHeight(15);
                       armeEquipé.vueRepos(new Image("file:src/main/resources/images/Armes/epeeFerInversé.png"), armeEquipé.getArme(), link);
                    }

                    System.out.println("le perso arrete l'attaque");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        if (armeEquipé!=null)
            bindeur(directionregardé);
            System.out.println(link.getX()+","+link.getY());
            System.out.println(link.getX()/tT+","+link.getY()/tT);
    }
    public void creerlink(String path , Acteur a){
        ImageView r = new ImageView();
        Image Image = new Image(path);
        r.setImage(Image);
        r.setFitWidth(30);
        r.setFitHeight(30);
        vueActeur.getChildren().add(r);
        r.setId(a.getId());
        r.setTranslateX(a.getX());
        r.setTranslateY(a.getY());
        r.translateXProperty().bind(a.getXProperty());
        r.translateYProperty().bind(a.getYProperty());
        this.vueLink=r;
        
    }

    public void selectioner(int i){
        if(armeEquipé!=null) {
            VueArmesJeu.getChildren().remove(armeEquipé.getArmeVue());
            System.out.println(VueArmesJeu.getChildren().isEmpty());
        }
        if(link.getInventaire().get(i-1)!=null) {
            armeEquipé = vueInventaire.get(i-1);
            VueArmesJeu.getChildren().add(armeEquipé.getArmeVue());
            bindeur(directionregardé);

        }

    }
    public void bindeur(String direction){
        switch (direction){
            case "sud" :
                armeEquipé.getArmeVue().setImage(armeEquipé.getArmeImage());
                armeEquipé.getArmeVue().xProperty().bind(this.link.getXProperty().add(-3)); // Adjust offset as needed
                armeEquipé.getArmeVue().yProperty().bind(this.link.getYProperty().add(10)); // Adjust offset as needed
                break;
            case "nord" :
                armeEquipé.getArmeVue().setImage(armeEquipé.getArmeInversé());
                armeEquipé.getArmeVue().xProperty().bind(this.link.getXProperty().add(20));
                armeEquipé.getArmeVue().yProperty().bind(this.link.getYProperty().add(7));
                break;
            case "ouest" :
                armeEquipé.getArmeVue().setImage(armeEquipé.getArmeImage());
                armeEquipé.getArmeVue().xProperty().bind(this.link.getXProperty().add(-3)); // Adjust offset as needed
                armeEquipé.getArmeVue().yProperty().bind(this.link.getYProperty().add(5));
                break;
            case "est" :
                armeEquipé.getArmeVue().setImage(armeEquipé.getArmeInversé());
                armeEquipé.getArmeVue().xProperty().bind(this.link.getXProperty().add(15));
                armeEquipé.getArmeVue().yProperty().bind(this.link.getYProperty().add(10));
                break;
        }

    }

    public Acteur getLink(){
        return this.link;
    }


    public void lacher(){
        if(armeEquipé!=null){
            armeEquipé.getArmeVue().xProperty().unbind();
            armeEquipé.getArmeVue().yProperty().unbind();
            armeEquipé=null;
        }
    }

    private void chargerInventaire(){
        for(int i=0;i<5;i++){
            vueInventaire.add(null);
        }
    }

    public void toucheRelaché(KeyEvent keyEvent) {
        touchePressé.remove(keyEvent.getCode().toString());
    }

    public void animation(String direction) {
        switch (direction) {
            case "nord":
                    this.vueLink.setImage(new Image("file:src/main/resources/images/Link/Nord/Nord" + numeroImage + ".png"));
                break;
            case "sud":
                    this.vueLink.setImage(new Image("file:src/main/resources/images/Link/Sud/Sud" + numeroImage + ".png"));
                break;
            case "est":
                this.vueLink.setImage(new Image("file:src/main/resources/images/Link/Est/Est" + numeroImage + ".png"));
                break;
            case "ouest":
                this.vueLink.setImage(new Image("file:src/main/resources/images/Link/Ouest/Ouest" + numeroImage + ".png"));
                break;
            case "inactif":
                this.vueLink.setImage(new Image("file:src/main/resources/images/Link/"+directionregardé+"Default.png"));
                break;
        }
    }

    private void initAnimation() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.03),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev ->{
                    DeplacementLink();
                    if (touchePressé.isEmpty())
                        animation("inactif");
                    else
                    animation(directionregardé);
                    numeroImage++;
                    if(numeroImage>10)
                        numeroImage=1;
                })
        );gameLoop.getKeyFrames().add(kf);
    }
    public ArrayList<VueArmes> getVueInventaire() {
        return vueInventaire;
    }
    public Champ getChamp() {
        return champ;
    }

    public ArrayList<VueArmes> getVueItem() {
        return vueItem;
    }

    public void re(){
        vueArmesInventaire.getChildren().remove(vueArmesInventaire.lookup("#case" + 1));
    }

    public Pane getVueArmesJeu() {
        return VueArmesJeu;
    }


}