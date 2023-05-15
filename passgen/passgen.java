package passgen;
import java.util.Random;
abstract class passgen {
    static String pass = new String("");
    abstract String gen_pass();
}

class pass extends passgen{
    String gen_pass(){
        int size = 8;
        while(size != 0) {
            Random random = new Random();
            int index = 0;
            while (true) {

                index = random.nextInt(48, 122);

                if(index >= 48 && index <=57)
                    break;
                else if (index >=63 && index<=90)
                    break;
                else if (index > 97)
                    break;
            }
            char temp = (char) index;
            pass = pass + temp;
            size--;
        }
        return pass;
    }
}