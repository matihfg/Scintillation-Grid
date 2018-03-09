import java.awt.Color;
import java.awt.Graphics;

/**
 * @author  Matias Fragoso
 * @version 2/11/2017
 *
 * A program to print out various scintillation grids and a student designed drawing. 
 *
 */

public class ScintillationGrid {

	// Main method that creates the DrawingPanel with scintillation grids.
	// Restricted to chapters 1 - 3 of Building Java Programs
    public static void main(String[] args) {
    	/* In the final version of the program DO NOT call method drawingOne 
    	   from main or anywhere else in the program */
    	
    	
    	DrawingPanel panel = new DrawingPanel(900, 650);
    	panel.setBackground(Color.CYAN);
    	Graphics g = panel.getGraphics();
    	
    	drawGrid(g, 0, 0, 348, 75, 3, 16);
    	drawGrid(g, 400, 50, 422, 50, 6, 12);
    	drawGrid(g, 50, 400, 220, 100, 1, 20);
    	drawGrid(g, 500, 500, 148, 15, 7, 4);
    }
    
    //draws the entirety of one Scintillation grid
    public static void drawGrid(Graphics g, int x, int y, int length, int smallSq,
    								int numLines, int lineThick){
    	g.setColor(Color.BLACK);
    	g.fillRect(x, y, length, length);
    	g.setColor(Color.GRAY);
    	vertLines(g, x, y, length, smallSq, numLines, lineThick);
    	horLines(g, x, y, length, smallSq, numLines, lineThick);
    	g.setColor(Color.WHITE);
    	drawCircles(g, x, y, length, smallSq, numLines, lineThick);
    }
    
    //draws the vertical lines on the grid
    public static void vertLines(Graphics g, int x, int y, int length, int smallSq, 
			int numLines, int lineThick){
    		for(int rows = 1; rows <= numLines; rows++){
    			int vertRows = smallSq * rows + lineThick *(rows - 1) + x;
    			g.fillRect(vertRows, y, lineThick, length);
    		}
    }
    
    //draws the horizontal lines on the grid
    public static void horLines(Graphics g, int x, int y, int length, int smallSq, 
			int numLines, int lineThick){
    	for(int columns = 1; columns <= numLines; columns++){
    		int horColumns = smallSq * columns + lineThick *(columns - 1) + y;
    		g.fillRect(x, horColumns, length, lineThick);
    	}
    }
    
    //draws the white circles in the center of vertical and horizontal lines
    public static void drawCircles(Graphics g, int x, int y, int length, int smallSq,
    								int numLines, int lineThick){
    	int width = (int) Math.max(lineThick + 2, lineThick * .4 + lineThick);
    	
    	for(int rows = 1; rows <= numLines; rows++){
    		int xStart = x + smallSq * rows + (lineThick / 2) + lineThick * (rows - 1) - (width / 2);
    		for(int columns = 1; columns <= numLines; columns++){
    			int yStart = y + smallSq * columns + (lineThick / 2) + lineThick * (columns - 1) - (width / 2);
    			g.fillOval(xStart, yStart, width, width);
    		}
    	}
    }

    
    
    // method for the student designed drawing
    // NOT restricted to chapters 1 - 3 of Building Java Programs
    public static void drawingOne() {
    	DrawingPanel panel = new DrawingPanel(400, 200);
        panel.setBackground(Color.GREEN);
        
        Graphics g = panel.getGraphics();
        for (int i = 0; i < 2; i++) {
            g.setColor(Color.RED);
            g.fillOval(i *200, i * 100, 200, 100);
            g.setColor(Color.BLACK);
            g.drawRect(i * 200, i * 100, 200, 100);
            //vertical line
            g.drawLine(100 + (200 * i) , i + (i * 100), 100 + (200 * i), 100 + (i * 100));
            //horizontal line
            g.drawLine(i * 200, 50 + (i * 100), (i * 200) + 200, 50 + (i * 100));
        }
	}
}