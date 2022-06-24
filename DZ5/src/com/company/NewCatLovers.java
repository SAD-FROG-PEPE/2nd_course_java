package com.company;

import java.util.ArrayList;

public class NewCatLovers extends Thread {
   CatLover catLover;
    ArrayList<CatLover> catLovers;
    int rand;

   public NewCatLovers(CatLover catLover, ArrayList<CatLover> catLovers,int rand)
   {
       this.catLover=catLover;
       this.catLovers=catLovers;
       this.rand=rand;
   }
    @Override
    public void run()
    {
            try{
                System.out.println("\u001b[38;5;1mПоприветствуем новых кошатников! : \u001b[38;5;0m");
                for (int i=0;i<rand;i++)
                {
                    catLovers.add(new CatLover());
                    System.out.println(catLovers.get(catLovers.size()-1).getInfo());
                    sleep(1000);
                }
            }catch(InterruptedException e)
            {
                System.out.println("\u001b[38;5;4m=========================InterruptedException=====================\u001b[38;5;0m");
                System.out.println(e.getMessage());
            }
    }
}
