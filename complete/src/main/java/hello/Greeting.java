package hello;

public class Greeting {

    /**
     * Id of request, unique inside a run
     */
    private final long id;

    /**
     *
     */
    private final String host_address;

    public Greeting(long id, String host_address) {
        this.id = id;
        this.host_address = host_address;
    }

    public long getId() {
        return id;
    }

    public String getHost_address() {
        return host_address;
    }
}
