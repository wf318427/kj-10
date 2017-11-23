package cn.tedu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Administrator on 17.11.19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LCAppnt implements Serializable {
    private static final long serialVersionUID = 7084693406753779249L;
    private String appntNo;
}
