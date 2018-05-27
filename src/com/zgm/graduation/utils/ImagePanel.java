package com.zgm.graduation.utils;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 4644786195524096243L;

	private BufferedImage image;

	public ImagePanel() {
		super();
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);

		// img = Toolkit.getDefaultToolkit().getImage("C:\\test.jpg");
		if (null != image) {
			this.setSize(image.getWidth(this), image.getHeight(this));
			g.fill3DRect(0, 0, image.getWidth(this), image.getHeight(this),
					true);
			g.drawImage(image, 0, 0, null, this);
			setPreferredSize(new Dimension(image.getWidth(this),
					image.getHeight(this)));
		}
	}

}


