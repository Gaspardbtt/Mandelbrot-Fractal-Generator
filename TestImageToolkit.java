import phelma.ImageToolkit; // la classe ImageToolkit a été créée dans un package nommé phelma

public class TestImageToolkit {
        public static void main(String[] args) {
                // Definition des dimensions
                int nbl=256, nbc=512;
                // Creation du tableau 2D
                int [][] image = new int[nbl][nbc];
                // On met un rectangle bleu dans l'image
                for (int i=20; i<nbl-20; i++)
                        for (int j=20; j<nbc-20; j++)
                                image[i][j]=255<<24|255;  // Couleur Bleue voir la remarque ci dessous

                // Utilisation de la classe ImageToolkit
                // Les méthodes de cette classe sont des méthodes de classe (static) :
                // => il n'est pas nécessaire (et pas pertinent) de créer un objet de type ImageToolkit.
                // => on utilise directement le nom de la classe.

                // Affichage de l'image par la fenetre
                ImageToolkit.displayPixelMatrix(image);
                // Sauvegarde dans un fichier nommé "jolirectangle.png"
                ImageToolkit.savePixelMatrix("jolirectangle", image);

        }
}
