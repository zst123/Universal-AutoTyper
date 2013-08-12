import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;



public class CopyPaster {
	public static Robot r;
	public static Thread d;

	public CopyPaster(){
		try{
		r = new Robot();
		}catch(Exception e){
			
		}

	}
	
	
	
	
	
	public static void type(final String text, final int loops, int initial, final int delay, final int modifierKey, final boolean unlimited){
		if (!(r != null )){ try { r = new Robot(); } catch (AWTException e) { }}
		MainFrame.start = true; 
		copyToClipboard(text);
		r.delay(initial);
		
		
		d = new Thread(new Runnable() { @Override public void run() {
			  for( int i = 0; i < loops; i++){  
				  if (unlimited == true){ i--;}
		    		r.delay(delay);
		    		
		    		if (MainFrame.start==true){
		 			sendPaste(modifierKey);
		 			sendEnter();
		    		}else{
		    			break;
		    		}
		    		
			 		}
			  MainFrame.start = false;
			  MainFrame.updateVariable(false);
				

		} }) ;
		d.start();
	}
	
	public static void copyToClipboard(String str){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		clipboard.setContents(new StringSelection(str), null);
	}
	
	
	
	
	public static void sendPaste(int ctrl){
		r.keyPress(ctrl);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(ctrl);  
}
	
	public static void sendEnter(){
		int rr = KeyEvent.VK_ENTER;
		r.keyPress(rr);
			r.keyRelease(rr);
	}
}
