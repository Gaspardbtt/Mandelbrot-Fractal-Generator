public class TestMandel {
    public static void main(String[] args) {
        Mandel m = new Mandel(1024, 500, 200);
        m.afficher();
        m.sauver("Mandel");
    }
}
