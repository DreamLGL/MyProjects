package com.lgl.domain;

import java.util.List;

/**
 * @author lgl
 * @Description:
 * @date 2019/11/7 11:25 下午
 */
public class QueryVo {
    private User user;

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
