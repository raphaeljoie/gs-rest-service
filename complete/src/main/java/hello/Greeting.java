package hello;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.IOException;

public class Greeting {

    /**
     * Id of request, unique inside a run
     */
    private final long id;

    /**
     *
     */
    private final String host_address;

    /**
     * the maximum amount of memory that the virtual machine will attempt to use, measured in bytes
     * {@link Runtime#maxMemory()}
     */
    private final long memory_max;

    /**
     * the total amount of memory currently available for current
     * and future objects, measured in bytes. {@link Runtime#totalMemory()}
     */
    private final long memory_allocated;

    /**
     * an approximation to the total amount of memory currently
     * available for future allocated objects, measured in bytes. {@link Runtime#freeMemory()}
     */
    private final long memory_free;

    /**
     * TODO
     */
    private final long memory_free_total;

    /**
     * total size of swap files, measured in bytes.
     */
    private final long swap_size;

    public Greeting(long id, String host_address) {
        this.id = id;
        this.host_address = host_address;

        Runtime runtime = Runtime.getRuntime();

        this.memory_max = runtime.maxMemory();
        this.memory_allocated = runtime.totalMemory();
        this.memory_free = runtime.freeMemory();
        this.memory_free_total = memory_free + (memory_max - memory_allocated);

        long swapSize = -1;
        try {
            swapSize = getSwapSize();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.swap_size = swapSize;
    }

    public long getId() {
        return id;
    }

    public String getHost_address() {
        return host_address;
    }

    public long getMemory_max() {
        return memory_max;
    }

    public long getMemory_allocated() {
        return memory_allocated;
    }

    public long getMemory_free() {
        return memory_free;
    }

    public long getMemory_free_total() {
        return memory_free_total;
    }

    public long getSwap_size() {
        return swap_size;
    }

    /**
     * @return the size of swap
     * @throws IOException
     */
    private long getSwapSize() throws IOException {
        long size = 0;
        if (System.getProperty("os.name").contains("OS X")) {
            // on OSX
            final String swapDirPath = "/private/var/vm";
            final File swapDir = new File(swapDirPath);

            final File[] swapFiles = swapDir.listFiles();

            if (swapFiles == null)
                return 0;

            for (File swapFile : swapFiles) {
                if (swapFile.isFile()) {
                    size += swapFile.length();
                }
            }
        } else {
            // TODO this is copy pasted from web. Test on Linux and other platforms
            // Node on linux, size can be found in file "/proc/swaps"
            // see : https://stackoverflow.com/questions/9845868/how-to-get-swap-size-in-linux-from-proc-swaps
            throw new NotImplementedException();
        }

        return size;
    }
}
