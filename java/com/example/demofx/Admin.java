package com.example.demofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Admin extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        // HEADER
        HBox header = new HBox();
        header.setStyle("-fx-padding: 10px; -fx-background-color: #f5f5f5; -fx-border-width: 0 0 1 0; -fx-border-color: #ccc;");
        header.setSpacing(20);
        header.setAlignment(Pos.CENTER_LEFT);

        // Logo y título
        ImageView logoImage = new ImageView(new Image(getClass().getResource("/images/logoWP.png").toExternalForm()));
        logoImage.setPreserveRatio(true);
        logoImage.setFitHeight(50);

        Label title = new Label("INMORTEM");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Botón de Logout
        ImageView userImage = new ImageView(new Image(getClass().getResource("/images/logout.png").toExternalForm()));
        userImage.setPreserveRatio(true);
        userImage.setFitHeight(25);
        userImage.setOnMouseClicked(event -> System.out.println("Botón de salir clickeado."));

        // Espaciador flexible para alinear el logout a la derecha
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Agregar componentes al header
        header.getChildren().addAll(logoImage, title, spacer, userImage);
        root.setTop(header);

        // LEFT SECTION
        VBox leftPane = new VBox(20);
        leftPane.setPadding(new Insets(20));
        leftPane.setAlignment(Pos.TOP_LEFT);

        Button addButton = new Button("Agregar");
        addButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 50px; -fx-font-size: 14px;");

        leftPane.getChildren().addAll(addButton);

        // CENTER SECTION
        VBox centerPane = new VBox(20);
        centerPane.setPadding(new Insets(20));

        GridPane causesGrid = new GridPane();
        causesGrid.setVgap(10);
        causesGrid.setHgap(10);
        causesGrid.setPadding(new Insets(10));

        // Agregar filas de "Causa"
        for (int i = 1; i <= 5; i++) {
            Label causaLabel = new Label("Causa " + i);
            causaLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

            Button modificarInfoButton = new Button("Modificar Información");
            modificarInfoButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 50px; -fx-font-size: 12px;");

            Button modificarGraficasButton = new Button("Modificar Gráficas");
            modificarGraficasButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 50px; -fx-font-size: 12px;");

            Button eliminarButton = new Button("Eliminar");
            eliminarButton.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-background-radius: 50px; -fx-font-size: 12px;");

            causesGrid.add(causaLabel, 0, i - 1);
            causesGrid.add(modificarInfoButton, 1, i - 1);
            causesGrid.add(modificarGraficasButton, 2, i - 1);
            causesGrid.add(eliminarButton, 3, i - 1);
        }

        centerPane.getChildren().add(causesGrid);
        root.setCenter(centerPane);

        // FOOTER
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(10));
        footer.setStyle("-fx-background-color: #f5f5f5;");
        Label footerLabel = new Label("Opciones administrador");
        footerLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: gray;");
        footer.getChildren().add(footerLabel);
        root.setBottom(footer);

        // Escena
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Interfaz Administrador");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}