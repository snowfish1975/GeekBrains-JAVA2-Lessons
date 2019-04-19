package server;

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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server extends Application {

    static Scene theScene;
    static Stage theStage;

    static TextArea ta;
    static TextField tf;
    static Button bt;

    public static ServerSocket serverSocket;
    public static DataInputStream in;
    public static List<Socket> incomeCalls = new LinkedList<>();
    public static boolean mustStop = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        theStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Just Chat SERVER");
        theScene = new Scene(root, 300, 500);
        theStage.setScene(theScene);
        theStage.show();

        tf = (TextField) theScene.lookup("#messageField");
        ta = (TextArea) theScene.lookup("#chatWindow");
        bt = (Button) theScene.lookup("#sendButton");
        if (tf == null || ta == null || bt == null) {
            System.out.println("Не смог обнаружить один из необходимых визуальных элементов на сцене!");
            stop();
        }

        incomeCalls.clear();
        new Thread(() -> {
            ta.appendText("Сервер запущен, ожидаем подключения..." + "\n");
            try {
                serverSocket = new ServerSocket(8189);
                Socket socket = serverSocket.accept();
                incomeCalls.add(socket);
                ta.appendText("Клиент подключился: " + socket + "\n");
                ta.appendText("Всего на связи " + incomeCalls.size() + " клиентов.\n");
                in = new DataInputStream(socket.getInputStream());
                ta.appendText("Входящий поток создан." + "\n");

                while (!mustStop) {
                    ta.appendText("Ожидание сообщений от клиента..." + "\n");
                    String str = in.readUTF();
                    if (str.equals("/end")) {
                        ta.appendText("Клиент разорвал соединение.");
                        socket.close();
                        break;
                    }
                    ta.appendText("КЛИЕНТ: " + str + "\n");
                    broadcast(str);
                }
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void broadcast(String str) {
        try {
            for (Socket s : incomeCalls) {
                new DataOutputStream(s.getOutputStream()).writeUTF(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}
