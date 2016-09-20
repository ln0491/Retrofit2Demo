package com.liu.retrofit2demo.bean;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/9/20 0020 10:44
 */
public class User {


    /**
     * login : list
     * id : 1133421
     * avatar_url : https://avatars.githubusercontent.com/u/1133421?v=3
     * gravatar_id :
     * url : https://api.github.com/users/list
     * html_url : https://github.com/list
     * followers_url : https://api.github.com/users/list/followers
     * following_url : https://api.github.com/users/list/following{/other_user}
     * gists_url : https://api.github.com/users/list/gists{/gist_id}
     * starred_url : https://api.github.com/users/list/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/list/subscriptions
     * organizations_url : https://api.github.com/users/list/orgs
     * repos_url : https://api.github.com/users/list/repos
     * events_url : https://api.github.com/users/list/events{/privacy}
     * received_events_url : https://api.github.com/users/list/received_events
     * type : User
     * site_admin : false
     * name : null
     * company : null
     * blog : null
     * location : null
     * email : null
     * hireable : null
     * bio : null
     * public_repos : 1
     * public_gists : 3
     * followers : 0
     * following : 0
     * created_at : 2011-10-17T14:53:35Z
     * updated_at : 2016-02-27T00:59:03Z
     */

    public String login;
    public int     id;
    public String  avatar_url;
    public String  gravatar_id;
    public String  url;
    public String  html_url;
    public String  followers_url;
    public String  following_url;
    public String  gists_url;
    public String  starred_url;
    public String  subscriptions_url;
    public String  organizations_url;
    public String  repos_url;
    public String  events_url;
    public String  received_events_url;
    public String  type;
    public boolean site_admin;
    public String  name;
    public String  company;
    public String  blog;
    public String  location;
    public String  email;
    public String  hireable;
    public String  bio;
    public int     public_repos;
    public int     public_gists;
    public int     followers;
    public int     following;
    public String  created_at;
    public String  updated_at;

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", avatar_url='" + avatar_url + '\'' +
                ", gravatar_id='" + gravatar_id + '\'' +
                ", url='" + url + '\'' +
                ", html_url='" + html_url + '\'' +
                ", followers_url='" + followers_url + '\'' +
                ", following_url='" + following_url + '\'' +
                ", gists_url='" + gists_url + '\'' +
                ", starred_url='" + starred_url + '\'' +
                ", subscriptions_url='" + subscriptions_url + '\'' +
                ", organizations_url='" + organizations_url + '\'' +
                ", repos_url='" + repos_url + '\'' +
                ", events_url='" + events_url + '\'' +
                ", received_events_url='" + received_events_url + '\'' +
                ", type='" + type + '\'' +
                ", site_admin=" + site_admin +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", blog='" + blog + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", hireable='" + hireable + '\'' +
                ", bio='" + bio + '\'' +
                ", public_repos=" + public_repos +
                ", public_gists=" + public_gists +
                ", followers=" + followers +
                ", following=" + following +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
