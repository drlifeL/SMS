package cn.dxxy.entity;

import java.util.Objects;

public class Admin {
    private String aId;
    private String aPassword;

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aId='" + aId + '\'' +
                ", aPassword='" + aPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(aId, admin.aId) &&
                Objects.equals(aPassword, admin.aPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aId, aPassword);
    }
}
