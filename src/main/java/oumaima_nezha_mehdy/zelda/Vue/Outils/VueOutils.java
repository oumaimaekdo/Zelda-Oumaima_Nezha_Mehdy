package oumaima_nezha_mehdy.zelda.Vue.Outils;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import oumaima_nezha_mehdy.zelda.modele.Outils.Element.Outils;

public class VueOutils {

    private Outils outils;
    @FXML
    private ImageView Vue;

    private Image Inversé;

    private Image Image;

    public VueOutils(Outils outils, Image inversé,Image image) {
        Inversé = inversé;
        Image = image;
        creerArme(image,outils);
    }
    public void creerArme(Image image, Outils outils) {
        ImageView r = new ImageView();
        r.setImage(image);
        r.setFitWidth(15); // Ajuste selon la taille souhaitée
        r.setFitHeight(15); // Ajuste selon la taille souhaitée
        r.setId(outils.getId());
        this.Vue = r;
        this.outils=outils;
    }


    public ImageView getVue() {
        return Vue;
    }
    public Image getImage(){
        return Image;
    }

    public Image getInversé() {
        return Inversé;
    }

    public Outils getOutils() {
        return outils;
    }
}
