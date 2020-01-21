import java.util.concurrent.locks.ReentrantLock;

class Transaction
{
    Account account1=new Account();
    Account account2=new Account();
    int from,to,amount;
    ReentrantLock lock1=new ReentrantLock();
    ReentrantLock lock2=new ReentrantLock();

    public void firstThread()
    {
        for(int i=0;i<1000;i++)
        {
            try
            {
                lock1.lock();
                lock2.lock();
                Account.deposit(account1,account2,(int)(Math.random()*10));
            }
            finally
            {
                System.out.println("Account 1 balance:"+account1.getBalance());
                lock1.unlock();
                lock2.unlock();
            }

        }

    }

    public void secondThread()
    {
        for(int i=0;i<1000;i++)
        {
            try
            {
                lock1.lock();
                lock2.lock();
                Account.withdraw(account1,account2,(int)(Math.random()*10));
            }
            finally
            {
                System.out.println("Account 2 balance:"+account2.getBalance());
                lock1.unlock();
                lock2.unlock();
            }

        }
    }

    public void getBalance()
    {

        System.out.println("Total Balance is: "+Account.balance);
    }


}



public class DeadlockDemo
{

    public static void main(String[] args)
    {

        final Transaction transaction=new Transaction();

        Thread thread1=new Thread(new Runnable()
        {
            public void run()
            {

                transaction.firstThread();
            }
        });

        Thread thread2=new Thread(new Runnable()
        {
            public void run()
            {

                transaction.secondThread();


            }
        });

        thread1.start();
        thread2.start();

        transaction.getBalance();

    }

}
