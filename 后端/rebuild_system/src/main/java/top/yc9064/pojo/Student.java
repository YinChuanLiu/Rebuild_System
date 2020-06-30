package top.yc9064.pojo;


public class Student {
    private Integer sid;
    private String sname;
    private String pwd;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Student(Integer sid, String sname, String pwd) {
        this.sid = sid;
        this.sname = sname;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
