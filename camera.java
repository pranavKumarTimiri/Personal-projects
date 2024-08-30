import java.util.*;
class camera{
    static Scanner sc=new Scanner(System.in);
    ArrayList<String> k1 = new ArrayList<String>();
    ArrayList<String> m1 = new ArrayList<String>();
    ArrayList<Boolean> b = new ArrayList<Boolean>();
    ArrayList<Integer> i1 = new ArrayList<Integer>();
    ArrayList<String> usercameras = new ArrayList<String>();
    ArrayList<String> rentedcamera = new ArrayList<String>();
    int balance=300;
    void addcamera(String brand,String model,int price){
        usercameras.add(brand);
        k1.add(brand);
        m1.add(model);
        i1.add(price);
        b.add(true);
    }
  void removecamera(String brand){
        for(int i=0;i<usercameras.size();i++) {
            if (brand.equals(usercameras.get(i))){
                usercameras.remove(i);
                 for(int j=0;j<k1.size();j++) {
                     if(brand.equals(k1.get(j))) {
                         k1.remove(j);
                         m1.remove(j);
                         i1.remove(j);
                         b.remove(j);
                     }
                 }
            }
        }
  }
  void usercam(){
        for(int i=0;i<usercameras.size();i++){

               for(int j=0;j<k1.size();j++){
                   if(usercameras.get(i).equals(k1.get(j))){
                       System.out.println(usercameras.get(i)+"        "+(b.get(i)?"available ":"rented"));
                   }
               }
        }
    }
    void rentedcam(){
        for(int i=0;i<rentedcamera.size();i++){

            for(int j=0;j<k1.size();j++){
                if(rentedcamera.get(i).equals(k1.get(j))){
                    System.out.println(rentedcamera.get(i));
                }
            }
        }
    }

    private boolean l;
    private boolean k;
    public camera() {
        k1.add("canon");
        k1.add("sony");
        k1.add("nikon");
        k1.add("chroma");

        k1.add("LG");
        m1.add("xc");
        m1.add("xlr");
        m1.add("dslr");
        m1.add("mt");
        m1.add("kr1234");
        i1.add(500);
        i1.add(500);
        i1.add(500);
        i1.add(500);
        i1.add(500);
        b.add(true);
        b.add(true);
        b.add(true);
        b.add(true);
        b.add(true);
        this.l=false;
        this.k=false;
    }





    void  rentbikebrand(String  bike){
        boolean t=false;
        for(int i=0;i<k1.size();i++){
            if(bike.equals(k1.get(i))&& b.get(i)){
                t=true;
                System.out.println("enter how many days :");
                int days =sc.nextInt();
                int u=days*i1.get(i);
                System.out.println("The amount for "+days+" is :"+u);
                System.out.println("The wallet balance is "+balance);
                if (u>balance){
                    System.out.println("Insufficient balance please deposit in your wallet");
                }else {
                    System.out.println("DO YOU WANT TO PAY (1.yes or 2.no) " + u);
                    String e = sc.next();
                    switch (e) {
                        case "1":
                            balance = balance - u;
                            b.set(i,false);
                            rentedcamera.add(bike);
                            System.out.println("rented successfully ");
                            break;
                        case "2":
                            break;

                    }
                }
            }
        }

        if(t){

        }else{
            System.out.println("The camera is not available or Invalid camera brand");

        }

    }

   void returncamera(String bike){
       boolean t=false;
       for(int i=0;i<rentedcamera.size();i++){
           if(rentedcamera.equals(bike)) {
               System.out.println("Do you want return the camera (1.yes or 2.no) :" );
               String c=sc.next();
               switch (c){
                   case  "1":
                   for (int j = 0; j < k1.size(); j++) {
                       if (bike.equals(k1.get(j)) && !b.get(j)) {
                           t = true;
                           b.set(j,true);
                           rentedcamera.remove(i);
                       }
                   }
                   break;
                   case "2":
                       break;
               }


           }
       }

       if(t){

       }else{
           System.out.println("The camera is not available or Invalid camera brand");

       }
   }
    void display(){

        for(int i=0;i<k1.size();i++){
            System.out.println(k1.get(i)+"     "+m1.get(i)+"         "+i1.get(i)+"rs                    "+(b.get(i)?"available":"Rented"));
        }
    }

