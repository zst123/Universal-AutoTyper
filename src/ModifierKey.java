import java.awt.event.KeyEvent;


public class ModifierKey {
	
	public static int get(){
		 String OS = System.getProperty("os.name").toLowerCase();
		 
		 if (OS.indexOf("mac") >= 0) {
			 return KeyEvent.VK_META;

		 } else {
				return KeyEvent.VK_CONTROL;
		 }
		 
		}
}
