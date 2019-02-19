package javatest.iristai.com.javatest.retrofit.javamodel.planet;

import java.util.List;

public class PlanetRootResult implements java.io.Serializable {
    private static final long serialVersionUID = -1134569374663638788L;
    private int offset;
    private int limit;
    private int count;
    private String sort;
    private List<PlanetRootResultResults> results;

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<PlanetRootResultResults> getResults() {
        return this.results;
    }

    public void setResults(List<PlanetRootResultResults> results) {
        this.results = results;
    }
}
