package com.wave.livedataexample.modelWeatherForecast.GetJsonValue;

        import retrofit2.Call;
        import retrofit2.http.GET;

        import retrofit2.http.Query;

/**
 * Created by Dell on 4/13/2018.
 */

public interface Api {
    @GET("forecast")
    Call<object>getTasks(@Query("q") String city, @Query("appid")String appid);

    /**@GET("forecast")
    Observable<object>getObservableText(@Query("q")String city,@Query("appid")String appid);**/
}
