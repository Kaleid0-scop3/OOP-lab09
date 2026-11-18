package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {
    public static final String TITLE = SimpleGUI.class.getSimpleName();
    public static final int SCALE = 4;
    private final JFrame frame = new JFrame(TITLE);
    private final Controller ctl = new SimpleController();

    /**
     * Setup the view.
     */
    public SimpleGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.setContentPane(panel);
        /* Input */
        final JTextField input = new JTextField();
        panel.add(input, BorderLayout.NORTH);
        /* History output */
        final JTextArea history = new JTextArea();
        history.setEditable(false);
        history.setLineWrap(true);
        panel.add(history, BorderLayout.CENTER);
        /* Buttons */
        final JPanel buttons = new JPanel();
        final JButton printBtn = new JButton("Print");
        final JButton historyBtn = new JButton("Show history");
        buttons.setLayout(new BorderLayout());
        buttons.add(printBtn, BorderLayout.CENTER);
        buttons.add(historyBtn, BorderLayout.SOUTH);
        panel.add(buttons, BorderLayout.SOUTH);
        /* Listeners */
        printBtn.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent event) {
                    try {
                        ctl.setNextString(input.getText());
                        ctl.print();
                    } catch (IllegalArgumentException | IllegalStateException e) {
                        JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        );
        historyBtn.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent event) {
                    history.setText(String.join(", ", ctl.getHistory()));
                }
            }
        );
    }

    /**
     * Display the view.
     */
    public void display() {
        final Dimension sizes = Toolkit.getDefaultToolkit().getScreenSize();
        final int height = (int) sizes.getHeight();
        final int width = (int) sizes.getWidth();
        frame.setSize(width / SCALE, height / SCALE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Application entrypoint.
     */
    public static void main() {
        new SimpleGUI().display();
    }
}
