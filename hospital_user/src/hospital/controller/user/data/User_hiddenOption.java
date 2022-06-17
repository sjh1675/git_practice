package hospital.controller.user.data;

import static hospital.view.user.UserLoaderFactory.USER_HOME;

import java.net.URL;
import java.util.ResourceBundle;

import hospital.controller.user.User_Home;
import hospital.controller.util.Changable;
import hospital.controller.util.Controllers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class User_hiddenOption implements Initializable, Changable {

	@FXML private TextField option_ip_1, option_ip_2, option_ip_3, option_ip_4, option_port;
	@FXML private Button option_change;
	
	private User_Home homeCont = USER_HOME.getController();
	private Pane main;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		option_change.setOnAction(e -> {			
			String ip = option_ip_1.getText() + "." + option_ip_2.getText() + "." + option_ip_3.getText() + "." + option_ip_4.getText();
			int port = Integer.parseInt(option_port.getText());	
			homeCont.helper.stopClient();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			homeCont.helper.startClient(ip, port);
		});
	}
	
	@Override
	public void loadView() {
		main = homeCont.getMain();
	}
}
