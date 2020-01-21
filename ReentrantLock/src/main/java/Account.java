
class Account
{
    int balance=10;
    int totalBalance=0;

    public void deposit(int amount)
    {
        this.balance=this.balance+amount;
    }

    public void withdraw(int amount)
    {
            this.balance=this.balance-amount;
    }
}
