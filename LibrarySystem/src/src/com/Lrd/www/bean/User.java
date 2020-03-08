package src.com.Lrd.www.bean;

/**
 * @date 2020/2/19-11:29
 */
/*User几个较为特殊属性
jobId：每个user对应的职业id
        1.curator
        2.common staff
        3.category staff
        4.administrator
memberOfLibrary ：该user隶属于哪个图书馆
* */
public class User {

    private int id;
    private String job;
    private String username;
    private String password;
    private String memberOfLibrary;
    private String realName;
    private int onCommission;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberOfLibrary() {
        return memberOfLibrary;
    }

    public void setMemberOfLibrary(String memberOfLibrary) {
        this.memberOfLibrary = memberOfLibrary;
    }


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getOnCommission() {
        return onCommission;
    }

    public void setOnCommission(int onCommission) {
        this.onCommission = onCommission;
    }

    @Override
    public String toString() {
        return String.format("%5d \t%15s \t%15s \t%15s \t%15s \t%5d",id,realName,job,username,memberOfLibrary,onCommission);

    }

    public String toDiffString() {
        return "用户信息为：\n" +
            "     id:" + id +
                " 姓名:" + realName +
                " 职业:" + job+
                " 所处图书馆:" + memberOfLibrary ;
    }

}
