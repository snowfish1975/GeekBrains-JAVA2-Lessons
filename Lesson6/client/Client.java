package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Application {

    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private Socket socket;


    static Scene theScene;
    static Stage theStage;

    static TextArea ta;
    static TextField tf;
    static Button bt;

    public static String strFromServer;
    public static DataInputStream in;
    public static DataOutputStream out;
    public static boolean mustStop = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        theStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Just Chat CLIENT");
        theScene = new Scene(root, 300, 500);
        primaryStage.setScene(theScene);
        primaryStage.show();

        tf = (TextField) theScene.lookup("#messageField");
        ta = (TextArea) theScene.lookup("#chatWindow");
        bt = (Button) theScene.lookup("#sendButton");
        if (tf == null || ta == null || bt == null) {
            System.out.println("Не смог обнаружить один из необходимых визуальных элементов на сцене!");
            stop();
        }

        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        System.out.print("Created socket: ");
        System.out.println(socket);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                while (!mustStop) {
                strFromServer = in.readUTF();
                if (strFromServer.equalsIgnoreCase("/end")) {
                    closeConnection();
                    mustStop = true;
                    break;
                }
                ta.appendText(  strFromServer+"\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
