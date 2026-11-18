package it.unibo.mvc;

import java.util.List;

/**
 * This interface represents a controller in the MVC pattern,
 * responsible for managing the flow of data between the model and the view.
 */
public interface Controller {
    /**
     * Sets the next string to print.
     * 
     * @param str the string to print
     * @throws IllegalArgumentException if {@code null} is passed
     */
    void setNextString(String str);

    /**
     * Gets the next string to print.
     * 
     * @return the string to print
     */
    String getNextString();

    /**
     * Gets all the strings that were previously printed.
     * 
     * @return all the previously printed strings
     */
    List<String> getHistory();

    /**
     * Prints the next string to {@link System#out} in the same way as {@link IO#println()}.
     * Set the next string to print with {@link #setNextString(String)}.
     * 
     * @throws IllegalStateException if the next string is unset.
     */
    void print();
}
