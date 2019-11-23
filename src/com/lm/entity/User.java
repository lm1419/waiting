package com.lm.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author lm
 * @version V1.0
 * @Package com.lm.entity
 * @date 2019/11/4 16:15
 */
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String passWord;
    private Timestamp registrationDate;
    private Timestamp lastLoginTime;
    private String question;
    private String answer;
    private String description;
    private String sex;
    private String userType;
    private Date birthday;
    private List<Blog> blog;

    public User() {
    }

    public User(Integer id, String userName, String passWord, Timestamp registrationDate, Timestamp lastLoginTime, String question, String answer, String description, String sex, Date birthday) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.registrationDate = registrationDate;
        this.lastLoginTime = lastLoginTime;
        this.question = question;
        this.answer = answer;
        this.description = description;
        this.sex = sex;
        this.birthday = birthday;
        this.userType = "normal";
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (!userName.equals(user.userName)) {
            return false;
        }
        return passWord.equals(user.passWord);
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + passWord.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName='" + userName + '\'' + ", passWord='" + passWord + '\'' + ", registrationDate=" + registrationDate + ", lastLoginTime=" + lastLoginTime + ", question='" + question + '\'' + ", answer='" + answer + '\'' + ", description='" + description + '\'' + ", sex='" + sex + '\'' + ", birthday=" + birthday + '}';
    }
}
