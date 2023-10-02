package tools;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class ActionButton extends JButton {
    private boolean mousePress; // Flag to track mouse press state
    
    /**
     * Initializes a new ActionButton.
     */
    public ActionButton() {
        setContentAreaFilled(false); // Make the button transparent and remove border
        setBorder(new EmptyBorder(3, 3, 3, 3));

        // Add mouse listeners to track mouse events
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mousePress = true;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mousePress = false;
            }
        });
    }
     /**
     * Custom painting of the button with an elliptical shape.
     *
     * @param grphcs The Graphics context for painting.
     */
    @Override
    public void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        int x = (width - size) / 2;
        int y = (height - size) / 2;

        // Set button color based on mouse press state
        if (mousePress) {
            g2.setColor(new Color(158, 158, 158)); // Gray color when pressed
        } else {
            g2.setColor(new Color(199, 199, 199)); // Light gray color when not pressed
        }
        g2.fill(new Ellipse2D.Double(x, y, size, size)); // Draw an elliptical shape to represent the button
        g2.dispose();
    }
}
