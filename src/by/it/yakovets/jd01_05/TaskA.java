package by.it.yakovets.jd01_05;
import static java.lang.Math.*;
class TaskA{
    public static void main(String[] args){
step1();
step11();
step2();
step3();
//step5();
//step6();
// step7();
    }
    static void step1(){
        double a=756.13;
        double x=0.3;
        double z=cos(pow((pow(x,2)+PI/6),5))-sqrt(x*pow(a,3))-log(abs((a-1.12*x)/4));
        System.out.println(z);
    }
    static void step2(){
        double a=756.13;
        double x=0.3;
        double z1=cos(pow((pow(x,2)+PI/6),5));
        double z2=sqrt(x*pow(a,3));
        double z3=log(abs((a-1.12*x)/4));
        double z=z1-z2-z3;
        System.out.println(z);
    }
    static void step11(){
        double a=1.21;
        double b=0.371;
        double y=tan(pow((a+b),2))-cbrt(a+1.5)+a*(pow(b,5))-b/log(pow(a,2));
        System.out.println(y);
    }
    static void step3(){

        double x=12.1;
        for (double a=-5; a<=12; a=a+3.75){
            double f=exp(a*x)-3.45*a;
            System.out.printf("При а=%6.2f f=%g\n",a,f);
        }
    }

}