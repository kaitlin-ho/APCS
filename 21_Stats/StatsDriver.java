public class StatsDriver {
  public static void main(String[] args){

    System.out.println(Stats.mean(1,5) + "...should be 3");
    System.out.println(Stats.mean(1,1) + "...should be 1");
    System.out.println(Stats.mean(0,12000) + "...should be 6000");
    System.out.println(Stats.mean(1.0,5.3) + "... should be 3.15");
    System.out.println(Stats.mean(1.0,1.0) + "...should be 1.0");
    System.out.println(Stats.mean(-100,-200) + "...should be -150");
    System.out.println(Stats.max(1,5) + "... should be 5");
    System.out.println(Stats.max(1.0,5.0) + "...should be 3.0");
    System.out.println(Stats.max(1,10000) + "...should be 10000");
    System.out.println(Stats.max(1.0,9.67) + "... should be 9.67");
    System.out.println(Stats.max(1,2,3) + "... should be 3");
    System.out.println(Stats.max(1.0,2.0,3.0) + "... should be 3.0");
    System.out.println(Stats.max(500,1700,900) + "... should be 1700");
    System.out.println(Stats.max(-1100,-500,-900) + "... should be -500");
    System.out.println(Stats.max(1.123912849,5.123812751) + "...should be 5.123812751");
    System.out.println(Stats.max(-1,-10000) + "...should be -1");
    System.out.println(Stats.geoMean(1,9) + "... should be 3");
    System.out.println(Stats.geoMean(1.0,9.0) + "... should be 3.0");
    System.out.println(Stats.geoMean(0,0) + "... should be 0");
    System.out.println(Stats.geoMean(0,5903) + "... should be 0");
    System.out.println(Stats.geoMean(0,0.213124) + "... should be 0.0");
    System.out.println(Stats.geoMean(1,289) + "... should be 17");
    System.out.println(Stats.geoMean(4,4,4) + "... should be 4");
    System.out.println(Stats.geoMean(1,1,64) + "... should be 4");
    System.out.println(Stats.geoMean(1.0,10.0,100.0) + "... should be 10.0");
  }
}
