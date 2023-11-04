import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chess implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    }
    JButton[][] button=new JButton[8][8];
    methods meth=new methods();
    String piece;
    int c=0;
    int x,y;
    //JButton WRook,WHorse,WBishop,WQueen,WKing,WPawn,BRook,BHorse,BBishop,BQueen,BKing,BPawn;
    Chess(){

        Icon bk = new ImageIcon("src/pieces/BKing.png");
        Icon wk = new ImageIcon("src/pieces/WKing.png");
        Icon wq = new ImageIcon("src/pieces/WQueen.png");
        Icon bq = new ImageIcon("src/pieces/BQueen.png");
        Icon wr = new ImageIcon("src/pieces/WRook.png");
        Icon br = new ImageIcon("src/pieces/BRook.png");
        Icon wh = new ImageIcon("src/pieces/WHorse.png");
        Icon bh = new ImageIcon("src/pieces/BHorse.png");
        Icon wb = new ImageIcon("src/pieces/WBishop.png");
        Icon bb = new ImageIcon("src/pieces/BBishop.png");
        Icon wp = new ImageIcon("src/pieces/WPawn.png");
        Icon bp = new ImageIcon("src/pieces/BPawn.png");

        JPanel panel=new JPanel();
        panel.setBackground(Color.cyan);
        panel.setBounds(100,100,800,800);
        panel.setLayout(new GridLayout(8,8));



        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++) {
                if (i == 1) {                                               //putting pawns
                    button[i][j] = new JButton(wp);
                    button[i][j].setName("white");
                }
                else if (i == 6) {
                    button[i][j] = new JButton(bp);
                    button[i][j].setName("black");
                }
                else if (i >= 1 && i < 6)
                    button[i][j] = new JButton();

                button[0][0] = new JButton(wr);
                button[0][1] = new JButton(wh);
                button[0][2] = new JButton(wb);
                button[0][3] = new JButton(wq);
                button[0][4] = new JButton(wk);
                button[0][5] = new JButton(wb);
                button[0][6] = new JButton(wh);
                button[0][7] = new JButton(wr);

                button[0][0].setName("white");
                button[0][1].setName("white");
                button[0][2].setName("white");
                button[0][3].setName("white");
                button[0][4].setName("white");
                button[0][5].setName("white");
                button[0][6].setName("white");
                button[0][7].setName("white");


                button[7][0] = new JButton(br);
                button[7][1] = new JButton(bh);
                button[7][2] = new JButton(bb);
                button[7][3] = new JButton(bk);
                button[7][4] = new JButton(bq);
                button[7][5] = new JButton(bb);
                button[7][6] = new JButton(bh);
                button[7][7] = new JButton(br);

                button[7][0].setName("black");
                button[7][1].setName("black");
                button[7][2].setName("black");
                button[7][3].setName("black");
                button[7][4].setName("black");
                button[7][5].setName("black");
                button[7][6].setName("black");
                button[7][7].setName("black");


            }
        }
        //button[7][7].setText("Hello");
        //System.out.println(button[7][7].getIcon()==bb?"true":"False");
        //System.out.println(button[3][6].getX());
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++) {
                int finalI = i;
                int finalJ = j;

                button[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        y=(int)button[finalI][finalJ].getLocation().getX()/100;
                        x=(int)button[finalI][finalJ].getLocation().getY()/100;
                        try{piece= button[finalI][finalJ].getIcon().toString();}
                        catch(NullPointerException ex){
                            piece=null;
                        }
                        System.out.println(x+" "+y+" "+piece+" "+button[finalI][finalJ].getName());
                        if(button[finalI][finalJ].getName()==null&&button[finalI][finalJ].getBackground()!=Color.green)
                            meth.colorReset(button);
                        if(button[finalI][finalJ].getBackground()==Color.green||button[finalI][finalJ].getBackground()==Color.RED){
                            meth.move(button,x,y);
                            c++;
                        }
                        else {
                            if(c%2==0) {
                                if (piece == wr.toString()) {
                                    meth.WRook(button, x, y);
                                }
                                if (piece == wh.toString()) {
                                    meth.WHorse(button, x, y);
                                }
                                if (piece == wb.toString()) {
                                    meth.WBishop(button, x, y);
                                }
                                if (piece == wk.toString()) {
                                    meth.WKing(button, x, y);
                                }
                                if (piece == wq.toString()) {
                                    meth.WQueen(button, x, y);
                                }
                                if (piece == wp.toString()) {
                                    meth.Wpawn(x, y, button);
                                }
                            }
                            else {
                                if (piece == br.toString()) {
                                    meth.BRook(button, x, y);
                                }
                                if (piece == bh.toString()) {
                                    meth.BHorse(button, x, y);
                                }
                                if (piece == bb.toString()) {
                                    meth.BBishop(button, x, y);
                                }
                                if (piece == bk.toString()) {
                                    meth.BKing(button, x, y);
                                }
                                if (piece == bq.toString()) {
                                    meth.BQueen(button, x, y);
                                }
                                if (piece == bp.toString()) {
                                    meth.Bpawn(x, y, button);
                                }
                            }
                        }

                    }
                });

                button[i][j].setFocusable(false);
                button[i][j].setBackground(Color.getHSBColor(216.75F, 221.85F,119.85F));
                if(i%2==0&&j%2==0){
                    button[i][j].setBackground(Color.white);
                }
                if(i%2!=0&&j%2!=0){
                    button[i][j].setBackground(Color.white);
                }
                panel.add(button[i][j]);
            }
        }

        JFrame frame=new JFrame("Chess");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.add(panel);



    }
    public static void main(String[] args) {
        Chess obj=new Chess();
    }

}
