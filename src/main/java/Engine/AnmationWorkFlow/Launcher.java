package Engine.AnmationWorkFlow;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Launcher {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation WorkFlow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 8, 8));
        inputPanel.setBorder(new EmptyBorder(16, 16, 16, 16));

        JTextField idlePathTextField = new JTextField("image/Player/1 Pink_Monster/Pink_Monster_Idle/Pink_Monster_idle_", 30);
        JTextField walkPathTextField = new JTextField("image/Player/1 Pink_Monster/Pink_Monster_Walk_6/Pink_Monster_Walk_", 30);
        JTextField attackPathTextField = new JTextField("image/Player/1 Pink_Monster/Pink_Monster_Attack2_6/Pink_Monster_Attack2_", 30);
        JTextField climbPathTextField = new JTextField("image/Player/1 Pink_Monster/Pink_Monster_Climb_4/Pink_Monster_Climb_", 30);
        JTextField jumpPathTextField = new JTextField("image/Player/1 Pink_Monster/Pink_Monster_Jump_8/Pink_Monster_Jump_", 30);

        JLabel idleLabel = new JLabel("Idle Path:");
        JLabel walkLabel = new JLabel("Walk Path:");
        JLabel attackLabel = new JLabel("Attack Path:");
        JLabel climbLabel = new JLabel("Climb Path:");
        JLabel jumpLabel = new JLabel("Jump Path:");

        inputPanel.add(idleLabel);
        inputPanel.add(idlePathTextField);
        inputPanel.add(walkLabel);
        inputPanel.add(walkPathTextField);
        inputPanel.add(attackLabel);
        inputPanel.add(attackPathTextField);
        inputPanel.add(climbLabel);
        inputPanel.add(climbPathTextField);
        inputPanel.add(jumpLabel);
        inputPanel.add(jumpPathTextField);

        JButton startButton = new JButton("Start Animation Workflow");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idlePath = idlePathTextField.getText();
                String walkPath = walkPathTextField.getText();
                String attackPath = attackPathTextField.getText();
                String climbPath = climbPathTextField.getText();
                String jumpPath = jumpPathTextField.getText();

                Character character = new Character(walkPath, idlePath, climbPath, attackPath, jumpPath);

                JFrame characterFrame = new JFrame("Character Animation");
                characterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                characterFrame.add(character);
                characterFrame.setSize(240, 140);
                characterFrame.setLocationRelativeTo(frame);
                characterFrame.setVisible(true);
            }
        });

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);

        frame.setSize(760, 320);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
