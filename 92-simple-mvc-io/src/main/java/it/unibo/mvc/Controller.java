package it.unibo.mvc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    public static final String DEFAULT_PATH = System.getProperty("user.home") 
        + File.separator + "output.txt";
    private File file = new File(DEFAULT_PATH);

    /**
     * Gets active file.
     * 
     * @return the active file
     */
    public File getFile() {
        return file;
    }

    /**
     * Sets active file.
     * 
     * @param file file to save to
     */
    public void setFile(final File file) {
        this.file = file;
    }

    /**
     * Gets active file path.
     * 
     * @return the active file path
     */
    String getFilePath() {
        return file.getPath();
    }

    /**
     * Saves str to the active file.
     * 
     * @param str string to save
     * @throws IOException if write or open fails
     */
    void save(final String str) throws IOException {
        try (FileWriter fw = new FileWriter(file, StandardCharsets.UTF_8)) {
            fw.write(str);
        } catch (final IOException e) {
            final String msg = String.format("failed to save string '%s' to '%s'", 
                str, getFilePath());
            throw new IOException(msg, e);
        }
    }
}
