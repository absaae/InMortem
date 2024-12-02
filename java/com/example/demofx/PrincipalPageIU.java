package com.example.demofx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrincipalPageIU extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        HBox topBox = new HBox();
        topBox.setStyle("-fx-padding: 10px; -fx-background-color: #f5f5f5; -fx-border-width: 0 0 1 0; -fx-border-color: #ccc;");
        topBox.setAlignment(Pos.CENTER);
        topBox.setSpacing(600);

        HBox leftBox = new HBox(10);
        leftBox.setAlignment(Pos.CENTER_LEFT);

        ImageView leftImage = new ImageView(new Image(getClass().getResource("/images/logoWP.png").toExternalForm()));
        leftImage.setPreserveRatio(true);
        leftImage.setFitHeight(50);

        Label nameLabel = new Label("InMortem");
        nameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        leftBox.getChildren().addAll(leftImage, nameLabel);


        ImageView rightImage = new ImageView(new Image(getClass().getResource("/images/user.png").toExternalForm()));
        rightImage.setPreserveRatio(true);
        rightImage.setFitHeight(25);
        rightImage.setOnMouseClicked(event -> System.out.println("Perfil de usuario clickeado."));

        topBox.getChildren().addAll(leftBox, rightImage);
        root.setTop(topBox);

        VBox centerBox = new VBox(20);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setStyle("-fx-padding: 20px;");

        Label title = new Label("Causas de mortalidad en México");
        title.setStyle("-fx-font-size: 45px; -fx-font-weight: bold;");
        Label description = new Label(
                "Descripción: Aquí se muestra información general sobre las estadísticas de mortalidad en México. "
                        + "Explora las causas para encontrar gráficas, utiliza la calculadora de riesgo o contacta a los especialistas para más información.");
        description.setWrapText(true);
        description.setMaxWidth(550);
        description.setStyle("-fx-font-size: 16px;");

        HBox botonesCausas = new HBox(20);
        botonesCausas.setAlignment(Pos.CENTER);
        for (int i = 1; i <= 5; i++) {
            final int causaIndex = i;
            Button btnCausa = new Button("Causa " + causaIndex);
            btnCausa.setPrefSize(100, 80);
            btnCausa.setStyle("-fx-background-radius: 15; -fx-font-size: 14px;");
            btnCausa.setOnAction(event -> System.out.println("Botón Causa " + causaIndex + " presionado."));
            botonesCausas.getChildren().add(btnCausa);
        }

        centerBox.getChildren().addAll(title, description, botonesCausas);
        root.setCenter(centerBox);

        HBox footerBox = new HBox(50);
        footerBox.setAlignment(Pos.CENTER);
        footerBox.setStyle("-fx-padding: 10px; -fx-background-color: #c3b4a4;");

        for (int i = 1; i <= 5; i++) {
            final int doctorIndex = i;
            Button btnDoctor = new Button("Doctor " + doctorIndex);
            btnDoctor.setPrefSize(100, 50);
            btnDoctor.setStyle("-fx-background-radius: 15; -fx-font-size: 14px;");
            btnDoctor.setOnAction(event -> System.out.println("Contactando al Doctor " + doctorIndex + "..."));
            footerBox.getChildren().add(btnDoctor);
        }

        root.setBottom(footerBox);

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Página Principal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
