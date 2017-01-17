package project.hrininlab.Entity;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by mrhri on 06.01.2017.
 */
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int userId;

    @Column(name="login",unique=true)
    private String login;

    @Column(name="name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    @Column(name="password")
    private String password;

    @Column(name="is_online")
    private Boolean is_online;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name = "owner_id")
    @IndexColumn(name="user_id")
    private Set<ContactList> contactList;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name = "owner_id")
    @IndexColumn(name="which_user_id")
    private Set<ChatHistory> chatHistories;


    public User(String login, String firstname, String lastname) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean is_online() {
        return is_online;
    }

    public void set_online() {
        this.is_online = true;
    }

    public void set_offline(){
        this.is_online = false;
    }

    public Set<ContactList> getContactList() {
        return contactList;
    }

    public void setContactList(Set<ContactList> contactList) {
        this.contactList = contactList;
    }

    public Set<ChatHistory> getChatHistories() {
        return chatHistories;
    }

    public void setChatHistories(Set<ChatHistory> chatHistories) {
        this.chatHistories = chatHistories;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", contactList=" + contactList +
                '}';
    }
}
