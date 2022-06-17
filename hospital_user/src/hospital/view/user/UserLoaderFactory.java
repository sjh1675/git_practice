package hospital.view.user;

import java.io.IOException;

import hospital.controller.util.Changable;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


public enum UserLoaderFactory {
	USER_HOME("/hospital/view/user/user_Home.fxml"),
	USER_CHAT("/hospital/view/user/user_Chat.fxml"),
	USER_DOCTOR("/hospital/view/user/user_Doctor.fxml"),
	USER_EDIT("/hospital/view/user/user_Edit.fxml"),
	USER_JOIN("/hospital/view/user/user_Join.fxml"),
	USER_LOGIN("/hospital/view/user/user_Login.fxml"),
	USER_MAIN("/hospital/view/user/user_Main.fxml"),
	USER_PWCHK("/hospital/view/user/user_PwChk.fxml"),
	USER_RESERV("/hospital/view/user/user_Reserv.fxml"),
	USER_ROUTE("/hospital/view/user/user_Route.fxml"),
	USER_OPTION("/hospital/view/user/user_hiddenOption.fxml");
	
	public final FXMLLoader loader;
	
	UserLoaderFactory(String text) {
		this.loader = new FXMLLoader(getClass().getResource(text));
	};
	
	public <T extends Pane> T getScreen() {
		T result = null;
		try { result = loader.load(); } 
		catch (IOException e) {	e.printStackTrace(); }
		return result;
	}
	
	public <T> T getController() { return loader.getController(); }
	
	public <T extends Changable> T get(){ return loader.getController(); }
	
}
