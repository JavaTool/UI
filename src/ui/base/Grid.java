package ui.base;

import ui.base.Container;

public interface Grid extends Container {
	
	void setSize(int size);
	
	int getSize();
	
	void setRows(int row);
	
	int getRows();
	
	int getColumns();
	
	void setGap(int gap);
	
	int getGap();

}
