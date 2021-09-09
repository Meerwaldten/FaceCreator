package com.example.facegenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HelloApplication extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Face");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);

        drawPrimitiveFace();

        stage.show();
    }

    public static void drawPrimitiveFace() {
        boolean randomTal = new Random().nextBoolean();
        boolean randomTal2 = new Random().nextBoolean();


        drawShape();
        drawMouth(randomTal2);
        drawEyes(randomTal);
        drawNose();
        drawBrows();
    }

    public static void drawShape() {
        gc.setFill(Color.rgb(255,220,177));
        gc.fillOval(150, 150, 300, 300);
    }

    public static void drawMouth(boolean mouthSize) {
        gc.setFill(Color.BLACK);
        if (mouthSize==true){
            gc.fillArc(250, 300, 100, 100, 180, 180, ArcType.ROUND);
            //gc.fillOval(280,370,mouthSize,mouthSize);
        }
        else {
            gc.fillArc(250, 320, 100, 100, 0, 180, ArcType.ROUND);
        }
    }

    public static void drawEyes(boolean blink) {
        gc.setFill(Color.color(Math.random(),Math.random(), Math.random()));
        if (blink==true) {
            gc.fillOval(220, 220, 30, 30);
            gc.fillOval(360, 220, 30, 30);
        }
        else {
            gc.fillRect(220, 220, 30, 10);
            gc.fillOval(360, 220, 30, 30);
        }
    }

    public static void drawNose() {
        gc.setFill(Color.BLACK);
        gc.fillOval(315, 300, 10,10);
        gc.fillOval(285,300,10,10);
    }

    public static void drawBrows() {
        gc.setLineWidth(5);
        gc.setLineCap(StrokeLineCap.ROUND);
        gc.setFill(Color.BLACK);
        gc.strokeLine(220,200,250,190);
        gc.strokeLine(360,200,390,210);

        //gc.fillRect(220, 200, 30,10);
        //gc.fillRect(360,200,30,10);

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        System.out.println("Welcome to the face generator.\n Please type in 'noget'");
        String firstInput = scanner.nextLine();
        System.out.println(firstInput);
        System.out.println("Please type if you want the face to blink or not.");
        Boolean blink = scanner.nextBoolean();
        */


        launch();
    }
}