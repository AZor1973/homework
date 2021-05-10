package lesson8;

import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame {
    protected static String command = "PLAY";
    private static final String GAME_OVER = "GAME_OVER";
    protected static final String AI_TURN = "AI_TURN";
    protected static final String PAUSE = "PAUSE";
    private static String result = "play";
    protected static int x;
    protected static int y;
    private static final int size = TicTacToeLogic.getSize();
    private static final JButton[][] arrButtons = new JButton[size][size];

    public TicTacToeFrame() {
        setBounds(400, 100, 500, 500);
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        setLayout(new GridLayout(size, size));
        Font font = new Font("Arial", Font.BOLD, 70);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arrButtons[i][j] = new JButton() {
                    {
                        addActionListener(e -> {
                            x = getX() / 97;
                            y = (getY() - 1) / 92;
                            if (TicTacToeLogic.map[y][x] == TicTacToeLogic.getDot_EMPTY()) {
                                setText("X");
                                setForeground(Color.BLUE);
                            }
                            TicTacToeLogic.humanTurn();
                            if (TicTacToeLogic.checkWin(TicTacToeLogic.getDotX())) {
                                result = "Победил человек";
                                System.out.println(result);
                                command = GAME_OVER;
                            }
                            if (TicTacToeLogic.isMapFull()) {
                                result = "Ничья";
                                System.out.println(result);
                                command = GAME_OVER;
                            }
                            if (command.equals(AI_TURN)) {
                                TicTacToeLogic.aiTurn();
                                arrButtons[TicTacToeLogic.yOut][TicTacToeLogic.xOut].setText("O");
                                arrButtons[TicTacToeLogic.yOut][TicTacToeLogic.xOut].setForeground(Color.RED);
                                if (TicTacToeLogic.checkWin(TicTacToeLogic.getDotO())) {
                                    result = "Победил ИИ";
                                    System.out.println(result);
                                    command = GAME_OVER;
                                }
                                if (TicTacToeLogic.isMapFull()) {
                                    result = "Ничья";
                                    System.out.println(result);
                                    command = GAME_OVER;
                                }
                            }
                            if (command.equals(GAME_OVER)) finalFrame();
                        });
                    }
                };
                arrButtons[i][j].setFont(font);
                add(arrButtons[i][j]);
            }
        }
        while (true){
            TicTacToeLogic.humanTurn();
            if (TicTacToeLogic.checkWin(TicTacToeLogic.getDotX())) {
                result = "Победил человек";
                System.out.println(result);
                command = GAME_OVER;
                break;
            }
            if (TicTacToeLogic.isMapFull()) {
                result = "Ничья";
                System.out.println(result);
                command = GAME_OVER;
                break;
            }
            if (command.equals(AI_TURN)) {
                TicTacToeLogic.aiTurn();
                arrButtons[TicTacToeLogic.yOut][TicTacToeLogic.xOut].setText("O");
                arrButtons[TicTacToeLogic.yOut][TicTacToeLogic.xOut].setForeground(Color.RED);
                if (TicTacToeLogic.checkWin(TicTacToeLogic.getDotO())) {
                    result = "Победил ИИ";
                    System.out.println(result);
                    command = GAME_OVER;
                    break;
                }
                if (TicTacToeLogic.isMapFull()) {
                    result = "Ничья";
                    System.out.println(result);
                    command = GAME_OVER;
                    break;
                }
            }
            if (command.equals(GAME_OVER)) finalFrame();
        }
        TicTacToeLogic.initMap();
        TicTacToeLogic.printMap();
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(TicTacToeFrame::new);
    }

    private static void finalFrame() {
        EventQueue.invokeLater(() -> new JFrame() {
            {
                setBounds(500, 300, 500, 120);
                setTitle("GAME OVER");
                setAlwaysOnTop(true);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setResizable(false);
                Font font = new Font("Arial", Font.BOLD, 32);
                JLabel labelGameOver = new JLabel("GAME OVER");
                JLabel labelResult = new JLabel(result);
                labelGameOver.setFont(font);
                labelGameOver.setForeground(Color.BLUE);
                labelGameOver.setHorizontalAlignment(SwingConstants.CENTER);
                add(labelGameOver, BorderLayout.NORTH);
                labelResult.setFont(font);
                labelResult.setForeground(Color.BLUE);
                labelResult.setHorizontalAlignment(SwingConstants.CENTER);
                add(labelResult, BorderLayout.SOUTH);

                setVisible(true);
            }
        });

    }
}

