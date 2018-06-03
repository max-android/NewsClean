package ru.exampleopit777.newsclean.data.entities;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by Максим on 01.06.2018
 */
@Root(name = "enclosure", strict = false)
public class Enclosure implements Serializable {

    public Enclosure() {
    }

    @Attribute(name = "url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Enclosure(String url) {
        this.url = url;
    }
}
