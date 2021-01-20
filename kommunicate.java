import java.util.*;

 abstract class cars{                                   //Abstract class implemented

    int id;
    String regno;
    String color;

    public abstract void  setcars(int ID,String REG,String COLOR);


}



// Inheritance Implemented
class parking extends cars {

    public void setcars(int ID,String REG,String COLOR)
    {
        id=ID;
        regno=REG;
        color=COLOR;
    }

    public void setparking(cars a,String newreg,String newcolor)
    {
        a.regno=newreg;
        a.color=newcolor;
    }

    public void removeparking(cars a)
    {
            a.color="";
            a.regno="";
            System.out.println("Slot number "+a.id+" is free");
    }

    public void status(cars[]a)
    {
        List<Integer> x = new ArrayList<Integer>();                         //list implemented
        List<String> y = new ArrayList<String>();
        List<String> z = new ArrayList<String>();
        int i=0;
        while(i<a.length)
        {
            if(!a[i].color.equals(""))
            {
                x.add(a[i].id);
                y.add(a[i].regno);
                z.add(a[i].color);
             }
             i++;
        }
        if(x.size()>0)
        {
            System.out.println("Slot No.");
        for(Integer val : x)                                //forEach loop implemented
        {
            System.out.println(val);
        }
        System.out.println("Registration No");
        for(String val : y) {
            System.out.println(val);
        }
        System.out.println("Colour");
        for(String val : z) {
            System.out.println(val);
        }
    }
    else{
        System.out.println("All slots are vaccant !");
    }
      
    }


    public void displayregcolor(String color,cars[]a)
    {
        List<String> l = new ArrayList<String>();
        StringBuilder sb=new StringBuilder();        // StringBuilder implemented
        int i=0;
        while(i<a.length)
        { 
            if(a[i].color.equals(color))
            {l.add(a[i].regno);}
            i++;
        }
        if(l.size()>0){
        for(String val : l) {
            sb.append(val);                             
            sb.append(", ");
        }
      String  str=sb.toString();
        str=str.substring(0,str.length()-2);
        System.out.println(str);
        }   
        else{
            System.out.println("Not found");
        }
        
    }


    public void displayslotcolor(String color,cars[]a)
    {
        List<Integer> l = new ArrayList<Integer>();
        StringBuilder sb=new StringBuilder();        // StringBuilder implemented
        int i=0;
        while(i<a.length)
        { 
            if(a[i].color.equals(color))
            {
                l.add(a[i].id);
            }
            i++;
        }
        if(l.size()>0){
        for(Integer val : l) {
            sb.append(val.toString());                             
            sb.append(", ");
        }
      String  str=sb.toString();
        str=str.substring(0,str.length()-2);
        System.out.println(str);
        }
        else{
            System.out.println("Not found");
        }
        
    }

    public void displayslotreg(String regno,cars[]a)
    {
        List<Integer> l = new ArrayList<Integer>();
        StringBuilder sb=new StringBuilder();        // StringBuilder implemented
        int i=0;
        while(i<a.length)
        { 
            if(a[i].regno.equals(regno))
            {
                l.add(a[i].id);
            }
            i++;
        }

        if(l.size()>0){
        for(Integer val : l) {
            sb.append(val.toString());                            
            sb.append(", ");
        }
      String  str=sb.toString();
        str=str.substring(0,str.length()-2);
        System.out.println(str);
        }
        else{
            System.out.println("Not found");
        }
        
    }
    

}

//Below the class containing main

public class kommunicate {
public static void main(String[] args) {
    
Scanner sc=new Scanner(System.in);
String str1= sc.nextLine();
String str2;
String str[]= str1.toString().split("\\s+");
Arrays.toString(str);
if(str[0].equals("exit"))
{
    System.exit(1);
}

else if(!str[0].equals("create_parking_lot"))
{
    System.out.println("Parking slot not created !");
    System.exit(1);
}
else{
    boolean check=true;
    while(check)
    {   
        String strslots=str[1];
        cars obj[];
        int  slots=Integer.parseInt(strslots);
        obj=new cars[slots];
        
        for(int i=0;i<slots;i++)
        {
            obj[i]=new parking();
            
        }
        for(int i=0;i<slots;i++)
        {
            obj[i].setcars(i+1,"","");
            
        }
        System.out.println("Created a parking lot with "+(slots)+ " slots");
            


        while(check){
         str2=sc.nextLine();
         String input[]= str2.toString().split("\\s+");
            Arrays.toString(input);


        switch(input[0]){                                          // switch statement implemented
            case "park":
            int count=0;
                for(int i=0;i<slots;i++)
                {
                    if((obj[i].regno).equals(""))
                    {
                        parking park=new parking();
                        park.setparking(obj[i],input[1],input[2]);
                        System.out.println("Allocated slot number: "+(i+1));
                        count=1;
                        break;
                    }
                }
                if(count==0)
                {
                    System.out.println("Sorry, parking lot is full");
                }
        
            break;

            case "leave":
                parking park=new parking();
                int num=Integer.parseInt(input[1]);
                if(num<=slots&&num>0)
                {park.removeparking(obj[num-1]);}
                else{
                    System.out.println("Don't have this slot !");
                }
                
            break;
            
            case "status":
                park=new parking();
                    park.status(obj);
                    
                
            break;

            case "registration_numbers_for_cars_with_colour":
                 park=new parking();
                 park.displayregcolor(input[1],obj );
            break;

            case "slot_numbers_for_cars_with_colour":
                 park=new parking();
                 park.displayslotcolor(input[1],obj);
            break;

            case "slot_number_for_registration_number":
                 park=new parking();
                 park.displayslotreg(input[1],obj);
            break;

            case "exit":
                 check=false;
            break;
            default:
             System.out.println("Command not found !");
            break;

            
        }
    }

        
         
    }
}

}
    
}