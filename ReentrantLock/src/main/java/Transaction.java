public class Transaction implements Runnable
{
    private Bank bank;
    private int amount=0;
    private int from=0;
    private int to;

    Transaction(Bank bank, int from)
    {
        this.bank=bank;
        this.from=from;
    }

    public void run()
    {

        while(true)
        {
            to=(int)(Math.random()*10);
            amount=(int)(Math.random()*10);
            try {
                bank.transfer(from,to,amount);  //To is generated randomlly since if any "account object"(in bank obj) is LESS value, some thread would later deposit it.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

 class MainApp
{
    public static void main(String[]args)
    {
            Bank bank=new Bank();
            Thread thread1=null;
            Transaction transaction1;

            for(int i=0;i<10;i++)
            {
                    System.out.println("Started thread: "+Thread.currentThread().getName());
                    transaction1=new Transaction(bank,i);
                    new Thread(transaction1).start();
            }
    }
}
