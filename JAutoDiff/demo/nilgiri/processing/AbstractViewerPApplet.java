package nilgiri.processing;



import java.awt.Color;
import java.awt.event.KeyEvent;

import processing.core.PApplet;

public abstract class AbstractViewerPApplet extends PApplet{

	
	
	private ViewConfig2D m_vc = new ViewConfig2D();
	private MouseGestureMode m_mgmode = new MouseGestureTranslationMode(this, m_vc);
	
	public void keyPressed(){
		switch(keyCode){
		case KeyEvent.VK_T:
			m_mgmode = new MouseGestureTranslationMode(this, m_vc);
			break;
		case KeyEvent.VK_Z:
			m_mgmode = new  MouseGestureScaleMode(this, m_vc);
			break;
		default:
			break;
		}
	}

	public ViewConfig2D viewConfig(){
		return m_vc;
	}
	
	public MouseGestureMode getMouseGestureMode(){
		return m_mgmode;
	}
	public void mouseDragged(){
		m_mgmode.mouseDragged();
		Color bgcolor = this.getBackground(); 
		background(bgcolor.getRGB());
	}
}
