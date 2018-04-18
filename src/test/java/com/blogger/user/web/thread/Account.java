package com.blogger.user.web.thread;

/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-04-01 23:04
 * @desc
 * @since 1.8
 */

public class Account {

    private ThreadLocal<String> name = new ThreadLocal<String>();

    public Account(String name) {

        this.name.set(name);
        System.out.println(name);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}

class Mytest extends Thread {

    private Account account;

    public Mytest(Account account, String name) {

        super(name);
        this.account = account;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            if (i == 6) {

                account.setName(getName());
            }

            System.out.println(account.getName());
        }
    }
}

class ThreadLocalTest {

    public static void main(String[] args) {

        Account account = new Account("初始名");

        new Mytest(account, "线程甲").start();

        new Mytest(account, "线程乙").start();
    }
}
