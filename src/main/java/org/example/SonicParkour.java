import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SonicParkour extends JPanel implements ActionListener, KeyListener {

    // =========================================================
    // CONFIGURAÇÕES
    // =========================================================

    static final int LARGURA = 1000;
    static final int ALTURA = 600;

    Timer timer;

    // =========================================================
    // JOGADOR
    // =========================================================

    Sonic sonic;

    // =========================================================
    // FASE
    // =========================================================

    int faseAtual = 1;
    final int TOTAL_FASES = 5;

    int mundoLargura = 3000;
    int cameraX = 0;

    // =========================================================
    // OBJETOS DO JOGO
    // =========================================================

    List<Plataforma> plataformas = new ArrayList<>();
    List<Anel> aneis = new ArrayList<>();
    List<Inimigo> inimigos = new ArrayList<>();
    List<Espinho> espinhos = new ArrayList<>();

    // =========================================================
    // TECLAS
    // =========================================================

    boolean esquerda = false;
    boolean direita = false;
    boolean correndo = false;

    // =========================================================
    // JOGO
    // =========================================================

    int vidas = 3;
    int pontos = 0;
    int aneisPegos = 0;

    boolean jogoIniciado = false;
    boolean faseConcluida = false;
    boolean jogoConcluido = false;

    // =========================================================
    // CONSTRUTOR
    // =========================================================

    public SonicParkour() {

        setPreferredSize(
                new Dimension(LARGURA, ALTURA)
        );

        setFocusable(true);

        addKeyListener(this);

        sonic = new Sonic(100, 400);

        carregarFase();

        timer = new Timer(16, this);
        timer.start();
    }

    // =========================================================
    // CARREGAR FASE
    // =========================================================

    public void carregarFase() {

        plataformas.clear();
        aneis.clear();
        inimigos.clear();
        espinhos.clear();

        faseConcluida = false;

        sonic.x = 100;
        sonic.y = 400;

        sonic.velocidadeY = 0;

        sonic.noChao = false;

        // Recupera os dois pulos
        sonic.pulosRestantes = 2;

        cameraX = 0;

        if (faseAtual == 1) {

            criarFase1();

        } else if (faseAtual == 2) {

            criarFase2();

        } else if (faseAtual == 3) {

            criarFase3();

        } else if (faseAtual == 4) {

            criarFase4();

        } else if (faseAtual == 5) {

            criarFase5();
        }
    }

    // =========================================================
    // FASE 1 - GREEN HILL
    // =========================================================

    public void criarFase1() {

        mundoLargura = 3000;

        // Chão
        plataformas.add(
                new Plataforma(0, 520, 700, 80)
        );

        plataformas.add(
                new Plataforma(850, 520, 600, 80)
        );

        plataformas.add(
                new Plataforma(1550, 520, 700, 80)
        );

        plataformas.add(
                new Plataforma(2350, 520, 650, 80)
        );

        // Plataformas suspensas
        plataformas.add(
                new Plataforma(400, 400, 180, 30)
        );

        plataformas.add(
                new Plataforma(1000, 390, 200, 30)
        );

        plataformas.add(
                new Plataforma(1700, 380, 200, 30)
        );

        plataformas.add(
                new Plataforma(2150, 400, 180, 30)
        );

        // Anéis
        adicionarAneisLinha(
                250, 450, 5, 50
        );

        adicionarAneisLinha(
                420, 350, 3, 50
        );

        adicionarAneisLinha(
                1000, 340, 4, 50
        );

        adicionarAneisLinha(
                1600, 450, 5, 50
        );

        adicionarAneisLinha(
                2150, 350, 3, 50
        );

        adicionarAneisLinha(
                2500, 450, 6, 50
        );

        // Inimigos
        inimigos.add(
                new Inimigo(600, 470)
        );

        inimigos.add(
                new Inimigo(1200, 470)
        );

        inimigos.add(
                new Inimigo(1900, 470)
        );

        inimigos.add(
                new Inimigo(2500, 470)
        );

        // Espinhos
        espinhos.add(
                new Espinho(700, 490)
        );

        espinhos.add(
                new Espinho(1450, 490)
        );

        espinhos.add(
                new Espinho(2250, 490)
        );
    }

    // =========================================================
    // FASE 2 - CHEMICAL PLANT
    // =========================================================

    public void criarFase2() {

        mundoLargura = 3200;

        plataformas.add(
                new Plataforma(0, 520, 500, 80)
        );

        plataformas.add(
                new Plataforma(650, 520, 500, 80)
        );

        plataformas.add(
                new Plataforma(1300, 520, 500, 80)
        );

        plataformas.add(
                new Plataforma(1950, 520, 500, 80)
        );

        plataformas.add(
                new Plataforma(2600, 520, 600, 80)
        );

        // Plataformas
        plataformas.add(
                new Plataforma(300, 380, 180, 30)
        );

        plataformas.add(
                new Plataforma(800, 350, 200, 30)
        );

        plataformas.add(
                new Plataforma(1450, 380, 180, 30)
        );

        plataformas.add(
                new Plataforma(2100, 350, 200, 30)
        );

        plataformas.add(
                new Plataforma(2750, 380, 200, 30)
        );

        // Anéis
        adicionarAneisLinha(
                200, 450, 5, 50
        );

        adicionarAneisLinha(
                300, 330, 3, 50
        );

        adicionarAneisLinha(
                750, 300, 4, 50
        );

        adicionarAneisLinha(
                1400, 330, 4, 50
        );

        adicionarAneisLinha(
                2050, 300, 4, 50
        );

        adicionarAneisLinha(
                2700, 330, 5, 50
        );

        // Inimigos
        inimigos.add(
                new Inimigo(450, 470)
        );

        inimigos.add(
                new Inimigo(1000, 470)
        );

        inimigos.add(
                new Inimigo(1600, 470)
        );

        inimigos.add(
                new Inimigo(2300, 470)
        );

        inimigos.add(
                new Inimigo(2900, 470)
        );

        // Espinhos
        espinhos.add(
                new Espinho(500, 490)
        );

        espinhos.add(
                new Espinho(1150, 490)
        );

        espinhos.add(
                new Espinho(1800, 490)
        );

        espinhos.add(
                new Espinho(2450, 490)
        );
    }

    // =========================================================
    // FASE 3 - SKY ZONE
    // =========================================================

    public void criarFase3() {

        mundoLargura = 3400;

        plataformas.add(
                new Plataforma(0, 500, 350, 40)
        );

        plataformas.add(
                new Plataforma(500, 430, 250, 30)
        );

        plataformas.add(
                new Plataforma(900, 350, 220, 30)
        );

        plataformas.add(
                new Plataforma(1250, 450, 250, 30)
        );

        plataformas.add(
                new Plataforma(1650, 330, 220, 30)
        );

        plataformas.add(
                new Plataforma(2000, 430, 250, 30)
        );

        plataformas.add(
                new Plataforma(2400, 350, 250, 30)
        );

        plataformas.add(
                new Plataforma(2800, 450, 250, 30)
        );

        plataformas.add(
                new Plataforma(3150, 500, 250, 100)
        );

        // Anéis
        adicionarAneisLinha(
                100, 450, 4, 50
        );

        adicionarAneisLinha(
                500, 380, 4, 50
        );

        adicionarAneisLinha(
                900, 300, 4, 50
        );

        adicionarAneisLinha(
                1250, 400, 4, 50
        );

        adicionarAneisLinha(
                1650, 280, 4, 50
        );

        adicionarAneisLinha(
                2000, 380, 4, 50
        );

        adicionarAneisLinha(
                2400, 300, 4, 50
        );

        adicionarAneisLinha(
                2800, 400, 4, 50
        );

        // Inimigos
        inimigos.add(
                new Inimigo(600, 390)
        );

        inimigos.add(
                new Inimigo(1000, 310)
        );

        inimigos.add(
                new Inimigo(1750, 290)
        );

        inimigos.add(
                new Inimigo(2100, 390)
        );

        inimigos.add(
                new Inimigo(2500, 310)
        );

        // Espinhos
        espinhos.add(
                new Espinho(350, 480)
        );

        espinhos.add(
                new Espinho(750, 410)
        );

        espinhos.add(
                new Espinho(1500, 430)
        );

        espinhos.add(
                new Espinho(2250, 410)
        );
    }

    // =========================================================
    // FASE 4 - MYSTIC CAVE
    // =========================================================

    public void criarFase4() {

        mundoLargura = 3500;

        plataformas.add(
                new Plataforma(0, 520, 500, 80)
        );

        plataformas.add(
                new Plataforma(650, 520, 450, 80)
        );

        plataformas.add(
                new Plataforma(1250, 520, 500, 80)
        );

        plataformas.add(
                new Plataforma(1900, 520, 500, 80)
        );

        plataformas.add(
                new Plataforma(2550, 520, 500, 80)
        );

        plataformas.add(
                new Plataforma(3200, 520, 300, 80)
        );

        // Plataformas
        plataformas.add(
                new Plataforma(300, 390, 180, 30)
        );

        plataformas.add(
                new Plataforma(750, 350, 200, 30)
        );

        plataformas.add(
                new Plataforma(1400, 380, 200, 30)
        );

        plataformas.add(
                new Plataforma(2050, 350, 200, 30)
        );

        plataformas.add(
                new Plataforma(2700, 380, 200, 30)
        );

        plataformas.add(
                new Plataforma(3250, 400, 150, 30)
        );

        // Anéis
        adicionarAneisLinha(
                150, 450, 5, 50
        );

        adicionarAneisLinha(
                300, 340, 3, 50
        );

        adicionarAneisLinha(
                750, 300, 4, 50
        );

        adicionarAneisLinha(
                1400, 330, 4, 50
        );

        adicionarAneisLinha(
                2050, 300, 4, 50
        );

        adicionarAneisLinha(
                2700, 330, 5, 50
        );

        adicionarAneisLinha(
                3250, 350, 3, 50
        );

        // Inimigos
        inimigos.add(
                new Inimigo(400, 470)
        );

        inimigos.add(
                new Inimigo(900, 470)
        );

        inimigos.add(
                new Inimigo(1500, 470)
        );

        inimigos.add(
                new Inimigo(2200, 470)
        );

        inimigos.add(
                new Inimigo(2800, 470)
        );

        // Espinhos
        espinhos.add(
                new Espinho(500, 490)
        );

        espinhos.add(
                new Espinho(1100, 490)
        );

        espinhos.add(
                new Espinho(1750, 490)
        );

        espinhos.add(
                new Espinho(2400, 490)
        );

        espinhos.add(
                new Espinho(3050, 490)
        );
    }

    // =========================================================
    // FASE 5 - CHEFÃO
    // =========================================================

    public void criarFase5() {

        mundoLargura = 3000;

        plataformas.add(
                new Plataforma(0, 520, 800, 80)
        );

        plataformas.add(
                new Plataforma(950, 520, 700, 80)
        );

        plataformas.add(
                new Plataforma(1800, 520, 1200, 80)
        );

        plataformas.add(
                new Plataforma(500, 400, 200, 30)
        );

        plataformas.add(
                new Plataforma(1200, 380, 200, 30)
        );

        plataformas.add(
                new Plataforma(2100, 400, 200, 30)
        );

        // Anéis
        adicionarAneisLinha(
                200, 450, 5, 50
        );

        adicionarAneisLinha(
                500, 350, 4, 50
        );

        adicionarAneisLinha(
                1200, 330, 4, 50
        );

        adicionarAneisLinha(
                2000, 450, 5, 50
        );

        adicionarAneisLinha(
                2400, 450, 5, 50
        );

        // CHEFÃO
        inimigos.add(
                new Inimigo(2500, 430, true)
        );

        // Espinhos
        espinhos.add(
                new Espinho(800, 490)
        );

        espinhos.add(
                new Espinho(1650, 490)
        );
    }

    // =========================================================
    // CRIAR ANÉIS
    // =========================================================

    public void adicionarAneisLinha(
            int x,
            int y,
            int quantidade,
            int distancia) {

        for (int i = 0; i < quantidade; i++) {

            aneis.add(
                    new Anel(
                            x + i * distancia,
                            y
                    )
            );
        }
    }

    // =========================================================
    // LOOP DO JOGO
    // =========================================================

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!jogoIniciado || jogoConcluido) {

            repaint();

            return;
        }

        atualizarJogador();

        atualizarInimigos();

        verificarAneis();

        verificarInimigos();

        verificarEspinhos();

        verificarFinal();

        // =====================================================
        // CÂMERA
        // =====================================================

        cameraX = sonic.x - 300;

        if (cameraX < 0) {

            cameraX = 0;
        }

        if (cameraX > mundoLargura - LARGURA) {

            cameraX = mundoLargura - LARGURA;
        }

        repaint();
    }

    // =========================================================
    // ATUALIZAR SONIC
    // =========================================================

    public void atualizarJogador() {

        int velocidade;

        if (correndo) {

            velocidade = 9;

        } else {

            velocidade = 5;
        }

        // Movimento para esquerda
        if (esquerda) {

            sonic.x -= velocidade;
        }

        // Movimento para direita
        if (direita) {

            sonic.x += velocidade;
        }

        // =====================================================
        // GRAVIDADE
        // =====================================================

        sonic.velocidadeY += 1;

        sonic.y += sonic.velocidadeY;

        // Começa cada frame sem estar no chão
        sonic.noChao = false;

        // =====================================================
        // CHÃO
        // =====================================================

        if (sonic.y + sonic.altura >= 500) {

            sonic.y = 500 - sonic.altura;

            sonic.velocidadeY = 0;

            sonic.noChao = true;

            // Recupera os dois pulos
            sonic.pulosRestantes = 2;
        }

        // =====================================================
        // PLATAFORMAS
        // =====================================================

        for (Plataforma p : plataformas) {

            Rectangle jogador = sonic.getBounds();

            Rectangle plataforma = p.getBounds();

            if (jogador.intersects(plataforma)) {

                // Sonic está caindo
                if (sonic.velocidadeY >= 0
                        && sonic.y + sonic.altura
                        - sonic.velocidadeY <= p.y + 10) {

                    sonic.y = p.y - sonic.altura;

                    sonic.velocidadeY = 0;

                    sonic.noChao = true;

                    // Recupera o pulo duplo
                    sonic.pulosRestantes = 2;
                }
            }
        }

        // =====================================================
        // LIMITES
        // =====================================================

        if (sonic.x < 0) {

            sonic.x = 0;
        }

        if (sonic.x > mundoLargura - sonic.largura) {

            sonic.x = mundoLargura - sonic.largura;
        }

        // =====================================================
        // CAIU DO MAPA
        // =====================================================

        if (sonic.y > ALTURA + 100) {

            perderVida();
        }
    }

    // =========================================================
    // PULO DUPLO
    // =========================================================

    public void pular() {

        // Verifica se ainda existe algum pulo
        if (sonic.pulosRestantes > 0) {

            // Faz o Sonic subir
            sonic.velocidadeY = -17;

            sonic.noChao = false;

            // Gasta um pulo
            sonic.pulosRestantes--;
        }
    }

    // =========================================================
    // ATUALIZAR INIMIGOS
    // =========================================================

    public void atualizarInimigos() {

        for (Inimigo inimigo : inimigos) {

            if (!inimigo.chefao) {

                inimigo.x += inimigo.direcao * 2;

                if (inimigo.x < 0) {

                    inimigo.direcao = 1;
                }

                if (inimigo.x > mundoLargura - 50) {

                    inimigo.direcao = -1;
                }
            }
        }
    }

    // =========================================================
    // PEGAR ANÉIS
    // =========================================================

    public void verificarAneis() {

        Iterator<Anel> iterator =
                aneis.iterator();

        while (iterator.hasNext()) {

            Anel anel = iterator.next();

            if (sonic.getBounds()
                    .intersects(anel.getBounds())) {

                pontos += 100;

                aneisPegos++;

                iterator.remove();
            }
        }
    }

    // =========================================================
    // INIMIGOS
    // =========================================================

    public void verificarInimigos() {

        Iterator<Inimigo> iterator =
                inimigos.iterator();

        while (iterator.hasNext()) {

            Inimigo inimigo = iterator.next();

            if (sonic.getBounds()
                    .intersects(inimigo.getBounds())) {

                // Sonic caiu em cima do inimigo
                if (sonic.velocidadeY > 0
                        && sonic.y + sonic.altura
                        < inimigo.y + 25) {

                    pontos += 500;

                    // Pula novamente
                    sonic.velocidadeY = -12;

                    iterator.remove();

                } else {

                    perderVida();

                    return;
                }
            }
        }
    }

    // =========================================================
    // ESPINHOS
    // =========================================================

    public void verificarEspinhos() {

        for (Espinho espinho : espinhos) {

            if (sonic.getBounds()
                    .intersects(espinho.getBounds())) {

                perderVida();

                return;
            }
        }
    }

    // =========================================================
    // FINAL DA FASE
    // =========================================================

    public void verificarFinal() {

        int finalDaFase =
                mundoLargura - 120;

        if (sonic.x >= finalDaFase) {

            faseConcluida = true;

            // Ainda existem fases
            if (faseAtual < TOTAL_FASES) {

                faseAtual++;

                JOptionPane.showMessageDialog(
                        this,
                        "FASE CONCLUÍDA!\n\n"
                                + "Pontos: " + pontos
                                + "\nAnéis: " + aneisPegos
                                + "\n\n"
                                + "Prepare-se para a próxima fase!"
                );

                carregarFase();

            } else {

                // Terminou todas as fases
                jogoConcluido = true;

                JOptionPane.showMessageDialog(
                        this,
                        "PARABÉNS!\n\n"
                                + "Você terminou todas as 5 fases!\n\n"
                                + "Pontuação: " + pontos
                                + "\n"
                                + "Anéis coletados: "
                                + aneisPegos
                                + "\n\n"
                                + "SONIC PARKOUR COMPLETO!"
                );
            }
        }
    }

    // =========================================================
    // PERDER VIDA
    // =========================================================

    public void perderVida() {

        vidas--;

        if (vidas <= 0) {

            jogoIniciado = false;

            JOptionPane.showMessageDialog(
                    this,
                    "GAME OVER!\n\n"
                            + "Pontuação: " + pontos
                            + "\n\n"
                            + "Pressione ENTER para tentar novamente."
            );

            return;
        }

        // Volta para o começo da fase
        sonic.x = 100;

        sonic.y = 400;

        sonic.velocidadeY = 0;

        sonic.noChao = false;

        // Recupera o pulo duplo
        sonic.pulosRestantes = 2;

        cameraX = 0;
    }

    // =========================================================
    // REINICIAR JOGO
    // =========================================================

    public void reiniciarJogo() {

        faseAtual = 1;

        vidas = 3;

        pontos = 0;

        aneisPegos = 0;

        jogoConcluido = false;

        jogoIniciado = true;

        carregarFase();

        requestFocusInWindow();
    }

    // =========================================================
    // DESENHAR
    // =========================================================

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 =
                (Graphics2D) g;

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // Fundo
        desenharFundo(g2);

        // =====================================================
        // CÂMERA
        // =====================================================

        g2.translate(-cameraX, 0);

        // Plataformas
        for (Plataforma p : plataformas) {

            p.desenhar(
                    g2,
                    faseAtual
            );
        }

        // Anéis
        for (Anel anel : aneis) {

            anel.desenhar(g2);
        }

        // Espinhos
        for (Espinho espinho : espinhos) {

            espinho.desenhar(g2);
        }

        // Inimigos
        for (Inimigo inimigo : inimigos) {

            inimigo.desenhar(g2);
        }

        // Sonic
        sonic.desenhar(g2);

        // Bandeira
        desenharFinal(g2);

        g2.translate(cameraX, 0);

        // Interface
        desenharHUD(g2);

        // Menu
        if (!jogoIniciado && !jogoConcluido) {

            desenharMenu(g2);
        }

        // Vitória
        if (jogoConcluido) {

            desenharVitoria(g2);
        }
    }

    // =========================================================
    // FUNDO
    // =========================================================

    public void desenharFundo(Graphics2D g) {

        // =====================================================
        // GREEN HILL
        // =====================================================

        if (faseAtual == 1) {

            g.setColor(
                    new Color(100, 190, 255)
            );

            g.fillRect(
                    0,
                    0,
                    LARGURA,
                    ALTURA
            );

            // Sol
            g.setColor(Color.YELLOW);

            g.fillOval(
                    780,
                    50,
                    80,
                    80
            );

            desenharNuvem(
                    g,
                    150,
                    80
            );

            desenharNuvem(
                    g,
                    500,
                    130
            );

        }

        // =====================================================
        // CHEMICAL PLANT
        // =====================================================

        else if (faseAtual == 2) {

            g.setColor(
                    new Color(60, 70, 90)
            );

            g.fillRect(
                    0,
                    0,
                    LARGURA,
                    ALTURA
            );

            g.setColor(
                    new Color(180, 220, 255)
            );

            for (int x = 50;
                 x < LARGURA;
                 x += 150) {

                g.fillOval(
                        x,
                        80,
                        40,
                        40
                );
            }
        }

        // =====================================================
        // SKY ZONE
        // =====================================================

        else if (faseAtual == 3) {

            g.setColor(
                    new Color(90, 180, 255)
            );

            g.fillRect(
                    0,
                    0,
                    LARGURA,
                    ALTURA
            );

            desenharNuvem(
                    g,
                    100,
                    100
            );

            desenharNuvem(
                    g,
                    450,
                    180
            );

            desenharNuvem(
                    g,
                    750,
                    70
            );
        }

        // =====================================================
        // MYSTIC CAVE
        // =====================================================

        else if (faseAtual == 4) {

            g.setColor(
                    new Color(30, 15, 50)
            );

            g.fillRect(
                    0,
                    0,
                    LARGURA,
                    ALTURA
            );

            g.setColor(
                    new Color(150, 80, 220)
            );

            for (int x = 50;
                 x < LARGURA;
                 x += 200) {

                int[] pontosX = {
                        x,
                        x + 30,
                        x + 60
                };

                int[] pontosY = {
                        400,
                        300,
                        400
                };

                g.fillPolygon(
                        pontosX,
                        pontosY,
                        3
                );
            }
        }

        // =====================================================
        // BOSS
        // =====================================================

        else {

            g.setColor(
                    new Color(35, 35, 45)
            );

            g.fillRect(
                    0,
                    0,
                    LARGURA,
                    ALTURA
            );

            g.setColor(Color.GRAY);

            for (int x = 0;
                 x < LARGURA;
                 x += 100) {

                g.fillRect(
                        x,
                        100,
                        70,
                        200
                );
            }
        }
    }

    // =========================================================
    // NUVEM
    // =========================================================

    public void desenharNuvem(
            Graphics2D g,
            int x,
            int y) {

        g.setColor(Color.WHITE);

        g.fillOval(
                x,
                y,
                70,
                40
        );

        g.fillOval(
                x + 30,
                y - 20,
                70,
                60
        );

        g.fillOval(
                x + 70,
                y,
                70,
                40
        );
    }

    // =========================================================
    // BANDEIRA FINAL
    // =========================================================

    public void desenharFinal(Graphics2D g) {

        int x =
                mundoLargura - 100;

        g.setColor(Color.BLACK);

        g.fillRect(
                x,
                350,
                5,
                170
        );

        g.setColor(Color.RED);

        int[] xs = {
                x + 5,
                x + 80,
                x + 5
        };

        int[] ys = {
                350,
                380,
                410
        };

        g.fillPolygon(
                xs,
                ys,
                3
        );

        g.setColor(Color.WHITE);

        g.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        g.drawString(
                "FIM",
                x + 20,
                340
        );
    }

    // =========================================================
    // HUD
    // =========================================================

    public void desenharHUD(Graphics2D g) {

        g.setColor(
                new Color(0, 0, 0, 170)
        );

        g.fillRoundRect(
                15,
                15,
                430,
                120,
                15,
                15
        );

        g.setColor(Color.WHITE);

        g.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        g.drawString(
                "FASE: "
                        + faseAtual
                        + " / "
                        + TOTAL_FASES,
                30,
                42
        );

        g.drawString(
                "PONTOS: "
                        + pontos,
                30,
                70
        );

        g.drawString(
                "ANEIS: "
                        + aneisPegos,
                200,
                42
        );

        g.drawString(
                "VIDAS: "
                        + vidas,
                200,
                70
        );

        // =====================================================
        // PULOS DISPONÍVEIS
        // =====================================================

        g.drawString(
                "PULOS: "
                        + sonic.pulosRestantes
                        + " / 2",
                30,
                100
        );

        g.drawString(
                "← → mover | ESPAÇO = pulo",
                200,
                100
        );
    }

    // =========================================================
    // MENU
    // =========================================================

    public void desenharMenu(Graphics2D g) {

        g.setColor(
                new Color(0, 0, 80, 230)
        );

        g.fillRect(
                0,
                0,
                LARGURA,
                ALTURA
        );

        g.setColor(Color.WHITE);

        g.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        60
                )
        );

        g.drawString(
                "SONIC PARKOUR",
                250,
                180
        );

        g.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );

        g.drawString(
                "5 FASES DE AVENTURA",
                355,
                230
        );

        g.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        g.drawString(
                "ENTER - Começar",
                390,
                310
        );

        g.drawString(
                "← → - Mover",
                390,
                350
        );

        g.drawString(
                "ESPAÇO - Pular",
                390,
                390
        );

        g.drawString(
                "ESPAÇO novamente - PULO DUPLO",
                320,
                430
        );

        g.drawString(
                "SHIFT - Correr",
                390,
                470
        );
    }

    // =========================================================
    // TELA DE VITÓRIA
    // =========================================================

    public void desenharVitoria(Graphics2D g) {

        g.setColor(
                new Color(0, 0, 0, 230)
        );

        g.fillRect(
                0,
                0,
                LARGURA,
                ALTURA
        );

        g.setColor(Color.YELLOW);

        g.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        55
                )
        );

        g.drawString(
                "VOCÊ VENCEU!",
                300,
                220
        );

        g.setColor(Color.WHITE);

        g.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );

        g.drawString(
                "Todas as 5 fases foram concluídas!",
                300,
                280
        );

        g.drawString(
                "Pontuação: "
                        + pontos,
                400,
                330
        );

        g.drawString(
                "Anéis: "
                        + aneisPegos,
                430,
                370
        );

        g.drawString(
                "ENTER - Jogar novamente",
                350,
                450
        );
    }

    // =========================================================
    // TECLAS - PRESSIONADA
    // =========================================================

    @Override
    public void keyPressed(KeyEvent e) {

        int tecla =
                e.getKeyCode();

        // =====================================================
        // ENTER
        // =====================================================

        if (tecla == KeyEvent.VK_ENTER) {

            if (!jogoIniciado
                    || jogoConcluido) {

                reiniciarJogo();
            }
        }

        // =====================================================
        // ESQUERDA
        // =====================================================

        if (tecla == KeyEvent.VK_LEFT
                || tecla == KeyEvent.VK_A) {

            esquerda = true;
        }

        // =====================================================
        // DIREITA
        // =====================================================

        if (tecla == KeyEvent.VK_RIGHT
                || tecla == KeyEvent.VK_D) {

            direita = true;
        }

        // =====================================================
        // CORRER
        // =====================================================

        if (tecla == KeyEvent.VK_SHIFT) {

            correndo = true;
        }

        // =====================================================
        // PULO
        // =====================================================

        if (tecla == KeyEvent.VK_SPACE
                || tecla == KeyEvent.VK_UP
                || tecla == KeyEvent.VK_W) {

            if (jogoIniciado) {

                pular();
            }
        }
    }

    // =========================================================
    // TECLAS - SOLTA
    // =========================================================

    @Override
    public void keyReleased(KeyEvent e) {

        int tecla =
                e.getKeyCode();

        if (tecla == KeyEvent.VK_LEFT
                || tecla == KeyEvent.VK_A) {

            esquerda = false;
        }

        if (tecla == KeyEvent.VK_RIGHT
                || tecla == KeyEvent.VK_D) {

            direita = false;
        }

        if (tecla == KeyEvent.VK_SHIFT) {

            correndo = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // =========================================================
    // CLASSE SONIC
    // =========================================================

    class Sonic {

        int x;
        int y;

        int largura = 45;
        int altura = 55;

        int velocidadeY = 0;

        boolean noChao = false;

        // =====================================================
        // PULO DUPLO
        // =====================================================

        int pulosRestantes = 2;

        public Sonic(
                int x,
                int y) {

            this.x = x;
            this.y = y;
        }

        public Rectangle getBounds() {

            return new Rectangle(
                    x,
                    y,
                    largura,
                    altura
            );
        }

        public void desenhar(Graphics2D g) {

            // =================================================
            // CORPO
            // =================================================

            g.setColor(
                    new Color(0, 80, 220)
            );

            g.fillOval(
                    x,
                    y + 15,
                    45,
                    45
            );

            // =================================================
            // CABEÇA
            // =================================================

            g.fillOval(
                    x - 3,
                    y - 5,
                    50,
                    50
            );

            // =================================================
            // ESPINHOS
            // =================================================

            int[] espinhoX = {
                    x + 5,
                    x - 20,
                    x + 10,
                    x - 15,
                    x + 20,
                    x + 5
            };

            int[] espinhoY = {
                    y + 15,
                    y + 20,
                    y + 28,
                    y + 35,
                    y + 40,
                    y + 45
            };

            g.fillPolygon(
                    espinhoX,
                    espinhoY,
                    6
            );

            // =================================================
            // OLHOS
            // =================================================

            g.setColor(Color.WHITE);

            g.fillOval(
                    x + 25,
                    y + 5,
                    12,
                    18
            );

            g.fillOval(
                    x + 35,
                    y + 5,
                    12,
                    18
            );

            // =================================================
            // PUPILAS
            // =================================================

            g.setColor(Color.BLACK);

            g.fillOval(
                    x + 31,
                    y + 10,
                    5,
                    8
            );

            g.fillOval(
                    x + 41,
                    y + 10,
                    5,
                    8
            );

            // =================================================
            // BARRIGA
            // =================================================

            g.setColor(
                    new Color(255, 220, 170)
            );

            g.fillOval(
                    x + 12,
                    y + 30,
                    25,
                    20
            );

            // =================================================
            // SAPATOS
            // =================================================

            g.setColor(Color.RED);

            g.fillOval(
                    x - 2,
                    y + 50,
                    25,
                    12
            );

            g.fillOval(
                    x + 25,
                    y + 50,
                    25,
                    12
            );

            // =================================================
            // FAIXA DOS SAPATOS
            // =================================================

            g.setColor(Color.WHITE);

            g.fillRect(
                    x + 5,
                    y + 52,
                    15,
                    4
            );

            g.fillRect(
                    x + 32,
                    y + 52,
                    15,
                    4
            );

            // =================================================
            // EFEITO DO SEGUNDO PULO
            // =================================================

            if (!noChao
                    && pulosRestantes == 0) {

                g.setColor(
                        new Color(
                                255,
                                255,
                                255,
                                150
                        )
                );

                g.fillOval(
                        x - 10,
                        y + 55,
                        65,
                        10
                );
            }
        }
    }

    // =========================================================
    // CLASSE PLATAFORMA
    // =========================================================

    class Plataforma {

        int x;
        int y;
        int largura;
        int altura;

        public Plataforma(
                int x,
                int y,
                int largura,
                int altura) {

            this.x = x;
            this.y = y;

            this.largura = largura;
            this.altura = altura;
        }

        public Rectangle getBounds() {

            return new Rectangle(
                    x,
                    y,
                    largura,
                    altura
            );
        }

        public void desenhar(
                Graphics2D g,
                int fase) {

            // =================================================
            // GREEN HILL
            // =================================================

            if (fase == 1) {

                g.setColor(
                        new Color(130, 75, 35)
                );

                g.fillRect(
                        x,
                        y,
                        largura,
                        altura
                );

                g.setColor(
                        new Color(40, 190, 60)
                );

                g.fillRect(
                        x,
                        y,
                        largura,
                        12
                );
            }

            // =================================================
            // CHEMICAL PLANT
            // =================================================

            else if (fase == 2) {

                g.setColor(
                        new Color(100, 100, 110)
                );

                g.fillRect(
                        x,
                        y,
                        largura,
                        altura
                );

                g.setColor(Color.YELLOW);

                g.fillRect(
                        x,
                        y,
                        largura,
                        8
                );
            }

            // =================================================
            // SKY ZONE
            // =================================================

            else if (fase == 3) {

                g.setColor(
                        new Color(120, 130, 150)
                );

                g.fillRect(
                        x,
                        y,
                        largura,
                        altura
                );

                g.setColor(Color.WHITE);

                g.fillRect(
                        x,
                        y,
                        largura,
                        8
                );
            }

            // =================================================
            // MYSTIC CAVE
            // =================================================

            else if (fase == 4) {

                g.setColor(
                        new Color(80, 50, 100)
                );

                g.fillRect(
                        x,
                        y,
                        largura,
                        altura
                );

                g.setColor(
                        new Color(180, 100, 220)
                );

                g.fillRect(
                        x,
                        y,
                        largura,
                        8
                );
            }

            // =================================================
            // BOSS
            // =================================================

            else {

                g.setColor(
                        new Color(80, 80, 80)
                );

                g.fillRect(
                        x,
                        y,
                        largura,
                        altura
                );

                g.setColor(Color.YELLOW);

                g.fillRect(
                        x,
                        y,
                        largura,
                        8
                );
            }
        }
    }

    // =========================================================
    // CLASSE ANEL
    // =========================================================

    class Anel {

        int x;
        int y;

        int tamanho = 25;

        public Anel(
                int x,
                int y) {

            this.x = x;
            this.y = y;
        }

        public Rectangle getBounds() {

            return new Rectangle(
                    x,
                    y,
                    tamanho,
                    tamanho
            );
        }

        public void desenhar(Graphics2D g) {

            g.setColor(Color.YELLOW);

            g.setStroke(
                    new BasicStroke(5)
            );

            g.drawOval(
                    x,
                    y,
                    tamanho,
                    tamanho
            );

            g.setStroke(
                    new BasicStroke(1)
            );
        }
    }

    // =========================================================
    // CLASSE INIMIGO
    // =========================================================

    class Inimigo {

        int x;
        int y;

        int largura = 45;
        int altura = 40;

        int direcao = 1;

        boolean chefao;

        public Inimigo(
                int x,
                int y) {

            this(
                    x,
                    y,
                    false
            );
        }

        public Inimigo(
                int x,
                int y,
                boolean chefao) {

            this.x = x;
            this.y = y;

            this.chefao = chefao;

            if (chefao) {

                largura = 90;

                altura = 80;
            }
        }

        public Rectangle getBounds() {

            return new Rectangle(
                    x,
                    y,
                    largura,
                    altura
            );
        }

        public void desenhar(Graphics2D g) {

            // =================================================
            // CHEFÃO
            // =================================================

            if (chefao) {

                g.setColor(Color.DARK_GRAY);

                g.fillOval(
                        x,
                        y,
                        largura,
                        altura
                );

                g.setColor(Color.RED);

                g.fillOval(
                        x + 20,
                        y + 20,
                        20,
                        20
                );

                g.setColor(Color.WHITE);

                g.fillOval(
                        x + 25,
                        y + 25,
                        8,
                        8
                );

                g.setColor(Color.RED);

                g.setFont(
                        new Font(
                                "Arial",
                                Font.BOLD,
                                18
                        )
                );

                g.drawString(
                        "BOSS",
                        x + 20,
                        y - 10
                );

            }

            // =================================================
            // INIMIGO NORMAL
            // =================================================

            else {

                g.setColor(Color.RED);

                g.fillOval(
                        x,
                        y,
                        largura,
                        altura
                );

                // Olhos
                g.setColor(Color.WHITE);

                g.fillOval(
                        x + 8,
                        y + 8,
                        12,
                        15
                );

                g.fillOval(
                        x + 25,
                        y + 8,
                        12,
                        15
                );

                // Pupilas
                g.setColor(Color.BLACK);

                g.fillOval(
                        x + 12,
                        y + 13,
                        5,
                        7
                );

                g.fillOval(
                        x + 29,
                        y + 13,
                        5,
                        7
                );

                // Pernas
                g.setColor(Color.BLACK);

                g.fillRect(
                        x + 5,
                        y + 35,
                        12,
                        8
                );

                g.fillRect(
                        x + 28,
                        y + 35,
                        12,
                        8
                );
            }
        }
    }

    // =========================================================
    // CLASSE ESPINHO
    // =========================================================

    class Espinho {

        int x;
        int y;

        public Espinho(
                int x,
                int y) {

            this.x = x;
            this.y = y;
        }

        public Rectangle getBounds() {

            return new Rectangle(
                    x,
                    y,
                    50,
                    30
            );
        }

        public void desenhar(Graphics2D g) {

            g.setColor(Color.LIGHT_GRAY);

            int[] xs = {
                    x,
                    x + 12,
                    x + 25,
                    x + 38,
                    x + 50
            };

            int[] ys = {
                    y + 30,
                    y,
                    y + 30,
                    y,
                    y + 30
            };

            g.fillPolygon(
                    xs,
                    ys,
                    5
            );
        }
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        JFrame janela =
                new JFrame(
                        "Sonic Parkour - Java"
                );

        SonicParkour jogo =
                new SonicParkour();

        janela.add(jogo);

        janela.pack();

        janela.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        janela.setLocationRelativeTo(null);

        janela.setResizable(false);

        janela.setVisible(true);

        jogo.requestFocusInWindow();
    }
}