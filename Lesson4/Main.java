package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage theStage;  // Основной объект JavaFX-проекта - "Постановка"
    static Scene theScene;  // Сцена - основное пространство отображения контента
    static TextArea ta;     // Основное окно чата. Сделано package-private для доступа из контроллера
    static TextField tf;    // Полеввода сообщения. Сделано package-private для доступа из контроллера
    static Button bt;       // Кнопка отправки сообщения. Сделано package-private для доступа из контроллера

    @Override
    // Метод запускается автоматически при старте JavaFX-приложения
    public void start(Stage primaryStage) throws Exception{
        theStage = primaryStage; // сохраняем созданную постановку для возможного принудительно закрытия из контроллера
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); // загружаем макет приложения
        theScene = new Scene(root, 300, 500); // выводим на сцену загруженный макет
        primaryStage.setTitle("Just Chat"); // выносим название приложения в заголовок окна
        primaryStage.setScene(theScene); // делаем сцену главной в нашей постановке
        primaryStage.show(); // открываем занавес

        tf = (TextField) theScene.lookup("#messageField"); // для прямого доступа сохраняем ссылку на поле ввода сообщения
        ta = (TextArea) theScene.lookup("#chatWindow"); // для прямого доступа сохраняем ссылку на окно чата
        bt = (Button) theScene.lookup("#sendButton"); // для прямого доступа сохраняем ссылку на кнопку отправки сообщения

        // Если вдруг не нашли один из визуальных элементов, нужно прекратить работу приложения
        if (tf==null || ta==null || bt==null){
            System.out.println("Не смог обнаружить один из необходимых визуальных элементов на сцене!");
            stop();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
