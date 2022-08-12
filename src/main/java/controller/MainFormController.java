package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.w3c.dom.html.HTMLBodyElement;

import java.io.*;
import java.net.URL;
import java.util.Arrays;

public class MainFormController {


    public HTMLEditor txtEditor;
    public MenuItem mnuNew;
    public MenuItem mnuOpen;
    public MenuItem mnuSave;
    public MenuItem mnuPrint;
    public MenuItem mnuClose;
    public MenuItem mnuCut;
    public MenuItem mnuCopy;
    public MenuItem mnuPaste;
    public MenuItem mnuSelectAll;
    public MenuItem mnuAbout;
    private File srcFile;
    private File srcDes;


    public void mnuNewOnAction(ActionEvent actionEvent) {
        txtEditor.setHtmlText("");
    }

    public void mnuOpenOnAction(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser(); //created a new object from FileChooser
        fileChooser.setInitialDirectory(new File("/home/nipunperera/Desktop")); //Set initial directory as Desktop
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("all files (*.*)","*.*")); // set extensions as txt

        srcFile = fileChooser.showOpenDialog(txtEditor.getScene().getWindow()); // get the memory location of 

        FileInputStream fis = new FileInputStream(srcFile);
        int [] readings = new int[(int) srcFile.length()];
        for(int i=0; i< srcFile.length();i++){
            int read = fis.read();
            readings[i] = read;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for(int eachByte : readings){
            stringBuilder.append((char)eachByte);
        }

        txtEditor.setHtmlText(String.valueOf(stringBuilder));
        fis.close();
    }

    public void mnuSaveOnAction(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("/home/nipunperera/Desktop"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("dep9 files (*.dep9)", "*.dep9"));

        srcDes = fileChooser.showSaveDialog(txtEditor.getScene().getWindow());


        FileOutputStream fos = new FileOutputStream(String.valueOf(srcDes));
        byte[] byteBuffer = txtEditor.getHtmlText().getBytes();
        for(int i=0 ; i< byteBuffer.length;i++){
            fos.write((char)byteBuffer[i]);
        }
        fos.close();


    }

    public void mnuPrintOnAction(ActionEvent actionEvent) {
    }

    public void mnuCloseOnAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void mnuCutOnAction(ActionEvent actionEvent) {
    }

    public void mnuCopyOnAction(ActionEvent actionEvent) {
    }

    public void mnuPasteOnAction(ActionEvent actionEvent) {
    }

    public void mnuSelectOnAction(ActionEvent actionEvent) {
    }

    public void mnuAboutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/AboutForm.fxml");
        Parent container = FXMLLoader.load(resource);
        Scene scene = new Scene(container);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("About The Text Editor");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        stage.centerOnScreen();
    }
}
