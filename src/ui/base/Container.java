package ui.base;

public interface Container extends Widget {
	
	void addChild(Widget widget);
	
	Widget[] getChilds();
	
	Widget getChild(int id);
	
	Widget removeWidget(int id, boolean destroy);
	
	void removeAllWidget();

}
