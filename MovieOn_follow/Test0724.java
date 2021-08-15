package MovieOn_follow;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test0724 {
	public static void main(String[] args) {
		
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
	    Date date = new Date();  
	    System.out.println(formatter.format(date));
		
		System.out.println(java.time.LocalDateTime.now());  
	}

}
