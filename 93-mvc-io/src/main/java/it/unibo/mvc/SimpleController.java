package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple implementation of the {@link Controller} interface.
 */
public final class SimpleController implements Controller {
    private final List<String> history = new ArrayList<>();
    private String nextString;

    @Override
    public String getNextString() {
        return nextString;
    }

    @Override
    public void setNextString(final String nextString) {
        if (nextString == null) {
            throw new IllegalArgumentException("can not set null as next string");
        }
        this.nextString = nextString;
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(history);
    }

    @Override
    public void print() {
        if (nextString == null) {
            throw new IllegalStateException();
        }
        IO.println(nextString);
        addToHistory(nextString);
    }

    private void addToHistory(final String str) {
        history.add(str);
    }
}
