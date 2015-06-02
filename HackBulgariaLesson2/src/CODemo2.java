class CODemo2
{
   int i = 3;
   public static void main (String [] args)
   {
      CODemo2 obj1 = new CODemo2 ();
      System.out.println ("obj1.i = " + obj1.i);
      obj1.printHello ();
      CODemo2 obj2 = new CODemo2 ();
      obj1.i = 5;
      System.out.println ("obj1.i = " + obj1.i);
      obj1.printHello ();
      System.out.println ("obj2.i = " + obj2.i);
      obj2.printHello ();
   }
   void printHello ()
   {
      System.out.println ("Hello! i = " + i + "\n");
   }
}