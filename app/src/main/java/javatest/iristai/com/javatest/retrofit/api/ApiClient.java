package javatest.iristai.com.javatest.retrofit.api;

import io.reactivex.Observable;
import javatest.iristai.com.javatest.retrofit.javamodel.category.CategoryListRoot;
import javatest.iristai.com.javatest.retrofit.javamodel.planetinfo.PlanetRoot;

public class ApiClient {

    /**
     * 取得館區列表
     */
    public static Observable<CategoryListRoot> getCategoryList() {
        return ServiceFactory.pushDomainService()
                .getLocationList("resourceAquire", "5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
                .compose(ObservableUtils.<CategoryListRoot>schedulersHandling());
    }

    /**
     * 取得植物列表
     */
    public static Observable<PlanetRoot> getPlanetList(String categoryName) {
        return ServiceFactory.pushDomainService()
                .getPlanetLocation("resourceAquire", "f18de02f-b6c9-47c0-8cda-50efad621c14", categoryName)
                .compose(ObservableUtils.<PlanetRoot>schedulersHandling());
    }
}
