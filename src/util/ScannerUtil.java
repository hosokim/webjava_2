package util;
import java.util.Scanner;

public class ScannerUtil {
  static Scanner mScan;
  
  public static String getNextInput() {
      if (mScan == null) {
          mScan = new Scanner(System.in);
      }
      return mScan.next();
  }
  
  public static void destroyScanner() {
      if (mScan != null) {
          mScan.close();
          mScan = null;
      }
  }
}
