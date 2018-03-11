package com.yfs.accumulation.spring.transaction;

import com.yfs.accumulation.spring.transaction.dtconfig.Tx1JavaConfig;
import com.yfs.accumulation.spring.transaction.dtconfig.Tx1JavaConfig2;
import com.yfs.accumulation.spring.transaction.dtconfig.Tx1JavaConfig3;
import com.yfs.accumulation.spring.transaction.dtconfig.Tx1JavaConfig4;
import com.yfs.accumulation.spring.transaction.service.*;
import com.yfs.accumulation.spring.util.LogUtil;
import com.yfs.accumulation.spring.util.ThreadLocalUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.IOException;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws Exception {
//        t1();
//        t2();
//        t3();
//        t4();
//        t5();
//        t6();
        t7();

    }

    public static void t7() throws IOException {
        LogUtil.initLogger();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Tx1JavaConfig4.class);
        MyLessionService4 lessionSvc = ctx.getBean(MyLessionService4.class);
        System.out.println("lessionSvc " + lessionSvc.getClass().getName());
        try {
            lessionSvc.autoAddSessions();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            lessionSvc.addNewLession("leader.us.1111", 9999);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            lessionSvc.addNewLession("java.1111", 9999);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ctx.close();
    }

    public static void t6() throws IOException {
        LogUtil.initLogger();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Tx1JavaConfig3.class);
        MyLessionService2 lessionSvc = ctx.getBean(MyLessionService2.class);
        System.out.println("lessionSvc " + lessionSvc.getClass().getName());
        lessionSvc.otherCall();
        ctx.close();
        //InfrastructureAdvisorAutoProxyCreator
        //AnnotationAwareAspectJAutoProxyCreator s;
        //BeanFactoryAdvisorRetrievalHelper ss;
        //TransactionInterceptor
        //AnnotationTransactionAspect
        //AnnotationTransactionAspect.aspectOf().setTransactionManager(transactionManager);
    }

    public static void t5() throws Exception {
        LogUtil.initLogger();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Tx1JavaConfig2.class);
        MyLessionService5 lessionSvc = ctx.getBean(MyLessionService5.class);
        System.out.println("lessionSvc " + lessionSvc.getClass().getName());
        try {
            lessionSvc.autoAddSessions();
        } catch (Exception e) {
            e.printStackTrace();
        }
        lessionSvc.addNewLession("leaderus.1111", 9999);
        ctx.close();
    }

    public static void t4() throws IOException {
        LogUtil.initLogger();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Tx1JavaConfig2.class);
        MyLessionService3 lessionSvc = ctx.getBean(MyLessionService3.class);
        System.out.println("lessionSvc " + lessionSvc.getClass().getName());
        lessionSvc.otherCall();
        ctx.close();

    }

    public static void t3() throws IOException {
        LogUtil.initLogger();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Tx1JavaConfig.class);
        PlatformTransactionManager txMan = ctx.getBean(PlatformTransactionManager.class);
        MyLessionService lessionSvc = ctx.getBean(MyLessionService.class);
        TransactionTemplate txTemp = new TransactionTemplate(txMan);
        txTemp.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        txTemp.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txTemp.setTimeout(300);
        txTemp.execute(t -> {
            try {
                lessionSvc.addNewLession("java one", 10000);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
        ctx.close();
    }

    public static void t2() throws SQLException, IOException {
//System.setProperty("java.util.logging.config.file", "jdk-log.properties");
        LogUtil.initLogger();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Tx1JavaConfig.class);
        PlatformTransactionManager txMan = ctx.getBean(PlatformTransactionManager.class);

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        def.setTimeout(300);
        TransactionStatus firstTXstatus = txMan.getTransaction(def);

        MyLessionService lessionSvc = ctx.getBean(MyLessionService.class);
        lessionSvc.addNewLession("java one", 10000);
        //second transaction
        System.out.println("start new transaction ");
        def = new DefaultTransactionDefinition();
        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        def.setTimeout(300);
        TransactionStatus secondStatus = txMan.getTransaction(def);
        try {
            lessionSvc.queryLessions();
            if (false) {
                throw new RuntimeException("failed trans");
            }
            txMan.commit(secondStatus);
        } catch (Exception e) {
            e.printStackTrace();
            txMan.rollback(secondStatus);
        }
        txMan.commit(firstTXstatus);
        ctx.close();
    }

    public static void t1() throws SQLException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Tx1JavaConfig.class);
        PlatformTransactionManager txManager = ctx.getBean(PlatformTransactionManager.class);
        ThreadLocalUtil.dumphreadLocals();
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        def.setTimeout(300);
        TransactionStatus status = txManager.getTransaction(def);
        ThreadLocalUtil.dumphreadLocals();
        MyLessionService lessionSvc = ctx.getBean(MyLessionService.class);
        ThreadLocalUtil.dumphreadLocals();
        lessionSvc.addNewLession("java one", 10000);
        ThreadLocalUtil.dumphreadLocals();
        lessionSvc.queryLessions();
        ThreadLocalUtil.dumphreadLocals();
        txManager.commit(status);
        ThreadLocalUtil.dumphreadLocals();
        ctx.close();
    }
}
