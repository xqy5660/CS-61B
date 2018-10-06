import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.WritableRaster;

import java.io.File;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.LinkedList;
import java.util.TreeSet;
import java.util.NoSuchElementException;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;



public class TestStdDraw {
       public static void main(String[] args) {
           /** StdDraw.setPenRadius(0.05);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.point(0.5, 0.5);
            StdDraw.setPenColor(StdDraw.MAGENTA);
            StdDraw.line(0.2, 0.2, 0.8, 0.2);
            */
       StdDraw.setScale(-2, +2);
    StdDraw.enableDoubleBuffering();
 
    for (double t = 0.0; true; t += 0.02) {
        double x = Math.sin(t);
        double y = Math.cos(t);
        StdDraw.clear();
        StdDraw.filledCircle(x, y, 0.05);
        StdDraw.filledCircle(-x, -y, 0.05);
        StdDraw.show();
        StdDraw.pause(20);
    }
}
}

    



















   }