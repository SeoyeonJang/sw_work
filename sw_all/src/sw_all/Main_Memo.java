package sw_all;

import java.io.*;
import java.util.Scanner;

public class Main_Memo {
   static Scanner s = new Scanner(System.in);
   public static void main(String args[]) {
      Select_m();
      return;
   }
      static void Select_m(){
         File file = new File("c://Example//File");
         if(!file.exists()){
               file.mkdirs();
           }
         int num = 0;
         while (num != 5) {
            System.out.println("1. 메모 생성");
            System.out.println("2. 메모 보기");
            System.out.println("3. 메모 수정");
            System.out.println("4. 메모 삭제");
            System.out.println("5. 메인으로 돌아가기");
            num = s.nextInt();
            switch (num){
               case 1:
                  Create_m();
                  break;
               case 2:
                   Scanner s1 = new Scanner(System.in);
                   if (View2_m()>0) {
                      System.out.println("특정 메모의 내용을 보시겠습니까?(yes인경우: yes 입력후 엔터치고 메모의 제목을 입력하세요, no인 경우:no를 입력하세요)");
                       String ans = s1.nextLine();
                       if( ans.equals("yes")) {
                          String title = s1.nextLine();
                          View_m(title);
                       }
                   }
                   else {
                       System.out.println("생성된 메모가 존재하지 않습니다.");
                    }
                   break;
               case 3:
                  Scanner s2 = new Scanner(System.in);
                  System.out.println("수정할 메모의 제목을 입력하세요");
                  String title = s2.nextLine();
                  Update_m(title);
                  break;
               case 4:
                  Scanner s3 = new Scanner(System.in);
                  System.out.println("삭제할 메모의 제목을 입력하세요");
                  String title2 = s3.nextLine();
                  Delete_m(title2);
                  break;
               case 5:
                  System.out.println("메모 기능을 종료합니다.");
                  break;
            }
         }
   }
static public boolean createMemo(String title) {
	File file1 = new File("c://Example//File//"+ title+ ".txt");
	return true;
}


      static void Create_m(){
          BufferedWriter writer = null;
          Scanner s2 = new Scanner(System.in);
          Scanner s3 = new Scanner(System.in);
          Scanner s4 = new Scanner(System.in);
                 try {
               	  System.out.println("날짜를 입력하세요(ex,2018년 11월 20일 오후 2시 20분의 경우: 2018 11 20 14 20로 입력함)");
                     String date = s3.nextLine();
                     System.out.println("제목을 입력하세요");
                     String title = s2.nextLine();
                     File file1 = new File("c://Example//File//");
                     File[] files = file1.listFiles();
                     for (int fileIntList = 0; fileIntList < files.length; fileIntList++) {
                   	  String ss = files[fileIntList].toString();
                   	  if (title.equals(ss.substring(ss.lastIndexOf("\\") + 1, ss.length()-4))) {
                   		  System.out.println("다른 제목을 입력하세요.");
                   		  title = s4.nextLine();
                   	  }
                     }
                    writer = new BufferedWriter(new FileWriter("c://Example//File//"+ title + ".txt"));
                    writer.write("날짜:" + date + "\r\n");
                    writer.write("제목:" + title + "\r\n");
                     System.out.println("내용을 입력하세요");
                     String story = s.nextLine();
                     while (!story.equals("store")){
                        writer.write( story + "\r\n");
                        story = s2.nextLine();
                     }
                     writer.close();
                 } catch (FileNotFoundException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
   static int View2_m(){
         File file1 = new File("c://Example//File//");
          File[] files = file1.listFiles();
          if (null != files) {
              for (int fileIntList = 0; fileIntList < files.length; fileIntList++) {
                  String ss = files[fileIntList].toString();
                  if (null != ss && ss.length() > 0) {
                      System.out.println("File" + (fileIntList + 1) + " :" + ss.substring(ss.lastIndexOf("\\") + 1, ss.length()-4));
                  }
              }
              return files.length;
          }
          System.out.println("메모가 존재하지 않습니다.");
          return 0;
    }
   static void View_m(String title){
	   int flag =0;
      try{
    	  File file1 = new File("c://Example//File//");
          File[] files = file1.listFiles();
          for (int fileIntList = 0; fileIntList < files.length; fileIntList++) {
        	  String ss = files[fileIntList].toString();
        	  if (title.equals(ss.substring(ss.lastIndexOf("\\") + 1, ss.length()-4))) {
        		  flag=1;
        	  }
          }
          if (flag == 0) {
        	  System.out.println("입력한 제목의 메모가 존재하지 않습니다.");
        	  return;
          }
         
    	 BufferedReader reader = new BufferedReader(new FileReader("c://Example//File//"+ title + ".txt"));
         String data = "";
         
         while ((data = reader.readLine()) != null) {
            System.out.println(data);
         }
         reader.close();
         }catch (FileNotFoundException e) {
               e.printStackTrace();
        } catch (IOException e) {
               e.printStackTrace();
          }
      
        }
   static void Update_m(String title){
	  int flag2=0;
      BufferedWriter writer=null;
      Scanner s2 = new Scanner(System.in);
      Scanner s3 = new Scanner(System.in);
      Scanner s4 = new Scanner(System.in);
      Scanner s5 = new Scanner(System.in);
      try{
    	  File file1 = new File("c://Example//File//");
          File[] files = file1.listFiles();
          for (int fileIntList = 0; fileIntList < files.length; fileIntList++) {
        	  String ss = files[fileIntList].toString();
        	  if (title.equals(ss.substring(ss.lastIndexOf("\\") + 1, ss.length()-4))) {
        		  flag2=1;
        	  }
          }
          if (flag2 == 0) {
        	  System.out.println("입력한 제목의 메모가 존재하지 않습니다.");
        	  return;
          }
    	  
    	 BufferedReader reader = new BufferedReader(new FileReader("c://Example//File//"+ title + ".txt"));
         String data = "";
         
         while ((data = reader.readLine()) != null) {
            System.out.println(data);
         }
         reader.close();
         File file2 = new File("c://Example//File//"+ title+ ".txt");
         if( file2.exists() ){
             file2.delete();
         }
         if( file2.exists() ){
             file2.delete();
         }
         }catch (FileNotFoundException e) {
               e.printStackTrace();
        } catch (IOException e) {
               e.printStackTrace();
          }
      try {
            System.out.println("날짜를 입력하세요(ex,2018년 11월 20일 오후 2시 20분의 경우: 2018 11 20 14 20로 입력함");
            String date = s2.nextLine();
            System.out.println("제목을 입력하세요");
            String title1 = s3.nextLine();
            writer = new BufferedWriter(new FileWriter("c://Example//File//"+ title1 + ".txt"));
            writer.write("날짜:" + date + "\r\n");
            writer.write("제목:" + title1 + "\r\n");
            System.out.println("내용을 입력하세요");
            String story = s5.nextLine();
            while (!story.equals("store")){
               writer.write( story + "\r\n");
               story = s5.nextLine();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   static void Delete_m(String title) {
      File file1 = new File("c://Example//File//"+ title+ ".txt");
      if (file1.exists()) {
              file1.delete();
      }
      else {
            System.out.println("파일이 존재하지 않습니다.");
        }
   }
   
   static Boolean Deletecheck(String title) {
	      File file3 = new File("c://Example//File//"+ title+ ".txt");
	    	  if (file3.exists()) {
	              file3.delete();
	    	  }
	      return true;
	 }
}

   