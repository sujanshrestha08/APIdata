package com.example.apidata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.validation.Validator;

import model.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchEmployeeActivity extends AppCompatActivity {

    private final static String BASE_URL = "http://dummy.restapiexample.com/api/v1/";
    private EditText etEmpID;
    private TextView tvData;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_employee);

        etEmpID = findViewById(R.id.etEmpID);
        tvData = findViewById(R.id.tvData);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 {
                    loadData();
                }
            }
        });
    }
        private void loadData(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            API api = retrofit.create(API.class);

            Call<Employee> listCall = api.getEmployeeByID(Integer.parseInt(etEmpID.getText().toString()));

            listCall.enqueue(new Callback<Employee>() {
                @Override
                public void onResponse(Call<Employee> call, Response<Employee> response) {

                    String content = "";
                    content += "ID : " + response.body().getId() + "\n";
                    content += "Name : " + response.body().getEmployee_name() + "\n";
                    content += "Age : " + response.body().getEmployee_age() + "\n";
                    content += "Salary : " + response.body().getEmployee_salary() + "\n";

                    tvData.append(content);
                }

                @Override
                public void onFailure(Call<Employee> call, Throwable t) {
                    Toast.makeText(SearchEmployeeActivity.this, "Error"  + t.getLocalizedMessage(),  Toast.LENGTH_LONG).show();
                }
            });
        }
    }