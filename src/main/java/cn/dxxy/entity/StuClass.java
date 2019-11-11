package cn.dxxy.entity;


/**
 * 班级信息
 */
public class StuClass {
    //班级号
    private String cId;
    //班级名称 非空、唯一校验
    private String cName;
    // 所属学院
    private College college;

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

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "StuClass{" +
                "cId='" + cId + '\'' +
                ", cName='" + cName + '\'' +
                ", college=" + college +
                '}';
    }
}
