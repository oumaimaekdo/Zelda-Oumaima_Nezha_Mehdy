package oumaima_nezha_mehdy.zelda.controleur;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

import oumaima_nezha_mehdy.zelda.Vue.VueChamp;
import oumaima_nezha_mehdy.zelda.Vue.VueVillage2;
import oumaima_nezha_mehdy.zelda.modele.Univers.*;
import oumaima_nezha_mehdy.zelda.Vue.VueActLink;
import oumaima_nezha_mehdy.zelda.Vue.VueSbir;

public class Controleur implements Initializable {

    @FXML
    private TilePane map1;
    @FXML
    private TilePane LayerSup;
    @FXML
    private TilePane armesMap;

    @FXML
    private TilePane mapVIllage2;

    @FXML
    private Pane univers;
    @FXML
    private HBox vueInventaire;

    @FXML
    private Pane vueActeur;
    @FXML
    private Pane vueArmes;
    @FXML
    private Pane vueSbir;
    @FXML
    private Pane vueArmesInventaire;

    private Champ champ;
    private VueActLink linkControl;
    private VueSbir sbirControl;
    private Clavier clavier;
    private VueChamp vueChamp;
    private VueVillage2 vueVillage2;

    private MapInt mapInt;
    private MapInt mapInt2;
    private MapInt mapInt3;
    private MapInt mapInt4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.mapInt = MapPossible.test3;
        this.mapInt2 = MapPossible.test4;
        this.mapInt3 = MapPossible.collision;
        this.mapInt4 = MapPossible.village2;

        this.champ = new Champ(mapInt.getLongueur(), mapInt.getLargeur(), MapPossible.collision.getCarte());
        this.vueChamp = new VueChamp(map1,LayerSup,armesMap,champ,mapInt,mapInt2,mapInt3);
        //this.champ = new Champ(mapInt.getLongueur(), mapInt.getLargeur(), MapVillage2.collision.getCarte());
        //this.vueVillage2 = new VueVillage2(mapVIllage2,champ,mapInt4,"village2");
        //this.vueVillage2 = new VueVillage2(mapVIllage2,champ,mapInt4,"volcanIsland");


        this.linkControl = new VueActLink(vueActeur, champ, champ.gettT(), vueArmes, vueInventaire, vueArmesInventaire, armesMap,vueChamp);
        this.sbirControl = new VueSbir(vueSbir, champ, champ.gettT());
        sbirControl.getSbir1().deplacementAleatoire();

        this.clavier = new Clavier(vueActeur, linkControl, vueInventaire);
        setUpListeners();
        //chamgementMap();
    }

    private void setUpListeners() {
        this.champ.getLink().getXProperty().addListener((observable, oldValue, newValue) -> {
            this.univers.setTranslateX(univers.getPrefWidth() / 2 - champ.getLink().getX());
        });
        this.champ.getLink().getYProperty().addListener((observable, oldValue, newValue) -> {
            this.univers.setTranslateY(univers.getPrefHeight() / 2 - champ.getLink().getY());
        });
        this.univers.setTranslateX(univers.getPrefWidth() / 2 - champ.getLink().getX());
        this.univers.setTranslateY(univers.getPrefHeight() / 2 - champ.getLink().getY());
    }

    public void mouseclicked(MouseEvent mouseEvent) {
        univers.requestFocus();
    }

    public void keyPressed(KeyEvent keyEvent) {
        clavier.handle(keyEvent);
        System.out.println(vueInventaire.lookup("#case1").getId());
    }

    public void keyReleased(KeyEvent e){
        clavier.toucheRelaché(e);
    }

    public void chamgementMap(){
        if(this.vueVillage2.getNom() == "village2") {
            if (this.champ.presencePortail(this.linkControl.getLink().getX(), this.linkControl.getLink().getY())) {
                this.champ = new Champ(this.mapInt.getLongueur(), this.mapInt.getLargeur(), MapPossible.collision.getCarte());
                this.vueChamp = new VueChamp(map1,LayerSup,armesMap,champ,mapInt,mapInt2,mapInt3);
                System.out.println("changement de map");
            }
        }
    }
}
