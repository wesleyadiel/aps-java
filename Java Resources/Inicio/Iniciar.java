package Inicio;

	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Iniciar extends Application {
	
	public static Stage stage = new Stage();
	
	@SuppressWarnings("static-access")
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../fxml/InicioFxml.fxml"));
			this.stage.setScene(new Scene(root));
			new Conexao();
			this.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
