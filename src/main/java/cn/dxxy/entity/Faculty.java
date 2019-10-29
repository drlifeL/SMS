package cn.dxxy.entity;

import java.util.List;

/**
 * 学院信息
 */
public class Faculty {
    //班级号
    private String cId;
    //班级名称 非空、唯一校验
    private String cName;
    // 所属学院
    private String cDepartments;


    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDepartments() {
        return cDepartments;
    }

    public void setcDepartments(String cDepartments) {
        this.cDepartments = cDepartments;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "cId='" + cId + '\'' +
                ", cName='" + cName + '\'' +
                ", cDepartments='" + cDepartments + '\'' +
                '}';
    }
}
