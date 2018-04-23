package com.example.ironman.projecttexas.Service;




import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

import com.example.ironman.projecttexas.model.LoginDto;
import com.example.ironman.projecttexas.model.UserListDto;

import java.util.List;


public interface Api {

    @POST("login")
    Call<LoginDto> sendUsernameAndPassword(@Body LoginDto loginDto);

    /*@POST("logout")
    Call<ResponseBody> logout(@Header("userId") int user,
                              @Body LogoutDto logoutDto);*/
    @GET("users")
    Call<List<UserListDto>> getUsers(@Header("loginId") int loginId,
                                    @Header("customerId") int customerId,
                                    @Query("sort") int sort,
                                    @Query("size") int size,
                                    @Query("page") int page,
                                    @Query("search") String search
                                    );

   /* @GET("notifications")
    Call <List<NotificationDto>> listNotification();

    @GET("students")
    Call<StudentListDto> listStudents(@Header("customerId")Long customerId,
                                      @Query("sort") String sort,
                                      @Query("size") String size,
                                      @Query("page") String page,
                                      @Query("search") String search);
    @GET("teachers")
    Call<TeacherListDto> listTeachers(@Header("customerId")Long customerId,
                                      @Header("userId") int userId,
                                      @Query("sort") String sort,
                                      @Query("size") String size,
                                      @Query("page") String page,
                                      @Query("search") String search);
    @GET("students/{id}")
    Call<StudentDto> studentInfo(@Path("id") int id);

    @GET("users/{id}")
    Call<UserDto> userInfo(@Path("id") int id);

    @GET("teacher/{teacherId}")
    Call<TeacherDto>teacherInfo(@Path("teacherId")int id);

    @POST("notifications")
    Call<String> sendNotification(@Header("userId")String header,@Body  SendNotificationDTO sendNotificationDTO);

    @GET("courses")
    Call<List<CourseDto>> courseDto();

    @GET("routines/mobile/courses/{courseId}/semesters/{semester}")
    Call<ClassRoutineDto> classRoutineDto(@Header("userId") int userId,
                                          @Path("courseId") int courseId,
                                          @Path("semester") String semester);

    @GET("teams")
    Call<TeamDto> getTeams(@Query("page") int page,
                           @Query("size") int size,
                           @Query("sort") String sort,
                           @Query("search") String search
    );


    @GET("subjects/{courseId}/{semester}")
    Call<List<SubjectsDto>> getListOfSubjects(@Path("courseId") int courseId,
                                              @Path("semester") String semester);*/


}