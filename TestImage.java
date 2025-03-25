public class TestImage {
    public static void main(String[] args) {
        Image im1 = new Image(256, 512);
        im1.drawRect(20, 20, 216, 472);
        im1.afficher();
        im1.sauver("Test");


        Image im2 = new Image(im1);
        im2.drawRect(0, 0, 216, 472);
        im2.afficher();

        
        im1.afficher();
    }
}