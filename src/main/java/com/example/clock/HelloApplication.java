package com.example.clock;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(final Stage stage) {
        // construct the analogueClock pieces.
        final Circle face = new Circle(100, 100, 100);
        //face.setId("face");
        final Line hourHand = new Line(0, 0, 0, -50);
        hourHand.setTranslateX(100);
        hourHand.setTranslateY(100);
        hourHand.setId("hourHand");
        final Line minuteHand = new Line(0, 0, 0, -75);
        minuteHand.setTranslateX(100);
        minuteHand.setTranslateY(100);
        minuteHand.setId("minuteHand");
        final Line secondHand = new Line(0, 15, 0, -88);
        secondHand.setTranslateX(100);
        secondHand.setTranslateY(100);
        secondHand.setId("secondHand");

        face.setFill(Color.TRANSPARENT);
        final Group analogueClock = new Group(face, hourHand, minuteHand, secondHand);

        HandTransitions.create(hourHand, minuteHand, secondHand);

        stage.initStyle(StageStyle.TRANSPARENT);

        // layout the scene.
        final VBox layout = new VBox();
        layout.getChildren().addAll(analogueClock);
        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(300, 300);
        final Scene scene = new Scene(layout, Color.TRANSPARENT);
        // scene.getStylesheets().add(getResource("clock.css"));
        scene.getStylesheets().add(HelloApplication.class.getResource("clock.css").toString());
        stage.setScene(scene);

        MouseActions mouseActions = new MouseActions();
        mouseActions.init(stage, scene, layout);

        stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("icon.png")));
        // show the scene.
        stage.show();
    }

}