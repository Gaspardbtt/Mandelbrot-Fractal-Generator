public class TestMandel {
    public static void main(String[] args) {
        Mandel m = new Mandel(512, 500, 400);
        m.afficher();
        m.sauver("Mandel");
    }
}
