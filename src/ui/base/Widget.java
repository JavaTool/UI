package ui.base;

public interface Widget extends UIElement {
	
	byte STATE_NORMAL = 0;
	
	byte STATE_PUSHED = 2;
	
	byte STATE_UNENABLE = 4;
	
	byte STATE_LIGHT = 8;
	
	void addRegion(Region region);
	
	Region getRegion(int id);
	
	void removeRegion(int id);
	
	void removeAllRegion();
	
	Widget in(int x, int y, int type);
	
	void fitSize();
	
	boolean handleWidgetEvent(int x, int y, int type, int button);
	
	boolean getEnable();
	
	void setEnable(boolean enable);
	
	void cycle();
	
	void setFocusable(boolean focusable);
	
	boolean getFocusable();
	
	void setFocus(boolean focus);
	
	boolean getFocus();

}
