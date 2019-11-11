package cn.dxxy.entity;

import java.util.List;

/**
 * 学院表
 */
public class College {
    //学院ID
    private String collegeNum;
    //学院名称
    private String collegeName;

    public String getCollegeNum() {
        return collegeNum;
    }

    public void setCollegeNum(String collegeNum) {
        this.collegeNum = collegeNum;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeNum='" + collegeNum + '\'' +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}
