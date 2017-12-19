package chess;

import static chess.Chess.BLACK;
import static chess.Chess.STARTING_ROW;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author ahmedsalah
 */

class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
       JButton btn = (JButton) e.getSource();
        System.out.println("clicked column " + btn.getClientProperty("column")
                + ", row " + btn.getClientProperty("row"));
        
        
         //chessBoardSquares[ii][0].setIcon(new ImageIcon(
                   // chessPieceImages[BLACK][STARTING_ROW[ii]]));
  }
    
}





public class Chess {
private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private Image[][] chessPieceImages = new Image[2][6];
    public piece[][] Board = new piece[8][8];
    
   
    
    private JPanel chessBoard;
    private final JLabel message = new JLabel(
            "Chess Champ is ready to play!");
    private static final String COLS = "ABCDEFGH";
    public static final int QUEEN = 0, KING = 1,
            ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = {
        ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK
    };
    
    
     board start =new board();
        ArrayList<piece> cmp=new ArrayList<>();
       
        piece k=new King(start,true);
       
        piece q=new queen(start,true);
      
        piece b=new bishop(start,true);
        
        piece kn=new Knight(start,true);
       
        piece r=new rook(start,true);
        
        piece r1=new rook(start,true);
        
        piece b1=new bishop(start,true);
        
        piece kn1=new Knight(start,true);
       
     
        ArrayList<piece> pl=new ArrayList();
        piece kp=new King(start,false);
        
        piece qp=new queen(start,false);
       
        piece bp=new bishop(start,false);
       
        piece knp=new Knight(start,false);
       
        piece rp=new rook(start,false);
        
        piece rp1=new rook(start,false);
        
        piece bp1=new bishop(start,false);
      
        piece knp1=new Knight(start,false);
       
       
    
    
    
    public static final int BLACK = 0, WHITE = 1;
    
      Chess() {
        initializeGui();
        
        for(int i = 0 ; i < 8 ; i++){
            
            for(int j = 0 ; j < 8 ; j++){
               chessBoardSquares[i][j].putClientProperty("column", i);
               chessBoardSquares[i][j].putClientProperty("row", j);
               chessBoardSquares[i][j].addActionListener(new ActionListener() {
    
   public void actionPerformed(ActionEvent e) {
       JButton btn = (JButton) e.getSource();
        System.out.println("clicked column " + btn.getClientProperty("column")
                + ", row " + btn.getClientProperty("row"));
        
               ImageIcon tmp=  (ImageIcon)chessBoardSquares[0][0].getIcon();

         /*chessBoardSquares[5][4].setIcon(tmp);
         chessBoardSquares[0][0].setIcon(null);*/
  }
    
      });
            }
        }

        
        
         for(int i=0;i<8;i++){
            Pawn p=new Pawn(start,true);
            p.pos=new point(1,i);
            cmp.add(p);
        }
         
         
         
         
          k.pos=new point(0,3);
          q.pos=new point(0,4);
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
        kp.pos=new point(7,3);
        qp.pos=new point(7,4);
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
            Pawn p=new Pawn(start,false);
            p.pos=new point(6,i);
            pl.add(p);
        }
        start.comp=cmp;
        start.player=pl;
    }
      
    
      
      public final JComponent getGui() {
        return gui;
    }

    private final void createImages() {
        try {
            URL url = new URL("http://i.stack.imgur.com/memI0.png");
            BufferedImage bi = ImageIO.read(url);
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

    /**
     * Initializes the icons of the initial chess board piece places
     */
    private final void setupNewGame() {
        message.setText("Make your move!");
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
    }

      
    
     public final void initializeGui() {
        // create the images for the chess pieces
        createImages();

        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        Action newGameAction = new AbstractAction("New") {

            @Override
            public void actionPerformed(ActionEvent e) {
                setupNewGame();
            }
        };
        tools.add(newGameAction);
        tools.add(new JButton("Save")); // TODO - add functionality!
        tools.add(new JButton("Restore")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(new JButton("Resign")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(message);

        gui.add(new JLabel("?"), BorderLayout.LINE_START);

        chessBoard = new JPanel(new GridLayout(0, 9)) {

            /**
             * Override the preferred size to return the largest it can, in
             * a square shape.  Must (must, must) be added to a GridBagLayout
             * as the only component (it uses the parent as a guide to size)
             * with no GridBagConstaint (so it is centered).
             */
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
        // Set the BG to be ochre
        Color ochre = new Color(204,119,34);
        chessBoard.setBackground(ochre);
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.setBackground(ochre);
        boardConstrain.add(chessBoard);
        gui.add(boardConstrain);

        // create the chess board squares
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((jj % 2 == 1 && ii % 2 == 1)
                        //) {
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[jj][ii] = b;
            }
        }

        /*
         * fill the chess board
         */
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                    SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
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
        board start =new board();
        ArrayList<piece> cmp=new ArrayList<>();
        for(int i=0;i<8;i++){
            Pawn p=new Pawn(start,true);
            p.pos=new point(1,i);
            cmp.add(p);
        }
        piece k=new King(start,true);
        k.pos=new point(0,3);
        piece q=new queen(start,true);
        q.pos=new point(0,4);
        piece b=new bishop(start,true);
        b.pos=new point(0,2);
        piece kn=new Knight(start,true);
        kn.pos=new point(0,1);
        piece r=new rook(start,true);
        r.pos=new point(0,0);
        piece r1=new rook(start,true);
        r1.pos=new point(0,7);
        piece b1=new bishop(start,true);
        b1.pos=new point(0,5);
        piece kn1=new Knight(start,true);
        kn1.pos=new point(0,6);
        cmp.add(k);
        cmp.add(q);
        cmp.add(b);
        cmp.add(kn);
        cmp.add(r);
        cmp.add(r1);
        cmp.add(b1);
        cmp.add(kn1);
        ArrayList<piece> pl=new ArrayList();
        piece kp=new King(start,false);
        kp.pos=new point(7,3);
        piece qp=new queen(start,false);
        qp.pos=new point(7,4);
        piece bp=new bishop(start,false);
        bp.pos=new point(7,2);
        piece knp=new Knight(start,false);
        knp.pos=new point(7,1);
        piece rp=new rook(start,false);
        rp.pos=new point(7,0);
        piece rp1=new rook(start,false);
        rp1.pos=new point(7,7);
        piece bp1=new bishop(start,false);
        bp1.pos=new point(7,5);
        piece knp1=new Knight(start,false);
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
            Pawn p=new Pawn(start,false);
            p.pos=new point(6,i);
            pl.add(p);
        }
        start.comp=cmp;
        start.player=pl;
        start.print();
        
          // initializeGui();
          
          
          
             Runnable ra = new Runnable() {

            @Override
            public void run() {
                Chess cg = new Chess();

                JFrame f = new JFrame("ChessChamp");
                f.add(cg.getGui());
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See https://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(ra);
    }
          
          
    }

    

    
    
      