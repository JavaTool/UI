package ui.core;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import ui.base.Anchor;
import ui.base.UIElement;
import ui.base.Widget;

public class IUIElement implements UIElement {
	
	protected final int id;
	
	protected int x;
	
	protected int y;
	
	protected int width;
	
	protected int height;
	
	protected boolean visible;
	
	protected List<Anchor> anchors;
	
	protected int mask;
	
	protected Widget parent;
	
	public IUIElement(int id) {
		this.id = id;
		anchors = new ArrayList<Anchor>(2);
		setMask(1 << Widget.STATE_NORMAL);
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getAbsoluteX() {
		return x + (parent == null ? 0 : parent.getAbsoluteX());
	}

	@Override
	public int getAbsoluteY() {
		return y + (parent == null ? 0 : parent.getAbsoluteY());
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setX(int x) {
		clearAnchor();
		this.x = x;
	}

	@Override
	public void setY(int y) {
		clearAnchor();
		this.y = y;

	}

	@Override
	public void setLocal(int x, int y) {
		setX(x);
		setY(y);
	}

	@Override
	public void setWidth(int width) {
		if (anchors.size() > 1) {
			anchors.remove(1);
		}
		
		this.width = width;
	}

	@Override
	public void setHeight(int height) {
		if (anchors.size() > 1) {
			anchors.remove(1);
		}

		this.height = height;
	}

	@Override
	public void setBound(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	@Override
	public void setBorder(int x, int y, int width, int height) {
		setLocal(x, y);
		setBound(width, height);
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public boolean getVisible() {
		return visible;
	}

	@Override
	public void paint(Graphics g) {
		g.setClip(getAbsoluteX(), getAbsoluteY(), getWidth(), getHeight());
	}

	@Override
	public void addAnchor(Anchor anchor) {
		if (anchors.size() > 1) {
			return;
		} else {
			anchors.add(anchor);
			adaptation();
		}
	}

	@Override
	public void clearAnchor() {
		anchors.clear();
		adaptation();
	}

	@Override
	public void setMask(int mask) {
		this.mask = mask;
	}

	@Override
	public int getMask() {
		return mask;
	}

	@Override
	public void destroy() {
		anchors = null;
		parent = null;
	}

	@Override
	public void setParent(Widget parent) {
		this.parent = parent;
		adaptation();
	}

	@Override
	public Widget getParentWidget() {
		return parent;
	}
	
	protected void adaptation() {
		if (getParentWidget() != null) {
			if (anchors.size() > 0) {
				adaptationLocal();
				if (anchors.size() > 1) {
					adaptationBound();
				}
			}
		}
	}
	
	protected void adaptationLocal() {
		Anchor anchor = anchors.get(0);
		switch (anchor.getRelativeAnchors()) {
		case ANCHOR_TOP_LEFT : 
			x = 0;
			y = 0;
			break;
		case ANCHOR_TOP : 
			x = parent.getWidth() >> 1;
			y = 0;
			break;
		case ANCHOR_TOP_RIGHT : 
			x = parent.getWidth();
			y = 0;
			break;
		case ANCHOR_RIGHT : 
			x = parent.getWidth();
			y = parent.getHeight() >> 1;
			break;
		case ANCHOR_BOTTOM_RIGHT : 
			x = parent.getWidth();
			y = parent.getHeight();
			break;
		case ANCHOR_BOTTOM : 
			x = parent.getWidth() >> 1;
			y = parent.getHeight();
			break;
		case ANCHOR_BOTTOM_LEFT : 
			x = 0;
			y = parent.getHeight();
			break;
		case ANCHOR_LEFT : 
			x = 0;
			y = parent.getHeight() >> 1;
			break;
		case ANCHOR_CENTER : 
			x = parent.getWidth() >> 1;
			y = parent.getHeight() >> 1;
			break;
		}
		switch (anchor.getAnchors()) {
		case ANCHOR_TOP : 
			x -= getWidth() >> 1;
			break;
		case ANCHOR_TOP_RIGHT : 
			x -= getWidth();
			break;
		case ANCHOR_RIGHT : 
			x -= getWidth();
			y -= getHeight() >> 1;
			break;
		case ANCHOR_BOTTOM_RIGHT : 
			x -= getWidth();
			y -= getHeight();
			break;
		case ANCHOR_BOTTOM : 
			x -= getWidth() >> 1;
			y -= getHeight();
			break;
		case ANCHOR_BOTTOM_LEFT : 
			y -= getHeight();
			break;
		case ANCHOR_LEFT : 
			y -= getHeight() >> 1;
			break;
		case ANCHOR_CENTER : 
			x -= getWidth() >> 1;
			y -= getHeight() >> 1;
			break;
		default:
			break;
		}
		x += anchor.getOffsetX();
		y += anchor.getOffsetY();
	}
	
	protected void adaptationBound() {
		int x = 0, y = 0;
		Anchor anchor = anchors.get(1);
		switch (anchor.getRelativeAnchors()) {
		case ANCHOR_TOP_LEFT : 
			x = 0;
			y = 0;
			break;
		case ANCHOR_TOP : 
			x = parent.getWidth() >> 1;
			y = 0;
			break;
		case ANCHOR_TOP_RIGHT : 
			x = parent.getWidth();
			y = 0;
			break;
		case ANCHOR_RIGHT : 
			x = parent.getWidth();
			y = parent.getHeight() >> 1;
			break;
		case ANCHOR_BOTTOM_RIGHT : 
			x = parent.getWidth();
			y = parent.getHeight();
			break;
		case ANCHOR_BOTTOM : 
			x = parent.getWidth() >> 1;
			y = parent.getHeight();
			break;
		case ANCHOR_BOTTOM_LEFT : 
			x = 0;
			y = parent.getHeight();
			break;
		case ANCHOR_LEFT : 
			x = 0;
			y = parent.getHeight() >> 1;
			break;
		case ANCHOR_CENTER : 
			x = parent.getWidth() >> 1;
			y = parent.getHeight() >> 1;
			break;
		}
		switch (anchor.getAnchors()) {
		case ANCHOR_TOP : 
			x -= getWidth() >> 1;
			break;
		case ANCHOR_TOP_RIGHT : 
			x -= getWidth();
			break;
		case ANCHOR_RIGHT : 
			x -= getWidth();
			y -= getHeight() >> 1;
			break;
		case ANCHOR_BOTTOM_RIGHT : 
			x -= getWidth();
			y -= getHeight();
			break;
		case ANCHOR_BOTTOM : 
			x -= getWidth() >> 1;
			y -= getHeight();
			break;
		case ANCHOR_BOTTOM_LEFT : 
			y -= getHeight();
			break;
		case ANCHOR_LEFT : 
			y -= getHeight() >> 1;
			break;
		case ANCHOR_CENTER : 
			x -= getWidth() >> 1;
			y -= getHeight() >> 1;
			break;
		default:
			break;
		}
		x += anchor.getOffsetX();
		y += anchor.getOffsetY();
		width = x - this.x;
		height = y - this.y;
	}

}
