package Vista;

import com.sun.tools.javac.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Juego extends javax.swing.JFrame {
    
    public JButton buttons[];
    public ImageIcon imgs[];
    public String msgs[];
    public int ran;
    public int err;
    public String res[];

    public Juego() {
        initComponents();
        setLocationRelativeTo(null);// centra el programa
        
        imgs = new ImageIcon[6];
        msgs = new String[38];
        buttons = new JButton[27];
        
        
        //imagenes del ahorcado
        imgs[0] = new ImageIcon(getClass().getResource("/Imagenes/cabezaFrame.png"));
        imgs[1] = new ImageIcon(getClass().getResource("/Imagenes/BrazoDerechoFrame.png"));
        imgs[2] = new ImageIcon(getClass().getResource("/Imagenes/torsoFrame.png"));
        imgs[3] = new ImageIcon(getClass().getResource("/Imagenes/pieIzquierdoFrame.png"));
        imgs[4] = new ImageIcon(getClass().getResource("/Imagenes/CompletoFrame.png"));
        
        
        //botones para las letras
        buttons[1] = jButtonA;
        buttons[2] = jButtonB;
        buttons[3] = jButtonC;
        buttons[4] = jButtonD;
        buttons[5] = jButtonE;
        buttons[6] = jButtonF;
        buttons[7] = jButtonG;
        buttons[8] = jButtonH;
        buttons[9] = jButtonI;
        buttons[10] = jButtonJ;
        buttons[11] = jButtonK;
        buttons[12] = jButtonL;
        buttons[13] = jButtonM;
        buttons[14] = jButtonN;
        buttons[15] = jButtonO;
        buttons[16] = jButtonP;
        buttons[17] = jButtonQ;
        buttons[18] = jButtonR;
        buttons[19] = jButtonS;
        buttons[20] = jButtonT;
        buttons[21] = jButtonU;
        buttons[22] = jButtonV;
        buttons[23] = jButtonW;
        buttons[24] = jButtonX;
        buttons[25] = jButtonY;
        buttons[26] = jButtonZ;
        
        msgs[0] = "Afganistan".toUpperCase();
        msgs[1] = "Alemania".toUpperCase();
        msgs[2] = "Australia".toUpperCase();
        msgs[3] = "Austria".toUpperCase();
        msgs[4] = "Belgica".toUpperCase();
        msgs[5] = "Bolivia".toUpperCase();
        msgs[6] = "Brasil".toUpperCase();
        msgs[7] = "Canada".toUpperCase();
        msgs[8] = "Chile".toUpperCase();
        msgs[9] = "China".toUpperCase();
        msgs[10] = "Colombia".toUpperCase();
        msgs[11] = "Cuba".toUpperCase();
        msgs[12] = "Ecuador".toUpperCase();
        msgs[13] = "Egipto".toUpperCase();
        msgs[14] = "US".toUpperCase();
        msgs[15] = "Francia".toUpperCase();
        msgs[16] = "Grecia".toUpperCase();
        msgs[17] = "Guatemala".toUpperCase();
        msgs[18] = "India".toUpperCase();
        msgs[19] = "Irak".toUpperCase();
        msgs[20] = "Italia".toUpperCase();
        msgs[21] = "Letonia".toUpperCase();
        msgs[22] = "Luxemburgo".toUpperCase();
        msgs[23] = "Malta".toUpperCase();
        msgs[24] = "Mexico".toUpperCase();
        msgs[25] = "Noruega".toUpperCase();
        msgs[26] = "Panama".toUpperCase();
        msgs[27] = "Peru".toUpperCase();
        msgs[28] = "Polonia".toUpperCase();
        msgs[29] = "Portugal".toUpperCase();
        msgs[30] = "UK".toUpperCase();
        msgs[31] = "Serbia".toUpperCase();
        msgs[32] = "Suiza".toUpperCase();
        msgs[33] = "Turquia".toUpperCase();
        msgs[34] = "Venezuela".toUpperCase();
        msgs[35] = "Vietnam".toUpperCase();
        msgs[36] = "Yemen".toUpperCase();
        msgs[37] = "Zambia".toUpperCase();
        
        //se asigna un evento a cada letra para comprobar que exista en la palabra a adivinar
        for (int i = 1; i < 27; i++) {
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    checarLetra(e);
                }
            });
        }
        iniciar();
    }
    
    
    //funcion para comenzar los parametros del juego o iniciar una nueva partida
    public void iniciar() {
        
        //ERRORES EN 0
        err = 0;
        jButton1.setIcon(imgs[0]);             //FALTA IMAGENES
        textoAdivinar.setText("");
        
        //para activar las letras del tablero
        for (int i = 1; i < 27; i++) {
            buttons[i].setEnabled(true);
        }
        
        //Para generar una palabra aleatoriamente 
        ran = (int) 0 + (int) (Math.random() * ((msgs.length - 1) + 1));
        
        //SEPARA EL MENSAJE POR PALABRAS
        String pal[] = msgs[ran].split(" ");
        res = new String[msgs[ran].length() + 1];
        
        // seran los guiones que van debajo de las letras como una separacion_
        int j = 0;
        for (String pal1 : pal) {
            for (int i = 0; i < pal1.length(); i++) {
                textoAdivinar.setText(textoAdivinar.getText() + "_ ");
                res[j++] = "_";
            }
            textoAdivinar.setText(textoAdivinar.getText() + "\n");
            res[j++] = " ";
        }
    }
    
    
    //al presionar una letra, esta se buscara si pertenece a la palabra, de lo contrario la marcara como error
    public void checarLetra(ActionEvent e) {
        JButton bt = (JButton) e.getSource();
        char c[];   
        //busca la letra en la palabra despues de haber sido presionada
        for (int i = 1; i < 27; i++) {
            if (bt == buttons[i]) {
                
                //la tecla es inicializada
                c = Character.toChars(64 + i);
                
                //busca si la letra esta en la frase
                boolean esta = false;
                for (int j = 0; j < msgs[ran].length(); j++) {
                    if (c[0] == msgs[ran].charAt(j)) {
                        res[j] = c[0] + "";
                        esta = true;
                    }
                }
                
                //SI LA LETRA ESTA EN EL MENSAJE SE MUESTRA EN EL Jlbael
                if (esta) {
                    textoAdivinar.setText("");
                    for (String re : res) {
                        if (" ".equals(re)) {
                            textoAdivinar.setText(textoAdivinar.getText() + "\n");
                        } else {
                            textoAdivinar.setText(textoAdivinar.getText() + re + " ");
                        }
                    }   
                    
                    //hace una comprobacion de las letras restantes y faltantes, en caso de que ya no haya letras sera ganador :S
                    boolean gano = true;
                    for (String re : res) {
                        if (re.equals("_")) {
                            gano = false;
                            break;
                        }
                    }
                    
                    //al ser correcta se muestra un mensaje y se reinicia el juego
                    if (gano) {
                        JOptionPane.showMessageDialog(this, "Felicidades ganastes :D" , "Ganastes", WIDTH);
                        iniciar();
                        return;
                    }
                    //SI LA LETRA NO ESTA EN EL MENSAGE, SE INCREMENTA EL ERROR Y SE CAMBIA LA IMAGEN
                } else {
                    //SI SE LLEGA A LOS 5 ERRORES ENTONCES SE PIERDE EL JUEGO Y SE MANDA EL MENSAGE DE:
                    err++;
                    jButton1.setIcon(imgs[err]);
                    
                    if (err == 4) {
                        JOptionPane.showMessageDialog(this, "Intenta con otra palabra la respuesta es: \n" + msgs[ran] , "Perdiste", HEIGHT);
                        iniciar();
                        return;
                    }
                }
                //esta es la linea que desactiva las letras despues de ser usadas S
                bt.setEnabled(false);
                break;
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonD = new javax.swing.JButton();
        jButtonA = new javax.swing.JButton();
        jButtonB = new javax.swing.JButton();
        jButtonE = new javax.swing.JButton();
        jButtonF = new javax.swing.JButton();
        jButtonG = new javax.swing.JButton();
        jButtonH = new javax.swing.JButton();
        jButtonI = new javax.swing.JButton();
        jButtonJ = new javax.swing.JButton();
        jButtonK = new javax.swing.JButton();
        jButtonC = new javax.swing.JButton();
        jButtonM = new javax.swing.JButton();
        jButtonN = new javax.swing.JButton();
        jButtonO = new javax.swing.JButton();
        jButtonL = new javax.swing.JButton();
        jButtonQ = new javax.swing.JButton();
        jButtonR = new javax.swing.JButton();
        jButtonS = new javax.swing.JButton();
        jButtonT = new javax.swing.JButton();
        jButtonV = new javax.swing.JButton();
        jButtonP = new javax.swing.JButton();
        jButtonW = new javax.swing.JButton();
        jButtonX = new javax.swing.JButton();
        jButtonY = new javax.swing.JButton();
        jButtonZ = new javax.swing.JButton();
        jButtonU = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButtonNewWord = new javax.swing.JButton();
        textoAdivinar = new javax.swing.JLabel();
        FondoPizarra = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuOptions = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuMenuPrincipal = new javax.swing.JMenuItem();
        jMenuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ahorcado");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/d.png"))); // NOI18N
        jButtonD.setBorderPainted(false);
        jButtonD.setContentAreaFilled(false);
        jButtonD.setFocusPainted(false);
        jButtonD.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dFade.png"))); // NOI18N
        jButtonD.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        jButtonA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/a.png"))); // NOI18N
        jButtonA.setBorderPainted(false);
        jButtonA.setContentAreaFilled(false);
        jButtonA.setFocusPainted(false);
        jButtonA.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aFade.png"))); // NOI18N
        jButtonA.setVerifyInputWhenFocusTarget(false);
        jButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonA, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        jButtonB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/b.png"))); // NOI18N
        jButtonB.setBorderPainted(false);
        jButtonB.setContentAreaFilled(false);
        jButtonB.setFocusPainted(false);
        jButtonB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bFade.png"))); // NOI18N
        jButtonB.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonB, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        jButtonE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/e.png"))); // NOI18N
        jButtonE.setBorderPainted(false);
        jButtonE.setContentAreaFilled(false);
        jButtonE.setFocusPainted(false);
        jButtonE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eFade.png"))); // NOI18N
        jButtonE.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonE, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, -1));

        jButtonF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/f.png"))); // NOI18N
        jButtonF.setBorderPainted(false);
        jButtonF.setContentAreaFilled(false);
        jButtonF.setFocusPainted(false);
        jButtonF.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fFade.png"))); // NOI18N
        jButtonF.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonF, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        jButtonG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/g.png"))); // NOI18N
        jButtonG.setBorderPainted(false);
        jButtonG.setContentAreaFilled(false);
        jButtonG.setFocusPainted(false);
        jButtonG.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gFade.png"))); // NOI18N
        jButtonG.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonG, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        jButtonH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/h.png"))); // NOI18N
        jButtonH.setBorderPainted(false);
        jButtonH.setContentAreaFilled(false);
        jButtonH.setFocusPainted(false);
        jButtonH.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hFade.png"))); // NOI18N
        jButtonH.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonH, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, -1));

        jButtonI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/i.png"))); // NOI18N
        jButtonI.setBorderPainted(false);
        jButtonI.setContentAreaFilled(false);
        jButtonI.setFocusPainted(false);
        jButtonI.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iFade.png"))); // NOI18N
        jButtonI.setVerifyInputWhenFocusTarget(false);
        jButtonI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonI, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, -1, -1));

        jButtonJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/j.png"))); // NOI18N
        jButtonJ.setBorderPainted(false);
        jButtonJ.setContentAreaFilled(false);
        jButtonJ.setFocusPainted(false);
        jButtonJ.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/jFade.png"))); // NOI18N
        jButtonJ.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        jButtonK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/k.png"))); // NOI18N
        jButtonK.setBorderPainted(false);
        jButtonK.setContentAreaFilled(false);
        jButtonK.setFocusPainted(false);
        jButtonK.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/kFade.png"))); // NOI18N
        jButtonK.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonK, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, -1, -1));

        jButtonC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/c.png"))); // NOI18N
        jButtonC.setBorderPainted(false);
        jButtonC.setContentAreaFilled(false);
        jButtonC.setFocusPainted(false);
        jButtonC.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cFade.png"))); // NOI18N
        jButtonC.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        jButtonM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/m.png"))); // NOI18N
        jButtonM.setBorderPainted(false);
        jButtonM.setContentAreaFilled(false);
        jButtonM.setFocusPainted(false);
        jButtonM.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mFade.png"))); // NOI18N
        jButtonM.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonM, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        jButtonN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/n.png"))); // NOI18N
        jButtonN.setBorderPainted(false);
        jButtonN.setContentAreaFilled(false);
        jButtonN.setFocusPainted(false);
        jButtonN.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nFade.png"))); // NOI18N
        jButtonN.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonN, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        jButtonO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/o.png"))); // NOI18N
        jButtonO.setBorderPainted(false);
        jButtonO.setContentAreaFilled(false);
        jButtonO.setFocusPainted(false);
        jButtonO.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/oFade.png"))); // NOI18N
        jButtonO.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonO, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, -1, -1));

        jButtonL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/l.png"))); // NOI18N
        jButtonL.setBorderPainted(false);
        jButtonL.setContentAreaFilled(false);
        jButtonL.setFocusPainted(false);
        jButtonL.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lFade.png"))); // NOI18N
        jButtonL.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonL, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        jButtonQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/q.png"))); // NOI18N
        jButtonQ.setBorderPainted(false);
        jButtonQ.setContentAreaFilled(false);
        jButtonQ.setFocusPainted(false);
        jButtonQ.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/qFade.png"))); // NOI18N
        jButtonQ.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, -1, -1));

        jButtonR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/r.png"))); // NOI18N
        jButtonR.setBorderPainted(false);
        jButtonR.setContentAreaFilled(false);
        jButtonR.setFocusPainted(false);
        jButtonR.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rFade.png"))); // NOI18N
        jButtonR.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonR, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, -1, -1));

        jButtonS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/s.png"))); // NOI18N
        jButtonS.setBorderPainted(false);
        jButtonS.setContentAreaFilled(false);
        jButtonS.setFocusPainted(false);
        jButtonS.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sFade.png"))); // NOI18N
        jButtonS.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonS, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, -1, -1));

        jButtonT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/t.png"))); // NOI18N
        jButtonT.setBorderPainted(false);
        jButtonT.setContentAreaFilled(false);
        jButtonT.setFocusPainted(false);
        jButtonT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tFade.png"))); // NOI18N
        jButtonT.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonT, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, -1, -1));

        jButtonV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/v.png"))); // NOI18N
        jButtonV.setBorderPainted(false);
        jButtonV.setContentAreaFilled(false);
        jButtonV.setFocusPainted(false);
        jButtonV.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vFade.png"))); // NOI18N
        jButtonV.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonV, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, -1, -1));

        jButtonP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/p.png"))); // NOI18N
        jButtonP.setBorderPainted(false);
        jButtonP.setContentAreaFilled(false);
        jButtonP.setFocusPainted(false);
        jButtonP.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pFade.png"))); // NOI18N
        jButtonP.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, -1, -1));

        jButtonW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/w.png"))); // NOI18N
        jButtonW.setBorderPainted(false);
        jButtonW.setContentAreaFilled(false);
        jButtonW.setFocusPainted(false);
        jButtonW.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/wFade.png"))); // NOI18N
        jButtonW.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonW, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, -1, -1));

        jButtonX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x.png"))); // NOI18N
        jButtonX.setBorderPainted(false);
        jButtonX.setContentAreaFilled(false);
        jButtonX.setFocusPainted(false);
        jButtonX.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xFade.png"))); // NOI18N
        jButtonX.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonX, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, -1, -1));

        jButtonY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/y.png"))); // NOI18N
        jButtonY.setBorderPainted(false);
        jButtonY.setContentAreaFilled(false);
        jButtonY.setFocusPainted(false);
        jButtonY.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/yFade.png"))); // NOI18N
        jButtonY.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonY, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, -1, -1));

        jButtonZ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/z.png"))); // NOI18N
        jButtonZ.setBorderPainted(false);
        jButtonZ.setContentAreaFilled(false);
        jButtonZ.setFocusPainted(false);
        jButtonZ.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/zFade.png"))); // NOI18N
        jButtonZ.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, -1, -1));

        jButtonU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/u.png"))); // NOI18N
        jButtonU.setBorderPainted(false);
        jButtonU.setContentAreaFilled(false);
        jButtonU.setFocusPainted(false);
        jButtonU.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/uFade.png"))); // NOI18N
        jButtonU.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButtonU, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, -1, -1));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setOpaque(false);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 320, 260));

        jButtonNewWord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/newWord.png"))); // NOI18N
        jButtonNewWord.setBorderPainted(false);
        jButtonNewWord.setContentAreaFilled(false);
        jButtonNewWord.setFocusPainted(false);
        jButtonNewWord.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/newWordFade.png"))); // NOI18N
        jButtonNewWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewWordActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNewWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 290, 50));

        textoAdivinar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        textoAdivinar.setForeground(new java.awt.Color(255, 255, 255));
        textoAdivinar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(textoAdivinar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 340, 80));

        FondoPizarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pizarra.png"))); // NOI18N
        getContentPane().add(FondoPizarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenuOptions.setText("Opciones");

        jMenuItem1.setText("Generar nueva palabra");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuOptions.add(jMenuItem1);

        jMenuMenuPrincipal.setText("Menu Principal");
        jMenuMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMenuPrincipalActionPerformed(evt);
            }
        });
        jMenuOptions.add(jMenuMenuPrincipal);

        jMenuExit.setText("Salir");
        jMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExitActionPerformed(evt);
            }
        });
        jMenuOptions.add(jMenuExit);

        jMenuBar1.add(jMenuOptions);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonIActionPerformed

    private void jButtonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAActionPerformed

    private void jButtonNewWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewWordActionPerformed
        // TODO add your handling code here:
        iniciar();
    }//GEN-LAST:event_jButtonNewWordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        iniciar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMenuPrincipalActionPerformed
        // TODO add your handling code here:
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuMenuPrincipalActionPerformed

    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoPizarra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonA;
    private javax.swing.JButton jButtonB;
    private javax.swing.JButton jButtonC;
    private javax.swing.JButton jButtonD;
    private javax.swing.JButton jButtonE;
    private javax.swing.JButton jButtonF;
    private javax.swing.JButton jButtonG;
    private javax.swing.JButton jButtonH;
    private javax.swing.JButton jButtonI;
    private javax.swing.JButton jButtonJ;
    private javax.swing.JButton jButtonK;
    private javax.swing.JButton jButtonL;
    private javax.swing.JButton jButtonM;
    private javax.swing.JButton jButtonN;
    private javax.swing.JButton jButtonNewWord;
    private javax.swing.JButton jButtonO;
    private javax.swing.JButton jButtonP;
    private javax.swing.JButton jButtonQ;
    private javax.swing.JButton jButtonR;
    private javax.swing.JButton jButtonS;
    private javax.swing.JButton jButtonT;
    private javax.swing.JButton jButtonU;
    private javax.swing.JButton jButtonV;
    private javax.swing.JButton jButtonW;
    private javax.swing.JButton jButtonX;
    private javax.swing.JButton jButtonY;
    private javax.swing.JButton jButtonZ;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuMenuPrincipal;
    private javax.swing.JMenu jMenuOptions;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel textoAdivinar;
    // End of variables declaration//GEN-END:variables
}
