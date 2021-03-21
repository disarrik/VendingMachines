package com.example.vendingmachines;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView VendingMachineName1;
    TextView VendingMachineStatus1;
    TextView VendingMachineStudent1;
    TextView VendingMachineProductsList1;

    TextView VendingMachineName2;
    TextView VendingMachineStatus2;
    TextView VendingMachineStudent2;
    TextView VendingMachineProductsList2;

    TextView VendingMachineName3;
    TextView VendingMachineStatus3;
    TextView VendingMachineStudent3;
    TextView VendingMachineProductsList3;

    TextView VendingMachineName4;
    TextView VendingMachineStatus4;
    TextView VendingMachineStudent4;
    TextView VendingMachineProductsList4;

    Spinner chooseProduct;
    Spinner chooseVendingMachine;
    EditText AmountOfProducts;
    Button add;
    Button generateStudents;

    ArrayList<Student> studentGroup1;
    ArrayList<Student> studentGroup2;
    ArrayList<Student> studentGroup3;
    ArrayList<Student> studentGroup4;

    VendingMachine vendingMachine1;
    VendingMachine vendingMachine2;
    VendingMachine vendingMachine3;
    VendingMachine vendingMachine4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Инициализация виджетов
        VendingMachineName1 = findViewById(R.id.VendingMachineName1);
        VendingMachineStatus1 = findViewById(R.id.VendingMachineStatus1);
        VendingMachineStudent1 = findViewById(R.id.VendingMachineStudent1);
        VendingMachineProductsList1 = findViewById(R.id.VendingMachineProductsList1);
        VendingMachineName2 = findViewById(R.id.VendingMachineName2);
        VendingMachineStatus2 = findViewById(R.id.VendingMachineStatus2);
        VendingMachineStudent2 = findViewById(R.id.VendingMachineStudent2);
        VendingMachineProductsList2 = findViewById(R.id.VendingMachineProductsList2);
        VendingMachineName3 = findViewById(R.id.VendingMachineName3);
        VendingMachineStatus3 = findViewById(R.id.VendingMachineStatus3);
        VendingMachineStudent3 = findViewById(R.id.VendingMachineStudent3);
        VendingMachineProductsList3 = findViewById(R.id.VendingMachineProductsList3);
        VendingMachineName4 = findViewById(R.id.VendingMachineName4);
        VendingMachineStatus4 = findViewById(R.id.VendingMachineStatus4);
        VendingMachineStudent4 = findViewById(R.id.VendingMachineStudent4);
        VendingMachineProductsList4 = findViewById(R.id.VendingMachineProductsList4);
        chooseProduct = findViewById(R.id.chooseProduct);
        chooseVendingMachine = findViewById(R.id.chooseVendingMachine);
        AmountOfProducts = findViewById(R.id.AmountOfProducts);
        add = findViewById(R.id.add);
        generateStudents = findViewById(R.id.generateStudents);

        //инициализация групп студентов на рандом
        studentGroup1 = new ArrayList<Student>();
        studentGroup2 = new ArrayList<Student>();
        studentGroup3 = new ArrayList<Student>();
        studentGroup4 = new ArrayList<Student>();
        for (int i = 0; i < 20; i++) {
            int randNum = (int) ((Math.random() * 100) % 4);
            switch (randNum) {
                case 0:
                    studentGroup1.add(new Student((int) (Math.random() * 100), 100 + (int) (Math.random() * 100)));
                    break;
                case 1:
                    studentGroup2.add(new Student((int) (Math.random() * 100), 100 + (int) (Math.random() * 100)));
                    break;
                case 2:
                    studentGroup3.add(new Student((int) (Math.random() * 100), 100 + (int) (Math.random() * 100)));
                    break;
                case 3:
                    studentGroup4.add(new Student((int) (Math.random() * 100), 100 + (int) (Math.random() * 100)));
                    break;
            }
        }

        //инициализация автоматов
        vendingMachine1 = new VendingMachine("1");
        vendingMachine2 = new VendingMachine("2");
        vendingMachine3 = new VendingMachine("3");
        vendingMachine4 = new VendingMachine("4");
    }
}