package ui.core;

import ui.base.Anchor;

public class IAnchor implements Anchor {
	
	protected Anchors anchor;
	
	protected Anchors relativeAnchor;
	
	protected int offsetX;
	
	protected int offsetY;
	
	public IAnchor(Anchors anchor, Anchors relativeAnchor, int offsetX, int offsetY) {
		setAnchors(anchor);
		setRelativeAnchors(relativeAnchor);
		setOffsetX(offsetX);
		setOffsetY(offsetY);
	}
	
	public IAnchor(Anchors anchor, int offsetX, int offsetY) {
		this(anchor, anchor, offsetX, offsetY);
	}
	
	public IAnchor(Anchors anchor, Anchors relativeAnchor) {
		this(anchor, relativeAnchor, 0, 0);
	}
	
	public IAnchor(Anchors anchor) {
		this(anchor, anchor, 0, 0);
	}

	@Override
	public Anchors getAnchors() {
		return anchor;
	}

	@Override
	public Anchors getRelativeAnchors() {
		return relativeAnchor;
	}

	@Override
	public int getOffsetX() {
		return offsetX;
	}

	@Override
	public int getOffsetY() {
		return offsetY;
	}

	@Override
	public void setAnchors(Anchors anchor) {
		this.anchor = anchor;
	}

	@Override
	public void setRelativeAnchors(Anchors relativeAnchor) {
		this.relativeAnchor = relativeAnchor;
	}

	@Override
	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	@Override
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}

}
