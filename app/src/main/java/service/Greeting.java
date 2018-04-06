package service;

/**
 * Created by mak on 4/6/18.
 */

public class Greeting {

    private String id;
    private String content;
    private static Greeting DEFAULT = new Greeting();

    public static Greeting getDefault() {
        DEFAULT.id = "-1";
        DEFAULT.content = "Default message";
        return DEFAULT;
    }

    public String getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public String toString() {
        return this.id + " " + this.content;
    }

}
