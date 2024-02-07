import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int CELL_SIZE = 20;
    private static final int INITIAL_SNAKE_LENGTH = 5;

    private ArrayList<Point> snake;
    private Point food;
    private int direction;
    private boolean isGameOver;
    private Timer timer;

    public SnakeGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                changeDirection(e.getKeyCode());
            }
        });

        initializeGame();
    }

    private void initializeGame() {
        snake = new ArrayList<>();
        snake.add(new Point(WIDTH / 2, HEIGHT / 2));
        food = generateFoodLocation();
        direction = KeyEvent.VK_RIGHT;
        isGameOver = false;

        timer = new Timer(150, this);
        timer.start();
    }

    private Point generateFoodLocation() {
        Random rand = new Random();
        int x = rand.nextInt(WIDTH / CELL_SIZE) * CELL_SIZE;
        int y = rand.nextInt(HEIGHT / CELL_SIZE) * CELL_SIZE;
        return new Point(x, y);
    }

    private void changeDirection(int newDirection) {
        if ((newDirection == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT) ||
            (newDirection == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT) ||
            (newDirection == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN) ||
            (newDirection == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP)) {
            direction = newDirection;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            moveSnake();
            checkCollision();
            repaint();
        }
    }

    private void moveSnake() {
        Point head = snake.get(0);
        int newHeadX = head.x;
        int newHeadY = head.y;

        switch (direction) {
            case KeyEvent.VK_LEFT:
                newHeadX -= CELL_SIZE;
                break;
            case KeyEvent.VK_RIGHT:
                newHeadX += CELL_SIZE;
                break;
            case KeyEvent.VK_UP:
                newHeadY -= CELL_SIZE;
                break;
            case KeyEvent.VK_DOWN:
                newHeadY += CELL_SIZE;
                break;
        }

        snake.add(0, new Point(newHeadX, newHeadY));

        // Check if the snake ate the food
        if (head.equals(food)) {
            food = generateFoodLocation();
        } else {
            snake.remove(snake.size() - 1);
        }
    }

    private void checkCollision() {
        Point head = snake.get(0);

        // Check if the snake hit the wall
        if (head.x < 0 || head.x >= WIDTH || head.y < 0 || head.y >= HEIGHT) {
            isGameOver = true;
            timer.stop();
            return;
        }

        // Check if the snake collided with itself
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                isGameOver = true;
                timer.stop();
                return;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isGameOver) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", WIDTH / 2 - 80, HEIGHT / 2);
        } else {
            // Draw food
            g.setColor(Color.RED);
            g.fillRect(food.x, food.y, CELL_SIZE, CELL_SIZE);

            // Draw snake
            g.setColor(Color.GREEN);
            for (Point p : snake) {
                g.fillRect(p.x, p.y, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame game = new SnakeGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
