package com.hdu.train.vo;
import java.util.List;
/**
 * @author 菠萝
 * @version 1.0
 * @description: PageVO
 * @date 2023/12/14 11:36
 */
public class PageVO {
    private List rows;
    private Long total;

    public PageVO(List rows, Long total) {
        this.rows = rows;
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public PageVO() {
    }
}
