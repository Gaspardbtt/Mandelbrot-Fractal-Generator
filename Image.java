import phelma.*;

public class Image {
    private int nbl;
    private int nbc;
    private int[][] data;


    public Image(int nbl, int nbc) {
        this.nbl = nbl;
        this.nbc = nbc;
        this.data = new int[nbl][nbc];
        for(int i = 0; i < nbl; i++) {
            for(int j = 0; j < nbc; j++) {
                this.data[i][j] = 255<<24;
            }
        }
    }

    public Image(Image im) {
        this.nbl = im.nbl;
        this.nbc = im.nbc;
        this.data = new int[nbl][nbc];    //création d'un tableau de la bonne taille
        for(int i = 0; i < this.nbl; i++) {
            for(int j = 0; j < nbc; j++) {
                    this.data[i][j] = im.data[i][j];       // copie en profondeur du tableau
            }
        }
    }

    public int getNbl() {
        return nbl;
    }

    public int getNbc() {
        return nbc;
    }

    public int getPixel(int i, int j) {
        return data[i][j];
    }

    public void modifyPixel(int i, int j, int value) {
        data[i][j] = value;
    }

    public void drawRect(int x, int y, int H, int L){
        if(x < 0 || y < 0 || x + H > nbl || y + L > nbc) {
            throw new IllegalArgumentException("Rectangle out of bounds");
        }
        for(int i = x; i < x + H; i++) {
            for(int j = y; j < y + L; j++) {
                this.data[i][j] = 0xFFFFFFFF;
            }
        }
    }

    void afficher(){
        ImageToolkit.displayPixelMatrix(this.data);
    }

    public void sauver(String nom){
        if(nom == null) {
            throw new IllegalArgumentException("Invalid file name");
        }

        ImageToolkit.savePixelMatrix(nom, this.data);
    }

}

