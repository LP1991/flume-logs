/********************** 版权声明 *************************
 * 文件名: Test.java
 * 包名: com.freitas.flume.serializer
 * 版权:	杭州华量软件  flume-logs
 * 职责: 
 ********************************************************
 *
 * 创建者：Primo  创建时间：2017/6/5
 * 文件版本：V1.0
 *
 *******************************************************/
package com.freitas.flume.serializer;

import com.google.common.base.Charsets;

import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    @org.junit.Test
    public void stringReplace(){
        String s = "sdas,asd";
        System.out.println(s.replaceAll(",.*", ""));
        byte b = (byte) 10;
        System.out.println(b);
    }

    @org.junit.Test
    public void matcher() {
        String s = "2017-06-12 16:11:09,930 [main] ERROR [modules.dc.dataprocess.service.DcQueryHiveService] - --> updateHiveTable: \n" +
                "org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.exceptions.TooManyResultsException: Expected one result (or null) to be returned by selectOne(), but found: 2\n" +
                "\tat org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:75)\n" +
                "\tat org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:371)\n" +
                "\tat com.sun.proxy.$Proxy23.selectOne(Unknown Source)\n" +
                "\tat com.hlframe.modules.dc.dataprocess.service.DcQueryHiveService$$EnhancerBySpringCGLIB$$733ea9e0.hiveDS(<generated>)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                "Caused by: org.apache.ibatis.exceptions.TooManyResultsException: Expected one result (or null) to be returned by selectOne(), but found: 2\n" +
                "\tat org.apache.ibatis.session.defaults.DefaultSqlSession.selectOne(DefaultSqlSession.java:70)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor130.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:606)\n" +
                "\tat org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:358)\n" +
                "\t... 90 more";
        Pattern regex = Pattern.compile("(\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}),\\d+\\s\\[(.*?)\\]\\s(.*?)\\s\\[(.*?)\\]([\\s\\S]*)");
        Matcher matcher = regex.matcher(s);
        if (matcher.find()) {
            int totalGroups = matcher.groupCount();
            for (int i = 0, count = totalGroups; i < count; i++) {
                 String ss = matcher.group(i+1);
                System.out.println(i+"  :  "+ss);
            }
        }
    }
}
