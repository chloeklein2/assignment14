
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderRepeat;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;


public class assignment14 extends Application {
    private TextField value = new TextField();
    private TextField result = new TextField();
    private Button btcalc = new Button ("Calculate");
    public void start(Stage primaryStage){
        HBox pane = new HBox (10);
        pane.setAlignment(Pos.CENTER);
        Button kmtomi= new Button ("km to miles");
        Button mitokm= new Button("miles to km");
        Button lbtokg= new Button("pounds to kg");
        Button ftoc= new Button("Fahrenheit to celcius");
        kmhandlerClass handler1 = new kmhandlerClass();
        kmtomi.setOnAction(handler1);
        mihandlerClass handler2= new mihandlerClass();
        lbtokg.setOnAction(handler2);
        lbhandlerClass handler3= new lbhandlerClass();
        mitokm.setOnAction(handler3);
        

        pane.getChildren().addAll(kmtomi,mitokm);

        


        Scene scene = new Scene(pane);
        primaryStage.setTitle("converter");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
    class kmhandlerClass implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            change(new Stage());
            btcalc.setOnAction(f -> convertkmtomi());
            
            
        }
    }
    class mihandlerClass implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            change(new Stage());
        }
        
    }
    class lbhandlerClass implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            change(new Stage());
        }
    }
    private  void change(Stage newstage){
        GridPane gridPane = new GridPane();
            gridPane.setHgap(5);
            gridPane.setVgap(5);
            gridPane.add( new Label("value to be converted"), 0, 0);
            gridPane.add(value, 1, 0);
            gridPane.add(btcalc, 1, 2);
            gridPane.setAlignment(Pos.CENTER);
            value.setAlignment(Pos.BOTTOM_RIGHT); 
            result.setAlignment(Pos.BOTTOM_RIGHT);
            result.setEditable(false);
            
            GridPane.setHalignment(btcalc, HPos.RIGHT);
            Scene scene = new Scene(gridPane, 400, 250);
            newstage.setTitle("convert");
            newstage.setScene(scene);
            newstage.show();
    }
    private void convertkmtomi(){
         int km = Integer.parseInt(result.getText());
          double r = km/1.609344;
          result.setText(String.format("$.2f", r));
    }
}

    