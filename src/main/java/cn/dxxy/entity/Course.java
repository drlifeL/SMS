package cn.dxxy.entity;

/**
 * 课程表
 */
public class Course {
    //课程号
    private String couId;
    //课程名
    private String couName;
    //教师ID
    private String tId;

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "couId='" + couId + '\'' +
                ", couName='" + couName + '\'' +
                ", tId='" + tId + '\'' +
                '}';
    }
}
