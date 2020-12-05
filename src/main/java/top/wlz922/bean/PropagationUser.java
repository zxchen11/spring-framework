package top.wlz922.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * propagation_user
 * @author 
 */
@Data
@NoArgsConstructor
public class PropagationUser implements Serializable {
    private Long id;
    private String name;
    private static final long serialVersionUID = 1L;
    public PropagationUser(String name) {
        this.name = name;
    }
}