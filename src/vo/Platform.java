package vo;

import java.util.Objects;

public class Platform {
    String platformName;
    String site;

    public Platform(String name, String site){
        this.platformName = name;
        this.site = site;
    }

    public String getPlatformName(){
        return platformName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Platform platform = (Platform) o;
        return platformName.equals(platform.platformName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platformName);
    }

    @Override
    public String toString() {
        return "Platform{" +
                "platformName='" + platformName + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}