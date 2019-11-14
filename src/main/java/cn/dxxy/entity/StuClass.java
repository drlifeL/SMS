package cn.dxxy.entity;


/**
 * 专业信息
 */
public class StuClass {
    //专业号
    private String cId;
    //专业名称 非空、唯一校验
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
