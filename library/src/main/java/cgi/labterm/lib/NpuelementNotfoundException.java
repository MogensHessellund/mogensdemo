package cgi.labterm.lib;

public class NpuelementNotfoundException extends RuntimeException {
    public NpuelementNotfoundException(String id) {
        super("Kunne ikke finde npuElement " + id);
    }


    public NpuelementNotfoundException(long id) {
        super("Kunne ikke finde npuElement " + id);
    }
}
