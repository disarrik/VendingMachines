package com.example.vendingmachines;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class VendingMachineFragment extends
        android.app.Fragment {

    private TextView VendingMachineName;
    private TextView VendingMachineStatus;
    private TextView VendingMachineStudent;
    private TextView VendingMachineProductsList;
    private TextView VendingMachineAmountOfProducts;


    public VendingMachineFragment() {
        // Required empty public constructor
    }

    public static VendingMachineFragment newInstance() {
        VendingMachineFragment fragment = new VendingMachineFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vending_machine, container, false);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = 500;
        params.height = 500;
        view.setLayoutParams(params);
        VendingMachineName = view.findViewById(R.id.VendingMachineName);
        VendingMachineStatus = view.findViewById(R.id.VendingMachineStatus);
        VendingMachineStudent = view.findViewById(R.id.VendingMachineStudent);
        VendingMachineProductsList = view.findViewById(R.id.VendingMachineProductsList);
        VendingMachineAmountOfProducts = view.findViewById(R.id.VendingMachineAmountOfProducts);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup.LayoutParams params = view.getLayoutParams();
                if (params.width == 500) {
                    params.width = 700;
                    params.height = 700;
                }
                else {
                    params.width = 500;
                    params.height = 500;
                }
                view.setLayoutParams(params);
            }
        });
        return view;
    }

    public void setVendingMachineNameValue(String name) {
        VendingMachineName.setText(name);
    }

    public void setVendingMachineStatusValue(Status status) {
        VendingMachineStatus.setText(status.toString());
    }

    public void setVendingMachineStatusValue(String status) {
        VendingMachineStatus.setText(status);
    }

    public void setVendingMachineStudentValue(int amountOfStudents) {
        VendingMachineStudent.setText(Integer.toString(amountOfStudents));
    }

    public void setVendingMachineProductsListValue(String products) {
        VendingMachineProductsList.setText(products);
    }

    public void appendVendingMachineProductsListValue(String products) {
        VendingMachineProductsList.setText(VendingMachineProductsList.getText() + products);
    }

    public void setVendingMachineAmountOfProductsValue(int n) {
        VendingMachineAmountOfProducts.setText(Integer.toString(n));
    }
}