import java.io.*;
import java.util.Scanner;

public class student {
    public static void main(String[] args)  {
        boolean login=false;
        Scanner sc=new Scanner(System.in);
        //file create...
        File f = new File("detail.txt");
        try{
            if(f.createNewFile()){
                System.out.println("File is created successfully");
            }
            else {
                System.out.println("File not created");
            }
        } catch (IOException e) {
            System.out.println("File Error...");
        }
        System.out.println("Press 1: Login");
        System.out.println("Press 2: Create Account");
        System.out.println("Press 3: Exit");
        int press= sc.nextInt();
        switch (press)
        {
            case 2:
            {
                // create account.....
               System.out.println("Enter your name:");
               String name=sc.next();
               System.out.println("Enter username:");
               String username=sc.next();
               System.out.println("Enter password:");
               String pass1=sc.next();
               System.out.println("Confirm password:");
               String pass2=sc.next();

               if (pass1.equals(pass2))
               {
                   System.out.println("Account Created Successfully ");
               }
               else {
                   System.out.println("Password not Match...");
                   System.exit(404);
               }

               try{
                FileOutputStream fout = new FileOutputStream("detail.txt",true);
                PrintStream pout = new PrintStream(fout);
                   pout.print(username + " ");
                   pout.println(pass1);
                   System.out.println("file successfully wrote");
                   pout.close();
               }
               catch (IOException e) {
                   System.out.println("File not Occur..");
                   e.printStackTrace();
               }
                break;
            }
           case 1:
           {
               System.out.println("Enter username");
               String user1=sc.next();
               System.out.println("Enter password");
               String pass=sc.next();

                    try{
                        FileReader read=new FileReader("detail.txt");
                        Scanner s=new Scanner(read);
                        while (s.hasNext())
                        {
                            if(user1.equals(s.next())&&pass.equals(s.next())) {
                                System.out.println("login successfully..");
                                login = true;
                                break;
                            }
                        }
                        if(login == false)
                        {
                            System.out.println("Invalid !!");
                        }
                    }
                    catch (Exception e){
                        System.out.println("login error");
                        e.printStackTrace();
                    }

               break;
               }
            case 0:{
                System.out.println("exit");
                break;
            }

            default:
                System.out.println("not yet...");
                break;
        }

    }
}




 /*
               //fill three students detail......
               if(login==true){
                   int count =3;

                   int rank_number[];
                   String rank_name[];
                   rank_name=new String[3];
                   rank_number=new int[3];

                   for(int i=0;i<3;i++)
                   {
                       //name
                       System.out.println("Enter your name");
                       String name=sc.next();
                       rank_name[i]=name;
                       //father name
                       System.out.println("Enter father name");
                       String father=sc.next();
                       //mother name
                       System.out.println("Enter mother name");
                       String mother=sc.next();
                       //school
                       System.out.println("Enter school name");
                       String school=sc.next();
                       // subjects names...
                       System.out.println("Enter hindi marks");
                       double hindi=sc.nextDouble();
                       System.out.println("Enter maths marks");
                       double math=sc.nextDouble();
                       System.out.println("Enter science marks");
                       double science=sc.nextDouble();
                       System.out.println("Enter social science marks");
                       double ss=sc.nextDouble();
                       System.out.println("Enter engilsh marks");
                       double eng=sc.nextDouble();

                       //total marks...
                       double totalMarks= (hindi+math+eng+science+ss);
                       rank_number[i]= (int) totalMarks;
                       int per= (int) ((totalMarks/600)*100);

                       // push all detail in txt file..
                       try{
                           FileOutputStream out=new FileOutputStream(i+".txt");
                           PrintStream write=new PrintStream(out);
                           write.println(name);
                           write.println(father);
                           write.println(mother);
                           write.println(school);
                           write.println(hindi);
                           write.println(math);
                           write.println(ss);
                           write.println(science);
                           write.println(eng);
                           write.println(totalMarks);
                           write.println(per);

                       }
                       catch (IOException e)
                       {
                           e.printStackTrace();
                       }
                   }
                        int maxVal=rank_number[0];
                   int minVal=rank_number[0];
                   int maxIndex=0;
                   int minIndex=0;

                   for (int j=0;j<rank_number.length;j++)
                   {
                       if(rank_number[j]>maxVal)
                       {
                           maxVal=rank_number[j];
                           maxIndex=j;
                       }
                       if(rank_number[j]<minVal)
                       {
                           minVal=rank_number[j];
                           minIndex=j;
                       }
                   }
                   int secondRank=(3-(maxIndex+minIndex));


                   try{
                       FileOutputStream fo=new FileOutputStream("rank.txt");
                       PrintStream w=new PrintStream(fo);
                       w.println("first rank holder:"+rank_name[maxIndex]);
                       w.println("second rank holder:"+rank_name[secondRank]);
                       w.println("third rank holder:"+rank_name[minIndex]);
                   } catch (IOException e) {
                       e.printStackTrace();

                   }
               } */