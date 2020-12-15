package top.wlz922.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * system_user_card
 * @author 
 */
@Data
public class SystemUserCard implements Serializable {
    private Long id;

    private Long systemUserId;

    private String cardNumber;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}