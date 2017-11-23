package cn.tedu.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 17.11.19.
 */
public class LCcont implements Serializable{

    private static final long serialVersionUID = 4983279141459720138L;
    private String  contno;
    private String polno;

    public String getContno() {
        return contno;
    }

    public void setContno(String contno) {
        this.contno = contno;
    }

    public String getPolno() {
        return polno;
    }

    public void setPolno(String polno) {
        this.polno = polno;
    }
}
