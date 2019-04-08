package client;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

import static client.Client.*;

public class Controller{

    @FXML
    public void onSendButtonClicked(){
        if (!tf.getText().equals("")) {
            try {
                out.writeUTF(tf.getText());
                bt.setDisable(true);
                tf.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void onKeyPressed(KeyEvent k){
        switch(k.getCode()){
            case ENTER:{
                onSendButtonClicked();
                break;
            }
            default: bt.setDisable(false);
        }
    }

    @FXML
    public void onClearChat(){
        ta.setText("");
    }

    public void onClose(){
        System.out.println("Обрабатывается закрытие программы по запросу пользователя.");
        Client.theStage.close();
        mustStop = true;
    }

    public void onHelp(){
        TitledPane p = (TitledPane) Client.theScene.lookup("#helpPane");
        TextArea t = (TextArea) Client.theScene.lookup("#helpContent");
        t.setText("JUST CHAT Client\nVersion 1.0\nBy Alexey Zimin\n\nGeekBrains JAVA 2 training course");
        p.setVisible(true);
    }

    public void onCloseHelp(){
        System.out.println("Закрываю помощь...");
        TitledPane p = (TitledPane) Client.theScene.lookup("#helpPane");
        p.setVisible(false);
    }

}
