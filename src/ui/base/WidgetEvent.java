package ui.base;

public interface WidgetEvent {
	
	public enum EventType {
		
		EVENT_MOUSE_ENTERED,

		EVENT_MOUSE_EXITED,

		EVENT_MOUSE_PRESSED,

		EVENT_MOUSE_RELEASED,

		EVENT_MOUSE_CLICKED,

		EVENT_MOUSE_MOVED,

		EVENT_MOUSE_DRAGGED,
		
		EVENT_KEY_TYPED,

		EVENT_KEY_PRESSED,

		EVENT_KEY_RELEASED,
		
	}
	
	public enum ButtonType {

		BUTTON_MOUSE_RIGHT,

		BUTTON_MOUSE_MIDDLE,

		BUTTON_MOUSE_LEFT,

		BUTTON_NULL;
		
	}
	
	int getX();
	
	int getY();
	
	EventType getType();
	
	ButtonType getButton();
	
	Widget getWidget();

}
