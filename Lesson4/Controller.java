package sample;

import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

import static javafx.scene.input.KeyCode.ENTER;
import static sample.Main.*;

public class Controller{

    // При нажатии кнопки отправки сообщения проверяем, не пустое ли оно и переносим в окно чата
    public void onSendButtonClicked(){
        if (!tf.getText().equals("")) {
            ta.setText(ta.getText().concat("\n").concat(tf.getText()));
            tf.setText("");         // очищаем поле ввода сообщения
            bt.setDisable(true);    // отключаем кнопку отправки сообщения
        }
    }

    // При нажатии клавиши в поле ввода сообщения, проверям, не Enter ли это, и если да - переносим так же, как по кнопке SEND
    public void onKeyPressed(KeyEvent k){
        if (k.getCode()==ENTER) onSendButtonClicked();
        if (!tf.getText().isEmpty()) bt.setDisable(false); // Если сообщение есть, сделай доступной кнопку SEND
    }

    // При выборе пункта меню "Clear Chat", очищаем содержимое окна чата
    public void onClearChat(){
        ta.setText("");
    }

    // При выборе пункта меню "Close", принудительно останавливаем постановку через сохраненную ссылку
    public void onClose(){
        Main.theStage.close();
    }

    // Динамически заполняем текст подсказки и делаем панель с подсказкой видимой
    public void onHelp(){
        ((TextArea) Main.theScene.lookup("#helpContent"))
                .setText("JUST CHAT\nVersion 1.0\nBy Alexey Zimin\n\nGeekBrains JAVA 2 training course");
        Main.theScene.lookup("#helpPane").setVisible(true);
    }

    // При нажатии кнопки "ОК" убираем подсказку, делая ее невидимой
    public void onCloseHelp(){
        Main.theScene.lookup("#helpPane").setVisible(false);
    }

}
