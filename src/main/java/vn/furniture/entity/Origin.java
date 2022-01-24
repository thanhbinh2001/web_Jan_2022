package vn.furniture.entity;

import java.sql.Timestamp;

public class Origin {
    private String originId;
    private String originName;
    private boolean status;
    private Timestamp createAt;
    private Timestamp updateAt;

    public Origin() {
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public Origin(String originId, String originName, boolean status, Timestamp createAt, Timestamp updateAt) {
        this.originId = originId;
        this.originName = originName;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Origin{" +
                "originId='" + originId + '\'' +
                ", originName='" + originName + '\'' +
                ", status='" + status + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
