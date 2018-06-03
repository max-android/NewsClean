package ru.exampleopit777.newsclean.data.entities;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by Максим on 01.06.2018.
 */

@Root(name = "rss", strict = false)
public class Rss implements Serializable {

    public Rss() {

    }

    // @Element(name = "channel")
    private Channel channel;

    @Element(name = "channel")
    public Channel getChannel() {
        return channel;
    }

    @Element(name = "channel")
    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
