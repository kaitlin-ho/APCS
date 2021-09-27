public class Time{
    public static void main(String[] args) {

int hour = 14;
int minute = 30;
int second = 00;

double secondsPassed = hour*3600 + minute*60 + second;
double secondsRemaining = 24*3600 - secondsPassed;
double percentPassed = secondsPassed/(24*3600)*100;

System.out.println(secondsPassed);
System.out.println(secondsRemaining);
System.out.println(percentPassed);

int hour1 = 14;
int minute1 = 38;
int second1 = 00;
int secondsPassed2 = hour1*3600 + minute1*60 + second1;

System.out.println(secondsPassed2 - secondsPassed);



    }
  }
