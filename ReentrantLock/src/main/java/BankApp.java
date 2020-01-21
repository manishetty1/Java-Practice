import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Bank {

    Account account[] = new Account[10];

    public static ReentrantLock lock;
    public static Condition availableMoneyCond;


    Bank()
    {
        for (int i = 0; i < 10; i++)
        {
            account[i] = new Account();
        }
        lock = new ReentrantLock();
        availableMoneyCond = lock.newCondition();
    }

    public void transfer(int from, int to, int amount) throws InterruptedException
    {
        lock.lock();
        System.out.println("Started thread: " + Thread.currentThread().getName());
        try
        {

            while ((account[from].balance < amount) || (amount == 0) || (from == to))
            {
                availableMoneyCond.await(); //Makes the threads which satisfy the condition wait and give away controll, till someother thread puts in the money (deposits) to the current account[i] and therefore breaks the while condition i.e (account[from].balance < amount).
            }

            System.out.println("\n \nAmount to be transferred " + amount);
            System.out.println("Transferring from: " + from + " to " + to);
            account[to].deposit(amount);
            account[from].withdraw(amount);

            getTotalBalance(account);
            availableMoneyCond.signalAll(); //Wakes up all the thread that were waiting for (account[from].balance < amount) condition wake up. Threadscheduler would pick randomly.
        }
        finally
        {
            lock.unlock();
        }


    }

    public int getTotalBalance(Account[] account)
    {
        lock.lock();
        int totalBalance = 0;
        try
        {
            for (int i = 0; i < account.length; i++)
            {
                totalBalance = totalBalance + account[i].balance;
            }
            System.out.println("Total Balance: " + totalBalance);
        }
        finally
        {
            lock.unlock();
        }

        return totalBalance;

    }
}