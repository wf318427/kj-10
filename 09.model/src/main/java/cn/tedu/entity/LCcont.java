package cn.tedu.entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
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
public class LCcont implements Serializable {
    private static final long serialVersionUID = 8522927879255757250L;
    private String contno;

}
