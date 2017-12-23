package chess;

import static chess.Chess.BLACK;
import static chess.Chess.STARTING_ROW;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author ahmedsalah
 */

public class Chess {
   board start;
private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    public static JButton[][] chessBoardSquares = new JButton[8][8];
    public static Image[][] chessPieceImages = new Image[2][6];
    public piece[][] Board = new piece[8][8];
    public boolean sel = false;
    public point csel;
   public point newp;
   public int diff = 1;
   boolean gameOn=false;
    ImageIcon tmp;
    private JPanel chessBoard;
    private final JLabel message = new JLabel();
    private static final String COLS = "ABCDEFGH";
    public static final int QUEEN = 0, KING = 1,
            ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = {
        ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK
    };
       public static void change(point oldp,point newp){
        ImageIcon tmp=(ImageIcon)Chess.chessBoardSquares[oldp.c][oldp.r].getIcon();
        Chess.chessBoardSquares[newp.c][newp.r].setIcon(tmp);
        Chess.chessBoardSquares[oldp.c][oldp.r].setIcon(null);
        }
    public boolean user(point p,board b){
        if(b.pcontain(p))return true;
        return false;
    }
    public board initboard(){
        board ret=new board();
        ArrayList<piece> cmp=new ArrayList<>();
       
        piece k=new King(ret,true);
       
        piece q=new queen(ret,true);
      
        piece b=new bishop(ret,true);
        
        piece kn=new Knight(ret,true);
       
        piece r=new rook(ret,true);
        
        piece r1=new rook(ret,true);
        
        piece b1=new bishop(ret,true);
        
        piece kn1=new Knight(ret,true);
        ArrayList<piece> pl=new ArrayList();
        piece kp=new King(ret,false);
        
        piece qp=new queen(ret,false);
       
        piece bp=new bishop(ret,false);
       
        piece knp=new Knight(ret,false);
       
        piece rp=new rook(ret,false);
        
        piece rp1=new rook(ret,false);
        
        piece bp1=new bishop(ret,false);
      
        piece knp1=new Knight(ret,false);
         for(int i=0;i<8;i++){
            Pawn p=new Pawn(ret,true);
            p.pos=new point(1,i);
            cmp.add(p);
        }
         k.pos=new point(0,4);
          q.pos=new point(0,3);
          b.pos=new point(0,2);
          kn.pos=new point(0,1);
          r.pos=new point(0,0);
          r1.pos=new point(0,7);
          b1.pos=new point(0,5);
          kn1.pos=new point(0,6);
            
        cmp.add(k);
        cmp.add(q);
        cmp.add(b);
        cmp.add(kn);
        cmp.add(r);
        cmp.add(r1);
        cmp.add(b1);
        cmp.add(kn1);
        kp.pos=new point(7,4);
        qp.pos=new point(7,3);
        bp.pos=new point(7,2);
        knp.pos=new point(7,1);
        rp.pos=new point(7,0);
        rp1.pos=new point(7,7);
        bp1.pos=new point(7,5);
        knp1.pos=new point(7,6);
             
        pl.add(kp);
        pl.add(qp);
        pl.add(bp);
        pl.add(knp);
        pl.add(rp);
        pl.add(rp1);
        pl.add(bp1);
        pl.add(knp1);
        for(int i=0;i<8;i++){
            Pawn p=new Pawn(ret,false);
            p.pos=new point(6,i);
            pl.add(p);
        }
        ret.comp=cmp;
        ret.player=pl;
        return ret;
    }
    public boolean live(board tmp,King king,boolean cmp){
        for(point pnt:king.posmoves){
                        board tmp1=tmp.clone();
                        tmp1.makeMove(king.pos, pnt);
                        if(!tmp1.check(tmp1.getKing(cmp)))
                            return true;
                        
                     }
        return false;
    }
    public static final int BLACK = 0, WHITE = 1;
    
