import org.nikkii.alertify4j.Alertify;
import org.nikkii.alertify4j.AlertifyBuilder;
import org.nikkii.alertify4j.AlertifyType;
import org.nikkii.*;


public class PmAlert {
	
	String playerName;
	
	public void run() {
		showPmAlert(playerName);
	}
	
	
	public void setName(String playerName) {
		this.playerName = playerName;
	}
	
	
	
	public void showPmAlert(String fromName) {
	/*
	 * Nikki's notification system
	 */
	Alertify.show(new AlertifyBuilder()
    .type(AlertifyType.LOG)
    .text("New PM from " + fromName)
    .autoClose(5000)
    .build());
	
	}

}
