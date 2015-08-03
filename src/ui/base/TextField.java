package ui.base;

import java.awt.Color;
import java.awt.Font;

public interface TextField extends Widget {
	
	int KEY_ENTER = 10;
	
	int KEY_SHIFT = 16;
	
	int KEY_CTRL = 17;
	
	int KEY_ALT = 18;
	
	int KEY_LEFT = 37;
	
	int KEY_UP = 38;
	
	int KEY_RIGHT = 39;
	
	int KEY_DOWN = 40;
	
	int[] KEY_CHARS = new int[]{
			127, // delete
			192, // `
			49, // 1
			50, // 2
			51, // 3
			52, // 4
			53, // 5
			54, // 6
			55, // 7
			56, // 8
			57, // 9
			48, // 0
			45, // -
			61, // =
			8, // backspace
			81, // q
			87, // w
			69, // e
			82, // r
			84, // t
			89, // y
			85, // u
			73, // i
			79, // o
			80, // p
			91, // [
			93, // ]
			92, // \
			65, // a
			83, // s
			68, // d
			70, // f
			71, // g
			72, // h
			74, // j
			75, // k
			76, // l
			59, // ;
			222, // '
			90, // z
			88, // x
			67, // c
			86, // v
			66, // b
			78, // n
			77, // m
			44, // ,
			46, // .
			47, // /
			97, // 1
			98, // 2
			99, // 3
			100, // 4
			101, // 5
			102, // 6
			103, // 7
			104, // 8
			105, // 9
			111, // /
			106, // *
			109, // -
			107, // +
			96, // 0
			110, // .
			32, // space
	};
	
	void setText(String text);
	
	String getText();
	
	void setMaxCount(int maxCount);
	
	int getMaxCount();
	
	void setFont(Font font);
	
	Font getFont();
	
	int getStringWidth(String text);
	
	int getStringHeight();
	
	void addKeyCodeHandler(KeyCodeHandler keyCodeHandler);
	
	void setColor(Color color);
	
	Color getColor();
	
	void setCacheLineMax(int max);
	
	void setText(String text, boolean cacheOld);
	
	int getCacheLineMax();
	
	int getCacheLineCount();
	
	void up();
	
	void down();
	
	void clearCacheLine();
	
	public static interface KeyCodeHandler {
		
		int[] getHandleCodes();
		
		void hanleKeyCode(int keyCode);
		
	}

}
