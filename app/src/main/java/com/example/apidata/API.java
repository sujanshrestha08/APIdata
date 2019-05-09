package com.example.apidata;

import java.util.List;

import model.Employee;
import retrofit2.Call;
import retrofit2.http.GET;

public interface API{
    @GET("employees")
    Call<List<Employee>> getEmployee();

}
