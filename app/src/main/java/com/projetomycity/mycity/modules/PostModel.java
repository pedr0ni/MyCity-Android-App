package com.projetomycity.mycity.modules;

/**
 * Created by PEDRONI on 15/08/2017.
 */

public class PostModel {

    private String userName;
    private String userUrl;
    private String content;
    private String time;
    private String icon;

    public PostModel(String userName, String userUrl, String content, String time, String icon) {
        this.userName = userName;
        this.userUrl = userUrl;
        this.content = content;
        this.time = time;
        this.icon = icon;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public String getContent() {
        return content;
    }

    public String getIcon() {
        return icon;
    }

    public String getTime() {
        return time;
    }
}
