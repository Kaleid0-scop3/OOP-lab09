package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {
    private final JFrame frame = new JFrame("SimpleGUI");
    private final Controller ctl = new Controller();

    /**
     * Makes GUI.
     */
    public SimpleGUI() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea textArea = new JTextArea();
        panel.add(textArea, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        panel.add(save, BorderLayout.SOUTH);

        /* Action Listener */
        save.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                    try {
                        ctl.save(textArea.getText());
                    } catch (final IOException e) {
                        IO.print(e.getMessage());
                    }
                }
            }
        );
    }

    /**
     * Displays the GUI.
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 4, sh / 4);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * program entrypoint.
     */
    public static void main() {
        new SimpleGUI().display();
    }
}
