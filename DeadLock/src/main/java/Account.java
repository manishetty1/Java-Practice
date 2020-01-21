public class Account
{
    static int balance=10000;

    public static void deposit(Account from, Account to, int amount)
    {
        balance+=Account.balance;
    }

    public static void withdraw(Account from, Account to, int amount)
    {
        balance-=Account.balance;
    }

    public int getBalance()
    {
        return this.balance;
    }
}
