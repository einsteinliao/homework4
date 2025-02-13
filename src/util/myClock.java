package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class myClock extends Thread {

	private JLabel jObj;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public myClock(JLabel obj) {
		this.jObj = obj;
	}
	
	public void run() {
		while(true) {

			SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
			String str = f.format(new Date());
			jObj.setText(str);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


