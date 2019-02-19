package javatest.iristai.com.javatest.retrofit.javamodel.planet;

public class PlanetRoot implements java.io.Serializable {
    private static final long serialVersionUID = 8286006275577108518L;
    private PlanetRootResult result;

    public PlanetRootResult getResult() {
        return this.result;
    }

    public void setResult(PlanetRootResult result) {
        this.result = result;
    }
}
