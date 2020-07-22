package com.qwz.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_menu")
public class Menu {
    /**
     * 菜单/按钮ID
     */
    @Id
    @Column(name = "MENU_ID")
    private Long menuId;

    /**
     * 上级菜单ID
     */
    @Column(name = "PARENT_ID")
    private Long parentId;

    /**
     * 菜单/按钮名称
     */
    @Column(name = "MENU_NAME")
    private String menuName;

    /**
     * 对应路由path
     */
    @Column(name = "PATH")
    private String path;

    /**
     * 对应路由组件component
     */
    @Column(name = "COMPONENT")
    private String component;

    /**
     * 权限标识
     */
    @Column(name = "PERMS")
    private String perms;

    /**
     * 图标
     */
    @Column(name = "ICON")
    private String icon;

    /**
     * 类型 0菜单 1按钮
     */
    @Column(name = "TYPE")
    private String type;

    /**
     * 排序
     */
    @Column(name = "ORDER_NUM")
    private Double orderNum;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;



    /**
     * 子部门
     */
    private List<Menu> children;
    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }


}