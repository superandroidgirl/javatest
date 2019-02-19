package javatest.iristai.com.javatest.retrofit.api;

import io.reactivex.Observable;
import javatest.iristai.com.javatest.retrofit.javamodel.category.CategoryListRoot;
import javatest.iristai.com.javatest.retrofit.javamodel.planet.PlanetRoot;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataApiService {

    @GET("apiAccess")
    Observable<CategoryListRoot> getLocationList(@Query("scope")String scope, @Query("rid")String rid);

    @GET("apiAccess")
    Observable<PlanetRoot> getPlanetLocation(@Query("scope")String scope,
                          @Query("rid")String rid,
                          @Query("q")String queryString);

}
