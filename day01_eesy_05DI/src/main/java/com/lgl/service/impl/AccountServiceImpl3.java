package com.lgl.service.impl;

import com.lgl.service.IAccountService;

import java.util.*;

/**
 * @author lgl
 * @Description: 账户的业务层实现类
 * @date 2019-08-23 23:20
 */
public class AccountServiceImpl3 implements IAccountService {
    private Properties myProps;
    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;


    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void saveAccount() {
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);

    }

}
