package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {
    private int value;
    private int counterStep;

    public CounterApp(int initialValue) {
        setLocationRelativeTo(null);
        setSize(300, 220);
        setTitle("Simple Counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        Font font = new Font("Arial", Font.BOLD, 32);
        JLabel counterValueView = new JLabel();
        counterValueView.setFont(font);
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValueView, BorderLayout.CENTER);

        value = initialValue;
        counterValueView.setText(String.valueOf(value));

        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        add(decrementButton, BorderLayout.WEST);

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        add(incrementButton, BorderLayout.EAST);

        JButton reset = new JButton("reset");
        reset.setFont(font);
        add(reset, BorderLayout.SOUTH);

        JTextField textField = new JTextField();
        textField.setFont(font);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        add(textField, BorderLayout.NORTH);

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value -= counterStep;
                counterValueView.setText(String.valueOf(value));
            }
        });

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value += counterStep;
                counterValueView.setText(String.valueOf(value));
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = 0;
                counterValueView.setText(String.valueOf(value));
            }
        });

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterStep = Integer.parseInt(textField.getText());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CounterApp(0);
            }
        });

    }
}
