package com.example.vendingmachines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.vendingmachines.fabricsforproducts.CocaColaFabric;
import com.example.vendingmachines.fabricsforproducts.IFabricForProduct;
import com.example.vendingmachines.fabricsforproducts.LaysFabric;
import com.example.vendingmachines.fabricsforproducts.SnickersFabric;
import com.example.vendingmachines.fabricsforproducts.TwixFabric;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {


    Spinner chooseProduct;
    Spinner chooseVendingMachine;
    EditText AmountOfProducts;
    Button add;
    Button generateStudents;

    VendingMachineFragment fragment1 = VendingMachineFragment.newInstance();
    VendingMachineFragment fragment2 = VendingMachineFragment.newInstance();
    VendingMachineFragment fragment3 = VendingMachineFragment.newInstance();
    VendingMachineFragment fragment4 = VendingMachineFragment.newInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //инициализация групп студентов на рандом
        ArrayList<Student> studentGroup1;
        ArrayList<Student> studentGroup2;
        ArrayList<Student> studentGroup3;
        ArrayList<Student> studentGroup4;
        studentGroup1 = new ArrayList<Student>();
        studentGroup2 = new ArrayList<Student>();
        studentGroup3 = new ArrayList<Student>();
        studentGroup4 = new ArrayList<Student>();
        for (int i = 0; i < 20; i++) {
            int randNum = (int) ((Math.random() * 100) % 4);
            switch (randNum) {
                case 0:
                    studentGroup1.add(new Student(i, 300 + (int) (Math.random() * 100)));
                    break;
                case 1:
                    studentGroup2.add(new Student(i, 300 + (int) (Math.random() * 100)));
                    break;
                case 2:
                    studentGroup3.add(new Student(i, 300 + (int) (Math.random() * 100)));
                    break;
                case 3:
                    studentGroup4.add(new Student(i, 300 + (int) (Math.random() * 100)));
                    break;
            }
        }

        //инициализация автоматов и запись их имен в соответсвующие виджеты текста
        VendingMachine vendingMachine1;
        VendingMachine vendingMachine2;
        VendingMachine vendingMachine3;
        VendingMachine vendingMachine4;
        vendingMachine1 = new VendingMachine("1");
        vendingMachine1.setQueue(studentGroup1);
        vendingMachine2 = new VendingMachine("2");
        vendingMachine2.setQueue(studentGroup2);
        vendingMachine3 = new VendingMachine("3");
        vendingMachine3.setQueue(studentGroup3);
        vendingMachine4 = new VendingMachine("4");
        vendingMachine4.setQueue(studentGroup4);

        //инициализация фрагментов
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.fragmentContainer1, fragment1);
        transaction.add(R.id.fragmentContainer2, fragment2);
        transaction.add(R.id.fragmentContainer3, fragment3);
        transaction.add(R.id.fragmentContainer4, fragment4);
        transaction.commit();

        //создание выпадающего меню с продуктами
        chooseProduct = findViewById(R.id.chooseProduct);
        String[] products = {"CocaCola", "Lays", "Snickers", "Twix"};
        ArrayAdapter<String> adapterProducts = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, products);
        adapterProducts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chooseProduct.setAdapter(adapterProducts);

        //создание выпадающего меню с автоматами
        chooseVendingMachine = findViewById(R.id.chooseVendingMachine);
        String[] machines = {"1", "2", "3", "4"};
        ArrayAdapter<String> adapterMachines = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, machines);
        adapterMachines.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chooseVendingMachine.setAdapter(adapterMachines);

        AmountOfProducts = findViewById(R.id.AmountOfProducts);

        //создание кнопки добавления продуктов
        add = (Button) findViewById(R.id.addProducts);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IFabricForProduct fabric = new CocaColaFabric();
                switch (chooseProduct.getSelectedItem().toString()) {
                    case "CocaCola":
                        fabric = new CocaColaFabric();
                        break;
                    case "Lays":
                        fabric = new LaysFabric();
                        break;
                    case "Snickers":
                        fabric = new SnickersFabric();
                    case "Twix":
                        fabric = new TwixFabric();
                        break;
                }
                int amount;
                if (AmountOfProducts.getText().toString().equals(""))
                    amount = 1;
                else
                    amount = Integer.parseInt(AmountOfProducts.getText().toString());
                switch (chooseVendingMachine.getSelectedItem().toString()) {
                    case "1":
                        vendingMachine1.addProducts(fabric, amount);
                        fragment1.setVendingMachineAmountOfProductsValue(vendingMachine1.getProducts().size());
                        break;
                    case "2":
                        vendingMachine2.addProducts(fabric, amount);
                        fragment2.setVendingMachineAmountOfProductsValue(vendingMachine2.getProducts().size());
                        break;
                    case "3":
                        vendingMachine3.addProducts(fabric, amount);
                        fragment3.setVendingMachineAmountOfProductsValue(vendingMachine3.getProducts().size());
                        break;
                    case "4":
                        vendingMachine4.addProducts(fabric, amount);
                        fragment4.setVendingMachineAmountOfProductsValue(vendingMachine4.getProducts().size());
                        break;
                }

            }
        });

        //создание кнопки запуска скудентов
        generateStudents = (Button) findViewById(R.id.generateStudents);
        generateStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VendingMachineLifeCycle lifeCycle1 = new VendingMachineLifeCycle();
                VendingMachineLifeCycle lifeCycle2 = new VendingMachineLifeCycle();
                VendingMachineLifeCycle lifeCycle3 = new VendingMachineLifeCycle();
                VendingMachineLifeCycle lifeCycle4 = new VendingMachineLifeCycle();
                lifeCycle1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, vendingMachine1);
                lifeCycle2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, vendingMachine2);
                lifeCycle3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, vendingMachine3);
                lifeCycle4.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, vendingMachine4);
            }
        });



    }




    class VendingMachineLifeCycle extends AsyncTask<VendingMachine, VendingMachine, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(VendingMachine... vendingMachine) {
            for (int i = 0; i < vendingMachine[0].getQueue().size(); i++) {
                vendingMachine[0].startToWork(vendingMachine[0].getQueue().get(i));
                publishProgress(vendingMachine[0]);
                vendingMachine[0].workingWithAClient();
                publishProgress(vendingMachine[0]);
                vendingMachine[0].paying();
                publishProgress(vendingMachine[0]);
                vendingMachine[0].delivering();
                publishProgress(vendingMachine[0]);
            }
            return null;
        }


        @Override
        protected void onProgressUpdate(VendingMachine... vendingMachine) {
            if (vendingMachine[0].getName().equals("1")) {
                fragment1.setVendingMachineStatusValue(vendingMachine[0].getStatus().toString());
                fragment1.setVendingMachineStudentValue(vendingMachine[0].getClientNumber());
                String wantToBuy = "";
                if (vendingMachine[0].getChoose() != null && vendingMachine[0].getStatus() == com.example.vendingmachines.Status.ISPAYING)
                for (int i = 0; i < vendingMachine[0].getChoose().length; i++) {
                    wantToBuy += vendingMachine[0].getProducts().get(vendingMachine[0].getChoose()[i]).getName() + " ";
                }
                fragment1.setVendingMachineProductsListValue(wantToBuy);
                fragment1.setVendingMachineAmountOfProductsValue(vendingMachine[0].getProducts().size());
            }

            if (vendingMachine[0].getName().equals("2")) {
                fragment2.setVendingMachineStatusValue(vendingMachine[0].getStatus().toString());
                fragment2.setVendingMachineStudentValue(vendingMachine[0].getClientNumber());
                String wantToBuy = "";
                if (vendingMachine[0].getChoose() != null && vendingMachine[0].getStatus() == com.example.vendingmachines.Status.ISPAYING)
                for (int i = 0; i < vendingMachine[0].getChoose().length; i++) {
                    wantToBuy += vendingMachine[0].getProducts().get(vendingMachine[0].getChoose()[i]).getName() + " ";
                }
                fragment2.setVendingMachineProductsListValue(wantToBuy);
                fragment2.setVendingMachineAmountOfProductsValue(vendingMachine[0].getProducts().size());
            }

            if (vendingMachine[0].getName().equals("3")) {
                fragment3.setVendingMachineStatusValue(vendingMachine[0].getStatus().toString());
                fragment3.setVendingMachineStudentValue(vendingMachine[0].getClientNumber());
                String wantToBuy = "";
                if (vendingMachine[0].getChoose() != null && vendingMachine[0].getStatus() == com.example.vendingmachines.Status.ISPAYING)
                for (int i = 0; i < vendingMachine[0].getChoose().length; i++) {
                    wantToBuy += vendingMachine[0].getProducts().get(vendingMachine[0].getChoose()[i]).getName() + " ";
                }
                fragment3.setVendingMachineProductsListValue(wantToBuy);
                fragment3.setVendingMachineAmountOfProductsValue(vendingMachine[0].getProducts().size());
            }

            if (vendingMachine[0].getName().equals("4")) {
                fragment4.setVendingMachineStatusValue(vendingMachine[0].getStatus().toString());
                fragment4.setVendingMachineStudentValue(vendingMachine[0].getClientNumber());
                String wantToBuy = "";
                if (vendingMachine[0].getChoose() != null && vendingMachine[0].getStatus() == com.example.vendingmachines.Status.ISPAYING)
                for (int i = 0; i < vendingMachine[0].getChoose().length; i++) {
                    wantToBuy += vendingMachine[0].getProducts().get(vendingMachine[0].getChoose()[i]).getName() + " ";
                }
                fragment4.setVendingMachineProductsListValue(wantToBuy);
                fragment4.setVendingMachineAmountOfProductsValue(vendingMachine[0].getProducts().size());
            }
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
}