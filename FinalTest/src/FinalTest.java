public class FinalTest{
    public static void main(String[] args)
    {
        FinalTest x = new FinalTest();
        int myVar = 7;
        int yourVar = myVar - 3;
        yourVar = x.processVar1(yourVar);
        x.print(yourVar);
        System.out.println("yourVar+5");
        int theirVar = 4;
        myVar += theirVar;
        x.print(myVar);
        System.out.println("ourVar" + yourVar + theirVar);
        x.print(x.processVar2(5));
        System.out.println(x.processVar2(theirVar++));
        System.out.println(("ourVar" + yourVar) + theirVar);
    }
    public int processVar1(int passVar)
    {
        int thisVar = 15;
        thisVar = passVar * thisVar;
        thisVar = processVar2(thisVar);
        print(thisVar*3);
        return thisVar;
    }
    public int processVar2(int passVar)
    {
        int thatVar = 10;
        thatVar = passVar / thatVar;
        return thatVar;
    }
    public void print(int xvar)
    {
        System.out.println(xvar);
        return;
    }
}
