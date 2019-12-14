package ru.popovich.emergencyassistmobile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import ru.popovich.emergencyassistmobile.dto.TaskSocialServiceIds;
import ru.popovich.emergencyassistmobile.model.Organization;
import ru.popovich.emergencyassistmobile.model.SocialService;
import ru.popovich.emergencyassistmobile.model.TaskSocialService;
import ru.popovich.emergencyassistmobile.model.User;

public interface RestApiService {

    //    String PREFIX = "";
    String PREFIX = "/emergency/api/v1";

    @GET(PREFIX + "/user/{name}")
    Call<User> getUser(@Path("name") String name);

    @GET(PREFIX + "/user")
    Call<List<User>> getUsers();

    @GET(PREFIX + "/organization/1")
    Call<Organization> getOrganization();

    @GET(PREFIX + "/service/{id}")
    Call<SocialService> getSocialService(@Path("id") Long id);

    @GET(PREFIX + "/task/{id}")
    Call<TaskSocialService> getTask(@Path("id") Long id);

    @POST(PREFIX + "/task/new")
    Call<TaskSocialServiceIds> newTaskByIds(@Body TaskSocialServiceIds taskSocialServiceIds);

    @POST(PREFIX + "/task")
    Call<TaskSocialService> newTask(@Body TaskSocialService taskSocialService);

    @PUT(PREFIX + "/task/{id}")
    Call<TaskSocialService> updateTask(@Path("id") Long id, @Body TaskSocialService taskSocialService);
}
