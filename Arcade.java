import javafx.scene.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.animation.PathTransition; 
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.scene.shape.*;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.geometry.*;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.image.*;
import javafx.geometry.*;


public class Arcade extends Application{
	@Override
	public void start(Stage primaryStage){
		
		double winPoints = Points.getPoints();
		
		BorderPane pane = new BorderPane();
		
		Pane center = new Pane();
		
		HBox top = new HBox(10);
		top.setAlignment(Pos.CENTER);
		top.setStyle("-fx-background-color: Tan;");
		
		VBox left = new VBox(10);
		left.setAlignment(Pos.TOP_CENTER);
		left.setStyle("-fx-background-color: Tan;");
		
		VBox right = new VBox(25);
		right.setAlignment(Pos.TOP_CENTER);
		right.setStyle("-fx-background-color: Tan;");
		
		HBox bottom = new HBox(10);
		bottom.setAlignment(Pos.CENTER);
		bottom.setStyle("-fx-background-color: Tan;");
		
		pane.setTop(top);
		pane.setLeft(left);
		pane.setCenter(center);
		pane.setRight(right);
		pane.setBottom(bottom);
		
		Scene scene = new Scene(pane, 1280, 800);
		
	
//Objects______________________________________________________________
		
		ImageView background = new ImageView("background.jpg");
		center.getChildren().add(background);
		
		ImageView targetImage = new ImageView("soldier.jpg");
		targetImage.setFitWidth(50);
		targetImage.setFitHeight(75);
		
		ImageView targetImage2 = new ImageView("soldier.jpg");
		targetImage2.setFitWidth(50);
		targetImage2.setFitHeight(75);
		
		Label stage = new Label("Stage 1");
		stage.setStyle("-fx-font-size: 26");
		stage.setAlignment(Pos.CENTER);
		
		Label instruct = new Label("Please click the start button to drop soldiers");
		instruct.setStyle("-fx-font-size: 26");
		
		TextField points = new TextField();
		points.setPrefHeight(30);
		points.setPrefWidth(100);
		points.setText("0");
		points.setEditable(false);
		left.getChildren().add(points);
		
		Label hit = new Label("Hit!");
		hit.setStyle("-fx-background-color: Red;" + "-fx-text-fill: Black; -fx-font-size: 26");
		
		Label win = new Label("YOU WIN!");
		win.setLayoutX(400);
		win.setLayoutY(200);
		win.setStyle("-fx-background-color: Yellow; -fx-text-fill: Black; -fx-font-size: 40");
		
		Rectangle winRec = new Rectangle(10, 10, 400, 400);
		winRec.setFill(Color.YELLOW);
		winRec.setStroke(Color.BLACK);
		winRec.setLayoutX(550);
		winRec.setLayoutY(250);
		
		Label hit2 = new Label("Hit!");
		hit2.setStyle("-fx-background-color: Red;" + "-fx-text-fill: Black; -fx-font-size: 26");
		
		Button start = new Button("Start");
		start.setStyle("-fx-background-color: Yellow");
		start.setPrefWidth(100);
		start.setPrefHeight(100);
		start.setLayoutX(600);
		start.setLayoutY(50);
		
		Button target = new Button("", targetImage);
		target.setBackground(null);
		target.setPrefWidth(50);
		target.setPrefHeight(75);
		target.setLayoutX(50);
		target.setLayoutY(50);
		
		Button target2 = new Button("", targetImage2);
		target2.setBackground(null);
		target2.setPrefWidth(50);
		target2.setPrefHeight(75);
		target2.setLayoutX(50);
		target2.setLayoutY(50);
		
		right.getChildren().add(start);
		top.getChildren().add(instruct);
		bottom.getChildren().add(stage);
		
//Controls_________________________________________________________________________________________________________________	
		start.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				right.getChildren().remove(hit);
				right.getChildren().remove(hit2);
			
				double totalPoints = Points.getPoints();
		double a = Math.random() * 750;
		double b = Math.random() * 80;
		double c = Math.random() * 800 + 800;
		double d = Math.random() * 800 + 800;
		
		double i = Math.random() * 750;
		double f = Math.random() * 80;
		double g = Math.random() * 800 + 800;
		double h = Math.random() * 800 + 800;
		
		Line line1 = new Line(a, b, c, d);
		line1.setStroke(Color.TRANSPARENT);
		
		Line line2 = new Line(i, f, g, h);
		line2.setStroke(Color.TRANSPARENT);
		
		PathTransition pt = new PathTransition(); 
 		pt.setDuration(Duration.millis(10000));
 		if( totalPoints >= 100){
 			stage.setText("Stage 2");
 			pt.setDuration(Duration.millis(8000));
 		}
 		if( totalPoints >= 200){
 			stage.setText("Stage 3");
 			pt.setDuration(Duration.millis(6000));
 		}
 		if( totalPoints >= 300){
 			stage.setText("Stage 4");
 			pt.setDuration(Duration.millis(5000));
 		}
 		pt.setPath(line1); 
 		pt.setNode(target);
 		pt.setOrientation(PathTransition.OrientationType.NONE); 
 		pt.setCycleCount(1);  // 
 		pt.setAutoReverse(false); 
 		pt.play();
 		
 		PathTransition pt2 = new PathTransition(); 
 		pt2.setDuration(Duration.millis(10000));
 		if( totalPoints >= 100){
 			pt2.setDuration(Duration.millis(8000));
 		}
 		if( totalPoints >= 200){
 			pt2.setDuration(Duration.millis(6000));
 		}
 		if( totalPoints >= 300){
 			pt2.setDuration(Duration.millis(5000));
 		}
 		pt2.setPath(line2); 
 		pt2.setNode(target2);
 		pt2.setOrientation(PathTransition.OrientationType.NONE); 
 		pt2.setCycleCount(1);  // 
 		pt2.setAutoReverse(false); 
 		pt2.play();
 		
 		center.getChildren().add(target2);
 		center.getChildren().add(target);
 		
 		if(totalPoints >= 400){
			
			center.getChildren().removeAll(target, target2, background);
			center.setStyle("-fx-background-color: Black");
			center.getChildren().addAll(win);
		}
			}
		});
		
		target.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent a){
				right.getChildren().add(hit);
				Points.getPoints();
				double newPoints = Points.addPoints();
				points.setText("" + newPoints);
				center.getChildren().remove(target);
			}
		});
		
		target2.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent a){
				right.getChildren().add(hit2);
				Points.getPoints();
				double newPoints = Points.addPoints();
				points.setText("" + newPoints);
				center.getChildren().remove(target2);
			}
		});
		
		center.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e){
				scene.setCursor(Cursor.CROSSHAIR);
			}
		});
		
		center.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e){
				scene.setCursor(Cursor.DEFAULT);
			}
		});
		
		primaryStage.setTitle("Vending machine GUI");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args){
		Application.launch(args);
		
	
}
}

