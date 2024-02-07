import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SlotMachine {
    private JFrame frame;
    private JPanel slotPanel;
    private JButton spinButton;
    private JLabel balanceLabel;
    private JLabel resultLabel;
    private JLabel winLineLabel;

    private String[] symbols = {"[♠]", "[♣]", "[♥]", "[♦]", "[★]", "[$]", "[7]"};
    private int money = 1000;
    private int bet = 10;
    private Random random = new Random();

    public SlotMachine() {
        frame = new JFrame("Máquina Tragamonedas");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        slotPanel = new JPanel();
        slotPanel.setLayout(new GridLayout(3, 3));
        frame.add(slotPanel, BorderLayout.CENTER);

        spinButton = new JButton("Girar");
        frame.add(spinButton, BorderLayout.SOUTH);

        JPanel infoPanel = new JPanel(new FlowLayout());
        balanceLabel = new JLabel("Saldo: $" + money);
        infoPanel.add(balanceLabel);
        resultLabel = new JLabel("");
        infoPanel.add(resultLabel);
        winLineLabel = new JLabel("");
        infoPanel.add(winLineLabel);
        frame.add(infoPanel, BorderLayout.NORTH);

        spinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spinButton.setEnabled(false);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        resultLabel.setText("");
                        winLineLabel.setText("");
                        String[] newSymbols = new String[9];
                        for (int i = 0; i < 10; i++) {
                            for (int j = 0; j < 9; j++) {
                                newSymbols[j] = symbols[random.nextInt(symbols.length)];
                            }
                            updateSlot(newSymbols);
                            try {
                                TimeUnit.MILLISECONDS.sleep(100);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }

                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                int winProbability = random.nextInt(100);
                                int prize = checkWin(winProbability);
                                money += prize;
                                balanceLabel.setText("Saldo: $" + money);

                                if (prize > 0) {
                                    resultLabel.setText("¡Felicidades! Has ganado $" + prize);
                                    winLineLabel.setText("Línea ganadora: " + getWinningLine());
                                    flashWinningSymbols();
                                } else if (prize < 0) {
                                    resultLabel.setText("Lo siento, no has ganado. Has perdido $" + bet);
                                } else {
                                    resultLabel.setText("No has ganado esta vez.");
                                }

                                spinButton.setEnabled(true);
                            }
                        });
                    }
                }).start();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private void updateSlot(String[] newSymbols) {
        slotPanel.removeAll();
        for (String symbol : newSymbols) {
            JLabel label = new JLabel(symbol);
            label.setFont(new Font("Arial", Font.PLAIN, 24));
            slotPanel.add(label);
        }
        frame.revalidate();
        frame.repaint();
    }

    private int checkWin(int winProbability) {
        if (winProbability < 15) { // 15% de probabilidad de ganar
            return bet * 10 + generateReward();
        } else {
            return -bet;
        }
    }

    private int generateReward() {
        return random.nextInt(101) + 50;
    }

    private String getWinningLine() {
        int[][] winningLines = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        for (int[] line : winningLines) {
            String symbol = slotPanel.getComponent(line[0]).toString();
            if (!symbol.equals("[ ]") && symbol.equals(slotPanel.getComponent(line[1]).toString()) && symbol.equals(slotPanel.getComponent(line[2]).toString())) {
                return symbol;
            }
        }
        return "";
    }

    private void flashWinningSymbols() {
        String winningSymbol = getWinningLine();

        if (!winningSymbol.isEmpty()) {
            for (Component component : slotPanel.getComponents()) {
                JLabel label = (JLabel) component;
                if (label.getText().equals(winningSymbol)) {
                    label.setForeground(Color.RED); // Cambia el color del símbolo ganador a rojo
                }
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(2); // Mantiene los símbolos resaltados durante 2 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Restablece el color de los símbolos a negro
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            for (Component component : slotPanel.getComponents()) {
                                JLabel label = (JLabel) component;
                                label.setForeground(Color.BLACK);
                            }
                        }
                    });
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SlotMachine();
            }
        });
    }
}
