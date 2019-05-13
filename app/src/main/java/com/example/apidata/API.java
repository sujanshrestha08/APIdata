package com.example.apidata;

import java.util.List;

import model.Employee;
import model.EmployeeCUD;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface API{
    @GET("employees")
    Call<List<Employee>> getEmployee();

    @POST("create")
    Call<Void> registerEmployee(@Body EmployeeCUD emp);

    @GET("employee/{empID}")
    Call<Employee> getEmployeeByID(@Path("empID") int empID);

    @PUT("update/{empID}")
    Call<Void> updateEmployee(@Path("empID") int empID, @Body EmployeeCUD emp);

    @DELETE("delete/{empID}")
    Call<Void> deleteEmployee(@Path("empID") int empId);

}

