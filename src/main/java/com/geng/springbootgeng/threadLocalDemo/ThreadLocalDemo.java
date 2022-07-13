package com.geng.springbootgeng.threadLocalDemo;

public class ThreadLocalDemo {

    ThreadLocal<String> threadLocal=new ThreadLocal<>();
    private String content;

    private String getContent() {
        //return content;
        return threadLocal.get();
    }

    private void setContent(String content) {
        //this.content=content;
        threadLocal.set(content);
    }

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();

        for(int i=0; i<5; i++) {
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println("--------------------------");
                    System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
                }
            });

            thread.setName("线程" + i);
            thread.start();
        }
    }
}
