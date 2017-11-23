package cn.tedu.entity;

import lombok.ToString;

/**
 * Created by Administrator on 17.11.19.
 */
@ToString
public class FieldCarriry {
    private String contNo;
    private String appntNo;

    public String getContNo() {
        return contNo;
    }

    public void setContNo(String contNo) {
        this.contNo = contNo;
    }

    public String getAppntNo() {
        return appntNo;
    }

    public void setAppntNo(String appntNo) {
        this.appntNo = appntNo;
    }
}
