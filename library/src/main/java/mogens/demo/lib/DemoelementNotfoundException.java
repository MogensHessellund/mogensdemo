package mogens.demo.lib;

public class DemoelementNotfoundException extends RuntimeException {
    public DemoelementNotfoundException(String id) {
        super("Kunne ikke finde demoElement " + id);
    }


    public DemoelementNotfoundException(long id) {
        super("Kunne ikke finde demoElement " + id);
    }
}
