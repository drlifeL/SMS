package cn.dxxy.entity;

/**
 * 成绩表
 */
public class Score {

    //学号
    private String sId;
    //课程号
    private String couId;
    //成绩
    private Integer grade;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Score{" +
                "sId='" + sId + '\'' +
                ", couId='" + couId + '\'' +
                ", grade=" + grade +
                '}';
    }
}
