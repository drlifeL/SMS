package cn.dxxy.entity;
/**
 * 学生表
 */
public class Student {
    //学号 主键
    private String sId;
    //姓名  非空校验
    private String sName;
    //性别
    private String sSex;
    // 班级号
    private String cId;
    // 籍贯
    private String sPlace;
    //所属专业
    private StuClass stuClass;
    //学生年龄字段
    private Integer sAge;
    //学生邮箱字段
    private String sEmail;

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getsPlace() {
        return sPlace;
    }

    public void setsPlace(String sPlace) {
        this.sPlace = sPlace;
    }

    public StuClass getStuClass() {
        return stuClass;
    }

    public void setStuClass(StuClass stuClass) {
        this.stuClass = stuClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", sName='" + sName + '\'' +
                ", sSex='" + sSex + '\'' +
                ", cId='" + cId + '\'' +
                ", sPlace='" + sPlace + '\'' +
                ", stuClass=" + stuClass +
                ", sAge=" + sAge +
                ", sEmail='" + sEmail + '\'' +
                '}';
    }
}
