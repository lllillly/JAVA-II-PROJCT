package Game;

import Engine.EngineMain;
import Game.PlayTheGame.GameMenu;
import Game.Register.DatabaseUtil;
import Game.Register.Login;
import Game.Register.Register;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;

public class GameLauncher extends JFrame {
    private static final Color NIGHT = new Color(17, 22, 38);
    private static final Color PURPLE = new Color(119, 92, 190);
    private static final Color GOLD = new Color(255, 205, 104);

    public GameLauncher() {
        setTitle("Seal Breakers — Portfolio Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(860, 620));
        setLocationByPlatform(true);
        setContentPane(createContent());
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createContent() {
        JPanel background = new GradientPanel();
        background.setLayout(new GridBagLayout());

        JPanel card = new JPanel();
        card.setOpaque(false);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(54, 72, 54, 72));

        JLabel eyebrow = new JLabel("2D PLATFORM ADVENTURE", SwingConstants.CENTER);
        eyebrow.setAlignmentX(CENTER_ALIGNMENT);
        eyebrow.setForeground(GOLD);
        eyebrow.setFont(new Font("Dialog", Font.BOLD, 13));

        JLabel title = new JLabel("SEAL BREAKERS", SwingConstants.CENTER);
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Dialog", Font.BOLD, 42));

        JLabel description = new JLabel(
            "<html><div style='text-align:center'>DB 설정 없이 게스트로 게임을 체험하거나<br/>팀이 만든 그래픽 도구를 확인할 수 있습니다.</div></html>",
            SwingConstants.CENTER
        );
        description.setAlignmentX(CENTER_ALIGNMENT);
        description.setForeground(new Color(205, 211, 229));
        description.setFont(new Font("Dialog", Font.PLAIN, 15));

        card.add(eyebrow);
        card.add(Box.createVerticalStrut(10));
        card.add(title);
        card.add(Box.createVerticalStrut(20));
        card.add(description);
        card.add(Box.createVerticalStrut(34));
        card.add(createButton("게스트로 게임 시작", true, () -> openWindow(new GameMenu())));
        card.add(Box.createVerticalStrut(12));
        card.add(createButton("로그인", false, () -> openWindow(new Login())));
        card.add(Box.createVerticalStrut(12));
        card.add(createButton("회원가입", false, () -> openWindow(new Register())));
        card.add(Box.createVerticalStrut(12));
        card.add(createButton("팀 그래픽 도구 보기", false, () -> {
            dispose();
            EngineMain.main(new String[0]);
        }));
        card.add(Box.createVerticalStrut(24));

        JLabel databaseStatus = new JLabel(
            DatabaseUtil.isConfigured()
                ? "● DB 연결 환경변수 설정됨"
                : "○ Demo mode · DB 없이 실행 가능",
            SwingConstants.CENTER
        );
        databaseStatus.setAlignmentX(CENTER_ALIGNMENT);
        databaseStatus.setForeground(new Color(173, 182, 209));
        databaseStatus.setFont(new Font("Dialog", Font.PLAIN, 12));
        card.add(databaseStatus);

        background.add(card);
        return background;
    }

    private JButton createButton(String text, boolean primary, Runnable action) {
        JButton button = new JButton(text);
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(320, 48));
        button.setPreferredSize(new Dimension(320, 48));
        button.setFocusPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setFont(new Font("Dialog", Font.BOLD, 15));
        button.setForeground(primary ? NIGHT : Color.WHITE);
        button.setBackground(primary ? GOLD : PURPLE);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEmptyBorder(12, 18, 12, 18));
        button.addActionListener(event -> action.run());
        return button;
    }

    private void openWindow(JFrame frame) {
        frame.setLocationRelativeTo(this);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameLauncher().setVisible(true));
    }

    private static class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            Graphics2D g2 = (Graphics2D) graphics.create();
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setPaint(new java.awt.GradientPaint(0, 0, NIGHT, getWidth(), getHeight(), new Color(48, 35, 82)));
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(960, 680);
        }
    }
}
