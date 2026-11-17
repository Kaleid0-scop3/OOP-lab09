package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
private final JFrame frame = new JFrame("SimpleGUIWithFileChooser");
    private final Controller ctl = new Controller();

    /**
     * Makes GUI.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        panel.add(textArea, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        panel.add(save, BorderLayout.SOUTH);
        final JPanel browsePanel = new JPanel();
        browsePanel.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setText(ctl.getFilePath());
        browsePanel.add(textField, BorderLayout.CENTER);
        final JButton browse = new JButton("Browse...");
        browsePanel.add(browse, BorderLayout.LINE_END);
        panel.add(browsePanel, BorderLayout.NORTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        browse.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                    final JFileChooser fc = new JFileChooser();
                    if (fc.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                        ctl.setFile(fc.getSelectedFile());
                        textField.setText(ctl.getFilePath());
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
        new SimpleGUIWithFileChooser().display();
    }
}
