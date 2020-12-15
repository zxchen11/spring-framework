package top.wlz922.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * system_user
 * @author 
 */
@Data
public class SystemUser implements Serializable {
    private Long id;

    private String userName;

    private String passwrod;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}