      Chess() {
        // start.getBoard()
 try{
   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
 }catch(Exception e){
  e.printStackTrace(); 
 }
        initializeGui();
          start = initboard();
        for(int i = 0 ; i < 8 ; i++){
            
            for(int j = 0 ; j < 8 ; j++){
               chessBoardSquares[i][j].putClientProperty("column", i);
               chessBoardSquares[i][j].putClientProperty("row", j);
               chessBoardSquares[i][j].addActionListener(new ActionListener() {
    
   public void actionPerformed(ActionEvent e) {
       System.out.println(gameOn);
       if(!gameOn)return;
       boolean p1=false;
       boolean c1=false;
       JButton btn = (JButton) e.getSource();
             piece[][] p =  start.brd;
             if(sel==false){
                 sel = true;
                 csel = new point(Integer.parseInt(btn.getClientProperty("row").toString()),Integer.parseInt(btn.getClientProperty("column").toString()));
                 tmp=  (ImageIcon)chessBoardSquares[csel.c][csel.r].getIcon();
                 if(p[csel.r][csel.c]==null||!user(csel,start)){
                     sel=false;
                     return;
                 }
                p[csel.r][csel.c].generate();
                 for(point d :p[csel.r][csel.c].posmoves){
                    
                     chessBoardSquares[d.c][d.r].setBorder(BorderFactory.createLineBorder(Color.red, 5));
                 }
             }
             else{
                 
                  for(point d :p[csel.r][csel.c].posmoves){
                 
                     chessBoardSquares[d.c][d.r].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                     
                 }
                 
                 newp = new point(Integer.parseInt(btn.getClientProperty("row").toString()),Integer.parseInt(btn.getClientProperty("column").toString()));
                 
                 if(start.possible(csel, newp)){                        
                        move mv=new move(0);
                     sel = false;
                      tmp = null;
                      board tmp=start.clone();
                      tmp.makeMove(csel,newp);
                     if(!tmp.check(tmp.getKing(false))){
                     change(csel,newp);
                     start.makeMove(csel, newp);
                     start.print();
                     King tmpking=tmp.getKing(false);
                     p1=live(tmp,tmpking,false);
                     tmpking=tmp.getKing(true);
                     c1=live(tmp,tmpking,true);                    
                     mv.alpha(start,diff);
                     if(start.check(start.getKing(false))) JOptionPane.showMessageDialog(null, "Check!");
                     tmpking=tmp.getKing(false);
                     p1=live(tmp,tmpking,false);
                     tmpking=tmp.getKing(true);
                     c1=live(tmp,tmpking,true); 
                     if(!c1){
                         if(!tmp.check(tmpking)&&tmp.comp.size()==1&&tmp.comp.get(0).getClass()==King.class){
                             JOptionPane.showMessageDialog(null, "Game is Tie");
                             gameOn=false;
                         }
                         else if(tmp.check(tmpking)) {
                             JOptionPane.showMessageDialog(null, "You win");
                             gameOn=false;
                         }
                     }
                     else if(!p1){
                         if(!tmp.check(tmp.getKing(false))&&tmp.player.size()==1&&tmp.player.get(0).getClass()==King.class){
                             JOptionPane.showMessageDialog(null, "Game is Tie");
                             gameOn=false;
                         }
                         else if(tmp.check(tmp.getKing(false))) {
                             JOptionPane.showMessageDialog(null, "Bot wins");
                             gameOn=false;
                         }
                     }
                      }
                     else JOptionPane.showMessageDialog(null, "The King Will Die");
                     
                 }
                 else{
                     sel = false;
                     return;
                 }
                 
             }
             
             }
    
      });
            }
        }

        
        
        
    }
      
    
      
      public final JComponent getGui() {
        return gui;
    }

