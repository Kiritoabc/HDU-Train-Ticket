package com.hdu.train.util;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 菠萝
 * @version 1.0
 * @description:  Bean的copy
 * @date 2023/12/14 11:34
 */
public class BeanCopyUtils {

    private BeanCopyUtils() {
    }

    public static <V> V copyBean(Object source,Class<V> clazz) {
        //创建目标对象
        V result = null ;
        try {
            result = clazz.newInstance();
            //实现属性copy
            BeanUtils.copyProperties(source, result);
            //返回结果

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static <O,V> List<V> copyBeanList(List<O> list, Class<V> clazz){
        //stream流
        return  list.stream()
                .map(o -> copyBean(o,clazz))
                .collect(Collectors.toList());

    }




}