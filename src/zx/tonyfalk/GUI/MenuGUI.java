package zx.tonyfalk.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MenuGUI extends JFrame {
    private JLabel difficultyLabel, playerLabel, aiTypeLabel;
    private JComboBox<String> difficultyComboBox;
    private JRadioButton humanButton, aiButton;
    private JButton startButton;

    public MenuGUI() {
        setTitle("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        // Create a panel to hold the difficulty components
        JPanel difficultyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        difficultyLabel = new JLabel("Difficulty:");
        difficultyComboBox = new JComboBox<>(new String[]{"Easy", "Medium", "Hard"});
        difficultyPanel.add(difficultyLabel);
        difficultyPanel.add(difficultyComboBox);
        add(difficultyPanel);

        // Create a panel to hold the player type components
        JPanel playerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        playerLabel = new JLabel("Player Type:");
        humanButton = new JRadioButton("Human", true);
        aiButton = new JRadioButton("AI");
        playerPanel.add(playerLabel);
        playerPanel.add(humanButton);
        playerPanel.add(aiButton);
        add(playerPanel);

        // Create a panel to hold the AI type components
        JComboBox aiTypeComboBox = new JComboBox();
        aiTypeComboBox.setVisible(false); // hide the panel by default
        aiTypeComboBox = new JComboBox<>(new String[]{"Anna", "Danny" , "Hard"});
        add(aiTypeComboBox);

        // Add an item listener to the AI radio button to show or hide the AI type options
        JComboBox finalAiTypeComboBox = aiTypeComboBox;
        aiButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                finalAiTypeComboBox.setVisible(e.getStateChange() == ItemEvent.SELECTED);
            }
        });

        // Create a start button to begin the game with the selected options
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String difficulty = (String) difficultyComboBox.getSelectedItem();
                boolean aiEnabled = aiButton.isSelected();
                String aiType = "";
                String playerType = aiEnabled ? aiType : "Human";
                System.out.println("Starting game with difficulty: " + difficulty + " and player type: " + playerType);
            }
        });
        add(startButton);

        // Add the player type buttons to a group so that only one can be selected at a time
        ButtonGroup playerGroup = new ButtonGroup();
        playerGroup.add(humanButton);
        playerGroup.add(aiButton);
        // Set the layout and add some padding between components
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        difficultyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        playerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        aiTypeComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        startButton.setAlignmentX(Component.LEFT_ALIGNMENT);

// Add the panels and components to the frame
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(playerPanel);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(aiTypeComboBox);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(startButton);
    }
}
