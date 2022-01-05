package test;

class TestSleepMethode1 extends Thread{
    public void run(){
        for(int i=1;i<5;i++){
            // the thread will sleep for the 500 milli seconds
            try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
            System.out.println(i);
        }
    }
    public static void main(String args[]){
        TestSleepMethode1 t1=new TestSleepMethode1();
        TestSleepMethode1 t2=new TestSleepMethode1();
        TestSleepMethode1 t4=new TestSleepMethode1();
        TestSleepMethode1 t3=new TestSleepMethode1();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}  