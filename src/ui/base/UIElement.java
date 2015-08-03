package ui.base;

import java.awt.Graphics;

public interface UIElement {
	
	byte MASK_SHOW = 0;
	
	byte MASK_HIDE = 1;
	
	byte MASK_IGNORE = 2;
	
	int getId();
	
	int getX();
	
	int getY();
	
	int getAbsoluteX();
	
	int getAbsoluteY();
	
	int getWidth();
	
	int getHeight();
	
	void setX(int x);
	
	void setY(int y);
	
	void setLocal(int x, int y);
	
	void setWidth(int width);
	
	void setHeight(int height);
	
	void setBound(int width, int height);
	
	void setBorder(int x, int y, int width, int height);
	
	void setVisible(boolean visiable);
	
	boolean getVisible();
	
	void paint(Graphics g);
	
	void addAnchor(Anchor anchor);
	
	void clearAnchor();
	
	void setMask(int mask);
	
	int getMask();
	
	void destroy();
	
	void setParent(Widget parent);
	
	Widget getParentWidget();

}