    int  wallett(int deposit){
        balance+=deposit;
        return balance;
    }

}
class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        camera obj1=new camera();

        System.out.println("********************************************              ");
        System.out.print("\n");

        System.out.println("*     welcome to the camera rentals        *                ");

        System.out.print("\n");
        System.out.println("********************************************              ");

           ArrayList<String> user=new ArrayList<String>();
        ArrayList<String> pass=new ArrayList<String>();
         user.add("pranavkumar");
         pass.add("pranav@2002");

         while (true) {
             System.out.println("USERNAME                     ");
             String username = sc.nextLine();
             System.out.println("PASSWORD                    ");
             String password = sc.nextLine();
             boolean e=false;
             for(int i=0;i<user.size();i++){
                 if(username.equals(user.get(i))){
                     if(password.equals(pass.get(i))){
                       e=true;
                     }
                 }
             }
             if(e){
                 break;
             }else{
                 System.out.println("Invalid username or password ");
             }
         }
        System.out.println("LOGINED SUCCESSFULLY              ");
        while (true) {

            System.out.println("                                            \ncamera Rental  Menu:");
            System.out.println("WALLET BALANCE :"+obj1.balance);
            System.out.println("1.  MY CAMERA");
            System.out.println("2. RENT A CAMERA");
            System.out.println("3. VIEW ALL CAMERA");
            System.out.println("4. MY WALLET");
            System.out.println("5. YOUR RENTED CAMERAS");
            System.out.println("6. EXIT");
            System.out.println("ENTER YOUR CHOICE : ");
            String choice = sc.next();

            while (true) {

                String s = choice;
                System.out.println(s);
                if ((s.equals("0") || s.equals("1") || s.equals("2") || s.equals("3")||s.equals("4")||s.equals("5")||s.equals("6"))) {

                    break;
                } else {
                    while (true) {
                        boolean b = true;
                        System.out.println(" invalid choice ");
                        System.out.println("1.do you want continue");
                        System.out.println("2.exit");
                        String t = sc.next();
                        switch (t) {
                            case "1":
                                System.out.println("enter your choice");
                                String choice1 = sc.next();
                                s = choice1;
                                choice = choice1;
                                b = false;
                                break;
                            case "2":
                                System.out.println("                                    exiting the system ");
                                System.exit(0);
                        }


                        if (!b) {
                            break;
                        }
                        System.out.println(" Invalid option ");
                    }
                }
            }

            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case "1":
                    System.out.println("1.add camera");
                    System.out.println("2.remove camera");
                    System.out.println("3.my camera");
                    System.out.println("4.return to main menu");
                    String e=sc.next();
                    switch (e) {
                        case "1":
                            System.out.println("enter tha camera name");
                            String brand = sc.next();
                            System.out.println("enter the model");
                            String model = sc.next();
                            System.out.print("enter the price");
                            int price = sc.nextInt();
                            obj1.addcamera(brand, model, price);

                            break;
                        case "2":
                            System.out.println("enter the camera");
                            String brand2=sc.next();
                            obj1.removecamera(brand2);
                            break;
                        case "3":
                            obj1.usercam();
                            break;
                        case "4":
                            break;
                    }
                    break;
                case "2":
                    obj1.display();
                    System.out.println("enter tha camera name :");
                    String k=sc.next();
                      obj1.rentbikebrand(k);
                    break;
                case "3":
                    obj1.display();
                    break;
                case "4":
                    System.out.println("YOUR CURRENT WALLET BALANCE IS  :"+obj1.balance);
                    System.out.println("DO YOU WANT TO DEPOSIT (1.YES OR 2.NO :) ");
                    String y=sc.next();
                    switch (y){
                        case "1":
                            System.out.println("please enter the amount you want deposit :");
                            int a=sc.nextInt();
                            obj1.wallett(a);
                            break;
                        case "2":
                            break;
                    }
                    break;
                case "5":
                    obj1.rentedcam();
                    System.out.println("DO YOU WANT TO RETURN CAMERA (1.YES OR 2.NO :) ");
                    String s=sc.next();
                    switch (s){
                        case "1":
                            obj1.rentedcam();
                            System.out.println("enter tha camera name :");
                            String v=sc.next();
                            obj1.returncamera(v);
                            break;
                        case "2":
                            break;
                    }

                    break;
                case "6":
                    System.exit(0);
                    break;
            }
        }
    }
}