package top.wlz922.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * goods
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements Serializable {
    private Long id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 售价
     */
    private Double salePrice;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}