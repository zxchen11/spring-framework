package top.wlz922.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * t_role
 * @author 
 */
@Data
public class TRole implements Serializable {
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    private String note;

    private static final long serialVersionUID = 1L;
}