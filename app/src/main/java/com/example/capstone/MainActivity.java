package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /**
     * Setting GLobal Variable
     */

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked
     */
    public void sumbitOrder(View view) {
        //Get text form the EditText XML
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        Log.v("MainActivity", "Name: " + name);

        //Figure out if user wants their PC cleaned
        CheckBox pc_clean_checkbox = (CheckBox) findViewById(R.id.pc_clean_checkbox);
        boolean hasPcCleaned = pc_clean_checkbox.isChecked();
        Log.v("MainActivity", "PC Clean: " + hasPcCleaned);

        //Figure out if user wants their thermal paste changed
        CheckBox thermal_paste_checkbox = (CheckBox) findViewById(R.id.thermal_paste_checkbox);
        boolean thermalPasteChange = thermal_paste_checkbox.isChecked();
        Log.v("MainActivity", "Thermal Paste Change: " + thermalPasteChange);

        //Figure out if user wants their CPU changed
        CheckBox cpu_change_checkbox = (CheckBox) findViewById(R.id.cpu_change_checkbox);
        boolean cpuChange = cpu_change_checkbox.isChecked();
        Log.v("MainActivity", "CPU Change: " + cpuChange);

        //Figure out if user wants their GPU changed
        CheckBox gpu_change_checkbox = (CheckBox) findViewById(R.id.gpu_change_checkbox);
        boolean gpuChange = gpu_change_checkbox.isChecked();
        Log.v("MainActivity", "GPU Change: " + gpuChange);

        // Calculates Price
        int price = calculatePrice(hasPcCleaned, thermalPasteChange, cpuChange, gpuChange);

        // Display the order summary on the screen
        String priceMessage = createOrderSummary(name, price, hasPcCleaned, thermalPasteChange, cpuChange, gpuChange);
        displayMessage(priceMessage);

        displayMessage(priceMessage);

    }

    /**
     * Calculates the price of the order
     *
     * @param hasPcCleaned
     * @param thermalPasteChange
     * @param cpuChange
     * @param gpuChange
     *
     */
    private int calculatePrice(Boolean hasPcCleaned, boolean thermalPasteChange, boolean cpuChange, boolean gpuChange) {
        int basePrice = 20;

        //Add $10 if the user wants PC Cleaned
        if (hasPcCleaned) {
            basePrice = basePrice + 10;
        }

        //Add $15 if user wants thermal paste changed
        if (thermalPasteChange) {
            basePrice = basePrice + 15;
        }

        //add $20 if user wants CPU Changed
        if (cpuChange) {
            basePrice = basePrice + 20;
        }

        //add $15 if user wants GPU changed
        if (gpuChange) {
            basePrice = basePrice + 15;
        }

        // Calculates the total order price by multiplying by quantity
        return quantity + basePrice;

    }


    /**
     * Create a summary of our order
     *
     * @param name of the customer
     * @param price of the order
     * @param hasPcCleaned
     * @param thermalPasteChange
     * @param cpuChange
     * @param gpuChange
     * @return priceMessage
     */
private String createOrderSummary(String name, int price, Boolean hasPcCleaned, boolean thermalPasteChange, boolean cpuChange, boolean gpuChange) {

    String priceMessage = "Name: " + name;
    priceMessage += "\nThank you for ordering " + quantity + " Coffees!";  //I used the escape key \n to put info on a new line
    priceMessage += "\nPC Cleaned For $10? " + hasPcCleaned;
    priceMessage += "\nThermal Paste Changed For %15? " + thermalPasteChange;
    priceMessage += "\nCPU Changed For $20? " + cpuChange;
    priceMessage += "\nGPU Changed For $15? " + gpuChange;
    priceMessage += "\nAmount Due: $" + price;
    priceMessage += "\n\nWe Will Get To Your Order As Soon As Possible"; //Double \n escape key for w line separation
    return priceMessage;

    /**
     * This method displays the given quantity value on the screen
     */

    private void displayQuantity(int ) {

    }
}





}