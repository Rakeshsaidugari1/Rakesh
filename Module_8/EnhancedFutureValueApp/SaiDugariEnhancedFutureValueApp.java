import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaiDugariEnhancedFutureValueApp extends Application {
    // initializing text fields
    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();
    private TextArea txtResult = new TextArea();

    // initializing labels
    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblYears = new Label("Years:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");

    private Label lblFutureValueDate= new Label("");

    // initializing combo box
    private ComboBox<Integer> comboBox = new ComboBox<>();
    
    // initializing buttons
    private Button btnCalculate = new Button("Calculate");
    private Button btnClear = new Button("Clear");

    @Override
    public void start(Stage primaryStage) {
        // creating grid pane and setting properties like alignment, paddding etc
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gridPane.setHgap(5.5);
        gridPane.setVgap(5.5);
        
        // adding components to grid pane
        gridPane.add(lblMonthlyPayment, 0, 0);
        gridPane.add(txtMonthlyPayment, 1, 0);
        gridPane.add(lblInterestRate, 0, 1);
        gridPane.add(txtInterestRate, 1, 1);
        gridPane.add(lblYears, 0, 3);
        gridPane.add(comboBox, 1, 3);

        // adding combo box and setting its width
        comboBox.setPrefWidth(147);
        // adding combo box items
        for (int i = 1; i <= 12; i++) {
            comboBox.getItems().add(i);
        }
        gridPane.add(lblFutureValueDate, 0, 5);
        GridPane.setColumnSpan(lblFutureValueDate, 2);
        
        gridPane.add(txtResult, 0, 6);
        GridPane.setColumnSpan(txtResult, 2);
        
        // setting label color to red
        lblInterestRateFormat.setTextFill(Color.RED);
        gridPane.add(lblInterestRateFormat, 1, 2);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);
        
        // creating a actionBtnContainer and adding buttons into the container
        HBox actionBtnContainer = new HBox(10);
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().addAll(btnClear, btnCalculate);
        gridPane.add(actionBtnContainer, 1, 4);

        // creating a scene
        Scene scene = new Scene(gridPane, 280, 350);
        primaryStage.setTitle("Sai Dugari Enhanced Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Setting button actions for clear and calculate
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> calculateResults());
    }

    // method to clear form fields
    private void clearFormFields() {
        txtMonthlyPayment.clear();
        txtInterestRate.clear();
        txtResult.clear();
        lblFutureValueDate.setText("");
        comboBox.setValue(0);
    }

    // method to calculate future value
    private void calculateResults() {
        double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText());
        double rate = Double.parseDouble(txtInterestRate.getText());
        int years = comboBox.getValue();

        // calling calculate future value method from FinanceCalculator class
        double futureValue = FinanceCalculator.calculateFutureValue(monthlyPayment, rate, years);
        String date = getTodayDate();
        lblFutureValueDate.setText("Calculation as of " + date); 

        // formatting future value
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        String formattedFutureValue = formatter.format(futureValue);
        txtResult.setText("The future value is $" + formattedFutureValue);
        
    }

    // method to get today's date
    private String getTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
