package ui.base;

public interface Anchor {
	
	public enum Anchors {
		
		ANCHOR_CENTER, 
		
		ANCHOR_TOP_LEFT, 
		
		ANCHOR_TOP, 
		
		ANCHOR_TOP_RIGHT, 
		
		ANCHOR_RIGHT, 
		
		ANCHOR_BOTTOM_RIGHT, 
		
		ANCHOR_BOTTOM, 
		
		ANCHOR_BOTTOM_LEFT, 
		
		ANCHOR_LEFT
		
		}
	
	Anchors getAnchors();
	
	Anchors getRelativeAnchors();
	
	int getOffsetX();
	
	int getOffsetY();
	
	void setAnchors(Anchors anchor);
	
	void setRelativeAnchors(Anchors relativeAnchor);
	
	void setOffsetX(int offsetX);
	
	void setOffsetY(int offsetY);

}