    private final void createImages() {
        try {
           URL url2 = this.getClass().getResource("memI0.png");
            URL url = new URL("http://i.stack.imgur.com/memI0.png");
            BufferedImage bi = ImageIO.read(url2);
            for (int ii = 0; ii < 2; ii++) {
                for (int jj = 0; jj < 6; jj++) {
                    chessPieceImages[ii][jj] = bi.getSubimage(
                            jj * 64, ii * 64, 64, 64);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

  
    private final void setupNewGame() {
        this.start = initboard();
        gameOn=true;
      
        // set up the black pieces
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][0].setIcon(new ImageIcon(
                    chessPieceImages[BLACK][STARTING_ROW[ii]]));
        }
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][1].setIcon(new ImageIcon(
                    chessPieceImages[BLACK][PAWN]));
        }
        // set up the white pieces
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][6].setIcon(new ImageIcon(
                    chessPieceImages[WHITE][PAWN]));
        }
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][7].setIcon(new ImageIcon(
                    chessPieceImages[WHITE][STARTING_ROW[ii]]));
        }
        start.print();
    }
    
    public void emptyBoard(){
        for(int i = 0; i < 8 ;i++){
            for(int j = 0 ; j < 8 ;j++){
                 chessBoardSquares[i][j].setIcon(null);
        }
    }
    }
      
    
     public final void initializeGui() {
     
        createImages();

       
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        Action newGameEasy = new AbstractAction("Start Easy!") {

            @Override
            public void actionPerformed(ActionEvent e) {
                 emptyBoard();
                diff =2;
                setupNewGame();
            }
        };
        
        
         Action newGameMedium = new AbstractAction("Start Medium!") {

            @Override
            public void actionPerformed(ActionEvent e) {
                 emptyBoard();
                diff =3;
                setupNewGame();
            }
        };
         
           Action newGameHard = new AbstractAction("Start Hard!") {

            @Override
            public void actionPerformed(ActionEvent e) {
                 emptyBoard();
                diff =4;
                setupNewGame();
            }
        };
        tools.add(newGameEasy);
        tools.add(newGameMedium);
        tools.add(newGameHard);
        tools.addSeparator();
        tools.addSeparator();
        tools.add(message);

        gui.add(new JLabel("?"), BorderLayout.LINE_START);

        chessBoard = new JPanel(new GridLayout(0, 9)) {

         
            @Override
            public final Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension(
                            (int)d.getWidth(),(int)d.getHeight());
                } else if (c!=null &&
                        c.getWidth()>d.getWidth() &&
                        c.getHeight()>d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // the smaller of the two sizes
                int s = (w>h ? h : w);
                return new Dimension(s,s);
            }
        };
        chessBoard.setBorder(new CompoundBorder(
                new EmptyBorder(8,8,8,8),
                new LineBorder(Color.BLACK)
                ));
       
       
        //chessBoard.setBackground(Color.white);
        chessBoard.setOpaque(true);
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.setBackground(Color.WHITE);
        boardConstrain.add(chessBoard);
        gui.add(boardConstrain);

       
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
              
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((jj % 2 == 1 && ii % 2 == 1)
                        //) {
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                   b.setOpaque(true);
                } else {
                    b.setBackground(Color.BLACK);
                    b.setOpaque(true);
                }
                chessBoardSquares[jj][ii] = b;
            }
        }

      
        chessBoard.add(new JLabel(""));
    
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                    SwingConstants.CENTER));
        }
      
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (9-(ii + 1)),
                                SwingConstants.CENTER));
                    default:
                        chessBoard.add(chessBoardSquares[jj][ii]);
                }
            }
        }
    }
    


    
    public static void main(String[] args) {
        
          // initializeGui();
          
          
          
             Runnable ra = new Runnable() {

            @Override
            public void run() {
                Chess cg = new Chess();

                JFrame f = new JFrame();
                f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
           
                f.add(cg.getGui());
               
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                f.setLocationByPlatform(true);

            
                f.pack();
              
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
      
        SwingUtilities.invokeLater(ra);
    }
          
          
    }

    

    
    
      