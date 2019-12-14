package ru.popovich.emergencyassistmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.popovich.emergencyassistmobile.dto.TaskSocialServiceIds;
import ru.popovich.emergencyassistmobile.model.Organization;
import ru.popovich.emergencyassistmobile.model.SocialService;
import ru.popovich.emergencyassistmobile.model.TaskSocialService;
import ru.popovich.emergencyassistmobile.model.TaskStatus;
import ru.popovich.emergencyassistmobile.model.User;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Organization organization;

    List<User> userList;

    User user;

    SocialService socialService;

    TaskSocialService task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "is created");

//        NetworkService.getInstance().getRestApi()
//                .getUsers()
//                .enqueue(new Callback<List<User>>() {
//                    @Override
//                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                        userList = response.body();
//                        user = userList.get(3);
//                        Log.d(TAG, "User[0]: " + userList.size());
//                        Log.d(TAG, "User[0]: " + userList.get(6).getNickname());
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<User>> call, Throwable t) {
//
//                    }
//                });

        NetworkService.getInstance().getRestApi()
                .getUser("lonshakovata")
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                        User user = response.body();
//                        Log.d(TAG, response.errorBody().toString());

                      if(user != null)
                        Log.d(TAG, "User: " + user.getNickname());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                        Log.d(TAG, call.toString());
                        Log.d(TAG, "User does not call :(");

                    }
                });

        NetworkService.getInstance().getRestApi()
                .getOrganization()
                .enqueue(new Callback<Organization>() {
                    @Override
                    public void onResponse(Call<Organization> call, Response<Organization> response) {

//                        Log.d(TAG,"Organization: " + response.errorBody().toString());
                        organization = response.body();
                        Log.d(TAG, "Organization ");
                        Log.d(TAG,"Organization: " + organization.getName());
                    }

                    @Override
                    public void onFailure(Call<Organization> call, Throwable t) {

                        Log.d(TAG, "Organization does not call :(");
                    }
                });

        NetworkService.getInstance().getRestApi()
                .getSocialService(6L)
                .enqueue(new Callback<SocialService>() {
                    @Override
                    public void onResponse(Call<SocialService> call, Response<SocialService> response) {
                        socialService = response.body();
                        Log.d(TAG, "Service ");
//                        Log.d(TAG, "Service is " + socialService.getTitle());
                    }

                    @Override
                    public void onFailure(Call<SocialService> call, Throwable t) {
                        Log.d(TAG, "Social Service does not call :(");
                    }
                });

        NetworkService.getInstance().getRestApi()
                .getTask(371L)
                .enqueue(new Callback<TaskSocialService>() {
                    @Override
                    public void onResponse(Call<TaskSocialService> call, Response<TaskSocialService> response) {
                        task = response.body();

                        Log.d(TAG, task.getStatus().getS());
                    }

                    @Override
                    public void onFailure(Call<TaskSocialService> call, Throwable t) {
                        Log.d(TAG, "TASK does not call :(");
                    }
                });

//        NetworkService.getInstance().getRestApi()
//                .newTaskByIds(new TaskSocialServiceIds("pupkin",8L))
//                .enqueue(new Callback<TaskSocialServiceIds>() {
//                    @Override
//                    public void onResponse(Call<TaskSocialServiceIds> call, Response<TaskSocialServiceIds> response) {
//
//                        Log.d(TAG, "Response: " + response.isSuccessful());
//                        Log.d(TAG, "task wrote! " + response.body().toString());
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<TaskSocialServiceIds> call, Throwable t) {
//
//                        Log.d(TAG, "task doesnt insert, " + t.getMessage());
//
//                    }
//                });

        Button button = findViewById(R.id.new_task);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"New task: " + socialService.getId() + ", user: " + user.getNickname() ,Toast.LENGTH_LONG).show();
                NetworkService.getInstance().getRestApi()
                        .newTask(new TaskSocialService(socialService,user))
                        .enqueue(new Callback<TaskSocialService>() {
                            @Override
                            public void onResponse(Call<TaskSocialService> call, Response<TaskSocialService> response) {

                                Log.d(TAG, "Overall task Response: " + response.isSuccessful());
//                                Log.d(TAG, "Overall task wrote! " + response.body().toString());

                            }

                            @Override
                            public void onFailure(Call<TaskSocialService> call, Throwable t) {

                                Log.d(TAG, "Overall task doesnt insert, " + t.getMessage());

                            }
                        });
            }
        });

        ((Button) findViewById(R.id.task_modify)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Task " + task.getId() + " modify STATUS to CLOSED", Toast.LENGTH_LONG).show();

                task.setStatus(TaskStatus.CLOSED);
                NetworkService.getInstance().getRestApi()
                        .updateTask(task.getId(), task)
                        .enqueue(new Callback<TaskSocialService>() {
                            @Override
                            public void onResponse(Call<TaskSocialService> call, Response<TaskSocialService> response) {
                                Log.d(TAG, "Overall task Response: " + response.isSuccessful());
                            }

                            @Override
                            public void onFailure(Call<TaskSocialService> call, Throwable t) {

                            }
                        });



            }
        });
    }
}