public class Mandel {
    private Image im;
    private double maxModule;
    private int maxTermes;



    public Mandel(int n, double maxModule, int maxTermes) {
        this.im = new Image(n, n);      
        this.maxModule = maxModule;
        this.maxTermes = maxTermes;
        this.genererImage();
    }

    public int imageSize(){
        return im.getNbl();   // nbl = nbc
    }
    
    
    private int calculer(Complexe zp){
        Complexe z = new Complexe(0, 0);
        int n = 0;
        while(z.getRho() < maxModule && n < maxTermes){
            z.mult(z);
            z.add(zp);
            n++;
        }
        return n;
    }
    
    
    private void genererImage(){
        int nb_pix = 0;
        for(int i = 0; i < im.getNbc(); i++){
            for(int j = 0; j < im.getNbc(); j++){
                Complexe zp = new Complexe(2.0 * i / im.getNbc() - 1.0, 2.0 * j / im.getNbc() - 1.0);
                int iter = calculer(zp);

                //pour l'affichage en terminal. 
                System.out.println("---calcul du pixel " + nb_pix + " sur " + im.getNbc()*im.getNbc() + " pixels---");
                nb_pix++;
                // Calcul des valeurs pour les canaux R, G et B
                int red = (iter * 5) % 255;   // Exemple : multiplier par 5 pour un effet
                int green = (iter * 7) % 255; // Exemple : multiplier par 7 pour un effet
                int blue = (iter * 11) % 255; // Exemple : multiplier par 11 pour un effet

                // Encodage ARGB (Alpha = 255 pour opacité totale)
                int argb = (255 << 24) | (red << 16) | (green << 8) | blue;

                // Modification du pixel dans l'image fractale
                //im.modifyPixel(i, j, grayValue);

                im.modifyPixel(i, j, argb);
            }
        }
    }


    public void afficher(){
        im.afficher();
    }

    public void sauver(String nom){
        im.sauver(nom);
    }

    
}
