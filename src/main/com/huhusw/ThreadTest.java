package com.huhusw;

import java.util.concurrent.TimeUnit;

public class ThreadTest {
    volatile int index = 0;

    public static void main(String[] args) throws Exception {
        ThreadTest test = new ThreadTest();
        test.imm(test);
    }

    private void imm(ThreadTest test) {
        ThreadA threadA = new ThreadA(test);
        ThreadB threadB = new ThreadB(test);
        ThreadC threadC = new ThreadC(test);
        new Thread(threadA).start();
        new Thread(threadB).start();
        new Thread(threadC).start();
        while (true) {

        }
    }

    private synchronized void waitA() throws InterruptedException {
        while (index != 1) {
            wait();
        }
    }

    private synchronized void waitB() throws InterruptedException {
        while (index != 2) {
            wait();
        }
    }

    private synchronized void waitC() throws InterruptedException {
        while (index != 0) {
            wait();
        }
    }

    private synchronized void notifyAllThread() {
        index += 1;
        index %= 3;
        notifyAll();
    }

    class ThreadA implements Runnable {
        ThreadTest threadTest;

        public ThreadA(ThreadTest test) {
            this.threadTest = test;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    waitC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程A工作");
                try {
                    TimeUnit.MILLISECONDS.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadTest.notifyAllThread();
            }
        }
    }

    class ThreadB implements Runnable {
        ThreadTest threadTest;

        public ThreadB(ThreadTest test) {
            this.threadTest = test;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    waitA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程B工作");
                try {
                    TimeUnit.MILLISECONDS.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadTest.notifyAllThread();
            }
        }
    }

    class ThreadC implements Runnable {
        ThreadTest threadTest;

        public ThreadC(ThreadTest test) {
            this.threadTest = test;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    waitB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程C工作");
                try {
                    TimeUnit.MILLISECONDS.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadTest.notifyAllThread();
            }
        }
    }
}
