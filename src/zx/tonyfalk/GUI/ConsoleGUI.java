package zx.tonyfalk.GUI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConsoleGUI extends JFrame {
    private JTextArea consoleArea;

    public ConsoleGUI() {
        setTitle("Debug");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        consoleArea = new JTextArea();
        consoleArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(consoleArea);
        add(scrollPane);
        setVisible(true);
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                consoleArea.append(String.valueOf((char) b));
                consoleArea.setCaretPosition(consoleArea.getDocument().getLength());
            }
        };
        System.setOut(new PrintStream(out));
    }
}