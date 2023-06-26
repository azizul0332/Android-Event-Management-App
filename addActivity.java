package com.example.eventmanagement;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class addActivity extends Activity {
    Button btnsave,btnshare,btncancel;
    TextView result;
    EditText name, place, dateTime, capacity, budget, email, phoneno, description;
    RadioGroup rg1;
    RadioButton rb1,rb2,rb3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name=(EditText)findViewById(R.id.txtName);
        place=(EditText)findViewById(R.id.txtPlace);
        rb1 = (RadioButton)findViewById(R.id.radioButton);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        rb3 = (RadioButton)findViewById(R.id.radioButton3);
        dateTime=(EditText)findViewById(R.id.txtDate);
        capacity=(EditText)findViewById(R.id.txtCapacity);
        budget=(EditText)findViewById(R.id.txtBudget);
        email=(EditText)findViewById(R.id.txtEmail);
        phoneno=(EditText)findViewById(R.id.txtPhone);
        description=(EditText)findViewById(R.id.txtDescription);
        result= (TextView)findViewById(R.id.resultView);
        btnsave = (Button)findViewById(R.id.button_save);
        btncancel = (Button)findViewById(R.id.button_cancel);
        btnshare = (Button)findViewById(R.id.button_share);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String errMessage ="";

                String pName= name.getText().toString();
                if(pName.length()<4){
                    errMessage=" Name is not valid\n";
                }
                String pPlace = place.getText().toString();
                if(pPlace.length()<5){
                    errMessage= errMessage+ "Place name is not valid\n";
                }


                String DT= dateTime.getText().toString();
                if(DT.length()<6){
                    errMessage=errMessage+ "Datetime is not valid\n";
                }

                String Capacity= capacity.getText().toString();
                if(Capacity.equals("0")){
                    errMessage=errMessage+ "Capacity is not valid\n";
                }
                if(Capacity.length()<1){
                    errMessage=errMessage+ "Capacity is not valid\n";
                }

                String Budget= budget.getText().toString();
                if(Budget.length()<4){
                    errMessage=errMessage+ "Budget is not valid\n";
                }

                String Email= email.getText().toString();
                if(Email.length()<11){
                    errMessage=errMessage+ "Email is not valid\n";
                }
                String Phone= phoneno.getText().toString();
                if(Phone.length()<11){
                    errMessage=errMessage+ "Phone number is not valid\n";
                }
                String Description= description.getText().toString();
                if(Description.length()<10){
                    errMessage=errMessage+ "Description is not valid\n";
                }

                if (errMessage.length()==0){
                    showDialog("Do you want to save event  info","info", "Yes","No");

                }

                else{
                    showDialog(errMessage,"Error", "Ok", "Back");
                }

            }
        });



    }

    void save() {
        String name = ((EditText) findViewById(R.id.txtName)).getText().toString();
        String place = ((EditText) findViewById(R.id.txtPlace)).getText().toString();
        String dateTime = ((EditText) findViewById(R.id.txtDate)).getText().toString();
        String capacity = ((EditText) findViewById(R.id.txtCapacity)).getText().toString();
        String budget = ((EditText) findViewById(R.id.txtBudget)).getText().toString();
        String email = ((EditText) findViewById(R.id.txtEmail)).getText().toString();
        String phoneno = ((EditText) findViewById(R.id.txtPhone)).getText().toString();
        String description = ((EditText) findViewById(R.id.txtDescription)).getText().toString();

        System.out.println("Name: " + name);
        System.out.println("Place: " + place);
        if (rb1.isChecked()) {
            System.out.println("Type: Indoor");
        } else if (rb2.isChecked()) {
            System.out.println("Type: Outdoor");
        } else if (rb3.isChecked()) {
            System.out.println("Type: Online");
        } else {
            System.out.println("No type is selected");
        }
        System.out.println("Date & Time: " + dateTime);
        System.out.println("Capacity: " + capacity);
        System.out.println("Budget: " + budget);
        System.out.println("Email: " + email);
        System.out.println("Phone no: " + phoneno);
        System.out.println("Description: " + description);
    }


    private void showDialog(String message, String title, String btn1, String btn2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setCancelable(false)
                .setPositiveButton(btn1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        System.out.println("Button1 was clicked");
                        //Util.getInstance().deleteByKey(MainActivity.this, key);
                        dialog.cancel();
                        //loaddata();
                        //adapter.notifydataSetChanged();
                    }
                })
                .setNegativeButton(btn2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        System.out.println("Button2 was not clicked");
                        dialog.cancel();

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();


    }
    public void onRadioButtonClicked(View view){
        String type="";
        if(rb1.isSelected()){
            String ind = rb1.getText().toString();
            type+="Indoor";
        }

        if(rb2.isSelected()){
            String out = rb2.getText().toString();
            type+="Outdoor";
        }

        if(rb3.isSelected()){
            String onl = rb3.getText().toString();
            type+="Online";
        }

    }

    public void cancelEvent(View view){
        finish();
    }
    public void shareEvent(View view){
        Toast.makeText(addActivity.this, "Information shared", Toast.LENGTH_SHORT).show();
    }
}