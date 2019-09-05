import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
    
    public static Color dkgry = new Color(30, 30, 30);
    public static int gridSize = 5;

    public MainFrame() {
        setTitle("lights out");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 540);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        //gridSize = Integer.parseInt((JOptionPane.showInputDialog("how many squares?", null)));
        JPanel p = new JPanel();
        add(p, BorderLayout.CENTER);
        p.setBackground(Color.BLACK);
        makePanels(p, gridSize);
        //p.setLayout(new GridLayout(gridSize,gridSize));
        //for(int i = 0;i < gridSize*gridSize;i++) {
        //    p.add(new LightPanel());
        //}
        
//        JMenuBar jmb = new JMenuBar();
//        JMenu jm = new JMenu("Mode");
//        JMenuItem jmi1 = new JMenuItem("randomify");
//        
//        setJMenuBar(jmb);
//        jmb.add(jm);
//        jm.add(jmi1);
        
        
        JPanel btmPanel = new JPanel();
        btmPanel.setBackground(Color.BLACK);
        add(btmPanel, BorderLayout.SOUTH);
        JButton rd = new JButton("Randomify");
        btmPanel.add(rd);
        rd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                for(int i = 0;i < p.getComponentCount();i++)
                    ((LightPanel) p.getComponent(i)).setOnOff(rnd.nextBoolean());
                
//                for(int i = 0;i<25;i++) {
//                    LightPanel no = (LightPanel) p.getComponent(i);
//                    System.out.println(no.getState());
//                }
                    
                p.repaint();
            }
        });
        JTextField jtf = new JTextField(3);
        btmPanel.add(jtf);
        JButton nbyn = new JButton("#x#");
        btmPanel.add(nbyn);
        nbyn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.removeAll();
                //p = new JPanel();
                int sizeby = Integer.parseInt(jtf.getText());
                makePanels(p, sizeby);
                p.updateUI();
                p.repaint();
            }
        });
        
        JButton solve = new JButton("Solve");
        btmPanel.add(solve);
        solve.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int rc = gridSize * gridSize;
                Main.Matrix solution = new Main.Matrix(rc, rc+1);
                //System.out.println("initial");
                //solution.print();
                System.out.println("---------------------------");
                
                // set all 0s
                // set 1s by column top to bottom
                // use same offsets as mouse press
                
                // for each rc main diagonal
                for(int i = 0;i < rc;i++) {
                    solution.mtx[i][i] = 1; // [row][col] = 1
                    
                    if(i > 0 && i % gridSize != 0) // we can go up one
                        solution.mtx[i-1][i] = 1;
                    if(i < rc-1 && i % gridSize != gridSize-1) // go down one
                        solution.mtx[i+1][i] = 1;
                    if(i < (rc) - gridSize) // we can go down by gridsize
                        solution.mtx[i+gridSize][i] = 1;
                    if(i >= gridSize) // we can go up by gridsize
                        solution.mtx[i-gridSize][i] = 1;
                }

                LightPanel gay;
                for(int i = 0; i < rc;i++) {
                    gay = (LightPanel) p.getComponent(i);
                    solution.mtx[i][rc] = gay.getState();
                }
                //System.out.println("print setup matrix");
                //solution.print();
                //System.out.println("---------------------------");
                //Main pls = new Main();
                Main.ToRREF(solution);
                System.out.println("print solved matrix");
                solution.print();
                System.out.println("---------------------------");
                System.out.println("--------------------print B");
                solution.printB();
                System.out.println("---------------------------");
                
                for (int i = 0; i < rc;i++) {
                    gay = (LightPanel) p.getComponent(i);
                    if(solution.mtx[i][rc] == 1)
                        gay.selected = true;
                    else gay.selected = false;
                }
            }
            
        });
        
        /*
         * sample 4x4 matrix without augment B
1   1   0   0   1   0   0   0   0   0   0   0   0   0   0   0
1   1   1   0   0   1   0   0   0   0   0   0   0   0   0   0
0   1   1   1   0   0   1   0   0   0   0   0   0   0   0   0
0   0   1   1   0   0   0   1   0   0   0   0   0   0   0   0
1   0   0   0   1   1   0   0   1   0   0   0   0   0   0   0
0   1   0   0   1   1   1   0   0   1   0   0   0   0   0   0
0   0   1   0   0   1   1   1   0   0   1   0   0   0   0   0
0   0   0   1   0   0   1   1   0   0   0   1   0   0   0   0
0   0   0   0   1   0   0   0   1   1   0   0   1   0   0   0
0   0   0   0   0   1   0   0   1   1   1   0   0   1   0   0
0   0   0   0   0   0   1   0   0   1   1   1   0   0   1   0
0   0   0   0   0   0   0   1   0   0   1   1   0   0   0   1
0   0   0   0   0   0   0   0   1   0   0   0   1   1   0   0
0   0   0   0   0   0   0   0   0   1   0   0   1   1   1   0
0   0   0   0   0   0   0   0   0   0   1   0   0   1   1   1
0   0   0   0   0   0   0   0   0   0   0   1   0   0   1   1

         */
        
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY() - 23; // title bar height is included for some reason
                //int panelPosition = p.getY();
                if(findComponentAt(e.getPoint()) == btmPanel)
                    return;
                
                int cx = x / (p.getWidth() / gridSize);
                int cy = y / (p.getHeight() / gridSize);
                if(cx >= gridSize)
                    cx = gridSize-1;
                int component = 0;
                component = cx + cy*gridSize;
                //JOptionPane.showMessageDialog(null, "component selected: " + component + "\ncx: " + cx + "\ncy: " + cy);
                
                ((LightPanel) p.getComponent(component)).toggle();
                ((LightPanel) p.getComponent(component)).selected = false;
                if(cy > 0) // up, 1-4
                    ((LightPanel) p.getComponent(component-gridSize)).toggle();
                if(cx > 0) // left, 1-4
                    ((LightPanel) p.getComponent(component-1)).toggle();
                if(cx < gridSize-1) // right, 0-3
                    ((LightPanel) p.getComponent(component+1)).toggle();
                if(cy < gridSize-1) // down, 0-3
                    ((LightPanel) p.getComponent(component+gridSize)).toggle();
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                p.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
    }
    
    public void makePanels(JPanel p, int gridSize) {
        MainFrame.gridSize = gridSize;
        p.setLayout(new GridLayout(gridSize,gridSize));
        for(int i = 0;i < gridSize*gridSize;i++) {
            //LightPanel lp = new LightPanel();
            p.add(new LightPanel());
//            p.add(lp);
//            lp.setInsidePos(lp.getX(), lp.getY());
        }
    }

    public static void main(String[] args) {
        JFrame f = new MainFrame();
        f.setVisible(true);
    }

}
