package src.com.Lrd.www.bean;

/**
 * @date 2020/2/19-11:26
 */
public class Curator {

    private int id;
    private String truthName;
    private String sex;
    private String email;
    private String mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTruthName() {
        return truthName;
    }

    public void setTruthName(String truthName) {
        this.truthName = truthName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Curator{" +
                "id=" + id +
                ", truthName='" + truthName + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
