public interface ListInt
{
  private int[] _data;
  private int _size;
  public void add(int newVal);
  public void add(int index, int newVal);
  public void remove(int index);
  public int size();
  //public int get(int index); // this works
  //public int set(int index); // this does not work, Error: SuperArray is not abstract and does not override abstract method set(int) in ListInt
  
}
