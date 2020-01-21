import java.sql.SQLOutput;

class Processor
{
    public void produce() throws InterruptedException
    {
        System.out.println("this Hashcode value"+this.hashCode());

        synchronized (this)
        {
            System.out.println("Entered producer block"+Thread.currentThread().getName());
            wait();
            System.out.println("Done executing producer");
        }
    }


    public void consume() throws InterruptedException
    {
        synchronized (this)
        {
            System.out.println("Entered consumer block"+Thread.currentThread().getName());
            notifyAll();
            System.out.println("Done executing consumer!");
        }

    }

}



class MainApp
{

    public static void main(String[] args) throws InterruptedException
    {

        final Processor processor;
        processor = new Processor();
        System.out.println("Hashcode value"+processor.hashCode());
        Thread producerThread=new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    processor.produce();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread=new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    processor.consume();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();


    }

}