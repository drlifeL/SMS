package cn.dxxy.entity;

/**
 * 课程表
 */
public class Course {
    //课程号
    private String couId;
    //课程名
    private String couName;

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

    @Override
    public String toString() {
        return "Course{" +
                "couId='" + couId + '\'' +
                ", couName='" + couName + '\'' +
                '}';
    }
}
