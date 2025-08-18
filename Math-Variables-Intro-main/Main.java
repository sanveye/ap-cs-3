class Main {
  public static void main(String[] args) {

    //Use the // to create single line comments to either add info or to take out code for debugging
    // okay

    System.out.println("Hello world!");

    //We will be using System.out.println and System.out.print throughout the year. Try using both below to see what the difference is!

  
    //ANSWER: 
    System.out.println("whats up guys");
    System.out.print("hey whats up");



    //Throughout the year this year we will need to store information. For that we will be using VARIABLES!

    //Java is an Object-Oriented programming language. All variables we use this year will either be OBJECTS or PRIMITIVES

    //There are 8 primitives in Java: int, byte, short, long, float, double, boolean, char

    //For AP we need to know: int, double, boolean

    //List examples of the types below and give definition
    //int (integer): a whole number (8, 90832, 0)
    //double: a decimal (7.8, 6.7865)
    //boolean: a true or false value (true, false)

    //For now we are just going to work with primitive

    //Create 3 variables of each of the above types (USE GOOD CODING PRACTICE WHEN CREATING THE VARIABLES

    int age = 15;
    int numberOfCandies = 10;
    int sides = 13;
    boolean canSwim = false;
    boolean isCool = true;
    boolean canRun = true;
    double weight = 7.8;
    double allowance = 100.8;
    double cost = 67.67;





    //MATH TIME!

    //What are the math operators that we can use?
    //+ - * / %

    //Try doing some math operations with numbers. How can we check to see if the math worked?

    System.out.println(3+7);

    //Create codes that will print the following:

    //Odd integers from 1 to 100, inclusive of both

    for (int count = 1; count < 100; count+=2){
      System.out.print(count + ", ");
    }
    System.out.println("Odd numbers printed");
    //All multiples of 3 from 1 to 100

    for (int count = 3; count < 100; count +=3){
      System.out.print(count + ", ");
    }
    System.out.println("Multiples of 3 printed");
    //Starting at 1000, print on the same line (with a - [hypthen] between each) all of the numbers that end in 0 going down to 0

    for (int count = 1000; count > 1 ; count-=10){
      System.out.print(count + " - ");
    }
  }
}
