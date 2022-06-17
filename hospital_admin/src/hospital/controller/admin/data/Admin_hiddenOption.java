package hospital.controller.admin.data;

import static hospital.view.admin.AdminLoaderFactory.ADMIN_MAIN;
import static hospital.view.admin.AdminLoaderFactory.ADMIN_RESERV_INFO;

import java.net.URL;
import java.util.ResourceBundle;

import hospital.controller.admin.Admin_Home;
import hospital.controller.util.Changable;
import hospital.controller.util.Controllers;
import hospital.dao.util.DBHelper;
import hospital.view.admin.AdminLoaderFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Admin_hiddenOption implements Initializable {

	@FXML
	private TextField option_ip_1, option_ip_2, option_ip_3, option_ip_4, option_port, option_db_id, option_db_password, option_db_table;
	private Admin_Home home;
	@FXML Button hiddenOption_complete, hiddenOption_reset, hiddenOption_cancel;

	private Pane main;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		home = AdminLoaderFactory.ADMIN_HOME.getController();		
		
		hiddenOption_complete.setOnAction(e->{
			String ip = option_ip_1.getText() + "." + option_ip_2.getText() + "." + option_ip_3.getText() + "." + option_ip_4.getText();
			String port = option_port.getText();
			String id = option_db_id.getText();
			String pw = option_db_password.getText();
			String table = option_db_table.getText();
			DBHelper.setConnect(ip, port, table, id, pw);
			Controllers.alt("변경 완료", "데이터베이스 정보가 변경되었습니다.", AlertType.CONFIRMATION);
		});
		
		hiddenOption_reset.setOnAction(e->{
			DBHelper.resetConnect();
			Controllers.alt("초기화", "데이터베이스 정보가 초기화되었습니다.", AlertType.CONFIRMATION);
		});
	}
}
