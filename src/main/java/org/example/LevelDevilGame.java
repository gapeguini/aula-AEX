package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class LevelDevilGame extends JPanel implements ActionListener, KeyListener {

    static final int WIDTH = 1000;
    static final int HEIGHT = 600;

    Timer timer;

    Player player;

    List<Platform> platforms;
    List<Spike> spikes;
    List<Trap> traps;

    Door door;

    int currentLevel = 0;
    int deaths = 0;

    boolean left = false;
    boolean right = false;
    boolean jumpPressed = false;

    boolean gameWon = false;

    // ============================================================
    // CONSTRUTOR
    // ============================================================

    public LevelDevilGame() {

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        addKeyListener(this);

        timer = new Timer(16, this);
        timer.start();

        loadLevel(0);
    }

    // ============================================================
    // CARREGAR FASE
    // ============================================================

    void loadLevel(int level) {

        platforms = new ArrayList<>();
        spikes = new ArrayList<>();
        traps = new ArrayList<>();

        player = new Player(50, 450);

        // ========================================================
        // FASE 1
        // ========================================================

        if (level == 0) {

            ground();

            platform(180, 450, 160);
            platform(430, 380, 150);
            platform(670, 450, 150);

            spike(340, 515, 80);
            spike(580, 515, 90);

            door = new Door(880, 470);
        }

        // ========================================================
        // FASE 2
        // ========================================================

        else if (level == 1) {

            ground();

            platform(120, 450, 120);
            platform(320, 360, 120);
            platform(520, 430, 100);
            platform(700, 330, 130);

            spike(240, 515, 100);
            spike(420, 515, 100);
            spike(620, 515, 80);

            door = new Door(880, 260);
        }

        // ========================================================
        // FASE 3
        // ========================================================

        else if (level == 2) {

            ground();

            platform(100, 430, 110);
            platform(270, 320, 100);
            platform(430, 420, 100);
            platform(590, 300, 100);
            platform(760, 400, 110);

            spike(210, 515, 60);
            spike(370, 515, 60);
            spike(530, 515, 60);
            spike(690, 515, 70);

            door = new Door(890, 330);
        }

        // ========================================================
        // FASE 4
        // ========================================================

        else if (level == 3) {

            ground();

            platform(80, 430, 100);
            platform(230, 300, 90);
            platform(380, 420, 90);
            platform(530, 280, 90);
            platform(680, 390, 90);
            platform(830, 250, 100);

            spike(180, 515, 50);
            spike(330, 515, 50);
            spike(480, 515, 50);
            spike(630, 515, 50);
            spike(780, 515, 50);

            door = new Door(900, 180);
        }

        // ========================================================
        // FASE 5
        // ========================================================

        else if (level == 4) {

            ground();

            platform(80, 430, 100);
            platform(220, 340, 80);
            platform(350, 250, 80);
            platform(480, 350, 80);
            platform(610, 240, 80);
            platform(740, 330, 80);
            platform(870, 220, 80);

            spike(180, 515, 40);
            spike(300, 515, 40);
            spike(430, 515, 40);
            spike(560, 515, 40);
            spike(690, 515, 40);
            spike(820, 515, 40);

            door = new Door(900, 150);
        }

        // ========================================================
        // FASE 6
        // ========================================================

        else if (level == 5) {

            ground();

            platform(70, 450, 80);
            platform(190, 330, 70);
            platform(310, 230, 70);
            platform(430, 350, 70);
            platform(550, 250, 70);
            platform(670, 370, 70);
            platform(790, 240, 70);
            platform(900, 330, 70);

            spike(150, 515, 40);
            spike(260, 515, 40);
            spike(380, 515, 40);
            spike(500, 515, 40);
            spike(620, 515, 40);
            spike(740, 515, 40);
            spike(860, 515, 40);

            door = new Door(920, 260);
        }

        // ========================================================
        // FASE 7
        // ========================================================

        else if (level == 6) {

            ground();

            platform(70, 430, 80);
            platform(200, 280, 70);
            platform(330, 400, 70);
            platform(460, 240, 70);
            platform(590, 350, 70);
            platform(720, 210, 70);
            platform(850, 330, 70);

            spike(150, 515, 50);
            spike(280, 515, 50);
            spike(410, 515, 50);
            spike(540, 515, 50);
            spike(670, 515, 50);
            spike(800, 515, 50);

            trap(330, 515, 80);
            trap(720, 515, 80);

            door = new Door(900, 260);
        }

        // ========================================================
        // FASE 8
        // ========================================================

        else if (level == 7) {

            ground();

            platform(60, 450, 70);
            platform(160, 350, 60);
            platform(260, 250, 60);
            platform(360, 350, 60);
            platform(460, 230, 60);
            platform(560, 330, 60);
            platform(660, 210, 60);
            platform(760, 310, 60);
            platform(860, 190, 60);

            spike(130, 515, 30);
            spike(230, 515, 30);
            spike(330, 515, 30);
            spike(430, 515, 30);
            spike(530, 515, 30);
            spike(630, 515, 30);
            spike(730, 515, 30);
            spike(830, 515, 30);

            door = new Door(900, 120);
        }

        // ========================================================
        // FASE 9
        // ========================================================

        else if (level == 8) {

            ground();

            platform(60, 430, 90);
            platform(200, 300, 70);
            platform(330, 430, 70);
            platform(460, 280, 70);
            platform(590, 400, 70);
            platform(720, 250, 70);
            platform(850, 350, 70);

            spike(150, 515, 50);
            spike(270, 515, 50);
            spike(400, 515, 50);
            spike(530, 515, 50);
            spike(660, 515, 50);
            spike(790, 515, 50);

            trap(460, 515, 80);
            trap(720, 515, 80);

            door = new Door(900, 280);
        }

        // ========================================================
        // FASE 10
        // ========================================================

        else if (level == 9) {

            ground();

            platform(50, 450, 70);
            platform(150, 320, 60);
            platform(250, 220, 60);
            platform(350, 350, 60);
            platform(450, 240, 60);
            platform(550, 330, 60);
            platform(650, 200, 60);
            platform(750, 300, 60);
            platform(850, 180, 60);

            spike(120, 515, 30);
            spike(220, 515, 30);
            spike(320, 515, 30);
            spike(420, 515, 30);
            spike(520, 515, 30);
            spike(620, 515, 30);
            spike(720, 515, 30);
            spike(820, 515, 30);

            trap(350, 515, 60);
            trap(650, 515, 60);

            door = new Door(900, 110);
        }

        // ========================================================
        // FASE 11
        // ========================================================

        else if (level == 10) {

            ground();

            platform(70, 430, 70);
            platform(180, 300, 60);
            platform(290, 390, 60);
            platform(400, 260, 60);
            platform(510, 350, 60);
            platform(620, 220, 60);
            platform(730, 330, 60);
            platform(840, 190, 60);

            spike(140, 515, 30);
            spike(250, 515, 30);
            spike(360, 515, 30);
            spike(470, 515, 30);
            spike(580, 515, 30);
            spike(690, 515, 30);
            spike(800, 515, 30);

            trap(290, 515, 60);
            trap(620, 515, 60);

            door = new Door(900, 120);
        }

        // ========================================================
        // FASE 12
        // ========================================================

        else if (level == 11) {

            ground();

            platform(50, 450, 60);
            platform(140, 330, 55);
            platform(230, 220, 55);
            platform(320, 350, 55);
            platform(410, 230, 55);
            platform(500, 320, 55);
            platform(590, 200, 55);
            platform(680, 300, 55);
            platform(770, 180, 55);
            platform(860, 270, 55);

            spike(110, 515, 30);
            spike(195, 515, 30);
            spike(285, 515, 30);
            spike(375, 515, 30);
            spike(465, 515, 30);
            spike(555, 515, 30);
            spike(645, 515, 30);
            spike(735, 515, 30);
            spike(825, 515, 30);

            door = new Door(900, 200);
        }

        // ========================================================
        // FASE 13
        // ========================================================

        else if (level == 12) {

            ground();

            platform(50, 440, 65);
            platform(145, 300, 55);
            platform(240, 400, 55);
            platform(335, 260, 55);
            platform(430, 370, 55);
            platform(525, 220, 55);
            platform(620, 330, 55);
            platform(715, 190, 55);
            platform(810, 300, 55);
            platform(905, 170, 55);

            spike(115, 515, 30);
            spike(210, 515, 30);
            spike(305, 515, 30);
            spike(400, 515, 30);
            spike(495, 515, 30);
            spike(590, 515, 30);
            spike(685, 515, 30);
            spike(780, 515, 30);
            spike(875, 515, 30);

            trap(335, 515, 55);
            trap(715, 515, 55);

            door = new Door(930, 100);
        }

        // ========================================================
        // FASE 14
        // ========================================================

        else if (level == 13) {

            ground();

            platform(40, 450, 60);
            platform(130, 350, 50);
            platform(220, 250, 50);
            platform(310, 340, 50);
            platform(400, 230, 50);
            platform(490, 320, 50);
            platform(580, 210, 50);
            platform(670, 300, 50);
            platform(760, 180, 50);
            platform(850, 270, 50);
            platform(940, 150, 50);

            spike(100, 515, 30);
            spike(180, 515, 30);
            spike(260, 515, 30);
            spike(340, 515, 30);
            spike(420, 515, 30);
            spike(500, 515, 30);
            spike(580, 515, 30);
            spike(660, 515, 30);
            spike(740, 515, 30);
            spike(820, 515, 30);
            spike(900, 515, 30);

            door = new Door(950, 80);
        }

        // ========================================================
        // FASE 15
        // ========================================================

        else if (level == 14) {

            ground();

            platform(40, 430, 60);
            platform(130, 300, 50);
            platform(220, 200, 50);
            platform(310, 330, 50);
            platform(400, 180, 50);
            platform(490, 290, 50);
            platform(580, 160, 50);
            platform(670, 270, 50);
            platform(760, 150, 50);
            platform(850, 250, 50);
            platform(940, 130, 50);

            spike(100, 515, 30);
            spike(180, 515, 30);
            spike(260, 515, 30);
            spike(340, 515, 30);
            spike(420, 515, 30);
            spike(500, 515, 30);
            spike(580, 515, 30);
            spike(660, 515, 30);
            spike(740, 515, 30);
            spike(820, 515, 30);
            spike(900, 515, 30);

            trap(310, 515, 50);
            trap(670, 515, 50);

            door = new Door(950, 60);
        }

        // ========================================================
        // FASE 16
        // ========================================================

        else if (level == 15) {

            ground();

            platform(30, 450, 55);
            platform(110, 330, 50);
            platform(190, 220, 50);
            platform(270, 340, 50);
            platform(350, 200, 50);
            platform(430, 300, 50);
            platform(510, 170, 50);
            platform(590, 280, 50);
            platform(670, 150, 50);
            platform(750, 260, 50);
            platform(830, 130, 50);
            platform(910, 230, 50);

            spike(85, 515, 25);
            spike(165, 515, 25);
            spike(245, 515, 25);
            spike(325, 515, 25);
            spike(405, 515, 25);
            spike(485, 515, 25);
            spike(565, 515, 25);
            spike(645, 515, 25);
            spike(725, 515, 25);
            spike(805, 515, 25);
            spike(885, 515, 25);

            trap(270, 515, 50);
            trap(590, 515, 50);
            trap(830, 515, 50);

            door = new Door(940, 160);
        }

        // ========================================================
        // FASE 17
        // ========================================================

        else if (level == 16) {

            ground();

            platform(30, 450, 50);
            platform(105, 300, 45);
            platform(180, 190, 45);
            platform(255, 320, 45);
            platform(330, 170, 45);
            platform(405, 290, 45);
            platform(480, 150, 45);
            platform(555, 270, 45);
            platform(630, 130, 45);
            platform(705, 250, 45);
            platform(780, 110, 45);
            platform(855, 230, 45);
            platform(930, 100, 45);

            spike(80, 515, 25);
            spike(155, 515, 25);
            spike(230, 515, 25);
            spike(305, 515, 25);
            spike(380, 515, 25);
            spike(455, 515, 25);
            spike(530, 515, 25);
            spike(605, 515, 25);
            spike(680, 515, 25);
            spike(755, 515, 25);
            spike(830, 515, 25);
            spike(905, 515, 25);

            trap(255, 515, 45);
            trap(555, 515, 45);
            trap(855, 515, 45);

            door = new Door(945, 40);
        }

        // ========================================================
        // FASE 18
        // ========================================================

        else if (level == 17) {

            ground();

            platform(20, 450, 50);
            platform(90, 320, 45);
            platform(160, 200, 45);
            platform(230, 300, 45);
            platform(300, 170, 45);
            platform(370, 280, 45);
            platform(440, 140, 45);
            platform(510, 250, 45);
            platform(580, 120, 45);
            platform(650, 230, 45);
            platform(720, 100, 45);
            platform(790, 210, 45);
            platform(860, 80, 45);
            platform(930, 190, 45);

            spike(70, 515, 20);
            spike(140, 515, 20);
            spike(210, 515, 20);
            spike(280, 515, 20);
            spike(350, 515, 20);
            spike(420, 515, 20);
            spike(490, 515, 20);
            spike(560, 515, 20);
            spike(630, 515, 20);
            spike(700, 515, 20);
            spike(770, 515, 20);
            spike(840, 515, 20);
            spike(910, 515, 20);

            trap(230, 515, 45);
            trap(510, 515, 45);
            trap(790, 515, 45);

            door = new Door(950, 120);
        }

        // ========================================================
        // FASE 19
        // ========================================================

        else if (level == 18) {

            ground();

            platform(20, 450, 45);
            platform(90, 300, 40);
            platform(155, 190, 40);
            platform(220, 290, 40);
            platform(285, 160, 40);
            platform(350, 270, 40);
            platform(415, 130, 40);
            platform(480, 240, 40);
            platform(545, 110, 40);
            platform(610, 220, 40);
            platform(675, 90, 40);
            platform(740, 200, 40);
            platform(805, 70, 40);
            platform(870, 180, 40);
            platform(935, 60, 40);

            spike(65, 515, 20);
            spike(130, 515, 20);
            spike(195, 515, 20);
            spike(260, 515, 20);
            spike(325, 515, 20);
            spike(390, 515, 20);
            spike(455, 515, 20);
            spike(520, 515, 20);
            spike(585, 515, 20);
            spike(650, 515, 20);
            spike(715, 515, 20);
            spike(780, 515, 20);
            spike(845, 515, 20);
            spike(910, 515, 20);

            trap(220, 515, 40);
            trap(480, 515, 40);
            trap(740, 515, 40);

            door = new Door(950, 20);
        }

        // ========================================================
        // FASE 20 - O INFERNO
        // ========================================================

        else {

            ground();

            // Plataformas extremamente pequenas
            platform(20, 450, 45);
            platform(85, 330, 35);
            platform(145, 220, 35);
            platform(205, 340, 35);
            platform(265, 190, 35);
            platform(325, 300, 35);
            platform(385, 150, 35);
            platform(445, 270, 35);
            platform(505, 120, 35);
            platform(565, 240, 35);
            platform(625, 100, 35);
            platform(685, 220, 35);
            platform(745, 80, 35);
            platform(805, 200, 35);
            platform(865, 60, 35);
            platform(925, 170, 35);

            // Campo gigantesco de espinhos
            spike(65, 515, 25);
            spike(125, 515, 25);
            spike(185, 515, 25);
            spike(245, 515, 25);
            spike(305, 515, 25);
            spike(365, 515, 25);
            spike(425, 515, 25);
            spike(485, 515, 25);
            spike(545, 515, 25);
            spike(605, 515, 25);
            spike(665, 515, 25);
            spike(725, 515, 25);
            spike(785, 515, 25);
            spike(845, 515, 25);
            spike(905, 515, 25);
            spike(965, 515, 25);

            // Armadilhas escondidas
            trap(205, 515, 35);
            trap(385, 515, 35);
            trap(565, 515, 35);
            trap(745, 515, 35);
            trap(925, 515, 35);

            door = new Door(950, 100);
        }

        repaint();
    }

    // ============================================================
    // CRIADORES
    // ============================================================

    void ground() {

        platforms.add(
                new Platform(
                        0,
                        540,
                        WIDTH,
                        60
                )
        );
    }

    void platform(int x, int y, int width) {

        platforms.add(
                new Platform(
                        x,
                        y,
                        width,
                        20
                )
        );
    }

    void spike(int x, int y, int width) {

        spikes.add(
                new Spike(
                        x,
                        y,
                        width,
                        25
                )
        );
    }

    void trap(int x, int y, int width) {

        traps.add(
                new Trap(
                        x,
                        y,
                        width,
                        25
                )
        );
    }

    // ============================================================
    // GAME LOOP
    // ============================================================

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!gameWon) {

            player.update();

            checkCollisions();

            if (player.y > HEIGHT + 100) {

                die();
            }

            if (door != null &&
                    player.getBounds().intersects(
                            door.getBounds()
                    )) {

                if (currentLevel < 19) {

                    currentLevel++;

                    loadLevel(currentLevel);

                } else {

                    gameWon = true;
                }
            }
        }

        repaint();
    }

    // ============================================================
    // COLISÕES
    // ============================================================

    void checkCollisions() {

        Rectangle playerRect =
                player.getBounds();

        // Plataformas
        for (Platform p : platforms) {

            Rectangle platformRect =
                    p.getBounds();

            if (playerRect.intersects(
                    platformRect
            )) {

                if (player.vy >= 0 &&
                        player.y + player.height
                                <= p.y + 25) {

                    player.y =
                            p.y - player.height;

                    player.vy = 0;

                    player.onGround = true;
                }
            }
        }

        // Espinhos
        for (Spike s : spikes) {

            if (playerRect.intersects(
                    s.getBounds()
            )) {

                die();

                return;
            }
        }

        // Armadilhas
        for (Trap t : traps) {

            if (playerRect.intersects(
                    t.getBounds()
            )) {

                t.active = true;

                die();

                return;
            }
        }
    }

    // ============================================================
    // MORTE
    // ============================================================

    void die() {

        deaths++;

        player.x = 50;
        player.y = 450;

        player.vx = 0;
        player.vy = 0;

        player.jumps = 0;

        for (Trap t : traps) {

            t.active = false;
        }
    }

    // ============================================================
    // DESENHO
    // ============================================================

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 =
                (Graphics2D) g;

        // Fundo
        g2.setColor(
                new Color(20, 20, 25)
        );

        g2.fillRect(
                0,
                0,
                WIDTH,
                HEIGHT
        );

        // ========================================================
        // HUD
        // ========================================================

        g2.setColor(Color.WHITE);

        g2.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        g2.drawString(
                "LEVEL DEVIL",
                20,
                30
        );

        g2.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        16
                )
        );

        g2.drawString(
                "Fase: " +
                        (currentLevel + 1) +
                        " / 20",
                20,
                55
        );

        g2.drawString(
                "Mortes: " +
                        deaths,
                150,
                55
        );

        g2.drawString(
                "A/D ou ← → = Mover",
                300,
                30
        );

        g2.drawString(
                "ESPAÇO = Pulo duplo",
                300,
                55
        );

        g2.drawString(
                "R = Reiniciar",
                550,
                30
        );

        // ========================================================
        // PLATAFORMAS
        // ========================================================

        for (Platform p : platforms) {

            p.draw(g2);
        }

        // ========================================================
        // ESPINHOS
        // ========================================================

        for (Spike s : spikes) {

            s.draw(g2);
        }

        // ========================================================
        // ARMADILHAS
        // ========================================================

        for (Trap t : traps) {

            t.draw(g2);
        }

        // ========================================================
        // PORTA
        // ========================================================

        if (door != null) {

            door.draw(g2);
        }

        // ========================================================
        // PLAYER
        // ========================================================

        player.draw(g2);

        // ========================================================
        // VITÓRIA
        // ========================================================

        if (gameWon) {

            g2.setColor(
                    new Color(
                            0,
                            0,
                            0,
                            220
                    )
            );

            g2.fillRect(
                    0,
                    0,
                    WIDTH,
                    HEIGHT
            );

            g2.setColor(
                    Color.GREEN
            );

            g2.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            60
                    )
            );

            g2.drawString(
                    "VOCÊ VENCEU!",
                    290,
                    250
            );

            g2.setColor(Color.WHITE);

            g2.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            24
                    )
            );

            g2.drawString(
                    "Você sobreviveu às 20 fases!",
                    330,
                    300
            );

            g2.drawString(
                    "Mortes: " +
                            deaths,
                    430,
                    345
            );

            g2.drawString(
                    "Pressione R para começar novamente",
                    310,
                    395
            );
        }
    }

    // ============================================================
    // CONTROLES
    // ============================================================

    @Override
    public void keyPressed(KeyEvent e) {

        int key =
                e.getKeyCode();

        if (key == KeyEvent.VK_A ||
                key == KeyEvent.VK_LEFT) {

            left = true;
        }

        if (key == KeyEvent.VK_D ||
                key == KeyEvent.VK_RIGHT) {

            right = true;
        }

        if (key == KeyEvent.VK_SPACE ||
                key == KeyEvent.VK_W ||
                key == KeyEvent.VK_UP) {

            jumpPressed = true;
        }

        if (key == KeyEvent.VK_R) {

            if (gameWon) {

                currentLevel = 0;
                deaths = 0;
                gameWon = false;
            }

            loadLevel(currentLevel);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key =
                e.getKeyCode();

        if (key == KeyEvent.VK_A ||
                key == KeyEvent.VK_LEFT) {

            left = false;
        }

        if (key == KeyEvent.VK_D ||
                key == KeyEvent.VK_RIGHT) {

            right = false;
        }

        if (key == KeyEvent.VK_SPACE ||
                key == KeyEvent.VK_W ||
                key == KeyEvent.VK_UP) {

            jumpPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // ============================================================
    // PLAYER
    // ============================================================

    class Player {

        double x;
        double y;

        double vx;
        double vy;

        int width = 25;
        int height = 50;

        double speed = 4.5;

        double gravity = 0.65;

        boolean onGround = false;

        int jumps = 0;

        Player(double x, double y) {

            this.x = x;
            this.y = y;
        }

        void update() {

            // ====================================================
            // MOVIMENTO HORIZONTAL
            // ====================================================

            if (left) {

                vx = -speed;

            } else if (right) {

                vx = speed;

            } else {

                vx *= 0.80;
            }

            x += vx;

            if (x < 0) {

                x = 0;
            }

            if (x + width > WIDTH) {

                x = WIDTH - width;
            }

            // ====================================================
            // GRAVIDADE
            // ====================================================

            vy += gravity;

            y += vy;

            // ====================================================
            // PULO DUPLO
            // ====================================================

            if (jumpPressed) {

                if (jumps < 2) {

                    vy = -12;

                    jumps++;

                    jumpPressed = false;
                }
            }

            if (onGround) {

                jumps = 0;
            }

            onGround = false;
        }

        Rectangle getBounds() {

            return new Rectangle(
                    (int) x + 4,
                    (int) y,
                    width - 8,
                    height
            );
        }

        // ========================================================
        // DESENHAR PESSOA PRETA
        // ========================================================

        void draw(Graphics2D g) {

            g.setColor(Color.BLACK);

            int px = (int) x;
            int py = (int) y;

            // ----------------------------------------------------
            // CABEÇA
            // ----------------------------------------------------

            g.fillOval(
                    px + 5,
                    py - 18,
                    15,
                    18
            );

            // ----------------------------------------------------
            // CORPO
            // ----------------------------------------------------

            g.fillRect(
                    px + 8,
                    py,
                    9,
                    25
            );

            // ----------------------------------------------------
            // BRAÇO ESQUERDO
            // ----------------------------------------------------

            g.setStroke(
                    new BasicStroke(
                            5,
                            BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND
                    )
            );

            g.drawLine(
                    px + 9,
                    py + 4,
                    px - 2,
                    py + 19
            );

            // ----------------------------------------------------
            // BRAÇO DIREITO
            // ----------------------------------------------------

            g.drawLine(
                    px + 16,
                    py + 4,
                    px + 27,
                    py + 19
            );

            // ----------------------------------------------------
            // PERNA ESQUERDA
            // ----------------------------------------------------

            g.drawLine(
                    px + 10,
                    py + 24,
                    px + 3,
                    py + 49
            );

            // ----------------------------------------------------
            // PERNA DIREITA
            // ----------------------------------------------------

            g.drawLine(
                    px + 15,
                    py + 24,
                    px + 22,
                    py + 49
            );
        }
    }

    // ============================================================
    // PLATAFORMA
    // ============================================================

    class Platform {

        int x;
        int y;
        int width;
        int height;

        Platform(
                int x,
                int y,
                int width,
                int height
        ) {

            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        Rectangle getBounds() {

            return new Rectangle(
                    x,
                    y,
                    width,
                    height
            );
        }

        void draw(Graphics2D g) {

            g.setColor(
                    new Color(
                            100,
                            100,
                            105
                    )
            );

            g.fillRect(
                    x,
                    y,
                    width,
                    height
            );

            g.setColor(Color.WHITE);

            g.drawRect(
                    x,
                    y,
                    width,
                    height
            );
        }
    }

    // ============================================================
    // ESPINHO
    // ============================================================

    class Spike {

        int x;
        int y;
        int width;
        int height;

        Spike(
                int x,
                int y,
                int width,
                int height
        ) {

            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        Rectangle getBounds() {

            return new Rectangle(
                    x,
                    y,
                    width,
                    height
            );
        }

        void draw(Graphics2D g) {

            g.setColor(Color.RED);

            int count =
                    Math.max(
                            1,
                            width / 20
                    );

            for (int i = 0;
                 i < count;
                 i++) {

                int[] px = {

                        x + i * 20,

                        x + i * 20 + 10,

                        x + i * 20 + 20
                };

                int[] py = {

                        y + height,

                        y,

                        y + height
                };

                g.fillPolygon(
                        px,
                        py,
                        3
                );
            }
        }
    }

    // ============================================================
    // ARMADILHA
    // ============================================================

    class Trap {

        int x;
        int y;
        int width;
        int height;

        boolean active = false;

        Trap(
                int x,
                int y,
                int width,
                int height
        ) {

            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        Rectangle getBounds() {

            return new Rectangle(
                    x,
                    y,
                    width,
                    height
            );
        }

        void draw(Graphics2D g) {

            // Armadilha invisível
            if (!active) {

                g.setColor(
                        new Color(
                                20,
                                20,
                                25
                        )
                );

            } else {

                g.setColor(Color.RED);
            }

            g.fillRect(
                    x,
                    y,
                    width,
                    height
            );

            if (active) {

                g.setColor(Color.WHITE);

                g.drawString(
                        "TRAP!",
                        x,
                        y - 5
                );
            }
        }
    }

    // ============================================================
    // PORTA
    // ============================================================

    class Door {

        int x;
        int y;

        int width = 40;
        int height = 65;

        Door(
                int x,
                int y
        ) {

            this.x = x;
            this.y = y;
        }

        Rectangle getBounds() {

            return new Rectangle(
                    x,
                    y,
                    width,
                    height
            );
        }

        void draw(Graphics2D g) {

            g.setColor(
                    new Color(
                            0,
                            200,
                            70
                    )
            );

            g.fillRect(
                    x,
                    y,
                    width,
                    height
            );

            g.setColor(Color.WHITE);

            g.drawRect(
                    x,
                    y,
                    width,
                    height
            );

            // Maçaneta
            g.setColor(Color.YELLOW);

            g.fillOval(
                    x + 28,
                    y + 32,
                    6,
                    6
            );
        }
    }

    // ============================================================
    // MAIN
    // ============================================================

    public static void main(String[] args) {

        JFrame frame =
                new JFrame(
                        "Level Devil Java"
                );

        LevelDevilGame game =
                new LevelDevilGame();

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setResizable(false);

        frame.add(game);

        frame.pack();

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        game.requestFocusInWindow();
    }
}
