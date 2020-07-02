package top.yc9064.pojo;

public class Teacher {
    private String tid;
    private String tname;
    private String pwd;
    private String college;
    private String rootpower;

    public Teacher(String tid, String tname, String pwd, String college, String rootpower) {
        this.tid = tid;
        this.tname = tname;
        this.pwd = pwd;
        this.college = college;
        this.rootpower = rootpower;
    }

    public Teacher() {
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getRootpower() {
        return rootpower;
    }

    public void setRootpower(String rootpower) {
        this.rootpower = rootpower;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", college='" + college + '\'' +
                ", rootpower='" + rootpower + '\'' +
                '}';
    }
}
